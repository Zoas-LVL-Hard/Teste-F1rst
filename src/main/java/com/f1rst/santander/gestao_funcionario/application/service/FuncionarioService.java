package com.f1rst.santander.gestao_funcionario.application.service;

import java.util.List;
import java.util.UUID;

import com.f1rst.santander.gestao_funcionario.application.api.FuncionarioAlteracaoRequest;
import com.f1rst.santander.gestao_funcionario.application.api.FuncionarioDetalhadoResponse;
import com.f1rst.santander.gestao_funcionario.application.api.FuncionarioListResponse;
import com.f1rst.santander.gestao_funcionario.application.api.FuncionarioRequest;
import com.f1rst.santander.gestao_funcionario.application.api.FuncionarioResponse;

import jakarta.validation.Valid;

public interface FuncionarioService {

    FuncionarioResponse criaFuncionario(@Valid FuncionarioRequest funcionarioRequest);

    FuncionarioDetalhadoResponse buscaFuncionarioPorId(UUID idFuncionario);

    List<FuncionarioListResponse> buscaTodosFuncionarios();

    void deletaFuncionarioPorId(UUID idFuncionario);

    void patchAtualizaFuncionario(UUID idFuncionario, FuncionarioAlteracaoRequest funcionarioAlteracaoRequest);

}
