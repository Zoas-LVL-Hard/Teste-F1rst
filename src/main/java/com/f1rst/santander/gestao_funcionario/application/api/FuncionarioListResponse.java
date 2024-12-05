package com.f1rst.santander.gestao_funcionario.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.f1rst.santander.gestao_funcionario.domain.Funcionario;

import lombok.Value;

@Value
public class FuncionarioListResponse {
    private UUID idFuncionario;
    private String nomeFuncionario;
    private String designacaoFuncionario;

    public FuncionarioListResponse(Funcionario funcionario) {
        this.idFuncionario = funcionario.getIdFuncionario();
        this.nomeFuncionario = funcionario.getNomeFuncionario();
        this.designacaoFuncionario = funcionario.getDesignacaoFuncionario();
    }

    public static List<FuncionarioListResponse> converte(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(FuncionarioListResponse::new)
                .collect(Collectors.toList());
    }

}
