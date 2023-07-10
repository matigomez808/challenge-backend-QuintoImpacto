package mgomez.quintoImpacto.backendChallenge.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mgomez.quintoImpacto.backendChallenge.model.Curso.Turno;
import mgomez.quintoImpacto.backendChallenge.model.Profe.Profe;

public record GuardarCurso(
        @NotBlank
        String nombre,
        @NotNull
        Turno turno
) {
}
