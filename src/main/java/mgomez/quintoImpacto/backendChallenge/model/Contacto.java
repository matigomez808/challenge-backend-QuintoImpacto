package mgomez.quintoImpacto.backendChallenge.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Contacto {
    private String direccion;
    private String ciudad;
    private String telefono;
}
