package mgomez.quintoImpacto.backendChallenge.model.Alumno;

import jakarta.persistence.*;
import lombok.*;
import mgomez.quintoImpacto.backendChallenge.dto.GuardarAlumno;
import mgomez.quintoImpacto.backendChallenge.model.Contacto;
import mgomez.quintoImpacto.backendChallenge.model.Curso.Curso;
import mgomez.quintoImpacto.backendChallenge.model.DatosPersonales;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity(name = "alumno")
@Table(name="alumnos")
public class Alumno {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cursos")
    @ManyToMany(mappedBy = "alumnos")
    private Set<Curso> cursos;
    @Embedded
    private DatosPersonales datosPersonales;
    @Embedded
    private Contacto datosContacto;
    @Column(name = "activo", nullable = false, columnDefinition="tinyint(1) default 1")
    private boolean activo = true;

    public Alumno(Alumno alumnoNuevo) {
        this.datosPersonales = alumnoNuevo.datosPersonales;
        this.datosContacto = alumnoNuevo.datosContacto;
    }
    public Alumno(String nombre, String apellido, String dni, String direccion, String ciudad, String telefono) {
        this.datosPersonales = new DatosPersonales(nombre, apellido, dni);
        this.datosContacto = new Contacto(direccion, ciudad, telefono);
    }

    public Alumno(GuardarAlumno data) {
        this.datosPersonales = new DatosPersonales(data.nombre(), data.apellido(), data.dni());
    }

    public void setNombre(String nombre) {
        this.datosPersonales = new DatosPersonales(nombre);
    }
    public String getNombre() {
        return this.datosPersonales.getNombre();
    }
}
