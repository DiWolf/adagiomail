/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Remmi
 */
public class excepciones {

    private static String VentanaLogin = "Excepción de Validación";
    private static String ErrorConectar = "Excepción en Tiempo de Conexión";
    private static String ErrorUsuario = "Excepción de Usuario.";
    private static String ExcepcionVacio = "Excepción al valadir campos.";
    private static String NoAturizado = "Error de Acceso.";
    private static int permisos;
    private static int claveUsuario;
    //Errores de Conexión a la Base de datos

    public static void ErrorConectar(SQLException error) {
        JOptionPane.showMessageDialog(null, "Excepción al momento de ingresar: " + error, ErrorConectar, JOptionPane.ERROR_MESSAGE);
    }

    public static void ErrorValidarUsuario() {
        JOptionPane.showMessageDialog(null, "El usuario no existe en la base de datos, por favor contacte con su Administrador.", ErrorUsuario, JOptionPane.ERROR_MESSAGE);
    }

    public static void CamposVacios(String txt_campo) {
        JOptionPane.showMessageDialog(null, "Compruebe que el campo: " + txt_campo + " No se encuentre vacio.", ExcepcionVacio, JOptionPane.WARNING_MESSAGE);
    }

    public static void ErrorAcceso() {
        JOptionPane.showMessageDialog(null, "No esta autorizado para acceder a este módulo. Consulte con el Administrador.", NoAturizado, JOptionPane.ERROR_MESSAGE);
    }

    public static int getPermisos() {
        return permisos;
    }

    public static void setPermisos(int permisos) {
        excepciones.permisos = permisos;
    }

    public static void NoBaseDatos() {
        JOptionPane.showMessageDialog(null, "Se a producido un error al conectar a la base de datos. Verifique la ruta de Host y que la DB este en función.", ErrorConectar, JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "El sistema no puede continuar, consulte al Administrador de Sistemas.", "Error en tiempo de conexión", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

    public static int getClaveUsuario() {
        return claveUsuario;
    }

    public static void setClaveUsuario(int claveUsuario) {
        excepciones.claveUsuario = claveUsuario;
    }
}
