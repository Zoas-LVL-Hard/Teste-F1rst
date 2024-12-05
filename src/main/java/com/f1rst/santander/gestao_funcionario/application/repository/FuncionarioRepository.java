package com.f1rst.santander.gestao_funcionario.application.repository;

import java.util.List;
import java.util.UUID;

import com.f1rst.santander.gestao_funcionario.domain.Funcionario;

public interface FuncionarioRepository {

    Funcionario salva(Funcionario funcionario);

    Funcionario buscaFuncionarioPorId(UUID idFuncionario);

    List<Funcionario> buscaTodosFuncionarios();

    void deleteFuncionario(Funcionario funcionario);

    


}
