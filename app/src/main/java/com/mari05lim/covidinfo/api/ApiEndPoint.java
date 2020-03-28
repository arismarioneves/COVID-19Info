package com.mari05lim.covidinfo.api;

import com.mari05lim.covidinfo.model.CountryModel;
import com.mari05lim.covidinfo.model.WorldModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET(Api.END_POINT_SUMMARY_WORLD)
    Call<WorldModel> getSummaryWorld();

    @GET(Api.END_POINT_IDN)
    Call<CountryModel> getSummaryIdn();

}
