package com.example.basedemo.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.basedemo.net.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel{

    private MutableLiveData<List<Contributor>> data;

    public MyViewModel() {
        //初始化数据
        data = new MutableLiveData<>();
        initData();
    }

    private void initData() {
        Call<List<Contributor>> api = ApiService.getInstance().contributors("square", "retrofit");
        api.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<List<Contributor>> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
        }
        return data;
    }


}
