package mgomez.quintoImpacto.backendChallenge.errorHandling.alumno;

public class AlumnoNotFoundException extends RuntimeException {
    public AlumnoNotFoundException(Long id) {
        super("No se encontró estudiante con id: " + id);
    }
}
