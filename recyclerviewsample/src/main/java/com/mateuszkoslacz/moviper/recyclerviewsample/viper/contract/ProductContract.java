package com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract;

import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.MvpViewHolder;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;

/**
 * Created by jjodelka on 29/11/2016.
 */

public interface ProductContract {

    interface Presenter extends MoviperPresenter<View> {

    }

    interface View extends MvpViewHolder {

        Product getProduct();

        void setProduct(Product product);

        void setTitle(String productTitle);

        void setDescription(String productDescription);

        void setPhoto(String productPhotoUrl);

        void setPrice(String productPrice);
    }

    interface Interactor extends MoviperRxInteractor {

    }

    interface Routing extends MoviperRxRouting {

    }
}
