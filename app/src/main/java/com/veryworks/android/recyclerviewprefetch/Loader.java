package com.veryworks.android.recyclerviewprefetch;

import android.support.annotation.NonNull;

import com.veryworks.android.recyclerviewprefetch.contract.UserService;
import com.veryworks.android.recyclerviewprefetch.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pc on 4/16/2017.
 */

public class Loader {

    public static void getList(@NonNull String url, final CallBack callback){
        if(!url.startsWith("http")){
            url = "http://"+url;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Call<List<User>> result = retrofit.create(UserService.class).getList();

        result.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                callback.call(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callback.call(null);
            }
        });
    }

    public interface CallBack{
        void call(List list);
    }
}
