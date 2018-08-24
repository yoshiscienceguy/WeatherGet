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

package net.aksingh.owmjapis.model

import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName

data class CurrentWeatherList(
  @field:SerializedName("cod")
  var respCode: String? = null,

  @field:SerializedName("calctime")
  var calcTime: Double? = null,

  @field:SerializedName("cnt")
  var dataCount: Short? = null,

  @field:SerializedName("list")
  var dataList: List<CurrentWeather>? = null
) {
  fun hasRespCode(): Boolean = respCode != null

  fun hasCalcTime(): Boolean = calcTime != null

  fun hasDataCount(): Boolean = dataCount != null

  fun hasDataList(): Boolean = dataList != null

  companion object Static {
    @JvmStatic
    fun fromJson(json: String): CurrentWeatherList {
      return GsonBuilder().create().fromJson(json, CurrentWeatherList::class.java)
    }

    @JvmStatic
    fun toJson(pojo: CurrentWeatherList): String {
      return GsonBuilder().create().toJson(pojo)
    }

    @JvmStatic
    fun toJsonPretty(pojo: CurrentWeatherList): String {
      return GsonBuilder().setPrettyPrinting().create().toJson(pojo)
    }
  }
}
