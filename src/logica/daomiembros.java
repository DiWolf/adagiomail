/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.dbmiembros;
import entidades.miembros;
import interfaces.interface_miembro;
import java.util.ArrayList;

/**
 *
 * @author DiWolf
 */
public class daomiembros implements interface_miembro {

    //creamos un objeto de la clase dbmiembros
    private dbmiembros dbmiembros_ = new dbmiembros();

    @Override
    public void AgregarMiembro(miembros miembro) {
        dbmiembros_.AgregarMiembro(miembro);
    }

    @Override
    public void EliminarMiembro(int idmiembro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModificarMiembro(int idmiembro, miembros miembro) {
        dbmiembros_.ModificarMiembro(idmiembro, miembro);
    }

    @Override
    public ArrayList<miembros> ListarMiembros() {
        return dbmiembros_.ListarMiembros();
    }

    @Override
    public ArrayList<miembros> ListarMiembros(int idmiembro) {
        return dbmiembros_.ListarMiembros(idmiembro);
    }
}
