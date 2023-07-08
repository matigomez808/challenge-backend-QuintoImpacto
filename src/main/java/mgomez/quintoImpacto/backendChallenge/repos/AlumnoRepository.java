package mgomez.quintoImpacto.backendChallenge.repos;

import jakarta.persistence.Id;
import mgomez.quintoImpacto.backendChallenge.model.Alumno.Alumno;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AlumnoRepository extends CrudRepository<Alumno, Id> {
    Optional<Alumno> findById(long id);

    List<Alumno> findAllByActivoTrue();
}
