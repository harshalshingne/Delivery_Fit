package com.example.delivery_fit.Dashboard.track;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TrackViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    public MutableLiveData<String> resultImageUrl = new MutableLiveData<>();
    public TrackViewModel() {
        resultImageUrl = new MutableLiveData<>();
        resultImageUrl.setValue("https://picsum.photos/seed/picsum/200/300");
    }

    public MutableLiveData<String> getResultImageUrl() {
        return resultImageUrl;
    }

    public void setResultImageUrl(MutableLiveData<String> resultImageUrl) {
        this.resultImageUrl = resultImageUrl;
    }

    public LiveData<String> getText() {
        return resultImageUrl;
    }
}
