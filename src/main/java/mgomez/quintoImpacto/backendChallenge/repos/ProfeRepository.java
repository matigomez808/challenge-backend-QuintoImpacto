package mgomez.quintoImpacto.backendChallenge.repos;

import jakarta.persistence.Id;
import mgomez.quintoImpacto.backendChallenge.model.Profe.Profe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProfeRepository extends CrudRepository<Profe, Id> {
    List<Profe> findByActivoTrue();

    Optional<Profe> findAllById(Long id);
}
