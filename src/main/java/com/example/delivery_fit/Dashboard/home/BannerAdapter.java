package com.example.delivery_fit.Dashboard.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery_fit.Entity.BannerEntity;
import com.example.delivery_fit.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {

    Context context;
    List<BannerEntity> bannerEntities;

    public BannerAdapter(Context context) {
        this.context = context;
    }

    public void setBannerList(List<BannerEntity> entities) {
        this.bannerEntities = entities;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.banner_recyclerview_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BannerEntity entity = bannerEntities.get(position);

        holder.background_ImageView.setImageResource(entity.getBackgroundColor());

    }

    @Override
    public int getItemCount() {
        return bannerEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.background_ImageView)
        ImageView background_ImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
