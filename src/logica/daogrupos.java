/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.dbgrupos;
import entidades.grupos;
import interfaces.interface_grupos;
import java.util.ArrayList;

/**
 *
 * @author DiWolf
 */
public class daogrupos implements interface_grupos {

    dbgrupos grupos = new dbgrupos();

    @Override
    public void AgregrarGrupos(grupos grupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarGrupo(int idgrupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModificarGrupo(int idgrupo, grupos grupo) {
       grupos.ModificarGrupo(idgrupo, grupo);
    }

    @Override
    public ArrayList<grupos> ListarGrupos() {
        return grupos.ListarGrupos();
    }

    @Override
    public ArrayList<grupos> ListarGrupos(int idgrupo) {
        return grupos.ListarGrupos(idgrupo);
    }
}
