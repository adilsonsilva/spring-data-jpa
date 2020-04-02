package br.com.ars.springdatajpa.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "PESSOA")
public class PessoaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;

	@Column(name = "CPF", length = 11, nullable = false)
	private String cpf;

	@Column(name = "DT_NASCIMENTO", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "IDADE", length = 3, nullable = false)
	private Integer idade;

	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;

	@Column(name = "STATUS", nullable = false)
	private Boolean status;

	@Column(name = "DATA_CADASTRO", nullable = false)
	private LocalDate dataCadastro;

	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
	private EnderecoEntity endereco;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
	private Set<ContatoEntity> contatos;

}
