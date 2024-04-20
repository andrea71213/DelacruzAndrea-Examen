package com.codigo.delacruzAndrea.controller;

import com.codigo.delacruzAndrea.entity.Empresa;
import com.codigo.delacruzAndrea.service.EmpresaServ;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empresa")
@AllArgsConstructor
@Tag(
        name = "Api de empresas", description = "Esta api te posibilita crear empresas")

public class EmpresaController {

        private final EmpresaServ empresaServ;

    @PostMapping("/crearEmpresa")
    @Operation(
            summary = "Registrar una empresa en base de datos",
            description = "Para usar este endPoint debes enviar una objeto empresa, lo cual se va guardar en Base de datos previa validacion"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS: 200 (significa registro exitoso)",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS: 400 (significa que el REQUEST esta mal)",
                    content = @Content(mediaType = "application/json")
            )
    })

    public ResponseEntity<Empresa> registrarEmpresa(@RequestBody Empresa empresa) {
        Empresa empresaRegistrada = EmpresaServ.registrarEmpresa(empresa);
        return ResponseEntity.ok(empresaRegistrada);
    }
    @GetMapping("/obtenerAll")
    @Operation(
            summary = "Obtener todas las empresas",
            description = "Este endPoint busca todos los registros de 'Empresa' en Base de Datos y te los trae."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS: 200 (significa registro exitoso)",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS: 400 (significa que el REQUEST esta mal)",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<List<Empresa>> getAll(){
        return ResponseEntity.ok(EmpresaServ.getAllStatic());
    }

    @GetMapping("/xId/{id}")
    @Operation(
            summary = "Buscar por id de empresa",
            description = "Para usar este endPoint debes enviar un id de empresa existente, lo cual se buscara en Base de Datos y se traera. "
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS: 200 (significa registro exitoso)",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS: 400 (significa que el REQUEST esta mal)",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<Empresa> obtenerxId(@PathVariable("id") Long id){
        return ResponseEntity.ok(empresaServ.buscarxId(id));
    }
    @GetMapping("/update/{id}")
    @Operation(
            summary = "Actualizar datos de empresa ",
            description = "Para usar este endPoint debes enviar un id de empresa existente, lo cual se buscara en Base de Datos y se traera. Una vez esto realizado el usuario podra actualizar los datos que desee de su empresa y guardarlos.  "
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS: 200 (significa registro exitoso)",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS: 400 (significa que el REQUEST esta mal)",
                    content = @Content(mediaType = "application/json")
            )
    })
public ResponseEntity<Empresa> updateEmpresa(@PathVariable("id") Long id ,@RequestBody Empresa request){
    return ResponseEntity.ok(empresaServ.updateEmpresa(id, request));
}

    @GetMapping("/delete/{id}")
    @Operation(
            summary = "Eliminar empresa (desactivarla)",
            description = "Para usar este endPoint debes enviar un id de empresa existente, lo cual se buscara en Base de Datos y se traera para consecuentemente desactivarla. "
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTTP STATUS: 200 (significa registro exitoso)",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTTP STATUS: 400 (significa que el REQUEST esta mal)",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<Empresa> deleteEmpresa(@PathVariable("id") Long id){
        return ResponseEntity.ok(empresaServ.deleteEmpresa(id));
    }

}
