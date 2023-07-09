package mgomez.quintoImpacto.backendChallenge.servicios.Curso;

import mgomez.quintoImpacto.backendChallenge.model.Curso.Curso;
import mgomez.quintoImpacto.backendChallenge.repos.CursoRepository;

import java.util.List;
import java.util.Optional;

public interface CursoService {


    Curso guardarCurso(Curso curso);

    List<Curso> listarCursosActivos();

    Optional<Curso> getCursoById(Long id);

    Curso modificarCurso(Curso cursoModificado);

    void eliminarCurso(Long id);
}
