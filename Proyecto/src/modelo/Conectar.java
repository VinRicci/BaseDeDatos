/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author User
 */
public class Conectar {
//  private static Connection con;
    // Declaramos los datos de conexion a la bd
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="Iron-man11";
    private static final String url="jdbc:mysql://localhost:3306/panaderiasancarlos";
    
    
//     public void conector() {
//        // Reseteamos a null la conexion a la bd
//        con=null;
//        try{
//            Class.forName(driver);
//            // Nos conectamos a la bd
//            con= (Connection) DriverManager.getConnection(url, user, pass);
//            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
//            if (con!=null){
//               // jLabel1.setText("Conexion establecida");
//               System.out.println("Conexion Establecida");
//            }
//        }
//        // Si la conexion NO fue exitosa mostramos un mensaje de error
//        catch (ClassNotFoundException | SQLException e){
//           // jLabel1.setText("Error de conexion" + e);
//           System.out.println("Error de conexion"+ e);
//        }
//    }    
    
    Connection conectar=null;
    public Connection conexion(){
        try {
            Class.forName(driver);
            conectar=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conectar;
    }
}
