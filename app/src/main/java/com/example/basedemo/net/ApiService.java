package com.example.basedemo.net;

import com.example.basedemo.common.Constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    //私有/禁止访问
    private ApiService(){}

    public static GitHubService getInstance(){
        return ApiServiceHolder.instance.getRetrofit();
    }

    private static class ApiServiceHolder{

        private static final ApiServiceHolder instance = new ApiServiceHolder();
        GitHubService getRetrofit(){
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Constant.URL_BASE)
                    .build();

            return retrofit.create(GitHubService.class);

        }

    }

}
