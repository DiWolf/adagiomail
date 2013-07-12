/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.grupos;
import interfaces.interface_grupos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DiWolf
 */
public class dbgrupos implements interface_grupos {

    private Connection cnx = new Conexion().getConnection();
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public void AgregrarGrupos(grupos grupo) {
        try {
            preparedStatement = cnx.prepareStatement("INSERT INTO cat_grupos VALUES (default,?)");
            preparedStatement.setString(1, grupo.getGrupo());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            close();
        }
    }

    @Override
    public void EliminarGrupo(int idgrupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModificarGrupo(int idgrupo, grupos grupo) {
       
        try{
            preparedStatement = cnx.prepareStatement("UPDATE cat_grupos SET grupo=? WHERE idgrupo=?");
            preparedStatement.setString(1, grupo.getGrupo());
            preparedStatement.setInt(2, idgrupo);
            preparedStatement.executeUpdate();
        }catch(SQLException ex) {
            Logger.getLogger(dbgrupos.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        finally {
          //  close();
        }
    }

    @Override
    public ArrayList<grupos> ListarGrupos() {
        ArrayList<grupos> grupos_ = new ArrayList<>();

        try {
            preparedStatement = cnx.prepareStatement("SELECT idGrupo, grupo  FROM cat_grupos;");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                grupos grupos__ = new grupos();
                grupos__.setIdgrupo(resultSet.getInt("idGrupo"));
                grupos__.setGrupo(resultSet.getString("grupo"));
                grupos_.add(grupos__);
            }
            return grupos_;
        } catch (SQLException ex) {
            Logger.getLogger(dbgrupos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<grupos> ListarGrupos(int idgrupo) {
        ArrayList<grupos> grupos_ = new ArrayList<>();

        try {
            preparedStatement = cnx.prepareStatement("SELECT idGrupo, grupo  FROM cat_grupos WHERE idGrupo like'" + idgrupo + "'");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                grupos grupo = new grupos();
                grupo.setIdgrupo(resultSet.getInt("idGrupo"));
                grupo.setGrupo(resultSet.getString("grupo"));
                grupos_.add(grupo);
            }
            return grupos_;
        } catch (SQLException ex) {
            Logger.getLogger(dbgrupos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //Método para cerrar resultados
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (cnx != null) {
                cnx.close();
            }

        } catch (Exception e) {
        }
    }
}
