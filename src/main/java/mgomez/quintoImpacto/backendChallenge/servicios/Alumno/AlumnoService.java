package mgomez.quintoImpacto.backendChallenge.servicios.Alumno;

import mgomez.quintoImpacto.backendChallenge.dto.GuardarPersona;
import mgomez.quintoImpacto.backendChallenge.model.Alumno.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    Alumno guardarAlumno(GuardarPersona data);
    List<Alumno> listarAlumnosActivos();
    Optional<Alumno> getAlumnoByID(Long id);

    Alumno modificarAlumno(Alumno alumnoModificado);

    void eliminarAlumno(long id);

}
