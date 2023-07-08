package mgomez.quintoImpacto.backendChallenge.errorHandling.alumno;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AlumnoNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AlumnoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String AlumnoNotFoundHandler(AlumnoNotFoundException alumnoNotFoundException) {
        return alumnoNotFoundException.getMessage();
    }
}
