/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author guill
 */
public class AccessDB {

    private Connection conexionBD;

    /**
     * Constructor private.
     */
    public AccessDB() {
        abrirConexionBD();
    }

    private void abrirConexionBD() {
        if (conexionBD == null) {
            String tablaConexionBD = "jdbc:mysql://den1.mysql5.gear.host:3306/omgyeah"; //Conexión con nuestra BD
            try {
                Class.forName("com.mysql.jdbc.Driver"); //El driver de mysql
                //Conexión teniendo en cuenta el usuario y clave de administrador de la BD
                conexionBD = DriverManager.getConnection(tablaConexionBD, "omgyeah", "Sn54bA4--5l7");

            } catch (Exception e) {
                //Error en la conexión con la BD
                System.out.println("No se ha completado la peticion...");
            }
        }
    }
    
    public String getManolo(){
         if (conexionBD == null) //Se comprueba que la conexión con la BD esté abierta
        {
            abrirConexionBD();
        }
    
        
        try {
            ResultSet resultados =null;
            String con;
            Statement s = conexionBD.createStatement();
            //Consulta, buscamos una correspondencia usuario/clave
            con = "SELECT * FROM `usuarios` WHERE id='1' and clave='juan'";
            resultados = s.executeQuery(con);
            while(resultados.next()){
                System.out.println(resultados.getInt(1)+ " " +resultados.getString(2));
                return  resultados.getString(2);
            }
            return "error in resultset pointer";
            
           
        } catch (Exception e) {
            //Error en la conexión con la BD
            System.out.println("te has quedado aki");
            System.out.println(e);
                   
            
            return "no va";
        }
    }
}
