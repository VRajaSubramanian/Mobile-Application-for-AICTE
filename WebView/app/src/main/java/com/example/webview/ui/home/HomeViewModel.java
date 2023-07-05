package com.example.webview.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    public HomeViewModel() {
        MutableLiveData<String> mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

}