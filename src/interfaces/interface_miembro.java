/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.miembros;
import java.util.ArrayList;

/**
 *
 * @author DiWolf
 */
public interface interface_miembro {

    public void AgregarMiembro(miembros miembro);

    public void EliminarMiembro(int idmiembro);

    public void ModificarMiembro(int idmiembro, miembros miembro);

    public ArrayList<miembros> ListarMiembros();

    public ArrayList<miembros> ListarMiembros(int idmiembro);
}
