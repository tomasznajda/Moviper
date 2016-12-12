package com.mateuszkoslacz.moviper.iface.view;

import android.app.Activity;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by mateuszkoslacz on 01.12.2016.
 */

public interface MvpViewHolder extends MvpView {

    Activity getActivity();
}
