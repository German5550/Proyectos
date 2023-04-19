package pkt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GestionAlquileres {
	
	private ArrayList<Vehiculos>lista;
	private ArrayList<Reservas>reservas;
	
	public GestionAlquileres() {
		lista=new ArrayList<Vehiculos>();
		reservas=new ArrayList<Reservas>();
	}
	
	public void addVehiculo(Vehiculos v) {
		lista.add(v);
	}
	
	public void listar() {
		for(Vehiculos v :lista) {
			System.out.println(v.toString());
			if(vehiculoDisponible(v)) {
				System.out.println("Disponible");
			}else {
				System.out.println("No disponible");
			}
		}
	}
	
	public Vehiculos buscar(String matricula) {
		Vehiculos aux=null;
		for(Vehiculos v : lista) {
			if(v.getMatricula().equalsIgnoreCase(matricula)) {
				aux=v;
			}
		}
		
		return aux;
	}
	
	public boolean actualizar(String matricula, float precio) {
		boolean ok=false;
		for(int i=0 ; i<lista.size() ; i++) {
			Vehiculos v = lista.get(i);
			if(v.getMatricula().equalsIgnoreCase(matricula)) {
				v.setPrecio(precio);
				lista.set(i, v);
				ok=true;
			}
		}
		
		return ok;
	}
	
	public boolean eliminar(String matricula) {
		boolean ok=false;
		for(int i=0 ; i<lista.size() ; i++) {
			Vehiculos v = lista.get(i);
			if(v.getMatricula().equalsIgnoreCase(matricula)) {
				lista.remove(v);
				ok=true;
			}
		}
		
		return ok;
		
	}
	
	public boolean vehiculoDisponible(Vehiculos v) {
		boolean reservado=true;
		for(int i=0 ; i<reservas.size() ; i++) {
			Reservas r=reservas.get(i);
			if(v.getMatricula().equalsIgnoreCase(r.getV().getMatricula())) {
				reservado=false;
			}
		}
		
		return reservado;
	}
	
	public void eliminarReserva(String dni) {
		for(int i=0 ; i<reservas.size() ; i++){
			Reservas r=reservas.get(i);
			if(r.getDni().equalsIgnoreCase(r.getDni())) {
				reservas.remove(i);
			}
		}
	}
	
	public void alquilar(String dni, Vehiculos v) {
		Reservas r = new Reservas(LocalDate.now(),dni,v, LocalTime.now());
		reservas.add(r);
	}
	
	public void mostrar() {
		for (Reservas r : reservas) {
			System.out.println(r.toString());
		}
	}
	
	public Vehiculos obtenerVehiculoDisponible() {
		Vehiculos v=null;
		for(int i=0 ; i<lista.size() ; i++) {
			Vehiculos aux = lista.get(i);
			 if(vehiculoDisponible(aux)) {
				 v=aux;
			 }
		}
		return v;
	}

}
