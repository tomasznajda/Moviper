package com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract;

import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.MvpViewHolder;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Category;

/**
 * Created by jjodelka on 29/11/2016.
 */

public interface HeaderContract {

    interface Presenter extends MoviperPresenter<View> {

    }

    interface View extends MvpViewHolder {

        Category getCategory();

        void setCategory(Category category);

        void setTitle(String title);
    }

    interface Interactor extends MoviperRxInteractor {

    }

    interface Routing extends MoviperRxRouting {

    }
}

