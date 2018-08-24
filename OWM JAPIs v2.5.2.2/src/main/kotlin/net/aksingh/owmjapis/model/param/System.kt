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

package net.aksingh.owmjapis.model.param

import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import java.util.*

data class System(
  @field:SerializedName("type")
  val type: Int? = null,

  @field:SerializedName("id")
  val id: Int? = null,

  @field:SerializedName("message")
  val message: Double? = null,

  @field:SerializedName("country")
  val countryCode: String? = null,

  @field:SerializedName("sunrise")
  private val sunrise: Int? = null,

  @field:SerializedName("sunset")
  private val sunset: Int? = null,

  @field:SerializedName("pod")
  val pod: String? = null
) {

  var sunriseDateTime: Date? = null
    get() {
      if (sunrise != null) {
        return Date(sunrise.toLong() * 1000L)
      }
      return null
    }

  var sunsetDateTime: Date? = null
    get() {
      if (sunset != null) {
        return Date(sunset.toLong() * 1000L)
      }
      return null
    }

  fun hasType(): Boolean = type != null

  fun hasId(): Boolean = id != null

  fun hasMessage(): Boolean = message != null

  fun hasCountryCode(): Boolean = countryCode != null

  fun hasSunriseDateTime(): Boolean = sunriseDateTime != null

  fun hasSunsetDateTime(): Boolean = sunsetDateTime != null

  companion object Static {
    @JvmStatic
    fun fromJson(json: String): System {
      return GsonBuilder().create().fromJson(json, System::class.java)
    }

    @JvmStatic
    fun toJson(pojo: System): String {
      return GsonBuilder().create().toJson(pojo)
    }

    @JvmStatic
    fun toJsonPretty(pojo: System): String {
      return GsonBuilder().setPrettyPrinting().create().toJson(pojo)
    }
  }
}
