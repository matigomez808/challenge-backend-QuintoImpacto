package mgomez.quintoImpacto.backendChallenge.servicios.Alumno;

import mgomez.quintoImpacto.backendChallenge.model.Alumno.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    Alumno guardarAlumno(Alumno alumno);
    List<Alumno> listarAlumnosActivos();
    Optional<Alumno> getAlumnoByID(Long id);
    Alumno modificarIngrediente(Alumno alumnoModificado);
    void eliminarAlumno(long id);

}
