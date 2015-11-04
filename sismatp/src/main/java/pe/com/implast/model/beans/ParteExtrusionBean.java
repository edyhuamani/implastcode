package pe.com.implast.model.beans;

import java.util.List;

public class ParteExtrusionBean {
	
	private String ordenTrabajo;
	private String fechaOT;
	private String fechaEntrega;
	private String codigoMaquina;
	private String codigoCliente;
	private String codigoSap; 
	private String status;
	private String horaInicio;
	private String horaFin;
	private String codigoProducto;
	private MezclaBean mezcla;
	private List<InformacionMateriaPrimaBean> listaMateriasPrimas;
	private List<InformacionProduccionBean> listaProductos;
	private String codigoOperador;
	private String codigoSupervisor;
	private String ancho;
	private String espesor;
	private String tratado;
	private String solapa;
	private String fuelle;
	private String grMLin;
	private String minimoMateriaPrima;
	private String maximoMateriaPrima;
	private String minimoProduccion;
	private String maximoProduccion;
	private String scrap;
	private String codigoTipoManga;

	public String getCodigoSap() {
		return codigoSap;
	}

	public void setCodigoSap(String codigoSap) {
		this.codigoSap = codigoSap;
	}

	public String getAncho() {
		return ancho;
	}

	public void setAncho(String ancho) {
		this.ancho = ancho;
	}

	public String getEspesor() {
		return espesor;
	}

	public void setEspesor(String espesor) {
		this.espesor = espesor;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getTratado() {
		return tratado;
	}

	public void setTratado(String tratado) {
		this.tratado = tratado;
	}

	public String getSolapa() {
		return solapa;
	}

	public void setSolapa(String solapa) {
		this.solapa = solapa;
	}

	public String getFuelle() {
		return fuelle;
	}

	public void setFuelle(String fuelle) {
		this.fuelle = fuelle;
	}

	public String getMinimoProduccion() {
		return minimoProduccion;
	}

	public void setMinimoProduccion(String minimoProduccion) {
		this.minimoProduccion = minimoProduccion;
	}

	public String getMaximoProduccion() {
		return maximoProduccion;
	}

	public void setMaximoProduccion(String maximoProduccion) {
		this.maximoProduccion = maximoProduccion;
	}

	public String getScrap() {
		return scrap;
	}

	public void setScrap(String scrap) {
		this.scrap = scrap;
	}

	public String getCodigoTipoManga() {
		return codigoTipoManga;
	}

	public void setCodigoTipoManga(String codigoTipoManga) {
		this.codigoTipoManga = codigoTipoManga;
	}

	public String getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public void setOrdenTrabajo(String ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public String getCodigoMaquina() {
		return codigoMaquina;
	}

	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}

	public MezclaBean getMezcla() {
		return mezcla;
	}

	public void setMezcla(MezclaBean mezcla) {
		this.mezcla = mezcla;
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
	
	public String getMinimoMateriaPrima() {
		return minimoMateriaPrima;
	}

	public void setMinimoMateriaPrima(String minimoMateriaPrima) {
		this.minimoMateriaPrima = minimoMateriaPrima;
	}

	public String getMaximoMateriaPrima() {
		return maximoMateriaPrima;
	}

	public void setMaximoMateriaPrima(String maximoMateriaPrima) {
		this.maximoMateriaPrima = maximoMateriaPrima;
	}
	
	public String getGrMLin() {
		return grMLin;
	}

	public void setGrMLin(String grMLin) {
		this.grMLin = grMLin;
	}



}
