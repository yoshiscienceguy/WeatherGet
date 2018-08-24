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
import net.aksingh.owmjapis.model.param.AirPollutionData
import net.aksingh.owmjapis.model.param.Coord
import java.util.*

data class AirPollution(
  @field:SerializedName("time")
  private val time: String? = null,

  @field:SerializedName("location")
  val location: Coord? = null,

  @field:SerializedName("data")
  val data: List<AirPollutionData?>? = null
) {

  var dateTime: Date? = null
    get() {
      if (time != null) {
        return Date(time.toLong() * 1000L)
      }
      return null
    }

  fun hasDateTime(): Boolean = dateTime != null

  fun hasLocation(): Boolean = location != null

  fun hasData(): Boolean = data != null

  companion object Static {
    @JvmStatic
    fun fromJson(json: String): AirPollution {
      return GsonBuilder().create().fromJson(json, AirPollution::class.java)
    }

    @JvmStatic
    fun toJson(pojo: AirPollution): String {
      return GsonBuilder().create().toJson(pojo)
    }

    @JvmStatic
    fun toJsonPretty(pojo: AirPollution): String {
      return GsonBuilder().setPrettyPrinting().create().toJson(pojo)
    }
  }
}
