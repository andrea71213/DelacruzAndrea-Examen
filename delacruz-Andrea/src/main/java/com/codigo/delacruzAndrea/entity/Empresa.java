package com.codigo.delacruzAndrea.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter

public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razon_social")
    private String razonSocial;
private String tipoDocumento;
private String numeroDocumento;
private String condicion;
private String direccion;
private String distrito;
private String provincia;
private String departamento;
private boolean esAgenteRetencion;
private int estado;
private String usua_crea;
private String usua_modifica;
private String usua_delet;

private Date date_create;
private Date date_modific;
private Date date_delet;
}
