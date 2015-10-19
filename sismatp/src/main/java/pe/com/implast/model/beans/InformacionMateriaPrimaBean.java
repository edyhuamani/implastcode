package pe.com.implast.model.beans;

import java.io.Serializable;

public class InformacionMateriaPrimaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pebd;
	private String codigoMateriaPrima;
	private String descMateriaPrima;
	private String tolvaInicial;
	private String pisoInicial;
	private String abastecido;
	private String consumo;
	private String tolvaFinal;
	private String pisoFinal;
	
	public String getPebd() {
		return pebd;
	}

	public void setPebd(String pebd) {
		this.pebd = pebd;
	}

	public String getCodigoMateriaPrima() {
		return codigoMateriaPrima;
	}

	public void setCodigoMateriaPrima(String codigoMateriaPrima) {
		this.codigoMateriaPrima = codigoMateriaPrima;
	}

	public String getDescMateriaPrima() {
		return descMateriaPrima;
	}

	public void setDescMateriaPrima(String descMateriaPrima) {
		this.descMateriaPrima = descMateriaPrima;
	}

	public String getTolvaInicial() {
		return tolvaInicial;
	}

	public void setTolvaInicial(String tolvaInicial) {
		this.tolvaInicial = tolvaInicial;
	}

	public String getPisoInicial() {
		return pisoInicial;
	}

	public void setPisoInicial(String pisoInicial) {
		this.pisoInicial = pisoInicial;
	}

	public String getAbastecido() {
		return abastecido;
	}

	public void setAbastecido(String abastecido) {
		this.abastecido = abastecido;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}

	public String getTolvaFinal() {
		return tolvaFinal;
	}

	public void setTolvaFinal(String tolvaFinal) {
		this.tolvaFinal = tolvaFinal;
	}

	public String getPisoFinal() {
		return pisoFinal;
	}

	public void setPisoFinal(String pisoFinal) {
		this.pisoFinal = pisoFinal;
	}
}
