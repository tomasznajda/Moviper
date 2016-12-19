package com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Category;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.interactor.MainInteractor;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing.MainRouting;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter
        extends BaseRxPresenter<MainContract.View,
        MainContract.Interactor,
        MainContract.Routing>
        implements MainContract.Presenter {

    @Override
    public void onViewCreated() {
        List<Object> listingItems = new ArrayList<>();

        for (Product product : getInteractor().getProducts()) {
            listingItems.add(product);
        }
        listingItems.add(5, new Category("Laptop"));
        listingItems.add(3, new Category("Tablets"));
        listingItems.add(0, new Category("Smartphones"));

        if (isViewAttached()) {
            getView().setData(listingItems);
        }
    }

    @NonNull
    @Override
    public MainContract.Routing createRouting() {
        return new MainRouting();
    }

    @NonNull
    @Override
    public MainContract.Interactor createInteractor() {
        return new MainInteractor();
    }
}
