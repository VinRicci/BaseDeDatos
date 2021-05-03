/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author User
 */
public class BdUsuarios extends Conectar{
    Conectar cnn=new Conectar();
    
    public boolean registrar(Usuario usr){
        PreparedStatement ps=null;
        Connection con=cnn.conexion();
        String sql="INSERT INTO usuario (Id_Usuario,Nombre,Apellido,Contrasena,Telefono,Fecha_Nacimiento,Cargo) VALUES(?,?,?,?,?,?,?)";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, usr.getId());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getApellido());
            ps.setString(4, usr.getPass());
            ps.setString(5, usr.getTelefono());
            ps.setString(6, usr.getFechanac());
            ps.setString(7, usr.getCargo());
            ps.execute();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BdUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        }
    }
    
    public int existeusuario(int id){
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=cnn.conexion();
        String sql="SELECT COUNT(Id_Usuario) FROM usuario WHERE Id_Usuario=?";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(BdUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 1;
        }
    }
    
     public boolean login(Usuario usr){
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=cnn.conexion();
        String sql="SELECT Id_Usuario, Contrasena, Cargo FROM usuario WHERE Id_Usuario=? ";
        
        try{ 
            ps=con.prepareStatement(sql);
            ps.setInt(1, usr.getId());
            rs=ps.executeQuery();
            if(rs.next()){
                if(usr.getPass().equals(rs.getString(2))){
                    usr.setId(rs.getInt(1));
                    usr.setCargo(rs.getString(3));
                    //usr.setTipo_cargo(rs.getString(4));
                    return true;
                }else{
                    return false;
                }
            }
         return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(BdUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        }
    }
    
}
