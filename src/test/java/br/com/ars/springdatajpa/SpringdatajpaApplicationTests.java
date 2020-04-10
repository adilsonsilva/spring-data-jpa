package br.com.ars.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.ars.springdatajpa.model.entity.PessoaEntity;
import br.com.ars.springdatajpa.model.repository.PessoaRepository;


@SpringBootTest
//@SqlGroup({ @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql"),
	//	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql") })
class SpringdatajpaApplicationTests {

	@Autowired
	PessoaRepository pessoaRepository;

	@Test
	void testePessoa_buscarId() {
		PessoaEntity pessoa = pessoaRepository.findPessoaById(1l);
		assertNotNull(pessoa);
	}

}
