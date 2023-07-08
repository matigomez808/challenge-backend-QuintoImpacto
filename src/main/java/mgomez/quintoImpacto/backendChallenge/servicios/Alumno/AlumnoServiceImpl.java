package mgomez.quintoImpacto.backendChallenge.servicios.Alumno;

import mgomez.quintoImpacto.backendChallenge.model.Alumno.Alumno;
import mgomez.quintoImpacto.backendChallenge.repos.AlumnoRepository;

import java.util.List;
import java.util.Optional;

public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public Alumno guardarAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public List<Alumno> listarAlumnosActivos() {
        return listarAlumnosActivos();
    }

    @Override
    public Optional<Alumno> getAlumnoByID(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public Alumno modificarIngrediente(Alumno alumnoModificado) {
        return alumnoRepository.save(alumnoModificado);
    }

    @Override
    public void eliminarAlumno(long id) {

    }
}
