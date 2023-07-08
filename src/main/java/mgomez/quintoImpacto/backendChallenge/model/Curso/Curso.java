package mgomez.quintoImpacto.backendChallenge.model.Curso;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mgomez.quintoImpacto.backendChallenge.model.Alumno.Alumno;
import mgomez.quintoImpacto.backendChallenge.model.Profe.Profe;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "curso")
@Table(name="cursos")
public class Curso {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Profe profe;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "alumnos_curso",
            joinColumns = @JoinColumn(name="curso_id"),
            inverseJoinColumns = @JoinColumn(name="alumno_id")
    )
    private Set<Alumno> alumnos;
    @Column(name = "turno")
    @Enumerated(EnumType.STRING)
    private Turno turno;
    @Column(name = "activo", nullable = false, columnDefinition="tinyint(1) default 1")
    private boolean activo = true;


    public Curso(String nombre, Profe profe) {
        this.nombre = nombre;
        this.profe = profe;
    }

    public Curso(String nombre) {
        this.nombre = nombre;
    }
}
