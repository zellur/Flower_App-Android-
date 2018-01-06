package com.hfad.flowerapp.FlowerClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rakib on 1/4/18.
 */

public interface FlowerService {

    @GET("feeds/flowers.json")

    Call<List<FlowerResponse>> getFlowerResponse();
}
