package pe.com.implast.model.beans;

import java.util.List;

public class ParteExtrusionBean {
	
	private String ordenTrabajo;
	private String fechaOT;
	private String fechaEntrega;
	private String codigoMaquinaria;
	private String codigoCliente;
	private String status;
	private String horaInicio;
	private String horaFin;
	private List<InformacionMateriaPrimaBean> listaMateriasPrimas;
	private List<InformacionProduccionBean> listaProductos;
	private String codigoOperador;
	private String codigoSupervisor;
	

	public String getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public void setOrdenTrabajo(String ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public List<InformacionMateriaPrimaBean> getListaMateriasPrimas() {
		return listaMateriasPrimas;
	}

	public void setListaMateriasPrimas(
			List<InformacionMateriaPrimaBean> listaMateriasPrimas) {
		this.listaMateriasPrimas = listaMateriasPrimas;
	}

	public List<InformacionProduccionBean> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<InformacionProduccionBean> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public String getCodigoOperador() {
		return codigoOperador;
	}

	public void setCodigoOperador(String codigoOperador) {
		this.codigoOperador = codigoOperador;
	}

	public String getCodigoSupervisor() {
		return codigoSupervisor;
	}

	public void setCodigoSupervisor(String codigoSupervisor) {
		this.codigoSupervisor = codigoSupervisor;
	}

}
