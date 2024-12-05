package com.f1rst.santander.gestao_funcionario.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FuncionarioResponse {
    private UUID idFuncionario;
}
