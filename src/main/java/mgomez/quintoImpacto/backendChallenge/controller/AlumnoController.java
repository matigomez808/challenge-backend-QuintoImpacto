package mgomez.quintoImpacto.backendChallenge.controller;

import mgomez.quintoImpacto.backendChallenge.servicios.Alumno.AlumnoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    private final AlumnoServiceImpl alumnoService;

    public AlumnoController(AlumnoServiceImpl alumnoService) {
        this.alumnoService = alumnoService;
    }



}
