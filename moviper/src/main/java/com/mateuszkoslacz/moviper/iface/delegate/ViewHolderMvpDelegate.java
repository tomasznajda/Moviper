package com.mateuszkoslacz.moviper.iface.delegate;

import android.app.Activity;

public interface ViewHolderMvpDelegate {

    public void onAttachedToWindow(Activity activity);

    public void onDetachedFromWindow();

}