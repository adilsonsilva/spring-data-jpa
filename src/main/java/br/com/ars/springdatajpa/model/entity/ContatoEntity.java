package br.com.ars.springdatajpa.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.ars.springdatajpa.enumerated.TipoContatoEnum;
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
@Table(name = "CONTATO")
public class ContatoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1723685561534059287L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long idContato;

	@Column(name = "TIPO_CONTATO", length = 100, nullable = false)
	@Enumerated
	private TipoContatoEnum tipoContato;

	@Column(name = "CONTATO", length = 100, nullable = false)
	private String contato;

	@Column(name = "OBS", length = 100, nullable = false)
	private String observacao;

	@ManyToOne
	private PessoaEntity pessoa;
	
}
