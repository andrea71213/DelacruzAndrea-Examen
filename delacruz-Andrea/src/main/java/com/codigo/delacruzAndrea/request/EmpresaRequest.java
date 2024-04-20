package com.codigo.delacruzAndrea.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmpresaRequest {
    @NotBlank
    private String tipoDocumento;
    @NotBlank
    private String numeroDocumento;
    @NotBlank
    private String condicion;
    @NotBlank
    private String direccion;
    @NotBlank
    private String distrito;
    @NotBlank
    private String provincia;
    @NotBlank
    private String departamento;
    @NotBlank
    private boolean esAgenteRetencion;

}
