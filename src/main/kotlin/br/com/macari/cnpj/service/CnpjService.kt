package br.com.macari.cnpj.service
import br.com.macari.cnpj.model.response.CnpjResponse
import com.google.api.client.http.HttpStatusCodes
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class CnpjService {

    private val client = OkHttpClient().newBuilder().readTimeout(30, TimeUnit.SECONDS).build()

    @Value("\${api.receitaws.url}")
    private val receitaWSUrl: String? = null

    private val log = LoggerFactory.getLogger(CnpjService::class.java)

    fun getCnpjDetails(cnpj: String): CnpjResponse? {

        val request = Request.Builder()
            .url("$receitaWSUrl/$cnpj")
            .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8")
            .get()
            .build()

        try {
            val response = client.newCall(request).execute()

            try {
                return if (response.isSuccessful && response.code == HttpStatusCodes.STATUS_CODE_OK) {
                    val response = Gson().fromJson(response.body!!.string(), JsonObject::class.java)

                    Gson().fromJson(response, CnpjResponse::class.java)
                } else {
                    null
                }
            }
            finally {
                response.close()
            }
        } catch (ex: Exception) {
            println("Error get url: $receitaWSUrl/$cnpj ")
            println("Error message: ${ex.message} ")

            return null
        }
    }
}
