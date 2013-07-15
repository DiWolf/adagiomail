/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.usuarios;
import interfaces.interface_usuarios;
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
public class dbusuarios implements interface_usuarios {

    private Connection cnx = new Conexion().getConnection();
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    boolean aux = false;

    @Override
    public void AgregarUsuarios(usuarios usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarUsuarios(int idUsuario) {
        try {
            preparedStatement = cnx.prepareStatement("UPDATE cat_usuarios SET activo=0 WHERE idusuario=?");
            preparedStatement.setInt(1, idUsuario);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbusuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ModificarUsuario(int idUsuario, usuarios usuario) {
        try {
            preparedStatement = cnx.prepareStatement("UPDATE cat_usuarios SET usr_nombres=?, usr_apellidos=?, telefono=?, direccion=?, usr_pop=?, usr_smtp=?, usr_popusr=?, usr_poppass=?,usr_correo=?, telefono=?, direccion=?, usuario=?, password=? WHERE idusuario=?");
            preparedStatement.setString(1, usuario.getUsr_nombres());
            preparedStatement.setString(2, usuario.getUsr_apellidos());
            preparedStatement.setString(3, usuario.getUsr_telefono());
            preparedStatement.setString(4, usuario.getUsr_direccion());
            preparedStatement.setString(5, usuario.getUsr_pop());
            preparedStatement.setString(6, usuario.getUsr_smtp());
            preparedStatement.setString(7, usuario.getUsr_popusr());
            preparedStatement.setString(8, usuario.getUsr_poppass());
            preparedStatement.setString(9, usuario.getUsr_correo());
            preparedStatement.setString(10, usuario.getUsr_telefono());
            preparedStatement.setString(11, usuario.getUsr_direccion());
            preparedStatement.setString(12, usuario.getUsuario());
            preparedStatement.setString(13, usuario.getPassword());
            preparedStatement.setInt(14, idUsuario);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbusuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<usuarios> ListarUsuario(int idUsuario) {
        ArrayList<usuarios> usuarios_ = new ArrayList<>();
        try {
            preparedStatement = cnx.prepareStatement("SELECT idusuario, usr_nombres, usr_apellidos, usr_pop, usr_smtp, usr_popusr, usr_poppass, usr_admin, usr_correo, direccion, telefono, usuario,password FROM cat_usuarios WHERE idusuario= '" + idUsuario + "' AND activo = 1");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuarios usuario = new usuarios();
                usuario.setIdusuario(resultSet.getInt("idusuario"));
                usuario.setUsr_nombres(resultSet.getString("usr_nombres"));
                usuario.setUsr_apellidos(resultSet.getString("usr_apellidos"));
                usuario.setUsr_correo(resultSet.getString("usr_correo"));
                usuario.setUsr_pop(resultSet.getString("usr_pop"));
                usuario.setUsr_smtp(resultSet.getString("usr_smtp"));
                usuario.setUsr_popusr(resultSet.getString("usr_popusr"));
                usuario.setUsr_poppass(resultSet.getString("usr_poppass"));
                usuario.setUsr_direccion(resultSet.getString("direccion"));
                usuario.setUsr_telefono(resultSet.getString("telefono"));
                usuario.setUsuario(resultSet.getString("usuario"));
                usuario.setPassword(resultSet.getString("password"));
                usuario.setUsr_admin(resultSet.getInt("usr_admin"));
                usuarios_.add(usuario);

            }
            return usuarios_;
        } catch (SQLException ex) {
            Logger.getLogger(dbusuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean Login(String usuaro, String Password) {
        try {
            preparedStatement = cnx.prepareStatement("SELECT idusuario, usuario, password FROM cat_usuarios WHERE usuario = '" + usuaro + "' AND password = '" + Password + "'");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                excepciones.setClaveUsuario(resultSet.getInt("idusuario"));
            }
            if (resultSet.first()) {
                aux = true;
            } else {
                aux = false;
            }
        } catch (SQLException ex) {
            SQLException x = ex;
            excepciones.ErrorConectar(x);
        }
        return aux;

    }

    public boolean LoginAdmin(String usuario, String Password) {
        try {
            preparedStatement = cnx.prepareStatement("SELECT * FROM cat_usuarios WHERE usuario = '" + usuario + "' AND password = '" + Password + "' AND usr_admin=1");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                aux = true;
            } else {
                aux = false;
            }
        } catch (SQLException ex) {
            SQLException x = ex;
            excepciones.ErrorConectar(x);
        }
        return aux;
    }
    excepciones exe = new excepciones();

    @Override
    public ArrayList<usuarios> ListarUsuario() {
        ArrayList<usuarios> usuarios_ = new ArrayList<>();
        try {
            preparedStatement = cnx.prepareStatement("SELECT idusuario, usr_nombres, usr_apellidos, usr_pop, usr_smtp, usr_popusr, usr_poppass, usr_admin, usr_correo, direccion, telefono, usuario,password FROM cat_usuarios WHERE activo = 1");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuarios usuario = new usuarios();
                usuario.setIdusuario(resultSet.getInt("idusuario"));
                usuario.setUsr_nombres(resultSet.getString("usr_nombres"));
                usuario.setUsr_apellidos(resultSet.getString("usr_apellidos"));
                usuario.setUsr_correo(resultSet.getString("usr_correo"));
                usuario.setUsr_pop(resultSet.getString("usr_pop"));
                usuario.setUsr_smtp(resultSet.getString("usr_smtp"));
                usuario.setUsr_popusr(resultSet.getString("usr_popusr"));
                usuario.setUsr_poppass(resultSet.getString("usr_poppass"));
                usuario.setUsr_direccion(resultSet.getString("direccion"));
                usuario.setUsr_telefono(resultSet.getString("telefono"));
                usuarios_.add(usuario);

            }
            return usuarios_;
        } catch (SQLException ex) {
            Logger.getLogger(dbusuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
