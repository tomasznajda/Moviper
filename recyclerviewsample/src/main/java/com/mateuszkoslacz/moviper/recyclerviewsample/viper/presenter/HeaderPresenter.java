package com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;

import com.mateuszkoslacz.moviper.base.presenter.viper.ViperViewHolderBaseRxPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.HeaderContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.interactor.HeaderInteractor;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing.HeaderRouting;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderPresenter
        extends ViperViewHolderBaseRxPresenter<
                    HeaderContract.View,
                    HeaderContract.Interactor,
                    HeaderContract.Routing>
        implements HeaderContract.Presenter {

    public HeaderPresenter(@NonNull View view) {
        super(view);
    }

    @Override
    public void attachView(HeaderContract.View view) {
        super.attachView(view);
        if (isViewAttached()) {
            getView().setTitle(getView().getDataObject().getName());
        }
    }

    @NonNull
    @Override
    public HeaderContract.Interactor createInteractor() {
        return new HeaderInteractor();
    }

    @NonNull
    @Override
    public HeaderContract.Routing createRouting(@NonNull Activity activity) {
        return new HeaderRouting(activity);
    }
}

