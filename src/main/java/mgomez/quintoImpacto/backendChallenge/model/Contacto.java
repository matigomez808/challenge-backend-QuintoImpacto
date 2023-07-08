package mgomez.quintoImpacto.backendChallenge.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Contacto {
    private String direccion;
    private String ciudad;
    private String telefono;
}
