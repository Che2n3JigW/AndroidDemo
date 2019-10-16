package com.example.basedemo.mvvm;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.basedemo.R;
import com.example.basedemo.databinding.ActivityMvvmBinding;
import com.example.basedemo.net.ApiService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvm);
        ActivityMvvmBinding binding
                = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        MyViewModel model
                = ViewModelProviders.of(this).get(MyViewModel.class);
        binding.setData(model);
        binding.setLifecycleOwner(this);
        getLifecycle().addObserver(model);
        Call<List<Contributor>> call
                = ApiService
                .getInstance()
                .contributors("square", "retrofit");
        new Thread(() -> {
            try {
                Response<List<Contributor>> execute = call.execute();
                List<Contributor> body = execute.body();
                assert body != null;
                for (Contributor contributor : body) {
                    Log.e("===cjw" , contributor.getLogin() + " ("
                            + contributor.getContributions() + ")");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
