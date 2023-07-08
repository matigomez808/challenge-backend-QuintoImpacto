package mgomez.quintoImpacto.backendChallenge.servicios.Alumno;

import mgomez.quintoImpacto.backendChallenge.dto.GuardarAlumno;
import mgomez.quintoImpacto.backendChallenge.model.Alumno.Alumno;
import mgomez.quintoImpacto.backendChallenge.repos.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public Alumno guardarAlumno(GuardarAlumno data) {
        return alumnoRepository.save(new Alumno(data));
    }

    @Override
    public List<Alumno> listarAlumnosActivos() {
        return alumnoRepository.findAllByActivoTrue();
    }

    @Override
    public Optional<Alumno> getAlumnoByID(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public Alumno modificarAlumno(Alumno alumnoModificado) {
        return alumnoRepository.save(alumnoModificado);
    }

    @Override
    public void eliminarAlumno(long id) {

    }
}
