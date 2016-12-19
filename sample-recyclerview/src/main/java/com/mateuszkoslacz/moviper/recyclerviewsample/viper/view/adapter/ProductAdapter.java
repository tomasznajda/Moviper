package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mateuszkoslacz.moviper.base.view.ViperViewHolder;

import java.util.HashMap;
import java.util.List;

/**
 * Created by tomasznajda on 19.12.2016.
 */

public class ProductAdapter extends RecyclerView.Adapter<ViperViewHolder> {

    protected HashMap<Integer, ViewHolderDelegate> holders = new HashMap<>();
    protected List<?> data;

    public void addViewHolder(Class dataObjectClass, ViewHolderDelegate holderDelegate) {
        holders.put(dataObjectClass.hashCode(), holderDelegate);
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public List<?> getData() {
        return data;
    }

    @Override
    public ViperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return holders.get(viewType).create(parent);
    }

    @Override
    public void onBindViewHolder(ViperViewHolder holder, int position) {
        holder.setDataObject(getItem(position));
        holder.bindPresenter();
    }

    @Override
    public void onViewRecycled(ViperViewHolder holder) {
        holder.unbindPresenter();
    }

    @Override
    public boolean onFailedToRecycleView(ViperViewHolder holder) {
        holder.unbindPresenter();
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getClass().hashCode();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return data.get(position);
    }

    public interface ViewHolderDelegate<ViewHolderType extends ViperViewHolder> {

        ViewHolderType create(ViewGroup parent);
    }
}
