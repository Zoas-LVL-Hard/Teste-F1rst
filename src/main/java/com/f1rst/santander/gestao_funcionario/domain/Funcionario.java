package com.f1rst.santander.gestao_funcionario.domain;

import java.math.BigDecimal;
import java.util.UUID;

import com.f1rst.santander.gestao_funcionario.application.api.FuncionarioAlteracaoRequest;
import com.f1rst.santander.gestao_funcionario.application.api.FuncionarioRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Data
@Table
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idCliente", updatable = false, unique = true, nullable = false)
    private UUID idFuncionario;
    @NotBlank
    private String nomeFuncionario;
    @NotBlank
    private String designacaoFuncionario;
    private BigDecimal salario;
    @NotBlank
    @Column(unique = true)
    private String numeroTelefone;
    private String enderecoFuncionario;

    public Funcionario(FuncionarioRequest funcionarioRequest) {
        this.nomeFuncionario = funcionarioRequest.getNomeFuncionario();
        this.designacaoFuncionario = funcionarioRequest.getDesignacaoFuncionario();
        this.salario = BigDecimal.valueOf(0.00);
        this.numeroTelefone = funcionarioRequest.getNumeroTelefone();
        this.enderecoFuncionario = funcionarioRequest.getEnderecoFuncionario();
    }

    public void atualiza(FuncionarioAlteracaoRequest funcionarioAlteracaoRequest) {
        this.nomeFuncionario = funcionarioAlteracaoRequest.getNomeFuncionario();
        this.designacaoFuncionario = funcionarioAlteracaoRequest.getDesignacaoFuncionario();
        this.salario = BigDecimal.valueOf(0.00);
        this.numeroTelefone = funcionarioAlteracaoRequest.getNumeroTelefone();
        this.enderecoFuncionario = funcionarioAlteracaoRequest.getEnderecoFuncionario();
    }    
}
