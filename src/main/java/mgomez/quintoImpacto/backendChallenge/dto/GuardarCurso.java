package mgomez.quintoImpacto.backendChallenge.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mgomez.quintoImpacto.backendChallenge.model.Curso.Turno;

public record GuardarCurso(
        @NotBlank
        String nombre,
        @NotNull
        Turno turno
) {
}
