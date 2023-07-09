package mgomez.quintoImpacto.backendChallenge.controller;

import jakarta.validation.Valid;
import mgomez.quintoImpacto.backendChallenge.dto.GuardarAlumno;
import mgomez.quintoImpacto.backendChallenge.errorHandling.alumno.AlumnoNotFoundException;
import mgomez.quintoImpacto.backendChallenge.model.Alumno.Alumno;
import mgomez.quintoImpacto.backendChallenge.model.Alumno.AlumnoAssembler;
import mgomez.quintoImpacto.backendChallenge.servicios.Alumno.AlumnoServiceImpl;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    private final AlumnoServiceImpl service;
    private final AlumnoAssembler assembler;


    public AlumnoController(
            AlumnoServiceImpl alumnoService,
            AlumnoAssembler assembler) {
        this.service = alumnoService;
        this.assembler = assembler;
    }

    @GetMapping()
    public CollectionModel<EntityModel<Alumno>> todos() {
        List<EntityModel<Alumno>> alumnos = service.listarAlumnosActivos().stream().map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(alumnos, linkTo(methodOn(AlumnoController.class).todos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Alumno> uno(@PathVariable Long id) {
        Alumno alumno = service.getAlumnoByID(id).orElseThrow(() -> new AlumnoNotFoundException(id));
        return assembler.toModel(alumno);
    }

    @PostMapping()
    public ResponseEntity<?> agregarAlumno(@RequestBody @Valid GuardarAlumno data) {
        EntityModel<Alumno> entityModel = assembler.toModel(
                service.guardarAlumno(data));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarAlumno(@RequestBody Alumno alumnoNuevo, @PathVariable Long id) {
        Alumno alumnoActualizado = service.getAlumnoByID(id)
                .map(alumno -> {
                    alumno.setDatosContacto(alumnoNuevo.getDatosContacto());
                    return service.modificarAlumno(alumno);
                })
                .orElseGet(() -> {
                    System.out.println("orelseGet");
                    alumnoNuevo.setId(id);
                    return service.modificarAlumno(alumnoNuevo);
                });

        EntityModel<Alumno> entityModel = assembler.toModel(alumnoActualizado);
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);

    }

    @PostMapping("/eliminar/{id}")
    void desactivarAlumno(@PathVariable Long id) {
        Alumno alumno = service.getAlumnoByID(id)
                .map(i -> {
                    i.setActivo(false);
                    return service.modificarAlumno(i);
                })
                .orElseThrow(() -> new AlumnoNotFoundException(id));

    }


}
