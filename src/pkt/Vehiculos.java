package pkt;

import java.text.DecimalFormat;

public class Vehiculos {
	
	private String matricula;
	private int plaza;
	private char gasofa;
	private float precio;
	
	public Vehiculos() {
		this.matricula="";
		this.plaza=0;
		this.gasofa='D';
		this.precio=0.0f;
	}
	
	public Vehiculos(String matricula, int plaza, char gasofa, float precio) {
		this.matricula=matricula;
		this.plaza=plaza;
		this.gasofa=gasofa;
		this.precio=precio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getPlaza() {
		return plaza;
	}

	public void setPlaza(int plaza) {
		this.plaza = plaza;
	}

	public char getGasofa() {
		return gasofa;
	}

	public void setGasofa(char gasofa) {
		this.gasofa = gasofa;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Vehiculo con matricula " + getMatricula() + " de " + getPlaza() + 
				" plazas gasolina tipo "  + getGasofa() + " y cuesta " + df.format(getPrecio());
	}
	
	

}
