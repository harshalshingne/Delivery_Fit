package com.example.delivery_fit.Dashboard.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.delivery_fit.Entity.CategoryEntity;
import com.example.delivery_fit.Entity.ProductEntity;
import com.example.delivery_fit.R;


import java.util.ArrayList;
import java.util.List;

public class ProfileProductAdapter extends  RecyclerView.Adapter<ProfileProductAdapter.ImageViewHolder> {

    Context context;
    List<ProductEntity> productEntities;

    public ProfileProductAdapter(Context context) {
        this.context = context;
    }

    public void setProductEntities(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile_product,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

        Glide.with(context).load(productEntities.get(position).getProduct_url())
                .placeholder(R.drawable.ic_launcher_background).dontAnimate().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productEntities.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.products_Imageview);

        }
    }
}
