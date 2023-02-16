package br.com.macari.cnpj.service

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class CnpjServiceTest @Autowired constructor(private val cnpjService: CnpjService) {

    @Test
    fun processCnpj() {
        val response = cnpjService.getCnpjDetails(111)
    }
}