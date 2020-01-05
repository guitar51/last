package com.example.last.manager.http;

import com.example.last.dao.PhotoitemcollectionDao;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiService {
    @POST("list")
    Call<PhotoitemcollectionDao> loadPhotoList();
}
