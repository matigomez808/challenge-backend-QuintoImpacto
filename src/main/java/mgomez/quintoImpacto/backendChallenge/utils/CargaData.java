package mgomez.quintoImpacto.backendChallenge.utils;

import mgomez.quintoImpacto.backendChallenge.model.Alumno.Alumno;
import mgomez.quintoImpacto.backendChallenge.model.Curso.Curso;
import mgomez.quintoImpacto.backendChallenge.model.Curso.Turno;
import mgomez.quintoImpacto.backendChallenge.model.Profe.Profe;
import mgomez.quintoImpacto.backendChallenge.repos.AlumnoRepository;
import mgomez.quintoImpacto.backendChallenge.repos.CursoRepository;
import mgomez.quintoImpacto.backendChallenge.repos.ProfeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargaData {

    private static final Logger log = LoggerFactory.getLogger(CargaData.class);

    Profe profe1 = new Profe(
            "Romina",
            "Martinez",
            "27548710",
            "Calle Falacia 153",
            "Ciudad Inventada",
            "16854334");

    Alumno alumno1 = new Alumno(
            "Matias",
            "Gomez",
            "37176896",
            "Calle Falsa 123",
            "Santa Rosa",
            "15231234"
    );
    Alumno alumno2 = new Alumno(
            "Marta",
            "Perez",
            "36546896",
            "Calle Trucha 133",
            "Santa Rosa",
            "15239514"
    );
    Alumno alumno3 =new Alumno(
            "Julian",
            "Garcia",
            "32654178",
            "Calle Mentiras 153",
            "Ciudad Inventada",
            "15856334"
    );
    Alumno alumno4 = new Alumno(
            "Roberta",
            "Molina",
            "35987632",
            "Avenida No Existe 6549",
            "Ciudad Inventada",
            "15652834"
    );
    Alumno alumno5 =new Alumno(
            "Miguel",
            "Molina",
            "36987528",
            "Avenida No Existe 6549",
            "Ciudad Inventada",
            "15652834"
    );
    Alumno alumno6 =new Alumno(
            "Juan Carlos",
            "Molina",
            "35965632",
            "Avenida No Existe 6549",
            "Ciudad Inventada",
            "15652834"
    );


    @Bean
    CommandLineRunner initDatabase(
            AlumnoRepository alumnoRepository,
            ProfeRepository profeRepository,
            CursoRepository cursoRepository) {
        return args -> {
            log.info("Cargando " + alumnoRepository.save(alumno1));
            log.info("Cargando " + alumnoRepository.save(alumno2));
            log.info("Cargando " + alumnoRepository.save(alumno3));
            log.info("Cargando " + alumnoRepository.save(alumno4));
            log.info("Cargando " + alumnoRepository.save(alumno5));
            log.info("Cargando " + alumnoRepository.save(alumno6));
            log.info("Cargando " + profeRepository.save(
                    new Profe(
                            "Marcos",
                            "Ramires",
                            "26548710",
                            "Calle Mentiras 153",
                            "Ciudad Inventada",
                            "15856334"
                    )));
            log.info("Cargando " + profeRepository.save(profe1));
            log.info("Cargando: " + cursoRepository.save(
                    new Curso("Matematica I", Turno.TARDE, profe1)
            ));

        };
    }



}
