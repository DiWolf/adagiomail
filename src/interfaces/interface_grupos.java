/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.grupos;
import java.util.ArrayList;

/**
 *
 * @author DiWolf
 */
public interface interface_grupos {

    public void AgregrarGrupos(grupos grupo);

    public void EliminarGrupo(int idgrupo);

    public void ModificarGrupo(int idgrupo, grupos grupo);

    public ArrayList<grupos> ListarGrupos();

    public ArrayList<grupos> ListarGrupos(int idgrupo);
}
