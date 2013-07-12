/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.miembros;
import interfaces.interface_miembro;
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
public class dbmiembros implements interface_miembro {

    private Connection cnx = new Conexion().getConnection();
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public void AgregarMiembro(miembros miembro) {

        try {
            preparedStatement = cnx.prepareStatement("INSERT INTO cat_miembros VALUES (default,?,?,?,?,?,?,?,?,?,0,?)");
            preparedStatement.setString(1, miembro.getM_nombres());
            preparedStatement.setString(2, miembro.getM_apellidos());
            preparedStatement.setString(3, miembro.getM_institucion());
            preparedStatement.setString(4, miembro.getM_cargo());
            preparedStatement.setString(5, miembro.getM_telefono());
            preparedStatement.setString(6, miembro.getM_celular());
            preparedStatement.setString(7, miembro.getM_mail());
            preparedStatement.setString(8, miembro.getM_dirección());
            preparedStatement.setInt(9, miembro.getM_pleno());
            preparedStatement.setInt(10, miembro.getIdGrupo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
         //   close();
        }
    }

    @Override
    public void EliminarMiembro(int idmiembro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModificarMiembro(int idmiembro, miembros miembro) {
        try {
            preparedStatement = cnx.prepareStatement("UPDATE cat_miembros SET m_nombres=?, m_apellidos=?, m_institucion=?, m_cargo=?, m_telefono=?, m_celular=?, m_mail=?, m_direccion=?, m_pleno=? WHERE idmiembro=?");
            preparedStatement.setString(1, miembro.getM_nombres());
            preparedStatement.setString(2, miembro.getM_apellidos());
            preparedStatement.setString(3, miembro.getM_institucion());
            preparedStatement.setString(4, miembro.getM_cargo());
            preparedStatement.setString(5, miembro.getM_telefono());
            preparedStatement.setString(6, miembro.getM_celular());
            preparedStatement.setString(7, miembro.getM_mail());
            preparedStatement.setString(8, miembro.getM_dirección());
            preparedStatement.setInt(9, miembro.getM_pleno());
            preparedStatement.setInt(10, idmiembro);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbmiembros.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
          //  close();
        }
    }

    @Override
    public ArrayList<miembros> ListarMiembros() {
        ArrayList<miembros> miembros_ = new ArrayList<>();
        try {
            preparedStatement = cnx.prepareStatement("SELECT idmiembro, m_nombres, m_apellidos, m_telefono, m_celular, m_mail, cat_grupos.grupo FROM cat_miembros, cat_grupos WHERE m_activo =0 AND cat_miembros.idGrupo = cat_grupos.idGrupo;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                miembros miembro = new miembros();
                miembro.setIdmiembro(resultSet.getInt("idmiembro"));
                miembro.setM_nombres(resultSet.getString("m_nombres"));
                miembro.setM_apellidos(resultSet.getString("m_apellidos"));
                miembro.setM_telefono(resultSet.getString("m_telefono"));
                miembro.setM_celular(resultSet.getString("m_celular"));
                miembro.setM_mail(resultSet.getString("m_mail"));
                miembros_.add(miembro);
            }
            return miembros_;
        } catch (SQLException ex) {
            Logger.getLogger(dbmiembros.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<miembros> ListarMiembros(int idmiembro) {
        ArrayList<miembros> miembros_ = new ArrayList<>();
        try {
            preparedStatement = cnx.prepareStatement("SELECT idmiembro, m_nombres, m_apellidos,m_institucion,m_cargo, m_telefono, m_celular, m_mail,m_direccion,cat_grupos.grupo,m_pleno FROM cat_miembros, cat_grupos WHERE m_activo =0 AND cat_miembros.idGrupo = cat_grupos.idGrupo AND idmiembro like '%" + idmiembro + "%'");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                miembros miembro = new miembros();
                miembro.setIdmiembro(resultSet.getInt("idmiembro"));
                miembro.setM_nombres(resultSet.getString("m_nombres"));
                miembro.setM_apellidos(resultSet.getString("m_apellidos"));
                miembro.setM_institucion(resultSet.getString("m_institucion"));
                miembro.setM_cargo(resultSet.getString("m_cargo"));
                miembro.setM_telefono(resultSet.getString("m_telefono"));
                miembro.setM_celular(resultSet.getString("m_celular"));
                miembro.setM_mail(resultSet.getString("m_mail"));
                miembro.setM_dirección(resultSet.getString("m_direccion"));
                miembro.setM_pleno(resultSet.getInt("m_pleno"));
                miembro.setGrupo(resultSet.getString("cat_grupos.grupo"));
                miembros_.add(miembro);
            }
            return miembros_;
        } catch (SQLException ex) {
            Logger.getLogger(dbmiembros.class.getName()).log(Level.SEVERE, null, ex);
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
