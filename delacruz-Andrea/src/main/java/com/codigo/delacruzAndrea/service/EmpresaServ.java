package com.codigo.delacruzAndrea.service;

import com.codigo.delacruzAndrea.entity.Empresa;

import java.util.List;

public interface EmpresaServ {
    static Empresa registrarEmpresa(Empresa empresa) {
        return null;
    }

    Empresa registarEmpresa(Empresa empresa);

    static List<Empresa> getAllStatic() {
        return null;
    }

    List<Empresa> getAll();

    Empresa buscarxId(Long id);
        Empresa updateEmpresa(Long id, Empresa request);
        Empresa deleteEmpresa(Long id);
}
