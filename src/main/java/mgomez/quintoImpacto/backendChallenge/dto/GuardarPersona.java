package mgomez.quintoImpacto.backendChallenge.dto;

import jakarta.validation.constraints.NotNull;
import mgomez.quintoImpacto.backendChallenge.model.Contacto;
import mgomez.quintoImpacto.backendChallenge.model.DatosPersonales;

public record GuardarPersona(
        @NotNull
        DatosPersonales datosPersonales,
        @NotNull
        Contacto contacto
) {
}
