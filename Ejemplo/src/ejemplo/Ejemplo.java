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
       String clave="mysql2017";
        try {
            conexion=DriverManager.getConnection(url,usuario,clave);
            System.out.println("Por fin llegue");
            String cadena= "INSERT INTO ejemplo (idejemplo,dato) VALUES (2,3)";
            //1. cREAR OBJETO
            Statement sentencia;
            sentencia= conexion.createStatement();
            sentencia.execute(cadena);
            
        } catch (SQLException ex) {
//            Logger.getLogger(Ejemplo.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex);
//            ex.getErrorCode();
            int guardar;
            guardar=ex.getErrorCode();
            System.out.println(guardar);
            System.out.println(ex);
            switch (guardar) {
                case 1049:
                {
                    System.out.println("Base de Datos Incorrecta");
                    break;
                }
                case 1062:
                {
                  System.out.println("la llave primaria se ha duplicado");
                  break;
                                 
                }
                default:
                  System.out.println("no se sabe el error");  
        
            }
        }
        
       
    }
    
}
