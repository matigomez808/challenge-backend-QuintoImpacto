package mgomez.quintoImpacto.backendChallenge.servicios.Profe;

import mgomez.quintoImpacto.backendChallenge.model.Profe.Profe;

import java.util.List;
import java.util.Optional;

public interface ProfeService {

    Profe guardarProfe(Profe profe);

    List<Profe> listarProfesActivos();

    Optional<Profe> getProfeById(Long id);

    Profe modificarProfe(Profe profeModificado);

    void eliminarProfe(Long id);
    
}
