package fases;

public class DatosDTO {
	
	//Clase contenedora de los datos de la las tablas
	//Persona
	private int id;	
	private String nombre;
	private String tipo;
	private int infectado;
	
	//Ciudad
	private int id_ciudad;
	private int nombreCiudad;
	
	DatosDTO(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getInfectado() {
		return infectado;
	}

	public void setInfectado(int infectado) {
		this.infectado = infectado;
	}

	public int getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(int nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
}
