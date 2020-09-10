package com.example.delivery_fit.Dashboard.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery_fit.Entity.CategoryEntity;
import com.example.delivery_fit.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;

    List<CategoryEntity> categoryEntities;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    public void setCategoryList(List<CategoryEntity> entities) {
        this.categoryEntities = entities;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_recycler_lyaout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryEntity entity = categoryEntities.get(position);

        holder.catName_TextView.setText(entity.getCatName());
        holder.cat_ImageView.setImageResource(entity.getCatIcon());
        holder.background_ImageView.setImageResource(entity.getCatBackground());

    }

    @Override
    public int getItemCount() {
        return categoryEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cat_ImageView)
        ImageView cat_ImageView;
        @BindView(R.id.background_ImageView)
        ImageView background_ImageView;

        @BindView(R.id.catName_TextView)
        TextView catName_TextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
