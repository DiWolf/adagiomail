/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import entidades.usuarios;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import logica.daousuarios;

/**
 *
 * @author Remmi
 */
public class frm_administrador extends javax.swing.JInternalFrame {

    //Declaración de variables del sistema. 
    daousuarios dbusuarios = new daousuarios();
    ArrayList lista = new ArrayList();
    DefaultMutableTreeNode root;
    usuarios usuarios_ = new usuarios();
    DefaultTableModel modelo;
    int clave_;

    /**
     * Creates new form frm_administrador
     */
    public frm_administrador() {
        initComponents();
        lista.add("Usuarios del Sistema");
        //llenarArbol();
        cargarUsuarios();
    }

    //Método para llenar la tabla de información 
    public void cargarUsuarios() {
        modelo = new DefaultTableModel(null, getColumnas());
        tablaUsuarios.setModel(modelo);
        for (int i = 0; i < tablaUsuarios.getColumnCount(); i++) {
            tablaUsuarios.getColumnModel().getColumn(i);
        }
        this.setFilas();
    }

    //Método para colocar nombre a las columnas
    private String[] getColumnas() {
        String columna[] = new String[]{"Clave", "Nombres", "Apellidos", "Telefono"};
        return columna;
    }
    
    private void setFilas() {
        Object datos[] = new Object[4];
        ArrayList<usuarios> usuarios_;
        usuarios_ = dbusuarios.ListarUsuario();
        Iterator iterator = usuarios_.iterator();
        try {
            while (iterator.hasNext()) {
                usuarios usuario___;
                usuario___ = (usuarios) iterator.next();
                datos[0] = usuario___.getIdusuario();
                datos[1] = usuario___.getUsr_nombres();
                datos[2] = usuario___.getUsr_apellidos();
                datos[3] = usuario___.getUsr_telefono();
                
                modelo.addRow(datos);
            }
        } catch (Exception e) {
        }
    }

    //Método para llenar el árbol 
    private void llenarArbol() {
        Object datos[] = new Object[2];
        ArrayList<usuarios> usuario_ = dbusuarios.ListarUsuario(1);
        Iterator iterator = usuario_.iterator();
        
        while (iterator.hasNext()) {
            usuarios usuarios__;
            usuarios__ = (usuarios) iterator.next();
            //Object valor[] = {usuarios__.getUsr_nombres()};
            datos[0] = usuarios__.getUsr_nombres();
            lista.add(datos);
            
        }
        
        Object hierarchy[] = lista.toArray();
        for (int i = 0; i < hierarchy.length; i++) {
            System.out.println("Valor: " + hierarchy[i]);
        }
        root = processHierarchy(hierarchy);
        // JTree arbol = new JTree(root);

    }
    
