package com.f1rst.santander.gestao_funcionario.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.f1rst.santander.gestao_funcionario.application.api.FuncionarioAlteracaoRequest;
import com.f1rst.santander.gestao_funcionario.application.api.FuncionarioDetalhadoResponse;
import com.f1rst.santander.gestao_funcionario.application.api.FuncionarioListResponse;
import com.f1rst.santander.gestao_funcionario.application.api.FuncionarioRequest;
import com.f1rst.santander.gestao_funcionario.application.api.FuncionarioResponse;
import com.f1rst.santander.gestao_funcionario.application.repository.FuncionarioRepository;
import com.f1rst.santander.gestao_funcionario.domain.Funcionario;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
@RequiredArgsConstructor
public class FuncionarioApplicationService implements FuncionarioService{

    private final FuncionarioRepository funcinarioRepository;

    @Override
    public FuncionarioResponse criaFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[Inicia] - FuncionarioApplicationService - criaFuncionario");
        Funcionario funcionario = funcinarioRepository.salva(new Funcionario(funcionarioRequest));
        log.info("[FInaliza] - FuncionarioApplicationService - criaFuncionario");
        return FuncionarioResponse.builder()
        .idFuncionario(funcionario.getIdFuncionario())
        .build();
    }

    @Override
    public FuncionarioDetalhadoResponse buscaFuncionarioPorId(UUID idFuncionario) {
        log.info("[Inicia] - FuncionarioApplicationService - buscaFuncionarioPorId");
        Funcionario funcionario = funcinarioRepository.buscaFuncionarioPorId(idFuncionario);
        log.info("[FInaliza] - FuncionarioApplicationService - buscaFuncionarioPorId");
        return new FuncionarioDetalhadoResponse(funcionario);
    }

    @Override
    public List<FuncionarioListResponse> buscaTodosFuncionarios() {
        log.info("[Inicia] - FuncionarioApplicationService - buscaTodosFuncionarios");
        List<Funcionario> funcionarios = funcinarioRepository.buscaTodosFuncionarios();
        log.info("[FInaliza] - FuncionarioApplicationService - buscaTodosFuncionarios");
        return FuncionarioListResponse.converte(funcionarios);
    }

    @Override
    public void deletaFuncionarioPorId(UUID idFuncionario) {
        log.info("[Inicia] - FuncionarioApplicationService - deletaFuncionarioPorId");
        Funcionario funcionario = funcinarioRepository.buscaFuncionarioPorId(idFuncionario);
        funcinarioRepository.deleteFuncionario(funcionario);
        log.info("[FInaliza] - FuncionarioApplicationService - deletaFuncionarioPorId");
    }

    @Override
    public void patchAtualizaFuncionario(UUID idFuncionario, FuncionarioAlteracaoRequest funcionarioAlteracaoRequest) {
        log.info("[Inicia] - FuncionarioApplicationService - patchAtualizaFuncionario");
        Funcionario funcionario = funcinarioRepository.buscaFuncionarioPorId(idFuncionario);
        funcionario.atualiza(funcionarioAlteracaoRequest);
        funcinarioRepository.salva(funcionario);
        log.info("[FInaliza] - FuncionarioApplicationService - patchAtualizaFuncionario");
    }
}
