package com.mateuszkoslacz.moviper.base.delegate;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.delegate.BaseMvpDelegateCallback;
import com.mateuszkoslacz.moviper.iface.delegate.ViewHolderMvpDelegate;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperViewHolderPresenter;

public class ViewHolderMvpDelegateImpl<V extends MvpView, P extends MoviperViewHolderPresenter<V>>
        implements ViewHolderMvpDelegate {

    protected BaseMvpDelegateCallback<V, P> delegateCallback;

    public ViewHolderMvpDelegateImpl(BaseMvpDelegateCallback<V, P> delegateCallback) {
        if (delegateCallback == null) {
            throw new NullPointerException("MvpDelegateCallback is null!");
        }
        this.delegateCallback = delegateCallback;
    }

    @Override
    public void onAttachedToWindow(@NonNull Activity activity) {
        createPresenter();
        attachView(activity);
    }

    @Override
    public void onDetachedFromWindow() {
        detachView();
    }

    /**
     * Called  to create the presenter (if no other one already exisits)
     */
    void createPresenter() {

        P presenter = delegateCallback.getPresenter();
        if (presenter == null) {
            presenter = delegateCallback.createPresenter();
        }
        if (presenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }

        delegateCallback.setPresenter(presenter);
    }

    /**
     * Attaches the view to the presenter
     */
    void attachView(@NonNull Activity activity) {
        getPresenter().attachView(delegateCallback.getMvpView(), activity);
    }

    /**
     * Called to detach the view from presenter
     */
    void detachView() {
        getPresenter().detachView(delegateCallback.shouldInstanceBeRetained());
    }

    private P getPresenter() {
        P presenter = delegateCallback.getPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter returned from getPresenter() is null");
        }
        return presenter;
    }
}
