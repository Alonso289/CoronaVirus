package fases;

import java.util.ArrayList;
import Interfaces.Vacunable;

public class Enfermeras extends Persona implements Vacunable{


	Enfermeras(int id, int id_ciudad, String nombre, String tipo, boolean infectado) {
		super(id, id_ciudad, nombre, tipo, infectado);

	}
	
	//Vacuna a un paciente
	public void vacunar(Pacientes infectado) {
		
		infectado.setInfectado(false);
	}

	
	//Recorre la lista de usuarios y los vacuna
	//La enfermera vacuna en la primera pasada a 2 de cada 5 infectados. Y en la segunda 
	//pasada a 1 de cada 5.
	public void vacunar(ArrayList<Pacientes> listaPacientes) {
		
		int j=0;
		for(int i=0; i<listaPacientes.size();i++) {
			
			if(j==0)
				listaPacientes.get(i).setInfectado(false);
			j++;
			if(j==4)
				j=0;
		}
	}

}
