package pe.com.implast.model.beans;

public class ParteExtrusionBean {
	private String codigoCliente;
	private String fechaOT;
	private String fechaEntrega;
	private String horaInicio;
	private String horaFin;
	private String codigoMaquinaria;
	
	public String getCodigoMaquinaria() {
		return codigoMaquinaria;
	}
	public void setCodigoMaquinaria(String codigoMaquinaria) {
		this.codigoMaquinaria = codigoMaquinaria;
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getFechaOT() {
		return fechaOT;
	}
	public void setFechaOT(String fechaOT) {
		this.fechaOT = fechaOT;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
}
