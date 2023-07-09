package mgomez.quintoImpacto.backendChallenge.repos;

import jakarta.persistence.Id;
import mgomez.quintoImpacto.backendChallenge.model.Curso.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends CrudRepository<Curso, Id> {
    List<Curso> findCursoByActivoTrue();

    Optional<Curso> findById(Long id);
}
