/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.usuarios;
import java.util.ArrayList;

/**
 *
 * @author DiWolf
 */
public interface interface_usuarios {

    public void AgregarUsuarios(usuarios usuario);

    public void EliminarUsuarios(int idUsuario);

    public void ModificarUsuario(int idUsuario, usuarios usuario);

    public ArrayList<usuarios> ListarUsuario();

    public ArrayList<usuarios> ListarUsuario(int idUsuario);

    public boolean Login(String usuaro, String Password);
}
