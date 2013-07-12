package datos;

import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DiWolf
 */
public class Errores {

    private static String excepcionValidacion = "Excepción de Validación";

    public static void campoVacio(String nombreCampo) {
        JOptionPane.showMessageDialog(null, "<html>Verifique que el campo: <b>" + nombreCampo + "</b> no se encuestre vacio.</html>", excepcionValidacion, JOptionPane.ERROR_MESSAGE);
    }
}
