package Hilos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import fases.Conexion;


public class ObtieneDatosHilo implements Runnable{

    public static Connection conexion;
    public static Statement statement;
	public void run() {
		
		try {
			Thread.sleep(5000);
			obtenerPacientes();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Obtiene el numero de pacientes infectados de la tabla informe
	public static void obtenerPacientes() throws SQLException {

        conexion = Conexion.getConexion();
        try {
            statement = conexion.createStatement();

            if (conexion != null) {
                //** Operaciones
                //procedimiento almacenado sin parametros
            	
            	CallableStatement st = conexion.prepareCall( "{?=call get_num_pacientes()}");

            	// Se indica que el primer interrogante es de salida.
            	st.registerOutParameter(1,Types.NUMERIC);


            	// Se hace la llamada a la función.
            	st.execute();

            	// Se recoge el resultado del primer interrogante.
            	int resultado = st.getInt(1);
            	          	
                System.out.print("El numero de infectados en la tabla de informe es "+resultado);

                Conexion.desconectar();
            } else {
                System.out.println("Conexion no realizada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }

	
}
