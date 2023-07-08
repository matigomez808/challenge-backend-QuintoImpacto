package mgomez.quintoImpacto.backendChallenge.errorHandling.curso;

public class CursoNotFoundException extends RuntimeException {
    public CursoNotFoundException(Long id) {
        super("No se encontró curso con id: " + id);
    }
}
