package pe.com.implast.beans;

public class MensajeValidacionBean {
	
	private String mensaje;
	private String campo;
	
	public MensajeValidacionBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MensajeValidacionBean(String mensaje, String campo) {
		super();
		this.mensaje = mensaje;
		this.campo = campo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	@Override
	public String toString() {
		return "MensajeValidacionBean [mensaje=" + mensaje + ", campo=" + campo
				+ "]";
	}
	
}
