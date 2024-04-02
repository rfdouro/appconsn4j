package com.example.appconsn4j.services;

import com.example.appconsn4j.model.Filme;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FilmeService {
    @GET("api/filme/{id}")
    Call<Filme> getFilme(@Path("id") String id);

    @GET("api/filme")
    Call<List<Filme>> getFilmes();

    @GET("api/filme/page")
    Call<HashMap> getFilmes(@Query("page") Integer page, @Query("perpage") Integer perpage);
}
