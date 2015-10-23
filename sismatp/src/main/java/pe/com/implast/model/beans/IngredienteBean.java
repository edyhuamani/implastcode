package pe.com.implast.model.beans;

public class IngredienteBean {
	private MateriaPrimaBean materiaPrima;
	private int porcentaje;
	private int cantidad;
	
	public MateriaPrimaBean getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrimaBean materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
