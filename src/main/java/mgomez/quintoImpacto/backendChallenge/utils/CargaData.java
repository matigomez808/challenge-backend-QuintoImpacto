package mgomez.quintoImpacto.backendChallenge.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargaData {

    private static final Logger log = LoggerFactory.getLogger(CargaData.class);

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            log.info("Cargando" + )
        };
    }



}
