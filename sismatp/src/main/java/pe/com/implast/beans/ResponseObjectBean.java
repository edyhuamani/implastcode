package pe.com.implast.beans;

import java.util.List;

public class ResponseObjectBean<T> {
	
	private String respuesta;
	private String tipoMensaje;
	private String mensaje;
	private List<MensajeValidacionBean> listaMensajesValidacion;
	private T objeto;
	
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String getTipoMensaje() {
		return tipoMensaje;
	}
	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<MensajeValidacionBean> getListaMensajesValidacion() {
		return listaMensajesValidacion;
	}
	public void setListaMensajesValidacion(
			List<MensajeValidacionBean> listaMensajesValidacion) {
		this.listaMensajesValidacion = listaMensajesValidacion;
	}
	public T getObjeto() {
		return objeto;
	}
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

}
