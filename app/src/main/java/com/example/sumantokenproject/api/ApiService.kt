package com.example.sumantokenproject.api

import com.example.sumantokenproject.PostModelResp
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.QueryMap
import java.util.concurrent.TimeUnit
//http://d.cabspoint.com/cabspoint_new/Apis?token=08df27301d6e87f6008afdb3b6cfebb0
interface ApiService {

    @Multipart
    @POST("Apis")
    suspend fun postTokenApi(@QueryMap param:HashMap<String,String>,
                             @Part("action") action: RequestBody,
                             @Part("car_type_id") cartype: RequestBody,
                             @Part("driver_id") drivetype:RequestBody,

                             ): PostModelResp






    companion object {
        fun create(): ApiService {
            val logger =
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            val client = OkHttpClient.Builder().addInterceptor(logger)
                .callTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()

//            3.142.208.241
//            13.233.49.194
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://d.cabspoint.com/cabspoint_new/")//RentainanceApp.getINSTANCE().getHostUrl
                .client(client)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
                .create(ApiService::class.java)
        }
    }
}