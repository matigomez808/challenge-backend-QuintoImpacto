package mgomez.quintoImpacto.backendChallenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DatosPersonales {

    private String nombre;
    private String apellido;

    @Column(unique = true)
    private String dni;


}