    private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(hierarchy[0]);
        DefaultMutableTreeNode child;
        for (int i = 0; i < hierarchy.length; i++) {
            Object nodeSpecifier = hierarchy[i];
            if (nodeSpecifier instanceof Object[]) // Ie node with children
            {
                child = processHierarchy((Object[]) nodeSpecifier);
            } else {
                child = new DefaultMutableTreeNode(nodeSpecifier); // Ie Leaf
            }
            node.add(child);
        }
        return (node);
    }

    //Llena los campos dependiendo del usuario seleccionado. 
    public void llenarCamposUsuarios(int clave) {
        ArrayList<usuarios> usuarios_ = dbusuarios.ListarUsuario(clave);
        Iterator iterator = usuarios_.iterator();
        
        try {
            while (iterator.hasNext()) {
                usuarios usuario__;
                usuario__ = (usuarios) iterator.next();
                clave_ = usuario__.getIdusuario(); //asignamos la clave al usuario; 
                txt_claveUsuario.setText(String.valueOf(usuario__.getIdusuario()));
                txt_nombres.setText(usuario__.getUsr_nombres());
                txt_apellidos.setText(usuario__.getUsr_apellidos());
                txt_serverPOP.setText(usuario__.getUsr_pop());
                txt_serverSMTP.setText(usuario__.getUsr_smtp());
                txt_USUARIO.setText(usuario__.getUsr_popusr());
                txt_CONTRASENA.setText(usuario__.getUsr_poppass());
                txt_correoElectronico.setText(usuario__.getUsr_correo());
                txt_telefono.setText(usuario__.getUsr_telefono());
                txt_direccion.setText(usuario__.getUsr_direccion());
                txt_usuarioUSR.setText(usuario__.getUsuario());
                txt_password.setText(usuario__.getPassword());
                switch (usuario__.getUsr_admin()) {
                    case 0:
                        chk_admin.setSelected(false);
                        break;
                    case 1:
                        chk_admin.setSelected(true);
                        break;
                }
            }
        } catch (Exception e) {
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_claveUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_apellidos = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_serverSMTP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_serverPOP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_USUARIO = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_CONTRASENA = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_correoElectronico = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_direccion = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txt_usuarioUSR = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        chk_admin = new javax.swing.JCheckBox();
        btn_nuevo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Administrador de Usuarios");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios del Sistema"));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                llenarDatos(evt);
            }
        });
        jScrollPane2.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jLabel1.setText("Busqueda:");

        jButton1.setText("Buscar");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del Usuario"));

        jLabel2.setText("Clave:");

        txt_claveUsuario.setEditable(false);

        jLabel3.setText("Nombres:");

        txt_nombres.setEditable(false);

        jLabel4.setText("Apellidos:");

        txt_apellidos.setEditable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Correo Electrónico"));

        jLabel5.setText("Servidor SMTP:");

        txt_serverSMTP.setEditable(false);

        jLabel6.setText("Servidor POP:");

        txt_serverPOP.setEditable(false);

        jLabel7.setText("Usuario:");

        txt_USUARIO.setEditable(false);

        jLabel8.setText("Contraseña:");

        txt_CONTRASENA.setEditable(false);

        jLabel9.setText("Correo Electrónico:");

        txt_correoElectronico.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_serverSMTP, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txt_serverPOP)
                            .addComponent(txt_USUARIO)
                            .addComponent(txt_CONTRASENA, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_correoElectronico)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_serverSMTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_serverPOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_USUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txt_CONTRASENA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_correoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Contacto"));

        jLabel10.setText("Teléfono:");

        txt_telefono.setEditable(false);

        jLabel11.setText("Dirección");

        txt_direccion.setEditable(false);
        txt_direccion.setColumns(20);
        txt_direccion.setRows(5);
        jScrollPane1.setViewportView(txt_direccion);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(7, 7, 7)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_telefono)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de la Cuenta"));

        jLabel12.setText("Usuario:");

        txt_usuarioUSR.setEditable(false);

        jLabel13.setText("Contraseña:");

        txt_password.setEditable(false);

        chk_admin.setText("Administrador");
        chk_admin.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_admin)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_usuarioUSR)
                        .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_usuarioUSR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_admin)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_claveUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_claveUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_borrar.setText("Borrar");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        btn_guardar.setText("Guardar");
        btn_guardar.setEnabled(false);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_nuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_borrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_borrar)
                            .addComponent(btn_editar)
                            .addComponent(btn_nuevo)
                            .addComponent(btn_guardar))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 724, 576);
    }// </editor-fold>//GEN-END:initComponents

    private void llenarDatos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_llenarDatos
        // TODO add your handling code here:
        int columna_ = tablaUsuarios.getSelectedRow();
        llenarCamposUsuarios((int) tablaUsuarios.getModel().getValueAt(columna_, 0));
    }//GEN-LAST:event_llenarDatos
    
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        usuarios_.setUsr_nombres(txt_nombres.getText());
        usuarios_.setUsr_apellidos(txt_apellidos.getText());
        usuarios_.setUsr_pop(txt_serverPOP.getText());
        usuarios_.setUsr_smtp(txt_serverSMTP.getText());
        usuarios_.setUsr_popusr(txt_USUARIO.getText());
        usuarios_.setUsr_poppass(txt_CONTRASENA.getText());
        usuarios_.setUsr_correo(txt_correoElectronico.getText());
        usuarios_.setUsuario(txt_usuarioUSR.getText());
        usuarios_.setPassword(txt_password.getText());
        usuarios_.setUsr_telefono(txt_telefono.getText());
        usuarios_.setUsr_direccion(txt_direccion.getText());
        dbusuarios.ModificarUsuario(clave_, usuarios_);
        dbusuarios.AgregarUsuarios(usuarios_);
        this.cargarUsuarios();
        
        clave_ = 0; //Reset clave.

        btn_nuevo.setEnabled(true);
        
        
        desactivaCamposTexto();
        refrescarCampos();
        btn_guardar.setEnabled(false);
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    // Método para Activar los campos
    public void activarCamposTexto() {
        txt_nombres.setEditable(true);
        txt_apellidos.setEditable(true);
        txt_serverPOP.setEditable(true);
        txt_serverSMTP.setEditable(true);
        txt_CONTRASENA.setEditable(true);
        txt_USUARIO.setEditable(true);
        txt_correoElectronico.setEditable(true);
        txt_direccion.setEditable(true);
        txt_password.setEditable(true);
        txt_telefono.setEditable(true);
        txt_usuarioUSR.setEditable(true);
        
    }
    //Método para desactivar campos texto. 

    public void desactivaCamposTexto() {
        txt_nombres.setEditable(false);
        txt_apellidos.setEditable(false);
        txt_serverPOP.setEditable(false);
        txt_serverSMTP.setEditable(false);
        txt_CONTRASENA.setEditable(false);
        txt_USUARIO.setEditable(false);
        txt_correoElectronico.setEditable(false);
        txt_direccion.setEditable(false);
        txt_password.setEditable(false);
        txt_telefono.setEditable(false);
        txt_usuarioUSR.setEditable(false);
    }

    //Método para limpiar campos
    public void refrescarCampos() {
        txt_claveUsuario.setText("");
        txt_nombres.setText("");
        txt_apellidos.setText("");
        txt_serverPOP.setText("");
        txt_serverSMTP.setText("");
        txt_CONTRASENA.setText("");
        txt_USUARIO.setText("");
        txt_correoElectronico.setText("");
        txt_direccion.setText("");
        txt_password.setText("");
        txt_telefono.setText("");
        txt_usuarioUSR.setText("");
    }
    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // TODO add your handling code here:
        activarCamposTexto();
        btn_nuevo.setEnabled(false);
    }//GEN-LAST:event_btn_editarActionPerformed
    
    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        // TODO add your handling code here:
        dbusuarios.EliminarUsuarios(clave_);
        refrescarCampos();
        cargarUsuarios();
        clave_ = 0;
    }//GEN-LAST:event_btn_borrarActionPerformed
    
    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // TODO add your handling code here:
        activarCamposTexto();
        btn_guardar.setEnabled(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JCheckBox chk_admin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txt_CONTRASENA;
    private javax.swing.JTextField txt_USUARIO;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_claveUsuario;
    private javax.swing.JTextField txt_correoElectronico;
    private javax.swing.JTextArea txt_direccion;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_serverPOP;
    private javax.swing.JTextField txt_serverSMTP;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_usuarioUSR;
    // End of variables declaration//GEN-END:variables
}
