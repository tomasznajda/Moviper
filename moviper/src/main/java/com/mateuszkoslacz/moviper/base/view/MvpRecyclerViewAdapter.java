package com.mateuszkoslacz.moviper.base.view;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by norbertbanaszek on 24.10.2016.
 * <p>
 * An {@link RecyclerView.Adapter} that uses an {@link MvpPresenter} to implement a
 * Model-View-Presenter
 * architecture.
 */

public abstract class MvpRecyclerViewAdapter<ViewHolder extends MvpBaseViewHolder>
        extends RecyclerView.Adapter<ViewHolder> {

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindPresenter();
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        holder.unbindPresenter();
    }

    @Override
    public boolean onFailedToRecycleView(ViewHolder holder) {
        holder.unbindPresenter();
        return super.onFailedToRecycleView(holder);
    }
}
