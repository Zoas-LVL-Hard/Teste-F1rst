package com.f1rst.santander.gestao_funcionario.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f1rst.santander.gestao_funcionario.domain.Funcionario;

@Repository
public interface FuncionarioSpringDataJPARepository extends JpaRepository<Funcionario, UUID>{
   
}

