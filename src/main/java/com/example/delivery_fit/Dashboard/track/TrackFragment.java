package com.example.delivery_fit.Dashboard.track;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.delivery_fit.Entity.TipsEntity;
import com.example.delivery_fit.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TrackFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap,mFlgMap;
    private TrackViewModel trackViewModel;

    @BindView(R.id.tips_RecyclerView)
    RecyclerView tips_RecyclerView;

    @BindView(R.id.captainProfile_ImageView)
    ImageView captainProfile_ImageView;

    @BindView(R.id.captainFlag_linear)
    LinearLayout captainFlag_linear;
    @BindView(R.id.pickedFlag_linear)
    LinearLayout pickedFlag_linear;
    @BindView(R.id.checkPointFlag_linear)
    LinearLayout checkPointFlag_linear;

    @BindView(R.id.captaint_Progressbar)
    ProgressBar captaint_Progressbar;
    @BindView(R.id.checkPoint_Progressbar)
    ProgressBar checkPoint_Progressbar;


    List<TipsEntity> tipEntityList;
    TipsAdapter tipsAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        trackViewModel =
                ViewModelProviders.of(this).get(TrackViewModel.class);
        View root = inflater.inflate(R.layout.fragment_track, container, false);
        if(getActivity()!=null) {
            SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager()
                    .findFragmentById(R.id.map);

            if (mapFragment != null) {
                mapFragment.getMapAsync(this);

            }
        }


        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        ButterKnife.bind(this, view);
        //captainProfile_ImageView = view.findViewById(R.id.captainProfile_ImageView);

        trackViewModel = ViewModelProviders.of(this).get(TrackViewModel.class);
        trackViewModel.getResultImageUrl().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Glide.with(getContext())
                        .load(s)
                        .circleCrop()
                        .into(captainProfile_ImageView);
            }
        });

        pickedFlag_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        setTips();
    }
    private void setTips() {
        tipEntityList = new ArrayList<>();

        tipEntityList.add(new TipsEntity("\u20B9 "+"4", R.drawable.ic_biscuit));
        tipEntityList.add(new TipsEntity("\u20B9 "+"5", R.drawable.ic_cupcake));
        tipEntityList.add(new TipsEntity("\u20B9 "+"6", R.drawable.ic_biscuit));
        tipEntityList.add(new TipsEntity("\u20B9 "+"7", R.drawable.ic_cupcake));
        tipEntityList.add(new TipsEntity("\u20B9 "+"8", R.drawable.ic_biscuit));
        tipEntityList.add(new TipsEntity("\u20B9 "+"8", R.drawable.ic_cupcake));
        tipEntityList.add(new TipsEntity("\u20B9 "+"4", R.drawable.ic_biscuit));
        tipEntityList.add(new TipsEntity("\u20B9 "+"5", R.drawable.ic_cupcake));

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL);
        tips_RecyclerView.setLayoutManager(staggeredGridLayoutManager);
        tipsAdapter = new TipsAdapter(getActivity());
        tips_RecyclerView.setAdapter(tipsAdapter);

        tipsAdapter.setCategoryList(tipEntityList);

       /* */
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in hyderabad and move the camera
        LatLng hyderadbad = new LatLng(17, 78);
        mMap.addMarker(new MarkerOptions().position(hyderadbad).title("Tutlane in India"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hyderadbad));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }
}