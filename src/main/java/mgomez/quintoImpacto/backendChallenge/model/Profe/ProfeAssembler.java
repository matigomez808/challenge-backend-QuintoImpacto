package mgomez.quintoImpacto.backendChallenge.model.Profe;

import mgomez.quintoImpacto.backendChallenge.controller.ProfeController;
import mgomez.quintoImpacto.backendChallenge.model.Profe.Profe;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProfeAssembler {

    public EntityModel<Profe> toModel(Profe profe){
        EntityModel<Profe> profeEntityModel = EntityModel.of(profe);
        profeEntityModel.add(
                linkTo(methodOn(ProfeController.class).uno(profe.getId())).withSelfRel(),
                linkTo(methodOn(ProfeController.class).todos()).withRel("profes"));
        return profeEntityModel;
    }
}
