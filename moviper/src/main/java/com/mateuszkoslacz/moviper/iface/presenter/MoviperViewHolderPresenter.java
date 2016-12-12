package com.mateuszkoslacz.moviper.iface.presenter;

import android.app.Activity;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

public interface MoviperViewHolderPresenter<ViewType extends MvpView> extends MoviperPresenter<ViewType> {

    void attachView(ViewType view, Activity activity);
}
