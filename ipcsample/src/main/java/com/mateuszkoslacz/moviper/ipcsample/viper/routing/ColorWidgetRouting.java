package com.mateuszkoslacz.moviper.ipcsample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.ColorWidgetContract;

public class ColorWidgetRouting
        extends BaseRxRouting
        implements ColorWidgetContract.Routing {

    public ColorWidgetRouting(@NonNull Activity activity) {
        super(activity);
    }
}
