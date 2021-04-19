package fases;

import java.util.ArrayList;
import java.util.Random;

public class Ciudad {

	//Clase contenedora de las listas
	public static ArrayList<Enfermeras> listaEnfermeras;
	public static ArrayList<Pacientes> listaPacientes;
	
	//Los usuarios proceden a hacer cosas aleatorias y la enfermera vacuna
	public static void simularDia() {
		
		boolean infectado = false;
		int j=0;
		
		Enfermeras enfermera = listaEnfermeras.get(listaEnfermeras.size()-1);
		
		for(int i=0; i<listaPacientes.size();i++) {
			int aleatorio = new Random().nextInt(2)+1;			
			
			if(aleatorio>1) {
				listaPacientes.get(i).cogerTransporte();
				infectado = listaPacientes.get(i).getInfectado();
				aleatorio = new Random().nextInt(2)+1;	
				if(!infectado && aleatorio>1)
					listaPacientes.get(i).visitarTrabajo();
				else
					if(!infectado)
						listaPacientes.get(i).visitarSuper();
			}	
				
			if(j==0 && j==1)
				enfermera.vacunar(listaPacientes.get(i));
			j++;
			if(j==4)
				j=0;
				
		}
		enfermera.vacunar(listaPacientes);
		
		ArrayList<Pacientes> listaInfectableAuxiliar = new ArrayList<>();
		for(int i=0; i<listaPacientes.size();i++) {
			
			if(listaPacientes.get(i).getInfectado())
				listaInfectableAuxiliar.add(listaPacientes.get(i));
		}
		listaPacientes = listaInfectableAuxiliar;
			
	}
	
}
