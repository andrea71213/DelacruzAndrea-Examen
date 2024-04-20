package com.codigo.delacruzAndrea.dao;

import com.codigo.delacruzAndrea.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface empresaRepository extends JpaRepository<Empresa, Long> {

}