package br.com.macari.cnpj.controller
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CnpjControllerTest @Autowired constructor(private val cnpjController: CnpjController){

    @Test
    fun processList() {
        cnpjController.processListOffline()
    }
}