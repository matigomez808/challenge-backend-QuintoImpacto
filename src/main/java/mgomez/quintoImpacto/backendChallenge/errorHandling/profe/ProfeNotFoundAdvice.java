package mgomez.quintoImpacto.backendChallenge.errorHandling.profe;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProfeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ProfeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String AlumnoNotFoundHandler(ProfeNotFoundException profeNotFoundException) {
        return profeNotFoundException.getMessage();
    }
}
