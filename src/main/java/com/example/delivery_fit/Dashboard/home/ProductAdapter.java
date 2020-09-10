package com.example.delivery_fit.Dashboard.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.example.delivery_fit.Entity.ProductEntity;
import com.example.delivery_fit.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    Context context;
    List<ProductEntity> productEntities;
    RequestOptions requestOptions;

    public ProductAdapter(Context context) {
        this.context = context;
    }

    public void setProductList(List<ProductEntity> entities) {
        this.productEntities = entities;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_recyclerview_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        ProductEntity entity = productEntities.get(position);

//        String url = entity.getProduct_Image();
//        Glide.with(context)
//                .load(url)
//                .apply(requestOptions)
//                .into(holder.product_ImageView);

        holder.product_ImageView.setImageResource(entity.getProduct_Image());

        holder.addProductCount_TextView.setOnClickListener(view -> {
            holder.addProductCount_TextView.setText("1");
            holder.productMinus_ImageView.setVisibility(View.VISIBLE);
            holder.productPlus_ImageView.setVisibility(View.VISIBLE);
        });

        holder.productMinus_ImageView.setOnClickListener(view -> {
            holder.addProductCount_TextView.setText("ADD");
            holder.productMinus_ImageView.setVisibility(View.GONE);
            holder.productPlus_ImageView.setVisibility(View.GONE);
        });
    }

    @Override
    public int getItemCount() {
        return productEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.addProductCount_TextView)
        TextView addProductCount_TextView;

        @BindView(R.id.productMinus_ImageView)
        ImageView productMinus_ImageView;
        @BindView(R.id.productPlus_ImageView)
        ImageView productPlus_ImageView;
        @BindView(R.id.product_ImageView)
        ImageView product_ImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            requestOptions = new RequestOptions()
                    //   .transform(new CircleCrop())
                    .placeholder(R.drawable.food_icon)
                    .error(R.drawable.food_icon);
        }
    }
}
