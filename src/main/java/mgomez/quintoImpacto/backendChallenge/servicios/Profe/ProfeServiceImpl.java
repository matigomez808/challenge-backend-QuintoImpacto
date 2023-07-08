package mgomez.quintoImpacto.backendChallenge.servicios.Profe;

import mgomez.quintoImpacto.backendChallenge.model.Profe.Profe;
import mgomez.quintoImpacto.backendChallenge.repos.ProfeRepository;

import java.util.List;
import java.util.Optional;

public class ProfeServiceImpl implements ProfeService{

    private final ProfeRepository profeRepository;

    public ProfeServiceImpl(ProfeRepository profeRepository) {
        this.profeRepository = profeRepository;
    }

    @Override
    public Profe guardarProfe(Profe profe) {
        return profeRepository.save(profe);
    }

    @Override
    public List<Profe> listarProfesActivos() {
        return profeRepository.findByActivoTrue();
    }

    @Override
    public Optional<Profe> getProfeById(Long id) {
        return profeRepository.findAllById(id);
    }

    @Override
    public Profe modificarProfe(Profe profeModificado) {
        return profeRepository.save(profeModificado);
    }

    @Override
    public void eliminarProfe(Long id) {

    }
}
