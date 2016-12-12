package com.mateuszkoslacz.moviper.base.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Activity version of base Routing class.
 * (see {@link MoviperRouting} and {@link MoviperPresenterForRouting})
 */
public abstract class BaseRxRouting
        implements MoviperRxRouting {

    @NonNull
    protected WeakReference<Activity> activity;

    public BaseRxRouting(@NonNull Activity activity) {
        this.activity = new WeakReference<>(activity);
    }

    @Override
    public boolean isActivityAttached() {
        return WeakReferenceUtils.isAttached(activity);
    }

    @Nullable
    @Override
    public Activity getActivity() {
        return WeakReferenceUtils.get(activity);
    }

    @Override
    public void attachActivity(Activity activity) {
        this.activity = new WeakReference<>(activity);
    }

    @Override
    public void detachActivity() {
        WeakReferenceUtils.detach(activity);
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
