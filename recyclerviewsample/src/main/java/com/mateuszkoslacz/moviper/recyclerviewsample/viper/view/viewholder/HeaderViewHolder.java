package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.mateuszkoslacz.moviper.base.view.MvpBaseViewHolder;
import com.mateuszkoslacz.moviper.recyclerviewsample.R;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.HeaderContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Category;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter.HeaderPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class HeaderViewHolder extends
        MvpBaseViewHolder<HeaderContract.View, HeaderContract.Presenter>
        implements HeaderContract.View {

    @BindView(R.id.product_title)
    TextView mProductTitleTextView;

    private Category category;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
        setTitle(category.getName());
    }

    @Override
    public void setTitle(String title) {
        mProductTitleTextView.setText(title);
    }

    @NonNull
    @Override
    public HeaderContract.Presenter createPresenter() {
        return new HeaderPresenter(itemView);
    }
}
