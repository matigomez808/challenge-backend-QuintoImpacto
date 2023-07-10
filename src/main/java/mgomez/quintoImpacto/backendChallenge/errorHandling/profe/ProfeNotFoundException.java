package mgomez.quintoImpacto.backendChallenge.errorHandling.profe;

public class ProfeNotFoundException extends RuntimeException {
    public ProfeNotFoundException(Long id) {
        super("No se encontró profe con id: " + id);
    }
}
