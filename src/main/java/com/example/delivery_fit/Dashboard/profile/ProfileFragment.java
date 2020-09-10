package com.example.delivery_fit.Dashboard.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.delivery_fit.Dashboard.home.ProductAdapter;
import com.example.delivery_fit.Dashboard.track.TipsAdapter;
import com.example.delivery_fit.Dashboard.track.TrackViewModel;
import com.example.delivery_fit.Entity.CategoryEntity;
import com.example.delivery_fit.Entity.ProductEntity;
import com.example.delivery_fit.Entity.TipsEntity;
import com.example.delivery_fit.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends Fragment {

    private ProfileViewModel notificationsViewModel;

    @BindView(R.id.delivery_products_Recyclerview)
    RecyclerView delivery_products_Recyclerview;

    @BindView(R.id.profile_Image)
    ImageView profile_Image;

    @BindView(R.id.message_Imageview)
    ImageView message_Imageview;

    @BindView(R.id.total_no_Button)
    Button total_no_Button;

    @BindView(R.id.edt_profile_Button)
    Button edt_profile_Button;

    @BindView(R.id.profile_history__Button)
    Button profile_history__Button;

    List<ProductEntity> productEntities;
    ProfileProductAdapter productAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        ButterKnife.bind(this, view);
        notificationsViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);

        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Glide.with(getContext())
                        .load(s)
                        .circleCrop()
                        .into(profile_Image);
            }
        });
        setProducts();
    }
    private void setProducts() {
        productEntities = new ArrayList<>();

        productEntities.add(new ProductEntity("https://picsum.photos/200/300"));
        productEntities.add(new ProductEntity("https://picsum.photos/seed/picsum/200/300"));
        productEntities.add(new ProductEntity("https://picsum.photos/200/300/?blur"));
        productEntities.add(new ProductEntity("https://picsum.photos/seed/picsum/200/300"));
        productEntities.add(new ProductEntity("https://picsum.photos/seed/picsum/200/300"));
        productEntities.add(new ProductEntity("https://picsum.photos/200/300"));
        productEntities.add(new ProductEntity("https://picsum.photos/id/237/200/300"));
        productEntities.add(new ProductEntity("https://picsum.photos/200/300/?blur"));
        productEntities.add(new ProductEntity("https://picsum.photos/seed/picsum/200/300"));
        productEntities.add(new ProductEntity("https://picsum.photos/seed/picsum/200/300"));
        productEntities.add(new ProductEntity("https://picsum.photos/200/300"));
        productEntities.add(new ProductEntity("https://picsum.photos/id/237/200/300"));
        productEntities.add(new ProductEntity("https://picsum.photos/200/300/?blur"));


        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        delivery_products_Recyclerview.setLayoutManager(staggeredGridLayoutManager);
        productAdapter = new ProfileProductAdapter(getActivity());
        delivery_products_Recyclerview.setAdapter(productAdapter);
        productAdapter.setProductEntities(productEntities);

        /* */
    }
}