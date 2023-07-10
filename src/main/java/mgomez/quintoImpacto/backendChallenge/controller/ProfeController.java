package mgomez.quintoImpacto.backendChallenge.controller;

import jakarta.validation.Valid;
import mgomez.quintoImpacto.backendChallenge.dto.GuardarPersona;
import mgomez.quintoImpacto.backendChallenge.errorHandling.profe.ProfeNotFoundException;
import mgomez.quintoImpacto.backendChallenge.model.Profe.Profe;
import mgomez.quintoImpacto.backendChallenge.model.Profe.ProfeAssembler;
import mgomez.quintoImpacto.backendChallenge.servicios.Profe.ProfeServiceImpl;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class ProfeController {

    private final ProfeServiceImpl service;
    private final ProfeAssembler assembler;


    public ProfeController(
            ProfeServiceImpl profeService,
            ProfeAssembler assembler) {
        this.service = profeService;
        this.assembler = assembler;
    }

    @GetMapping()
    public CollectionModel<EntityModel<Profe>> todos() {
        List<EntityModel<Profe>> profes = service.listarProfesActivos().stream().map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(profes, linkTo(methodOn(ProfeController.class).todos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Profe> uno(@PathVariable Long id) {
        Profe profe = service.getProfeById(id).orElseThrow(() -> new ProfeNotFoundException(id));
        return assembler.toModel(profe);
    }

    @PostMapping()
    public ResponseEntity<?> agregarProfe(@RequestBody @Valid GuardarPersona data) {
        EntityModel<Profe> entityModel = assembler.toModel(
                service.guardarProfe(data));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarProfe(@RequestBody Profe profeNuevo, @PathVariable Long id) {
        Profe profeActualizado = service.getProfeById(id)
                .map(profe -> {
                    profe.setDatosContacto(profeNuevo.getDatosContacto());
                    return service.modificarProfe(profe);
                })
                .orElseThrow(() -> new ProfeNotFoundException(id));

        EntityModel<Profe> entityModel = assembler.toModel(profeActualizado);
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);

    }

    @PostMapping("/eliminar/{id}")
    void desactivarProfe(@PathVariable Long id) {
        Profe profe = service.getProfeById(id)
                .map(i -> {
                    i.setActivo(false);
                    return service.modificarProfe(i);
                })
                .orElseThrow(() -> new ProfeNotFoundException(id));

    }


}