package mgomez.quintoImpacto.backendChallenge.errorHandling.curso;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CursoNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CursoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CursoNotFoundHandler(CursoNotFoundException cursoNotFoundException) {
        return cursoNotFoundException.getMessage();
    }
}
