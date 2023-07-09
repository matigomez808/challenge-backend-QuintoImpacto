package mgomez.quintoImpacto.backendChallenge.controller;

import jakarta.validation.Valid;
import mgomez.quintoImpacto.backendChallenge.dto.GuardarCurso;
import mgomez.quintoImpacto.backendChallenge.errorHandling.alumno.AlumnoNotFoundException;
import mgomez.quintoImpacto.backendChallenge.errorHandling.curso.CursoNotFoundException;
import mgomez.quintoImpacto.backendChallenge.model.Alumno.Alumno;
import mgomez.quintoImpacto.backendChallenge.model.Curso.Curso;
import mgomez.quintoImpacto.backendChallenge.model.Curso.CursoAssembler;
import mgomez.quintoImpacto.backendChallenge.servicios.Alumno.AlumnoServiceImpl;
import mgomez.quintoImpacto.backendChallenge.servicios.Curso.CursoServiceImpl;
import org.apache.coyote.Response;
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
@RequestMapping("/curso")
public class CursoController {

    private final CursoServiceImpl service;
    private final CursoAssembler assembler;
    private final AlumnoServiceImpl serviceAlumno;


    public CursoController(
            CursoServiceImpl cursoService,
            CursoAssembler assembler,
            AlumnoServiceImpl serviceAlumno) {
        this.service = cursoService;
        this.assembler = assembler;
        this.serviceAlumno = serviceAlumno;
    }

    @GetMapping()
    public CollectionModel<EntityModel<Curso>> todos() {
        List<EntityModel<Curso>> cursos = service.listarCursosActivos().stream().map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(cursos, linkTo(methodOn(CursoController.class).todos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Curso> uno(@PathVariable Long id) {
        Curso curso = service.getCursoById(id).orElseThrow(() -> new CursoNotFoundException(id));
        return assembler.toModel(curso);
    }

    @PostMapping()
    public ResponseEntity<?> agregarCurso(@RequestBody @Valid GuardarCurso data) {
        EntityModel<Curso> entityModel = assembler.toModel(
                service.guardarCurso(new Curso(data)));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }



    @PostMapping("/inscripcion/{cursoId}")
    public ResponseEntity<?> inscribirAlumno(@PathVariable Long cursoId, @RequestBody Alumno alumno) {
        Curso curso = service.getCursoById(cursoId).orElseThrow(() -> new CursoNotFoundException(cursoId));
        Alumno alumnoInscripcion = serviceAlumno.getAlumnoByID(alumno.getId()).orElseThrow(() -> new AlumnoNotFoundException(alumno.getId()));
        curso.inscribir(alumnoInscripcion);
        service.guardarCurso(curso);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarCurso(@RequestBody Curso cursoNuevo, @PathVariable Long id) {
        Curso cursoActualizado = service.getCursoById(id)
                .map(curso -> {
                    curso.setNombre(cursoNuevo.getNombre());
                    return service.modificarCurso(cursoNuevo);
                })
                .orElseGet(() -> {
                    cursoNuevo.setId(id);
                    return service.modificarCurso(cursoNuevo);
                });
        EntityModel<Curso> entityModel = assembler.toModel(cursoActualizado);
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PostMapping("/eliminar/{id}")
    void desactivarCurso(@PathVariable Long id) {
        Curso curso = service.getCursoById(id)
                .map(i -> {
                    i.setActivo(false);
                    return service.modificarCurso(i);
                })
                .orElseThrow(() -> new CursoNotFoundException(id));
    }
}