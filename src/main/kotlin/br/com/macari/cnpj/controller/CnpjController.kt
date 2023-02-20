package br.com.macari.cnpj.controller
import br.com.macari.cnpj.consts.C_FILE_NAME_CSV
import br.com.macari.cnpj.consts.C_LIST_FILE
import br.com.macari.cnpj.consts.C_PATH
import br.com.macari.cnpj.consts.C_PATH_RESPONSE
import br.com.macari.cnpj.fileutils.utils
import br.com.macari.cnpj.model.response.CnpjResponse
import br.com.macari.cnpj.service.CnpjService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class CnpjController @Autowired constructor(private val cnpjService: CnpjService){
    fun processListOnline() {
        utils.loadListFromFile(C_PATH, C_LIST_FILE).forEach {
            try {
                val aFileName = "$it.json"

                println("Processando CNPJ: $it")

                if (!utils.fileExists(C_PATH_RESPONSE, aFileName)) {
                    val response = cnpjService.getCnpjDetails(it)

                    if (response != null) {
                        if (response.status == "OK") {
                            utils.saveToFile(Gson().toJson(response).toString(), C_PATH_RESPONSE, aFileName)
                            utils.addJsonItemToCsv(C_PATH, C_FILE_NAME_CSV, response.toString())
                        }
                    } else {
                        Thread.sleep(60000)
                    }
                }
            }catch (ex: Exception) {
                println("Error processList - CNPJ: $it")
            }
        }
    }

    fun processListOffline() {

        utils.loadFilesFromDir(C_PATH_RESPONSE).forEach {
            try {
                val response = Gson().fromJson(it.readText(), CnpjResponse::class.java)

                if (response != null) {
                    if (response.status == "OK") {
                        utils.addJsonItemToCsv(C_PATH, C_FILE_NAME_CSV, response.toString())
                    }
                }

            } catch (ex: Exception) {
                println("Error processList - CNPJ: ${it.name}")
            }
        }
    }
}