package br.com.ars.springdatajpa.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.ars.springdatajpa.enumerated.EstadosEnum;
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
@Table(name = "ENDERECO")
public class EnderecoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long idEndereco;

	@Column(name = "LOFRADOURO", length = 100, nullable = false)
	private String logradouro;

	@Column(name = "BAIRRO", length = 100, nullable = false)
	private String bairro;

	@Column(name = "CIDADE", length = 100, nullable = false)
	private String cidade;

	@Column(name = "ESTADO", length = 2, nullable = false)
	@Enumerated
	private EstadosEnum estado;

	@Column(name = "CEP", length = 7, nullable = false)
	private String cep;

	@Column(name = "NUMERO", length = 5, nullable = false)
	private String numero;

	@Column(name = "COMPLEMENTO", length = 100)
	private String complemento;

	@Column(name = "OBS", length = 500)
	private String observacoes;
}
