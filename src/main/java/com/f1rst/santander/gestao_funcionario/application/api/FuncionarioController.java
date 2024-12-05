package com.f1rst.santander.gestao_funcionario.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.f1rst.santander.gestao_funcionario.application.service.FuncionarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class FuncionarioController implements FuncionarioAPI {
    private final FuncionarioService funcionarioService;

    @Override
    public FuncionarioResponse postNovoFuncionario(@Valid FuncionarioRequest funcionarioRequest) {
        log.info("[Inicia] FuncionarioController - postNovoFuncionario");
        FuncionarioResponse funcionarioCriado = funcionarioService.criaFuncionario(funcionarioRequest);
        log.info("[FInaliza] FuncionarioController - postNovoFuncionario");
        return funcionarioCriado;
    }

    @Override
    public FuncionarioDetalhadoResponse getClienteId(UUID idFuncionario) {
        log.info("[Inicia] FuncionarioController - getClienteId");
        FuncionarioDetalhadoResponse funcionarioDetalhado = funcionarioService.buscaFuncionarioPorId(idFuncionario);
        log.info("[FInaliza] FuncionarioController - getClienteId");
        return funcionarioDetalhado;
    }

    @Override
    public List<FuncionarioListResponse> getTodosFuncionarios() {
        log.info("[Inicia] FuncionarioController - getTodosFuncionarios");
        List<FuncionarioListResponse> funcionarios = funcionarioService.buscaTodosFuncionarios();
        log.info("[FInaliza] FuncionarioController - getTodosFuncionarios");
        return funcionarios;
    }

    @Override
    public void deletaFuncionarioId(UUID idFuncionario) {
        log.info("[Inicia] FuncionarioController - deletaFuncionarioId");
        log.info("[idFuncionario] {}", idFuncionario);
        funcionarioService.deletaFuncionarioPorId(idFuncionario);
        log.info("[FInaliza] FuncionarioController - deletaFuncionarioId");
    }

    @Override
    public void patchAtualizaFuncionario(UUID idFuncionario, @Valid FuncionarioAlteracaoRequest funcionarioAlteracaoRequest) {
        log.info("[Inicia] FuncionarioController - patchAtualizaFuncionario");
        log.info("[idFuncionario] {}", idFuncionario);
        funcionarioService.patchAtualizaFuncionario(idFuncionario, funcionarioAlteracaoRequest);
        log.info("[FInaliza] FuncionarioController - patchAtualizaFuncionario");
    }

}
