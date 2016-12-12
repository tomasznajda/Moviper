package com.mateuszkoslacz.moviper.base.view;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.delegate.BaseMvpDelegateCallback;
import com.hannesdorfmann.mosby.mvp.delegate.ViewGroupMvpDelegate;
import com.hannesdorfmann.mosby.mvp.delegate.ViewGroupMvpDelegateImpl;
import com.mateuszkoslacz.moviper.base.delegate.ViewHolderMvpDelegateImpl;
import com.mateuszkoslacz.moviper.iface.delegate.ViewHolderMvpDelegate;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperViewHolderPresenter;
import com.mateuszkoslacz.moviper.iface.view.MvpViewHolder;

/**
 * Created by norbertbanaszek on 24.10.2016.
 * <p>
 * An {@link RecyclerView.Adapter} that uses an {@link MvpPresenter} to implement a
 * Model-View-Presenter
 * architecture.
 */

public abstract class MvpBaseViewHolder
        <DataObject, View extends MvpViewHolder,
                Presenter extends MoviperViewHolderPresenter<View>>
        extends RecyclerView.ViewHolder
        implements BaseMvpDelegateCallback<View, Presenter>, MvpViewHolder<DataObject> {

    private DataObject mDataObject;
    protected Presenter mPresenter;
    protected ViewHolderMvpDelegateImpl<View, Presenter> mvpDelegate;

    public MvpBaseViewHolder(android.view.View itemView) {
        super(itemView);
    }

    @NonNull
    protected ViewHolderMvpDelegate getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new ViewHolderMvpDelegateImpl<>(this);
        }

        return mvpDelegate;
    }

    @Override
    public DataObject getDataObject() {
        return mDataObject;
    }

    @Override
    public void setDataObject(DataObject dataObject) {
        mDataObject = dataObject;
    }

    public void bindPresenter(@NonNull Activity activity) {
        getMvpDelegate().onAttachedToWindow(activity);
    }

    public void unbindPresenter() {
        getMvpDelegate().onDetachedFromWindow();
    }

    @NonNull
    public abstract Presenter createPresenter();

    @Override
    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public View getMvpView() {
        return (View) this;
    }

    @Override
    public boolean isRetainInstance() {
        return true;
    }

    @Override
    public void setRetainInstance(boolean retainingInstance) {
        throw new UnsupportedOperationException("Retaining instance is not supported yet");
    }

    @Override
    public boolean shouldInstanceBeRetained() {
        return true;
    }

}