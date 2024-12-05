package com.f1rst.santander.gestao_funcionario.application.api;

import java.math.BigDecimal;
import java.util.UUID;

import com.f1rst.santander.gestao_funcionario.domain.Funcionario;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class FuncionarioDetalhadoResponse {

    private UUID idFuncionario;
    @NotBlank
    private String nomeFuncionario;
    @NotBlank
    private String designacaoFuncionario;
    private BigDecimal salario;
    @NotBlank
    private String numeroTelefone;
    private String enderecoFuncionario;

    public FuncionarioDetalhadoResponse(Funcionario funcionario) {
        this.idFuncionario = funcionario.getIdFuncionario();
        this.nomeFuncionario = funcionario.getNomeFuncionario();
        this.designacaoFuncionario = funcionario.getDesignacaoFuncionario();
        this.salario = BigDecimal.valueOf(0.00);
        this.numeroTelefone = funcionario.getNumeroTelefone();
        this.enderecoFuncionario = funcionario.getEnderecoFuncionario();
    }
}
