package com.veryworks.android.recyclerviewprefetch.contract;

import com.veryworks.android.recyclerviewprefetch.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pc on 4/16/2017.
 */

public interface UserService {
    @GET("users")
    Call<List<User>> getList();
}
