package service

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class CnpjService @Autowired constructor(private val objectMapper: ObjectMapper) {
    private val client = OkHttpClient().newBuilder().readTimeout(30, TimeUnit.SECONDS).build()

    @Value("\${api.receitaws.url}")
    private val receitaWSUrl: String? = null

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
