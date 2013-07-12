/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author DiWolf
 */
public class miembros {

    private int idmiembro;     //Id del mimbro
    private String m_nombres;   //nombres del miembro
    private String m_apellidos;  //apellidos del miembro
    private String m_institucion;  // institución del miembro
    private String m_cargo;    //cargo del miembro
    private String m_telefono;   //teléfono del miembro
    private String m_celular;   //celular de contacto al miembro
    private String m_mail;    //correo electrónico
    private String m_dirección;  //direción postal 
    private int idGrupo; //Identifica el grupo al que pertenece el miembro.
    private String grupo; //Identica el grupo 
    private int m_pleno;  //es pleno miembro o no. 

    public int getIdmiembro() {
        return idmiembro;
    }

    public void setIdmiembro(int idmiembro) {
        this.idmiembro = idmiembro;
    }

    public String getM_nombres() {
        return m_nombres;
    }

    public void setM_nombres(String m_nombres) {
        this.m_nombres = m_nombres;
    }

    public String getM_apellidos() {
        return m_apellidos;
    }

    public void setM_apellidos(String m_apellidos) {
        this.m_apellidos = m_apellidos;
    }

    public String getM_institucion() {
        return m_institucion;
    }

    public void setM_institucion(String m_institucion) {
        this.m_institucion = m_institucion;
    }

    public String getM_cargo() {
        return m_cargo;
    }

    public void setM_cargo(String m_cargo) {
        this.m_cargo = m_cargo;
    }

    public String getM_telefono() {
        return m_telefono;
    }

    public void setM_telefono(String m_telefono) {
        this.m_telefono = m_telefono;
    }

    public String getM_celular() {
        return m_celular;
    }

    public void setM_celular(String m_celular) {
        this.m_celular = m_celular;
    }

    public String getM_mail() {
        return m_mail;
    }

    public void setM_mail(String m_mail) {
        this.m_mail = m_mail;
    }

    public String getM_dirección() {
        return m_dirección;
    }

    public void setM_dirección(String m_dirección) {
        this.m_dirección = m_dirección;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getM_pleno() {
        return m_pleno;
    }

    public void setM_pleno(int m_pleno) {
        this.m_pleno = m_pleno;
    }
}
