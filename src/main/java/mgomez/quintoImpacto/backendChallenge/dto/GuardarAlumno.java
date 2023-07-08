package mgomez.quintoImpacto.backendChallenge.dto;

import jakarta.validation.constraints.NotBlank;

public record GuardarAlumno(
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotBlank
        String dni
) {
}
