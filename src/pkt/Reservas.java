package pkt;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservas {
	
	private LocalDate fecha;
	private String dni;
	private Vehiculos v;
	private LocalTime hora;
	
	public Reservas() {
		this.fecha=LocalDate.now();
		this.dni="";
		this.v=null;
		this.hora=LocalTime.now();
	}
	
	public Reservas(LocalDate fecha, String dni, Vehiculos v, LocalTime hora) {
		this.fecha = fecha;
		this.dni = dni;
		this.v = v;
		this.hora = hora;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Vehiculos getV() {
		return v;
	}

	public void setV(Vehiculos v) {
		this.v = v;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "El dia " + getFecha() + " el cliente con DNI " + getDni() + " alquilo un " + getV()
		+ " a las " + getHora() + " horas";
	}
	
	

}
