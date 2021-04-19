package fases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import Hilos.InsertaDatosHilo;
import Hilos.ObtieneDatosHilo;

//Clase que contiene el main
public class Principal {

	public static Logger logger = LogManager.getLogger(Principal.class);
	public static void main(String[] args) {
						
		String url = ".\\resources\\log4j.properties";
		PropertyConfigurator.configure(url);
		
		
		//Creamos el objeto con los datos y obtenemos la ciudad por teclado
		DatosDTO datos = new DatosDTO();
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca el id de una ciudad: (valor entero como 9): ");
		int nombreCiudad = teclado.nextInt();
		datos.setNombreCiudad(nombreCiudad);
		try {
			//Iniciamos la conexion y obtenemos los usuarios
			System.out.println("Iniciando conexion..");
			ArrayList<Persona> listaPersonas = DatosControlador.obtenerDatos(datos);
			System.out.println("Registros obtenidos");
			
			//Asignamos los usuarios a su lista correspondiente de la clase ciudad
			ArrayList<Pacientes> listaPacientes = new ArrayList<>();
			ArrayList<Enfermeras> listaEnfermeras = new ArrayList<>();
			for(int i=0; i<listaPersonas.size();i++) {			
				if(listaPersonas.get(i).getTipo().equalsIgnoreCase("e")) {
					
					Enfermeras enfermera = new Enfermeras(listaPersonas.get(i).getId(), listaPersonas.get(i).getId_ciudad(), listaPersonas.get(i).getNombre(), listaPersonas.get(i).getTipo(), listaPersonas.get(i).getInfectado());					
					listaEnfermeras.add(enfermera);
					
				}else {
					Pacientes paciente = new Pacientes(listaPersonas.get(i).getId(), listaPersonas.get(i).getId_ciudad(), listaPersonas.get(i).getNombre(), listaPersonas.get(i).getTipo(), listaPersonas.get(i).getInfectado());					
					listaPacientes.add(paciente);
				}
				Principal.logger.info("Se han obtenido la lista enfemeras y la lista pacientes");
			}
			
			Ciudad.listaPacientes = listaPacientes;
			Ciudad.listaEnfermeras = listaEnfermeras;
			System.out.println("Hay un total de "+Ciudad.listaPacientes.size()+" usuarios al principio del dia");
			System.out.println("Hay un total de "+Ciudad.listaEnfermeras.size()+" enfermeras al principio del dia");
			Ciudad.simularDia();			
			System.out.println("Hay un total de "+Ciudad.listaPacientes.size()+" infectados al final del dia");    
			
			//Hilos que insertan usuarios infectado en la tabla informe
			InsertaDatosHilo uno = new InsertaDatosHilo();
			Thread hiloUno = new Thread(uno, "1");
			hiloUno.start();
			InsertaDatosHilo dos = new InsertaDatosHilo();
			Thread hiloDos = new Thread(dos, "1");
			hiloDos.start();
			InsertaDatosHilo tres = new InsertaDatosHilo();
			Thread hiloTres = new Thread(tres, "1");
			hiloTres.start();
			InsertaDatosHilo cuatro = new InsertaDatosHilo();
			Thread hiloCuatro = new Thread(cuatro, "1");
			hiloCuatro.start();
			
			//Hilo que obtiene el numero de usuarios infectado en la tabla informe
			ObtieneDatosHilo cinco = new ObtieneDatosHilo();
			Thread hiloCinco = new Thread(cinco, "5");
			hiloCinco.start();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		teclado.close();
		Principal.logger.info("Programa finalizado");
	}
}
