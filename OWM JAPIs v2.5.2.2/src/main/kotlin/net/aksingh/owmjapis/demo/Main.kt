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

import java.util.*


object Main {

  @JvmStatic
  fun main(args: Array<String>) {
    val controller = Controller()
    controller.start()

    val countries = HashMap<String, String>()
    val countryCodes = Locale.getISOCountries()

    for (cc in countryCodes) {
      // country name , country code map
      countries.put(Locale("", cc).displayCountry, cc.toUpperCase())
    }

    for (c in countries.toSortedMap()) {
      println(c.key.toUpperCase() + "(\"" + c.value.toUpperCase() + "\"),")
    }

//        System.setProperty("java.net.useSystemProxies", "true")
//        println("detecting proxies")
//        var l: List<*>? = null
//        try {
//            l = ProxySelector.getDefault().select(URI("http://localhost/"))
//        } catch (e: URISyntaxException) {
//            e.printStackTrace()
//        }
//
//        if (l != null) {
//            val iter = l.iterator()
//            while (iter.hasNext()) {
//                val proxy = iter.next() as java.net.Proxy
//                println("proxy type: " + proxy.type())
//
//                if (proxy.type() != Proxy.Type.DIRECT && proxy.address() != null) {
//                    val addr = proxy.address() as InetSocketAddress
//
//                    if (addr == null) {
//                        println("No Proxy")
//                    } else {
//                        println("proxy hostname: " + addr.hostName)
//                        System.setProperty("http.proxyHost", addr.hostName)
//                        println("proxy port: " + addr.port)
//                        System.setProperty("http.proxyPort", Integer.toString(addr.port))
//                    }
//                }
//            }
//        }
  }
}
