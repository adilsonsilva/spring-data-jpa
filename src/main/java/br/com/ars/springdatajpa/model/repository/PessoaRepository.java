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

	PessoaEntity findPessoaById(Long id);

	Optional<PessoaEntity> findPessoaByNome(String nome);

	Set<PessoaEntity> findPessoaByNomeLike(String nome);

	Set<PessoaEntity> findPessoaByNomeStartingWith(String nome);

	Set<PessoaEntity> findPessoaByNomeEndingWith(String nome);

	Set<PessoaEntity> findPessoaByCpfNotNull();

	Set<PessoaEntity> findPessoaByCpfIsNull();

	Set<PessoaEntity> findPessoaByCpfNot(String cpf);

	Optional<PessoaEntity> findPessoaByEmailIgnoreCaseAndAtivoTrue(String email);

	Set<PessoaEntity> findPessoaByAtivoTrueOrderByName();

	Set<PessoaEntity> findPessoaByAtivoEquals();

	Set<PessoaEntity> findPessoaByDataCadastroAfter(LocalDate data);

	Set<PessoaEntity> findPessoaByDataNascimentoBetween(LocalDate inicio, LocalDate fim);

	Set<PessoaEntity> findPessoaByIdadeLessThan(int idade);

	Set<PessoaEntity> findPessoaByIdadeLessThanEqual(int idade);

	Set<PessoaEntity> findPessoaByIdadeGreaterThan(int idade);

	Set<PessoaEntity> findPessoaByIdadeGreaterThanEqual(int idade);

	Set<PessoaEntity> findPessoaByAtivoTrueAndEnderecoByEstadoEquals(String estado);

//	Set<PessoaEntity> findPessoaByAtivoTrueAndNomeContatoTipoContato(String nome, String tipo);
//
//	Set<PessoaEntity> findPessoaByAtivoTrueEnderecoEstadoIn(String... estados);

	/** Usando @Query para consultas **/
	@Query("SELECT p FROM PessoaEntity p WHERE p.cpf=:cpf")
	Optional<PessoaEntity> buscarPessoaPorCpf(@Param("cpf") String cpf);

	/** Usando @Query para consultas native query **/
	@Query(value = "SELECT * FROM PESSOA p WHERE p.ATIVO =:ativo ", nativeQuery = true)
	Set<Object> buscarPessoaPorNome(@Param("ativo") Boolean ativo);

	/** Usando @Query update/delete **/
	@Modifying
	@Transactional
	@Query(value = "UPDATE PessoaEntity SET ativo=:ativo WHERE id=:id")
	void desativarPessoa(@Param("ativo") Boolean status, @Param("id") Long id);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM PessoaEntity WHERE id=:id")
	void excluirPessoa(@Param("id") Long id);

}
