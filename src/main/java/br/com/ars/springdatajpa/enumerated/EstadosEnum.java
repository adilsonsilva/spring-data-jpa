package br.com.ars.springdatajpa.enumerated;

public enum EstadosEnum {

	ACRE("AC"), ALAGOAS("AL"), AMAPA("AP"), AMAZONAS("AM"), BAHIA("BA"), CEARA("CE"), DISTRITO_FERDERAL(
			"DF"), ESPIRITO_SANTO("ES"), GOIAS("GO"), MARANHAO("MA"), MATO_GROSSO("MT"), MATO_GROSSO_DO_SUL(
					"MS"), MINAS_GERAIS("MG"), PARA("PA"), PARAIBA("PB"), PARANA("PR"), PERNANBUCO("PE"), PIAUI(
							"PI"), RIO_DE_JANEIRO("RJ"), RIO_GRANDE_DO_NORTE("RN"), RIO_GRANDE_DO_SUL("RS"), RONDONIA(
									"RO"), RORAIMA("RR"), SANTA_CATARINA(
											"SC"), SAO_PAULO("SP"), SSERGIPE("SE"), TOCANTINS("TO");

	public String estado;

	EstadosEnum(String estado) {
		this.estado = estado;
	}

}
