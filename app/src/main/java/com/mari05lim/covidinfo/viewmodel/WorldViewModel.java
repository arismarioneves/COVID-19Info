package com.mari05lim.covidinfo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mari05lim.covidinfo.model.WorldModel;
import com.mari05lim.covidinfo.api.ApiEndPoint;
import com.mari05lim.covidinfo.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WorldViewModel extends ViewModel {

    private MutableLiveData<WorldModel> mutableLiveData = new MutableLiveData<>();

    public void setWorldData() {
        Retrofit retrofit = ApiService.getRetrofitService();
        ApiEndPoint apiEndpoint = retrofit.create(ApiEndPoint.class);
        Call<WorldModel> call = apiEndpoint.getSummaryWorld();
        call.enqueue(new Callback<WorldModel>() {
            @Override
            public void onResponse(Call<WorldModel> call, Response<WorldModel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<WorldModel> call, Throwable t) {

            }
        });

    }

    public LiveData<WorldModel> getWorldData() {
        return mutableLiveData;
    }
}
