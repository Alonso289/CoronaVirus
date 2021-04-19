package fases;

import java.util.Random;

import Interfaces.Infectable;
import Interfaces.Moveable;

public class Pacientes extends Persona implements Infectable, Moveable{

	
	Pacientes(int id, int id_ciudad, String nombre, String tipo, boolean infectado) {
		super(id, id_ciudad, nombre, tipo, infectado);

	}

	//Los pacientes tiene probabilidad de infectarse segun la accion a realizar
	public void visitarSuper() {
		if(new Random().nextInt(100)+1<10) 
			infectar(true);			
	}

	
	public void visitarTrabajo() {
		
		if(new Random().nextInt(100)+1<12)
			infectar(true);
	}

	
	public void cogerTransporte() {
		
		if(new Random().nextInt(100)+1<16)
			infectar(true);
	}

	
	public void infectar(boolean infectado) {
		
		setInfectado(infectado);
	}

}
