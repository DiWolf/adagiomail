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
public class daousuarios implements interface_usuarios {

    dbusuarios usuarios = new dbusuarios();

    @Override
    public void AgregarUsuarios(usuarios usuario) {
        usuarios.AgregarUsuarios(usuario);
    }

    @Override
    public void EliminarUsuarios(int idUsuario) {
       usuarios.EliminarUsuarios(idUsuario);
    }

    @Override
    public void ModificarUsuario(int idUsuario, usuarios usuario) {
        usuarios.ModificarUsuario(idUsuario, usuario);
    }

    @Override
    public ArrayList<usuarios> ListarUsuario() {
        return usuarios.ListarUsuario();
    }

    @Override
    public ArrayList<usuarios> ListarUsuario(int idusuario) {
        return usuarios.ListarUsuario(idusuario);
    }

    @Override
    public boolean Login(String usuaro, String Password) {
        return usuarios.Login(usuaro, Password);
    }
}
