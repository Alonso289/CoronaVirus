package Interfaces;

import java.util.ArrayList;

import fases.Pacientes;

public interface Vacunable{

	public void vacunar(Pacientes infectado);
	public void vacunar(ArrayList<Pacientes> listaPacientes);
}
