package com.f1rst.santander.gestao_funcionario.application.api;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class FuncionarioRequest {

    @NotBlank
    private String nomeFuncionario;
    @NotBlank
    private String designacaoFuncionario;
    private BigDecimal salario;
    @NotBlank
    private String numeroTelefone;
    private String enderecoFuncionario;
}
