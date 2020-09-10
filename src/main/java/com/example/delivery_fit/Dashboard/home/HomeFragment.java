package com.example.delivery_fit.Dashboard.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.delivery_fit.Entity.BannerEntity;
import com.example.delivery_fit.Entity.CategoryEntity;
import com.example.delivery_fit.Entity.ProductEntity;
import com.example.delivery_fit.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    @BindView(R.id.search_EditText)
    EditText search_EditText;

    @BindView(R.id.category_RecyclerView)
    RecyclerView category_RecyclerView;
    @BindView(R.id.banner_RecyclerView)
    RecyclerView banner_RecyclerView;
    @BindView(R.id.product_RecyclerView)
    RecyclerView product_RecyclerView;

    List<CategoryEntity> categoryEntityList;
    List<BannerEntity> bannerEntities;
    List<ProductEntity> productEntities;
    HomeAdapter homeAdapter;
    BannerAdapter bannerAdapter;
    ProductAdapter productAdapter;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        ButterKnife.bind(this, view);

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        // adding data to category recyclerView
        setCategory();
        setBanners();
        setProducts();
    }

    private void setCategory() {
        categoryEntityList = new ArrayList<>();

        categoryEntityList.add(new CategoryEntity("Food", R.drawable.food_icon, R.drawable.background_circle_light_blue));
        categoryEntityList.add(new CategoryEntity("Footwear", R.drawable.footwear_icon, R.drawable.background_circle_light_green));
        categoryEntityList.add(new CategoryEntity("Electronic", R.drawable.electronic_icon, R.drawable.background_circle_light_pink));
        categoryEntityList.add(new CategoryEntity("Cloths", R.drawable.cloths_icon, R.drawable.background_circle_light_yellow));
        categoryEntityList.add(new CategoryEntity("More", R.drawable.more_icon, R.drawable.background_circle_light_purple));

        category_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        category_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        homeAdapter = new HomeAdapter(getActivity());
        category_RecyclerView.setAdapter(homeAdapter);

        homeAdapter.setCategoryList(categoryEntityList);
    }

    private void setBanners() {
        bannerEntities = new ArrayList<>();

        bannerEntities.add(new BannerEntity(R.drawable.background_rounded_bgc));
        bannerEntities.add(new BannerEntity(R.drawable.background_rounded_bm));
        bannerEntities.add(new BannerEntity(R.drawable.background_rounded_ccd));

        banner_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        banner_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        bannerAdapter = new BannerAdapter(getActivity());
        banner_RecyclerView.setAdapter(bannerAdapter);


        bannerAdapter.setBannerList(bannerEntities);
    }

    private void setProducts() {
        productEntities = new ArrayList<>();

        productEntities.add(new ProductEntity(R.drawable.burger_img,"Burger"));
        productEntities.add(new ProductEntity(R.drawable.pancake_img,"PanCake"));
        productEntities.add(new ProductEntity(R.drawable.noodles_img,"Noodles"));
        productEntities.add(new ProductEntity(R.drawable.fingerfish_img,"Finger Fish"));
        productEntities.add(new ProductEntity(R.drawable.cookie_img,"Cookie"));
        productEntities.add(new ProductEntity(R.drawable.bread_img,"Bread"));
        productEntities.add(new ProductEntity(R.drawable.burger_img,"Burger"));
        productEntities.add(new ProductEntity(R.drawable.pancake_img,"PanCake"));
        productEntities.add(new ProductEntity(R.drawable.noodles_img,"Noodles"));
        productEntities.add(new ProductEntity(R.drawable.fingerfish_img,"Finger Fish"));
        productEntities.add(new ProductEntity(R.drawable.cookie_img,"Cookie"));
        productEntities.add(new ProductEntity(R.drawable.bread_img,"Bread"));
        
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        product_RecyclerView.setLayoutManager(gridLayoutManager);//new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false)
        product_RecyclerView.setItemAnimator(new DefaultItemAnimator());
        productAdapter = new ProductAdapter(getContext());
        product_RecyclerView.setAdapter(productAdapter);

        productAdapter.setProductList(productEntities);

    }
}