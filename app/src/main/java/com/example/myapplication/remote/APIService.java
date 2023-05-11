package com.example.myapplication.remote;

import com.example.myapplication.model.Test;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIService {
    @POST("storage/uploadFile")
    @Multipart
    public Call<String> postImage(@Part MultipartBody.Part file);

    @POST("post")
    @Multipart
    public Call<Test> uploadImagePostman(@Part MultipartBody.Part file);
}
