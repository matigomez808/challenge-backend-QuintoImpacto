package mgomez.quintoImpacto.backendChallenge.model.Profe;

import jakarta.persistence.*;
import lombok.*;
import mgomez.quintoImpacto.backendChallenge.model.Contacto;
import mgomez.quintoImpacto.backendChallenge.model.Curso.Curso;
import mgomez.quintoImpacto.backendChallenge.model.DatosPersonales;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "profesor")
@Table(name="profesores")
public class Profe {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "profe")
    private Set<Curso> cursos;
    @Embedded
    private DatosPersonales datosPersonales;
    @Embedded
    private Contacto datosContacto;
    @Column(name = "activo", nullable = false, columnDefinition="tinyint(1) default 1")
    private boolean activo = true;

    public Profe(String nombre, String apellido, String dni, String direccion, String ciudad, String telefono) {
        this.datosPersonales = new DatosPersonales(nombre, apellido, dni);
        this.datosContacto = new Contacto(direccion, ciudad, telefono);
    }
    public String getName() {
        return this.datosPersonales.getNombre();
    }

    public String getApellido() {
        return this.datosPersonales.getApellido();
    }
}
