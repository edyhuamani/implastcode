package pe.com.implast.model.beans;

import java.io.Serializable;

public class InformacionProduccionBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroBobina;
	private String codigoProducto;
	private String pesoBruto;
	private String tara;
	private String pesoNeto;
	private String empalmes;
	private String probeta;
	
	public int getNumeroBobina() {
		return numeroBobina;
	}

	public void setNumeroBobina(int numeroBobina) {
		this.numeroBobina = numeroBobina;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(String pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public String getTara() {
		return tara;
	}

	public void setTara(String tara) {
		this.tara = tara;
	}

	public String getPesoNeto() {
		return pesoNeto;
	}

	public void setPesoNeto(String pesoNeto) {
		this.pesoNeto = pesoNeto;
	}

	public String getEmpalmes() {
		return empalmes;
	}

	public void setEmpalmes(String empalmes) {
		this.empalmes = empalmes;
	}

	public String getProbeta() {
		return probeta;
	}

	public void setProbeta(String probeta) {
		this.probeta = probeta;
	}

}
