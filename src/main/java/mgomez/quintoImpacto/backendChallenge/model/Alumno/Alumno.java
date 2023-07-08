package mgomez.quintoImpacto.backendChallenge.model.Alumno;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mgomez.quintoImpacto.backendChallenge.model.Contacto;
import mgomez.quintoImpacto.backendChallenge.model.Curso.Curso;
import mgomez.quintoImpacto.backendChallenge.model.DatosPersonales;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
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
}
