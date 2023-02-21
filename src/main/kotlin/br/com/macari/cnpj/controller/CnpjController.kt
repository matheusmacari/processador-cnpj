package br.com.macari.cnpj.controller
import br.com.macari.cnpj.consts.*
import br.com.macari.cnpj.utils.utils
import br.com.macari.cnpj.model.response.*
import br.com.macari.cnpj.service.CnpjService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class CnpjController @Autowired constructor(private val cnpjService: CnpjService){
    fun processListOnline(service : ServiceApi) {
        utils.loadListFromFile(C_INITIAL_DIR, C_LIST_FILE).forEach {
            try {
                val aFileName = "$it.json"

                println("Processando CNPJ: $it")

                if (!utils.fileExists(C_PATH_RESPONSE_BRASILAPI, aFileName)) {

                    if (service == ServiceApi.RECEITAWS) {

                        val response = cnpjService.getCnpjDetailsReceitaWS(it)

                        if (response != null) {
                            if (response.status == "OK") {
                                utils.saveToFile(Gson().toJson(response).toString(), C_PATH_RESPONSE_RECEITAWS, aFileName)

                                utils.addJsonItemToCsv(C_PATH_RECEITAWS, C_FILE_NAME_CSV, response.toString())
                            }
                        } else {
                            Thread.sleep(60000)
                        }
                    }
                    else{
                        val response = cnpjService.getCnpjDetailsBrasilApi(it)

                        utils.saveToFile(Gson().toJson(response).toString(), C_PATH_RESPONSE_BRASILAPI, aFileName)

                        utils.addJsonItemToCsv(C_PATH_BRASILAPI, C_FILE_NAME_CSV, response.toString())
                    }
                }
            }catch (ex: Exception) {
                println("Error processListOnline - CNPJ: $it")
            }
        }
    }

    fun processListOffline(service : ServiceApi) {
        var aPath = ""
        var aPathCsv = ""

        if (service == ServiceApi.BRASILAPI) {
            aPath = C_PATH_RESPONSE_BRASILAPI
            aPathCsv = C_PATH_BRASILAPI
        } else {
            aPath = C_PATH_RESPONSE_RECEITAWS
            aPathCsv = C_PATH_RECEITAWS
        }

        utils.loadFilesFromDir(aPath).forEach {
            try {
                if (!it.isDirectory) {
                    val response = Gson().fromJson(it.readText(), ReceitaWsResponse::class.java)

                    if (response != null) {
                        if (response.status == "OK") {
                            utils.addJsonItemToCsv(aPathCsv, C_FILE_NAME_CSV, response.toString())
                        }
                    }
                }

            } catch (ex: Exception) {
                println("Error processListOffline - CNPJ: ${it.name}")
            }
        }
    }
}