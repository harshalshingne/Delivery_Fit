package com.example.delivery_fit.Dashboard.owner;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OwnerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OwnerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}