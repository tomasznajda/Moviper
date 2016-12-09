package com.mateuszkoslacz.moviper.base.interactor;


import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.interactor.MoviperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenterForInteractor;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by lucas.urbas on 29/08/15.
 * <p>
 * Adapted and modified by mateuszkoslacz on 08.08.2016.
 * <p>
 * Base Interactor class. (see {@link MoviperInteractor})
 */
public abstract class BaseInteractor<PresenterType extends MoviperPresenterForInteractor>
        implements MoviperInteractor<PresenterType> {

    @Nullable
    private WeakReference<PresenterType> presenter;

    @Nullable
    @Override
    public PresenterType getPresenter() {
        return WeakReferenceUtils.get(presenter);
    }

    @Override
    public boolean isPresenterAttached() {
        return WeakReferenceUtils.isAttached(presenter);
    }

    @Override
    public void attachPresenter(PresenterType presenter) {
        this.presenter = new WeakReference<>(presenter);
    }

    @Override
    public void detachPresenter() {
        WeakReferenceUtils.detach(presenter);
    }

    @Override
    public void onPresenterDetached(boolean retainInstance) {
        onPresenterDetached();
        // stub
    }

    @Override
    @Deprecated
    public void onPresenterDetached() {
        // stub
    }
}
