package com.f1rst.santander.gestao_funcionario.application.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/v1/gestao")
public interface FuncionarioAPI {

    //Todo Adicionado extra (GetClienteId), não estava nos requesitos para a construção da API e personalizado dados que irão para o front na chamada do metodo getTodosFuncionarios.

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    FuncionarioResponse postNovoFuncionario(@Valid @RequestBody FuncionarioRequest funcionarioRequest);

    @GetMapping("/{idFuncionario}")
    @ResponseStatus(HttpStatus.OK)
    FuncionarioDetalhadoResponse getClienteId(@PathVariable UUID idFuncionario);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<FuncionarioListResponse> getTodosFuncionarios();

    @DeleteMapping(value = "/{idFuncionario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletaFuncionarioId(@PathVariable UUID idFuncionario);

    @PatchMapping(value = "/{idFuncionario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void patchAtualizaFuncionario(@PathVariable UUID idFuncionario, @Valid @RequestBody FuncionarioAlteracaoRequest funcionarioAlteracaoRequest);
    

}
