package br.com.ars.springdatajpa.model.repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ars.springdatajpa.model.entity.PessoaEntity;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

	Optional<PessoaEntity> findPessoaId(Long id);

	Optional<PessoaEntity> findPessoaName(String nome);

	Set<PessoaEntity> findPessoaNameLike(String nome);

	Set<PessoaEntity> findPessoaNameStartingWith(String nome);

	Set<PessoaEntity> findPessoaNameEndingWith(String nome);

	Set<PessoaEntity> findPessoaCpfNotNull();

	Set<PessoaEntity> findPessoaCpfIsNull();

	Set<PessoaEntity> findPessoaCpfNot(String cpf);

	Optional<PessoaEntity> findPessoaEmailIgnoreCaseAndAtivoTrue(String email);

	Set<PessoaEntity> findPessoaAtivoTrueOrderByName();

	Set<PessoaEntity> findPessoaAtivoEquals();

	Set<PessoaEntity> findPessoaDateCadastroAfter(LocalDate data);

	Set<PessoaEntity> findPessoaDateNascimentoBetween(LocalDate inicio, LocalDate fim);

	Set<PessoaEntity> findPessoaIdadeLessThan(int idade);

	Set<PessoaEntity> findPessoaIdadeLessThanEqual(int idade);

	Set<PessoaEntity> findPessoaIdadeGreaterThan(int idade);

	Set<PessoaEntity> findPessoaIdadeGreaterThanEqual(int idade);

	Set<PessoaEntity> findPessoaAtivaTrueEnderecoEstadoEquals(String estado);

	Set<PessoaEntity> findPessoaAtivaTrueAndNameContatoTipoContato(String nome, String tipo);

	Set<PessoaEntity> findPessoaAtivaTrueEnderecoEstadoIn(String... estados);

	/** Usando @Query para consultas **/
	@Query("SELECT p FROM PessoaEntity p WHERE p.cpf=:cpf")
	Optional<PessoaEntity> buscarPessoaPorCpf(@Param("cpf") String cpf);

	/** Usando @Query para consultas native query **/
	@Query(name = "SELECT * FROM PESSOA WHERE ATIVO =:ativo ", nativeQuery = true)
	Set<PessoaEntity> buscarPessoaPorNome(@Param("ativo") Boolean ativo);

	/** Usando @Query update/delete **/
	@Modifying
	@Transactional
	@Query(name = "UPDATE PessoaEntity SET ativo=:ativo WHERE id=:id")
	void desativarPessoa(@Param("ativo") Boolean status, @Param("id") Long id);

	@Modifying
	@Transactional
	@Query(name = "DELETE FROM PessoaEntity WHERE id=:id")
	void excluirPessoa(@Param("id") Long id);

}
