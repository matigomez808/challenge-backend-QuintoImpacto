package mgomez.quintoImpacto.backendChallenge.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mgomez.quintoImpacto.backendChallenge.model.Contacto;
import mgomez.quintoImpacto.backendChallenge.model.DatosPersonales;

public record GuardarAlumno(
        @NotNull
        DatosPersonales datosPersonales,
        @NotNull
        Contacto contacto
) {
}
