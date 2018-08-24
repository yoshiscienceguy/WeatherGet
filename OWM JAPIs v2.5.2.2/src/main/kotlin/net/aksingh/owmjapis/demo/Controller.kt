/**************************************************************************************************
 * Copyright (c) 2013-2018 Ashutosh Kumar Singh <ashutosh@aksingh.net>                            *
 *                                                                                                *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this           *
 * software and associated documentation files (the "Software"), to deal in the Software without  *
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,     *
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the  *
 * Software is furnished to do so, subject to the following conditions:                           *
 *                                                                                                *
 * The above copyright notice and this permission notice shall be included in all copies or       *
 * substantial portions of the Software.                                                          *
 *                                                                                                *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING  *
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND     *
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,   *
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.        *
 **************************************************************************************************/

package net.aksingh.owmjapis.demo

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import net.aksingh.owmjapis.model.CurrentWeather
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Controller/* : Callback<CurrentWeather>*/ {
  val BASE_URL = "http://samples.openweathermap.org/data/2.5/"

  fun start() {
    val gson: Gson = GsonBuilder().setLenient().create()

    val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build()

    val gerritAPI: GerritAPI = retrofit.create(GerritAPI::class.java)

    val call: Call<CurrentWeather> = gerritAPI.loadChanges("London", "71e4b8caea75040cb832aa2768c013d7")

    val response: Response<CurrentWeather> = call.execute()

    val change = response.body()
    println(change?.hasDateTime())
//    println(change?.hasRain())
    println(change.toString())
    println(change?.dateTime.toString())
  }

//    override fun onResponse(call: Call<CurrentWeather>, response: Response<CurrentWeather>) {
//        if (response.isSuccessful) {
//            println("Change is success")
//            val change = response.body()
//            println(change?.hasDt())
//            println(change?.hasRain())
//            println(change.toString())
//        } else {
//            println("Change is failure")
//            println(response.errorBody())
//        }
//    }
//
//    override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
//        t.printStackTrace()
//    }
}
