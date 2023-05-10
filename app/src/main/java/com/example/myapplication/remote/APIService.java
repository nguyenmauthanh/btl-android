package com.example.myapplication.remote;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIService {
    @POST("storage/uploadFile")
    @Multipart
    public Call<String> postImage(@Part MultipartBody.Part file);
}
