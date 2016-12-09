package com.mateuszkoslacz.moviper.base.presenter.perv;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.presenter.MoviperBasePresenter;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;

/**
 * Created by mateuszkoslacz on 09.08.2016.
 * <p>
 * Perv - Presenter, Entities, Routing, View.
 * <p>
 * This is an Activity version of base presenter class for mentioned set of concepts.
 * (see {@link MvpBasePresenter})
 * <p>
 * You can use any Mosby Activity View with this class
 * ({@link com.hannesdorfmann.mosby.mvp.MvpActivity},
 * {@link com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity})
 */
//TODO migrate to MvpNullObjectPresenter base class?
public abstract class PervActivityBasePresenter
        <RoutingType extends MoviperRouting,  // I prefer readability rather than conventions
                ViewType extends MvpView>
        extends MoviperBasePresenter<ViewType>
        implements MoviperPresenter<ViewType>,
        MoviperPresenterForRouting<RoutingType> {

    @NonNull
    private RoutingType routing;

    public PervActivityBasePresenter(@NonNull Activity activity) {
        this(activity, null);
    }

    public PervActivityBasePresenter(@NonNull Activity activity, Bundle args) {
        super(args);
        this.routing = createRouting(activity);
    }

    @Override
    @Deprecated
    public boolean isRoutingAttached() {
        return routing != null;
    }

    @Override
    public void attachView(ViewType view) {
        super.attachView(view);
        //noinspection unchecked
        routing.attachPresenter(this);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        routing.detachPresenter();
    }

    @NonNull
    @Override
    public RoutingType getRouting() {
        return routing;
    }
}
