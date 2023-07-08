package mgomez.quintoImpacto.backendChallenge.model.Curso;

import mgomez.quintoImpacto.backendChallenge.controller.CursoController;
import mgomez.quintoImpacto.backendChallenge.model.Curso.Curso;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CursoAssembler {

    public EntityModel<Curso> toModel(Curso curso){
        EntityModel<Curso> cursoEntityModel = EntityModel.of(curso);
        cursoEntityModel.add(
                linkTo(methodOn(CursoController.class).uno(curso.getId())).withSelfRel(),
                linkTo(methodOn(CursoController.class).todos()).withRel("cursos"));
        return cursoEntityModel;
    }
}
