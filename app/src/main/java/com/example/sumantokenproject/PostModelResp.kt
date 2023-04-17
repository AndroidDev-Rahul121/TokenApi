package com.example.sumantokenproject

data class PostModelResp(
    val msg: String,
//    val response: Response,
    val status: String
)

data class Response(
    val added_date: String,
    val city_lat: String,
    val city_long: String,
    val delete_status: String,
    val driver_city: String,
    val driver_name: String,
    val email_address: Any,
    val flag_screen: String,
    val gender: String,
    val id: String,
    val mobile: String,
    val otp_number: String,
    val password: String,
    val preferred_shift_id: String,
    val referral_code: String,
    val registration_status: String,
    val status: String,
    val token: String,
    val updated_date: String,
    val username: String,
    val vehicle_type: String
)