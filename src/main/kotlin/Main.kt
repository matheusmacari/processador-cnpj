import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import javax.annotation.PostConstruct

@SpringBootApplication
class ProcessadorCnpjApplication
@PostConstruct
fun started() {
 // se eu quiser rodar algo após construir o objeto
 //TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"))
}
fun main(args: Array<String>) {
    runApplication<ProcessadorCnpjApplication>(*args)
}