package com.example.delivery_fit.Dashboard.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> profile_Image;

    public ProfileViewModel() {
        profile_Image = new MutableLiveData<>();
        profile_Image.setValue("https://picsum.photos/seed/picsum/200/300");
    }

    public LiveData<String> getText() {
        return profile_Image;
    }
}