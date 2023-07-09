package mgomez.quintoImpacto.backendChallenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DatosPersonales {

    private String nombre;
    private String apellido;

    @Column(unique = true)
    private String dni;

    public DatosPersonales(String nombre) {
        this.nombre = nombre;
    }
    public DatosPersonales(DatosPersonales datosPersonalesNuevos) {
        this.nombre = datosPersonalesNuevos.getNombre();
        this.apellido = datosPersonalesNuevos.getApellido();
        this.dni = datosPersonalesNuevos.getDni();
    }
}
