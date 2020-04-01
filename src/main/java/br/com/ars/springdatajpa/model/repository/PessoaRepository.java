package br.com.ars.springdatajpa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ars.springdatajpa.model.entity.PessoaEntity;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

}
