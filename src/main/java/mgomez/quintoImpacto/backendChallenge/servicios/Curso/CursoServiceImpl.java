package mgomez.quintoImpacto.backendChallenge.servicios.Curso;

import mgomez.quintoImpacto.backendChallenge.model.Curso.Curso;
import mgomez.quintoImpacto.backendChallenge.repos.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService{

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }


    @Override
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> listarCursosActivos() {
        return cursoRepository.findCursoByActivoTrue();
    }

    @Override
    public Optional<Curso> getCursoById(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso modificarCurso(Curso cursoModificado) {
        return cursoRepository.save(cursoModificado);
    }

    @Override
    public void eliminarCurso(Long id) {

    }
}
