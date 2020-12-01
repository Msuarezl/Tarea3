package com.example.myapplication3.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface InterfaceU {
    @Headers("Public-Merchant-Id: 9cc81de79fe94712a000d23e51874619")
    @GET("bankList")
    Call<List<Bancos>> getBancos();

    @GET("login.php")
    Call<String> Mensaje(@Query("usr") String usuario, @Query("pass") String clave);

}
