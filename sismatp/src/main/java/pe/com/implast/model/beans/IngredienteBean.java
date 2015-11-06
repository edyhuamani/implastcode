package pe.com.implast.model.beans;

public class IngredienteBean {
	private MateriaPrimaBean materiaPrima;
	private double porcentaje;
	private double cantidad;

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public MateriaPrimaBean getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrimaBean materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
}
