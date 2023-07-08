package mgomez.quintoImpacto.backendChallenge.model.Profe;

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

}