package br.com.ars.springdatajpa.enumerated;

public enum SexoEnum {

	FEMININO("FEMININO"), MASCULINO("MASCULINO");

	public String sexo;

	SexoEnum(String sexo) {
		this.sexo = sexo;
	}

}
