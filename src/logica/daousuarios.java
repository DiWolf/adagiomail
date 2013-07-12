/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.dbusuarios;
import entidades.usuarios;
import interfaces.interface_usuarios;
import java.util.ArrayList;

/**
 *
 * @author DiWolf
 */
public class daousuarios implements interface_usuarios{
    
    dbusuarios usuarios = new dbusuarios();

    @Override
    public void AgregarUsuarios(usuarios usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarUsuarios(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModificarUsuario(int idUsuario, usuarios usuario) {
       usuarios.ModificarUsuario(idUsuario, usuario);
    }

    @Override
    public ArrayList<usuarios> ListarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<usuarios> ListarUsuario(int idusuario){
        return usuarios.ListarUsuario(idusuario);
    }

    @Override
    public boolean Login(String usuaro, String Password) {
        return usuarios.Login(usuaro, Password);
    }
    
}
