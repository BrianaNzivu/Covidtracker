package com.example.covid_19.presenter;

import com.example.covid_19.model.World;

import retrofit2.http.GET;

interface WorldDataApi {

    @GET("v2/all")
    Class<World> getWorldStatistics();
}
