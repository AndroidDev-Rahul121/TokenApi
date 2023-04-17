package com.example.sumantokenproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.viewModels
import com.example.sumantokenproject.api.ApiControler
import com.example.sumantokenproject.api.ApiState
import com.example.sumantokenproject.viewModel.TokenApiViewModel
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    lateinit var id:EditText
    private lateinit var car_type:EditText
    private lateinit var drive_type:EditText
    lateinit var done:MaterialButton
    private val tokenViewModel:TokenApiViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        id = findViewById(R.id.etv_id)
        car_type = findViewById(R.id.etv_cartype)
       drive_type = findViewById(R.id.etv_driverid)
       done = findViewById(R.id.btn_done)

        done.setOnClickListener {
            setparam()
        }
    }
    private fun setparam(){
        val param = HashMap<String,String>()
//
        var action ="add_vehicle_type"
//        var car_ty = car_type.text.
        var drive_ty = drive_type.text
//        val  action= mutableListOf<String>()
//        val car_ty= mutableListOf<String>()
//        val drive_ty= mutableListOf<String>()
//         action.add(Action.toString())
//         car_ty.add(Car_ty.toString())
//        drive_ty.add(Drive_ty.toString())

        param["token"] = "08df27301d6e87f6008afdb3b6cfebb0".trim()
//        param["car_type_id"] = car_ty.toString()
//        param["driver_id"] =drive_ty.toString()
//Log.d("tag","$param")
        tokenViewModel.postTokenApi(param,action,2,1, ApiControler.getApi())
        setupObserverPaidBro()
    }

    private fun setupObserverPaidBro(): Unit = with(tokenViewModel) {
        postTokenLiveData.observe(this@MainActivity) { state ->
            when (state) {
                is ApiState.Loading -> {
//                    showProgressBar(true)
                    Log.d("tag", "Loading")
                }

                is ApiState.Success -> {
//                    showProgressBar(false)
                    Log.d("tag", "Success")
                    Log.d("tag",state.data.toString())

//                    }
                }
                is ApiState.Error -> {

                    Log.d("tag", "Error")
//                    showProgressBar(false)
//                    showError(state.message,binding.root)
                }
                else -> {
                    Log.d("tag", "Default")
//                    showProgressBar(false)
                }
            }
        }
    }

}