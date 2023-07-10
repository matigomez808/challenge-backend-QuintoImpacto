package mgomez.quintoImpacto.backendChallenge.model.Curso;

import jakarta.persistence.*;

import lombok.*;
import mgomez.quintoImpacto.backendChallenge.dto.GuardarCurso;
import mgomez.quintoImpacto.backendChallenge.model.Alumno.Alumno;
import mgomez.quintoImpacto.backendChallenge.model.Profe.Profe;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
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

    @Column(name = "profeName")
    private String profeName;

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


    public Curso(GuardarCurso data) {
        this.nombre = data.nombre();
        this.turno = data.turno();
    }

    public Curso(String nombre, Turno turno, Profe profe) {
        this.nombre = nombre;
        this.turno = turno;
        this.profe = profe;
        this.profeName = profe.getName() + " " +  profe.getApellido();
    }

    public void setProfe(Profe profe) {
        this.profe = profe;
    }

    public void inscribir(Alumno alumno) {
        this.alumnos.add(alumno);
    }
    public void asignar(Profe profe) {
        this.profe = profe;
        this.profeName = profe.getName() + " " +  profe.getApellido();
    }
}
