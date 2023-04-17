package com.example.sumantokenproject.repository

import com.example.sumantokenproject.PostModelResp
import com.example.sumantokenproject.api.ApiService
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.http.Part

object HomeRepository {

    suspend fun postToken(param:HashMap<String,String>,
                         action: String,
                          cartypr: String,
                         drivetype: String,
                          api:ApiService) = api.postTokenApi(param,action.toRequestBody(),cartypr.toRequestBody(),drivetype.toRequestBody())


//    suspend fun postToken(param:HashMap<String,String>, carTypeId: Int, driverId: Int,api:ApiService): PostModelResp {
//        val action = "add_vehicle_type".toRequestBody("multipart/form-data".toMediaTypeOrNull())
//        val carTypeIdBody =
//            carTypeId.toString().toRequestBody("multipart/form-data".toMediaTypeOrNull())
//        val driverIdBody =
//            driverId.toString().toRequestBody("multipart/form-data".toMediaTypeOrNull())
//
//        return api.postTokenApi(param, action, carTypeIdBody, driverIdBody)
//    }

}