package com.clearsky77.androidwithretrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Upbit_Service {
        //https://api.upbit.com/v1/candles/days?count=1&market=KRW-BTC
        @GET("v1/candles/days")
        fun getPrice(
            @Query("count") count: Int,
            @Query("market") market: String
        ): Call<PriceResult>
}

//class NaverAPI {
//    interface NaverAPI {
//        @GET("v1/search/news.json")
//        fun getSearchNews(
//            @Header("X-Naver-Client-Id") clientId: String,
//            @Header("X-Naver-Client-Secret") clientSecret: String,
//            @Query("query") query: String,
//            @Query("display") display: Int? = null,
//            @Query("start") start: Int? = null
//        ): Call<ResultGetSearchNews>
//    }
//}