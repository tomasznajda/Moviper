package com.mateuszkoslacz.moviper.base.presenter;


import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 */

public abstract class MoviperBasePresenter<ViewType extends MvpView>
        extends MvpBasePresenter<ViewType>
        implements MoviperPresenter<ViewType> {

    private Bundle args;

    public MoviperBasePresenter() {
    }

    public MoviperBasePresenter(Bundle args) {
        this.args = args;
    }

    public String getClassName() {
        return getClass().getName();
    }

    @Override
    public String getName() {
        return DEFAULT_NAME;
    }

    @Override
    public void attachView(ViewType viewType) {
        super.attachView(viewType);
        Moviper.getInstance().register(this);
    }

    @Override
    public void detachView(boolean retainInstance) {
        Moviper.getInstance().unregister(this);
        super.detachView(retainInstance);
    }

    public Bundle getArgs() {
        return args;
    }

    public void setArgs(Bundle args) {
        this.args = args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoviperBasePresenter)) return false;

        MoviperBasePresenter<?> that = (MoviperBasePresenter<?>) o;

        if (!getName().equals(that.getName())) return false;
        return getClassName().equals(that.getClassName());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getClassName().hashCode();
        return result;
    }
}
