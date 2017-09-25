package ejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ejemplo {
     
    public static void main(String[] args) {
       Connection conexion;
       String url="jdbc:mysql://localhost:3306/javadb";
       String usuario="root";
       String clave="frank3194985608";
        try {
            conexion=DriverManager.getConnection(url,usuario,clave);
            System.out.println("Por fin llegue");
            String cadena= "INSERT INTO ejemplo (idejemplo,dato) VALUES (2,3)";
            //1. cREAR OBJETO
            Statement sentencia;
            sentencia= conexion.createStatement();
            sentencia.execute(cadena);
            
        } catch (SQLException ex) {
            Logger.getLogger(Ejemplo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            ex.getErrorCode();
        }
        
       
    }
    
}
