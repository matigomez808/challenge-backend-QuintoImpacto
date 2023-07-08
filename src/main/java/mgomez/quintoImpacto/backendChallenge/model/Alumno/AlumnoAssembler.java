package mgomez.quintoImpacto.backendChallenge.model.Alumno;

import mgomez.quintoImpacto.backendChallenge.controller.AlumnoController;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AlumnoAssembler {

    public EntityModel<Alumno> toModel(Alumno alumno){
        EntityModel<Alumno> alumnoEntityModel = EntityModel.of(alumno);
        alumnoEntityModel.add(
                linkTo(methodOn(AlumnoController.class).uno(alumno.getId())).withSelfRel(),
                linkTo(methodOn(AlumnoController.class).todos()).withRel("alumnos"));
        return alumnoEntityModel;
    }
}
