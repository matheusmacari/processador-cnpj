package br.com.macari.cnpj.service


import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class CnpjService {

    private val client = OkHttpClient().newBuilder().readTimeout(30, TimeUnit.SECONDS).build()

    @Value("\${api.receitaws.url}")
    private val receitaWSUrl: String? = null

    private val log = LoggerFactory.getLogger(CnpjService::class.java)

    fun getCnpjDetails(cnpj: Int): String? {

        val request = Request.Builder()
            .url("$receitaWSUrl/$cnpj")
            .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8")
            .get()
            .build()

        try {
            val response = client.newCall(request).execute()

            //val cnpjDetails = Gson().fromJson(response.body!!.string(), BackofficeSupportLoginResponse::class.java)
            // mapear json to class

            val cnpjDetails = response.body?.string()

            response.close()

            return cnpjDetails

        } catch (ex: Exception) {
            println("Error get url: $receitaWSUrl/$cnpj ")
            println("Error message: ${ex.message} ")

            return ""
        }
    }
}
