package com.example.sumantokenproject.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sumantokenproject.PostModelResp
import com.example.sumantokenproject.api.ApiService
import com.example.sumantokenproject.api.ApiState
import com.example.sumantokenproject.repository.HomeRepository
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Part

class TokenApiViewModel:ViewModel() {
    private val _postTokenData = MutableLiveData<ApiState<PostModelResp>>()
    val postTokenLiveData: LiveData<ApiState<PostModelResp>> = _postTokenData

    fun postTokenApi(param:HashMap<String,String>,
action:String,
                     carTypeId: Int, driverId: Int,
                     api: ApiService) {
        _postTokenData.value = ApiState.loading()
        viewModelScope.launch {
            try {
                val res = HomeRepository.postToken(param,action,carTypeId.toString(),driverId.toString(),api = api)
                Log.d("tag", "area: ${res.status}")
                if (res.status == "ok")
                {

                    Log.d("tagM", "area: $res")
                    _postTokenData.postValue(ApiState.success(res))
                }
                else
                    _postTokenData.postValue(
                    ApiState.error(
//                        res.status
                                res.status?: "Something went wrong"

                    )
                )
            } catch (e: Exception) {
                Log.d("tagM", "exp: $e")
                _postTokenData.postValue(
                    ApiState.error(
                        e.localizedMessage ?: "Something went wrong"
                    )
                )
            }
        }
    }

}