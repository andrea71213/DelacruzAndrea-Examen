package com.codigo.delacruzAndrea.service;

import com.codigo.delacruzAndrea.dao.empresaRepository;
import com.codigo.delacruzAndrea.entity.Empresa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class EmpresaSeImpl implements EmpresaServ {

    private final empresaRepository empresaRepository;

@Override
    public Empresa registarEmpresa (Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa buscarxId(Long id) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
        return optionalEmpresa.orElse(null);
    }

    @Override
    public Empresa updateEmpresa(Long id, Empresa request) {
        Optional<Empresa> empresa = empresaRepository.findById(id);

        if (empresa.isPresent()) {
            Empresa empresaExistente = empresa.get();
            empresaExistente.setTipoDocumento(request.getTipoDocumento());
            empresaExistente.setNumeroDocumento(request.getNumeroDocumento());
            empresaExistente.setCondicion(request.getCondicion());
            empresaExistente.setDireccion(request.getDireccion());
            empresaExistente.setDistrito(request.getDistrito());
            empresaExistente.setProvincia(request.getProvincia());
            empresaExistente.setDepartamento(request.getDepartamento());
            empresaExistente.setEsAgenteRetencion(request.isEsAgenteRetencion());

            return empresaRepository.save(empresaExistente);
        } else {
            return null;
        }
    }
    @Override
    public Empresa deleteEmpresa(Long id) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
        if (optionalEmpresa.isPresent()) {
            Empresa empresa = optionalEmpresa.get();
            empresa.setEstado(0);
            empresa.setDate_delet(new Date());

            return empresaRepository.save(empresa);
        } else {
            return null;
        }
    }
}