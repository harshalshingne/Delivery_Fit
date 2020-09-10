package com.example.delivery_fit.Dashboard.track;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery_fit.Entity.CategoryEntity;
import com.example.delivery_fit.Entity.TipsEntity;
import com.example.delivery_fit.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.ViewHolder> {

    Context context;

    List<TipsEntity> tipsEntities;

    public TipsAdapter(Context context) {
        this.context = context;
    }

    public void setCategoryList(List<TipsEntity> entities) {
        this.tipsEntities = entities;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tips_recycler_lyaout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TipsEntity entity = tipsEntities.get(position);

        holder.tipsRupee_TextView.setText(entity.getTipsRupee());
        holder.food_ImageView.setImageResource(entity.getFoodIcon());

        if (position!=0){
            holder.food_ImageView.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return tipsEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.food_ImageView)
        ImageView food_ImageView;

        @BindView(R.id.tipsRupee_TextView)
        TextView tipsRupee_TextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
