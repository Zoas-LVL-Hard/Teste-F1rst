package com.f1rst.santander.gestao_funcionario.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.f1rst.santander.gestao_funcionario.application.repository.FuncionarioRepository;
import com.f1rst.santander.gestao_funcionario.domain.Funcionario;
import com.f1rst.santander.gestao_funcionario.handler.APIException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class FuncionarioInfraRepository implements FuncionarioRepository {
    private final FuncionarioSpringDataJPARepository funcionarioSpringDataJPARepository;

    public Funcionario salva(Funcionario funcionario) {
        log.info("[Inicia] FuncionarioInfraRepository - salva");
        try {
            funcionarioSpringDataJPARepository.save(funcionario);

        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Funcionario já existe!", e);
        }
        log.info("[Finaliza] FuncionarioInfraRepository - salva");
        return funcionario;
    }

    @Override
    public Funcionario buscaFuncionarioPorId(UUID idFuncionario) {
        log.info("[Inicia] FuncionarioInfraRepository - buscaFuncionarioPorId");
        Funcionario funcionario = funcionarioSpringDataJPARepository
                .findById(idFuncionario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Funcionário não encontrado!"));
        log.info("[FInaliza] FuncionarioInfraRepository - buscaFuncionarioPorId");
        return funcionario;
    }

    @Override
    public List<Funcionario> buscaTodosFuncionarios() {
        log.info("[Inicia] FuncionarioInfraRepository - buscaTodosFuncionarios");
        List<Funcionario> todosFuncionarios = funcionarioSpringDataJPARepository.findAll();
        log.info("[FInaliza] FuncionarioInfraRepository - buscaTodosFuncionarios");
        return todosFuncionarios;
    }

    @Override
    public void deleteFuncionario(Funcionario funcionario) {
        log.info("[Inicia] FuncionarioInfraRepository - deleteFuncionario");
        funcionarioSpringDataJPARepository.delete(funcionario);
        log.info("[FInaliza] FuncionarioInfraRepository - deleteFuncionario");
    }

}
