package pkt;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) throws Exception {
		
		GestionAlquileres g = new GestionAlquileres();
		ArrayList<Reservas> coche = new ArrayList<Reservas>();
		Scanner ent = new Scanner(System.in);
		int opcion=0;
		
		do {
			System.out.println("1º) Añadir vehiculo \n" +
					"2º) Listar vehiculos \n" +
					"3º) Buscar vehiculo \n" +
					"4º) Actualizar vehiculo \n" +
					"5º) Eliminar vehiculo \n" +
					"6º) Hacer reserva \n" +
					"7º) Mostrar reserva \n" +
					"8º) Devolver coche \n" +
					"0º) Salir ");
			try {
				opcion = Integer.parseInt(ent.nextLine());
				
				switch(opcion) {
				case 1:addVehiculo(g);
					break;
					
				case 2:g.listar();
					break;
					
				case 3:
					System.out.println("Introduce la matricula");
					String matricula=ent.nextLine();
					Vehiculos v=g.buscar(matricula);
					System.out.println(v.toString());
					break;
					
				case 4:
					System.out.println("Introduzca la matricula");
					String matricula1=ent.nextLine();
					System.out.println("Introduzca el precio");
					float precio=ent.nextFloat();
					g.actualizar(matricula1, precio);
					break;
					
				case 5:
					System.out.println("Introduce la matricula");
					String matricula2=ent.nextLine();
					g.eliminar(matricula2);
					break;
					
				case 6:
					System.out.println("Introduce el dni");
					String dni=ent.nextLine();
					Vehiculos v1=g.obtenerVehiculoDisponible();
					if(v1!=null) {
						g.alquilar(dni, v1);
					}else {
						System.out.println("No hay vehiculos disponibles");
					}
					
					break;
				
				case 7:g.mostrar();
					break;
					
				case 8:
					System.out.println("Introduce el dni");
					String dni1=ent.nextLine();
					g.eliminarReserva(dni1);
					break;
				case 0:
					break;
				default: System.out.println("Opción no valida");
				}
			}catch(NumberFormatException ex) {
				System.out.println("Dato no numérico");
				opcion=99;
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}while(opcion!=0);
		 System.out.println("Adios");
	}
	
	public static void addVehiculo (GestionAlquileres g) throws Exception {
		
		Scanner ent = new Scanner(System.in);
		String matricula="", entTeclado="";
		int plaza=0;
		char gasofa='D';
		float precio=0.0f;
		boolean sinErrores=true, salir=false;
		
		//Control de la matricula
		do {
			sinErrores=true;
			System.out.println("Introduce la matricula del vehiculo");
			matricula=ent.nextLine();
			if(matricula.equalsIgnoreCase("salir")) {
				System.out.println("Adios");
				sinErrores=false;
				salir=true;
			}
			if(matricula.isEmpty()) {
				throw new Exception("No puede estar vacio");
			}
		}while(!sinErrores && !salir);
		
		if(!salir) {
			//Control de las plazas
			do{
				sinErrores=true;
				System.out.println("Cuantas plazas quiere");
				plaza= Integer.parseInt(ent.nextLine());
				if(entTeclado.equalsIgnoreCase("salir")) {
					System.out.println("Adios");
					sinErrores=false;
					salir=true;
				}
			}while(!sinErrores && !salir);
			
		if(!salir) {
			//Control de la gasolina
			do {
				sinErrores=true;
				System.out.println("Introduce el tipo de gasolina");
				gasofa=ent.nextLine().charAt(0);
				if(entTeclado.equalsIgnoreCase("salir")) {
					System.out.println("Adios");
					sinErrores=false;
					salir=true;
				}
			}while(!sinErrores && !salir);
		}
		
		if(!salir) {
			//Control del precio
			do {
				sinErrores=true;
				System.out.println("Introduce el precio del vehiculo");
				precio=Float.parseFloat(ent.nextLine());
				if(entTeclado.equalsIgnoreCase("salir")) {
					System.out.println("Adios");
					sinErrores=false;
					salir=true;
				}
			}while(!sinErrores && !salir);
		}
		
		if(sinErrores) {
			g.addVehiculo(new Vehiculos(matricula,plaza,gasofa,precio));
		}
		
		}
	}
	
}
