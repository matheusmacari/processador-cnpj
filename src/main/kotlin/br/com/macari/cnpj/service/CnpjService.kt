package br.com.macari.cnpj.service
import com.google.api.client.http.HttpStatusCodes
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit
import br.com.macari.cnpj.model.response.*

@Service
class CnpjService {

    private val client = OkHttpClient().newBuilder().readTimeout(30, TimeUnit.SECONDS).build()

    @Value("\${api.receitaws.url}")
    private val receitaWSUrl: String? = null

    @Value("\${api.brasilapi.url}")
    private val brasilApiUrl: String? = null

    fun getCnpjDetailsReceitaWS(cnpj: String): ReceitaWsResponse? {

        val request = Request.Builder()
            .url("$receitaWSUrl/$cnpj")
            .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8")
            .get()
            .build()

        try {
            val response = client.newCall(request).execute()

            response.use { response ->
                return if (response.isSuccessful && response.code == HttpStatusCodes.STATUS_CODE_OK) {
                    val response = Gson().fromJson(response.body!!.string(), JsonObject::class.java)

                    Gson().fromJson(response, ReceitaWsResponse::class.java)
                } else {
                    null
                }
            }
        } catch (ex: Exception) {
            println("Error get url: $receitaWSUrl/$cnpj ")
            println("Error message: ${ex.message} ")

            return null
        }
    }

    fun getCnpjDetailsBrasilApi(cnpj: String): BrasilApiResponse? {

        val request = Request.Builder()
            .url("$brasilApiUrl/$cnpj")
            .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8")
            .get()
            .build()

        try {
            val response = client.newCall(request).execute()

            response.use { response ->
                return if (response.isSuccessful && response.code == HttpStatusCodes.STATUS_CODE_OK) {
                    val response = Gson().fromJson(response.body!!.string(), JsonObject::class.java)

                    Gson().fromJson(response, BrasilApiResponse::class.java)
                } else {
                    null
                }
            }
        } catch (ex: Exception) {
            println("Error get url: $brasilApiUrl/$cnpj ")
            println("Error message: ${ex.message} ")

            return null
        }
    }
}
