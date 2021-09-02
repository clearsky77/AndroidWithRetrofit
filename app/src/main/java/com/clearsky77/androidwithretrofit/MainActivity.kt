package com.clearsky77.androidwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("TAG", "MainActivity ============ ")

        priceBtn.setOnClickListener() {
            Log.e("TAG", "OnClickListener 실행")
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.upbit.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            Log.e("TAG", ".build() 완료 ")

            val api = retrofit.create(Upbit_Service::class.java)
            val callGetPrice = api.getPrice(1, "KRW-BTC")

            callGetPrice.enqueue(object : Callback<PriceResult> {
                override fun onResponse(
                    call: Call<PriceResult>,
                    response: Response<PriceResult>
                ) {
                    Log.e("TAG", "성공: ${response.message()}")
//                Log.d("TAG", "성공 : ${response.raw()}")
                }

                override fun onFailure(call: retrofit2.Call<PriceResult>, t: Throwable) {
                    Log.e("TAG", "실패!! : $t")
                }
            })


        }

//        val CLIENT_ID = "네이버_개발자센터_아이디"
//        val CLIENT_SECRET = "네이버_개발자센터_비밀번호"
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL_NAVER_API)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val api = retrofit.create(API::class.java)
//        val callGetSearchNews = api.getSearchNews(CLIENT_ID, CLIENT_SECRET, "테스트")
//
//        callGetSearchNews.enqueue(object : Callback<ResultGetSearchNews> {
//            override fun onResponse(
//                call: Call<ResultGetSearchNews>,
//                response: Response<ResultGetSearchNews>
//            ) {
//                Log.d(TAG, "성공 : ${response.raw()}")
//            }
//
//            override fun onFailure(call: Call<ResultGetSearchNews>, t: Throwable) {
//                Log.d(TAG, "실패 : $t")
//            }
//        })


    }
}