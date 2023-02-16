package service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = CnpjService.class)
@ActiveProfiles("dev")
internal class CnpjServiceTest @Autowired constructor(private val cnpjService: CnpjService) {
    @Test
    fun getCnpjDetails() {

        val json = cnpjService.getCnpjDetails(1111)

    }
}