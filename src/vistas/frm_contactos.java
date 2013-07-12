/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import datos.EmailValidator;
import entidades.miembros;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import logica.daomiembros;
import datos.Errores;
import entidades.grupos;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import logica.TableColumnAdjuster;
import logica.daogrupos;

/**
 *
 * @author DiWolf
 */
public class frm_contactos extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    DefaultTableModel modeloGrupos;
    frm_principal p = new frm_principal();
//    frm_cat x = new frm_cat();
    Errores error = new Errores();
    daomiembros dmiembros = new daomiembros();
    // daomiembros daomiembros_ = new daomiembros();
     miembros miembros_ = new miembros();
     grupos grupos = new grupos(); 
    daogrupos dgrupos = new daogrupos();
    int dz = 0;
    int clavemiembro;
    int clavegrupo;

    /**
     * Creates new form frm_contactos
     */
    public frm_contactos() {
        initComponents();
        this.cargarListaContactos();
        llenarComboGrupo();
        this.cargarGrupos();
        
        
    }

    //cargar la lista de contactos
    public void cargarListaContactos() {

        modelo = new DefaultTableModel(null, getColumnas());

        tabla_contactos.setModel(modelo);
        int[] anchos = {1, 50, 50, 20, 20, 50};
        for (int i = 0; i < tabla_contactos.getColumnCount(); i++) {
            tabla_contactos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        this.setFilas();
    }

    //Cargar la lista de Grupos
    public void cargarGrupos() {
        modeloGrupos = new DefaultTableModel(null, getColumnasGrupos());
        tabla_listas.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabla_listas.setModel(modeloGrupos);
        TableColumnAdjuster tca = new TableColumnAdjuster(tabla_listas);
        tca.adjustColumns();
        int[] anchos = {1, 250};
        for (int i = 0; i < tabla_listas.getColumnCount(); i++) {
            tabla_listas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        this.setFilasListas();
    }

    //Columnas para Contactos
    private String[] getColumnas() {
        String columna[] = new String[]{"Clave", "Nombres", "Apellidos", "Teléfono", "Celular", "Correo Electrónico"};
        return columna;
    }
    //Columnas para Grupos

    private String[] getColumnasGrupos() {
        String columna[] = new String[]{"ID", "Grupo"};
        return columna;
    }

    private void setFilas() {
        Object datos[] = new Object[6];

        ArrayList<miembros> miembros_ = dmiembros.ListarMiembros();
        Iterator iterator = miembros_.iterator();
        try {
            while (iterator.hasNext()) {
                miembros miembro__;
                //  miembro__ = new miembros();
                miembro__ = (miembros) iterator.next();
                datos[0] = miembro__.getIdmiembro();
                datos[1] = miembro__.getM_nombres();
                datos[2] = miembro__.getM_apellidos();
                datos[3] = miembro__.getM_telefono();
                datos[4] = miembro__.getM_celular();
                datos[5] = miembro__.getM_mail();
                modelo.addRow(datos);
            }

        } catch (Exception e) {
        }
    }

    private void setFilasListas() {
        Object datos[] = new Object[2];
        ArrayList<grupos> grupos_ = dgrupos.ListarGrupos();
        Iterator iterator = grupos_.iterator();
        try {
            while (iterator.hasNext()) {
                grupos grupos__;
                grupos__ = (grupos) iterator.next();
                datos[0] = grupos__.getIdgrupo();
                datos[1] = grupos__.getGrupo();
                modeloGrupos.addRow(datos);
            }
        } catch (Exception e) {
        }
    }

    public void llenarInformacionContacto(int clave) {
        ArrayList<miembros> miembros_ = dmiembros.ListarMiembros(clave);
        Iterator iterator = miembros_.iterator();
        try {
            while (iterator.hasNext()) {
                miembros miembro__;
                miembro__ = (miembros) iterator.next();
                clavemiembro = miembro__.getIdmiembro();
                txt_rsnombres.setText(miembro__.getM_nombres());
                txt_rsapellidos.setText(miembro__.getM_apellidos());
                txt_rsinstitucion.setText(miembro__.getM_institucion());
                txt_rscargo.setText(miembro__.getM_cargo());
                txt_rstelefono.setText(miembro__.getM_telefono());
                txt_rscelular.setText(miembro__.getM_celular());
                txt_rsmail.setText(miembro__.getM_mail());
                txt_rsdireccion.setText(miembro__.getM_dirección());
                cbn_grupos.addItem(miembro__.getGrupo());
                // System.out.println(miembro__.getM_pleno());
                switch (miembro__.getM_pleno()) {
                    case 0:
                        chk_rspleno.setSelected(false);
                        break;
                    case 1:
                        chk_rspleno.setSelected(true);
                        break;
                }
            }
        } catch (Exception e) {
        }
    }

    public void llenarComboGrupo() {
        ArrayList<grupos> grupos_ = dgrupos.ListarGrupos();
        Iterator iterator = grupos_.iterator();
        try {
            while (iterator.hasNext()) {
                grupos grupos__;
                grupos__ = (grupos) iterator.next();
                combo_lista.addItem(grupos__.getGrupo());
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        contacto_panel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_contactos = new javax.swing.JTable();
        panel_infoContacto = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_rsnombres = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_rsapellidos = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_rsinstitucion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_rscargo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_rstelefono = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_rscelular = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_rsmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_rsdireccion = new javax.swing.JTextArea();
        chk_rspleno = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        cbn_grupos = new javax.swing.JComboBox();
        btn_mEditar = new javax.swing.JButton();
        btn_mGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panel_usrInfo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_contactoNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_contactoApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_contactoInstitucion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_contactoCargo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_contactoTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_contactoCelular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_contactoEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_contactoDireccion = new javax.swing.JTextArea();
        chk_contactoPleno = new javax.swing.JCheckBox();
        btn_guardarContacto = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        combo_lista = new javax.swing.JComboBox();
        btn_categoria = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_listas = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txt_listas = new javax.swing.JTextField();
        btn_listasNew = new javax.swing.JButton();
        btn_listasEdit = new javax.swing.JButton();
        btn_editSave = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setClosable(true);
        setTitle("Libreta de Direcciones");

        contacto_panel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        contacto_panel.setAutoscrolls(true);
        contacto_panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabla_contactos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_contactos.setToolTipText("Lista de Contactos en el Sistema");
        tabla_contactos.setGridColor(new java.awt.Color(255, 255, 255));
        tabla_contactos.setShowHorizontalLines(false);
        tabla_contactos.setShowVerticalLines(false);
        tabla_contactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listar(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_contactos);

        panel_infoContacto.setBackground(new java.awt.Color(255, 255, 255));
        panel_infoContacto.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Contacto"));

        jLabel10.setText("Nombres:");

        txt_rsnombres.setEditable(false);

        jLabel11.setText("Apellidos:");

        txt_rsapellidos.setEditable(false);

        jLabel12.setText("Institución:");

        txt_rsinstitucion.setEditable(false);

        jLabel13.setText("Cargo:");

        txt_rscargo.setEditable(false);

        jLabel14.setText("Teléfono:");

        txt_rstelefono.setEditable(false);

        jLabel15.setText("Celular:");

        txt_rscelular.setEditable(false);

        jLabel16.setText("E-Mail:");

        txt_rsmail.setEditable(false);

        jLabel17.setText("Dirección:");

        txt_rsdireccion.setEditable(false);
        txt_rsdireccion.setColumns(20);
        txt_rsdireccion.setRows(5);
        jScrollPane3.setViewportView(txt_rsdireccion);

        chk_rspleno.setText("Pleno Miembro");
        chk_rspleno.setEnabled(false);

        jLabel20.setText("Grupo:");

        javax.swing.GroupLayout panel_infoContactoLayout = new javax.swing.GroupLayout(panel_infoContacto);
        panel_infoContacto.setLayout(panel_infoContactoLayout);
        panel_infoContactoLayout.setHorizontalGroup(
            panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_infoContactoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_infoContactoLayout.createSequentialGroup()
                        .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_infoContactoLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txt_rsnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_infoContactoLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_rsinstitucion)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_infoContactoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_rsapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_infoContactoLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_rscargo)
                                    .addComponent(jScrollPane3)))))
                    .addGroup(panel_infoContactoLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addComponent(jLabel15))
                            .addGroup(panel_infoContactoLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(5, 5, 5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chk_rspleno)
                            .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_rstelefono)
                                .addComponent(txt_rscelular)
                                .addComponent(txt_rsmail)
                                .addComponent(cbn_grupos, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panel_infoContactoLayout.setVerticalGroup(
            panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_infoContactoLayout.createSequentialGroup()
                .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_rsnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_rsapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_rsinstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_rscargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_infoContactoLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_infoContactoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbn_grupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addGroup(panel_infoContactoLayout.createSequentialGroup()
                        .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_rstelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txt_rscelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_infoContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txt_rsmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(chk_rspleno)
                .addGap(12, 12, 12))
        );

        btn_mEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/doc_edit.png"))); // NOI18N
        btn_mEditar.setText("Editar");
        btn_mEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mEditarActionPerformed(evt);
            }
        });

        btn_mGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sq_plus.png"))); // NOI18N
        btn_mGuardar.setText("Guardar");
        btn_mGuardar.setEnabled(false);
        btn_mGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_infoContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_mEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_mGuardar)
                .addGap(145, 145, 145))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_infoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_mEditar)
                    .addComponent(btn_mGuardar))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        contacto_panel.addTab("Libreta de Direcciones", new javax.swing.ImageIcon(getClass().getResource("/img/adress book.png")), jPanel1); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        panel_usrInfo.setBackground(new java.awt.Color(255, 255, 255));
        panel_usrInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Alta de Miembro"));

        jLabel2.setText("Nombres:");

        txt_contactoNombre.setToolTipText("Escriba el nombre del miembro que pertenece al comite.");
        txt_contactoNombre.setName("Nombres"); // NOI18N

        jLabel3.setText("Apellidos:");

        txt_contactoApellido.setName("Apellidos"); // NOI18N

        jLabel4.setText("Institución:");

        txt_contactoInstitucion.setName("Institución"); // NOI18N

        jLabel5.setText("Cargo:");

        txt_contactoCargo.setName("Cargo"); // NOI18N

        jLabel6.setText("Teléfono:");

        txt_contactoTelefono.setName("Teléfono"); // NOI18N

        jLabel7.setText("Celular:");

        txt_contactoCelular.setName("Teléfono Celular."); // NOI18N

        jLabel8.setText("Correo Electrónico:");

        txt_contactoEmail.setName("Correo Electrónico."); // NOI18N

        jLabel9.setText("Dirección Postal:");

        txt_contactoDireccion.setColumns(20);
        txt_contactoDireccion.setRows(5);
        jScrollPane2.setViewportView(txt_contactoDireccion);

        chk_contactoPleno.setText("Pleno Miembro");

        btn_guardarContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sq_plus.png"))); // NOI18N
        btn_guardarContacto.setText("Guardar");
        btn_guardarContacto.setToolTipText("Guarda la Información en la libreta de Cotactos.");
        btn_guardarContacto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarContactoActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jButton2.setText("Cancelar");

        jLabel18.setText("Categoría:");

        combo_lista.setEditable(true);
        combo_lista.setSelectedIndex(-1);
        combo_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_listaActionPerformed(evt);
            }
        });

        btn_categoria.setText("Agregar Categoria");
        btn_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_usrInfoLayout = new javax.swing.GroupLayout(panel_usrInfo);
        panel_usrInfo.setLayout(panel_usrInfoLayout);
        panel_usrInfoLayout.setHorizontalGroup(
            panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_usrInfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_guardarContacto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(152, 152, 152))
            .addGroup(panel_usrInfoLayout.createSequentialGroup()
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_usrInfoLayout.createSequentialGroup()
                        .addComponent(txt_contactoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18))
                    .addComponent(txt_contactoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contactoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contactoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contactoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contactoInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contactoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_usrInfoLayout.createSequentialGroup()
                        .addComponent(btn_categoria)
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addComponent(combo_lista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(panel_usrInfoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addGroup(panel_usrInfoLayout.createSequentialGroup()
                        .addComponent(chk_contactoPleno)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_usrInfoLayout.setVerticalGroup(
            panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_usrInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_contactoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_contactoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_contactoInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_contactoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(combo_lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_contactoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btn_categoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_contactoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_contactoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(chk_contactoPleno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(panel_usrInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardarContacto)
                    .addComponent(jButton2))
                .addGap(32, 32, 32))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Person-group.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_usrInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panel_usrInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        contacto_panel.addTab("Nuevo Contacto", new javax.swing.ImageIcon(getClass().getResource("/img/Person-group.png")), jPanel2); // NOI18N

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tabla_listas.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_listas.setShowHorizontalLines(false);
        tabla_listas.setShowVerticalLines(false);
        tabla_listas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarListas(evt);
            }
        });
        jScrollPane4.setViewportView(tabla_listas);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Manejar Categorias"));

        jLabel19.setText("Categoria:");

        txt_listas.setEditable(false);

        btn_listasNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sq_plus.png"))); // NOI18N
        btn_listasNew.setText("Nuevo");
        btn_listasNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listasNewActionPerformed(evt);
            }
        });

        btn_listasEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/doc_edit.png"))); // NOI18N
        btn_listasEdit.setText("Editar");
        btn_listasEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listasEditActionPerformed(evt);
            }
        });

        btn_editSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        btn_editSave.setText("Guardar");
        btn_editSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_listas))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btn_listasNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_listasEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_editSave)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_listas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_listasNew)
                    .addComponent(btn_listasEdit)
                    .addComponent(btn_editSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Categorias", jPanel5);

        contacto_panel.addTab("Administración de Listas", new javax.swing.ImageIcon(getClass().getResource("/img/list-accept.png")), jTabbedPane2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contacto_panel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contacto_panel)
        );

        contacto_panel.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarContactoActionPerformed
        // TODO add your handling code here:
        daomiembros daomiembros_ = new daomiembros();
        miembros miembros_ = new miembros();
        miembros_.setM_nombres(txt_contactoNombre.getText());
        miembros_.setM_apellidos(txt_contactoApellido.getText());
        miembros_.setM_institucion(txt_contactoInstitucion.getText());
        miembros_.setM_cargo(txt_contactoCargo.getText());
        miembros_.setM_telefono(txt_contactoTelefono.getText());
        miembros_.setM_celular(txt_contactoCelular.getText());
        miembros_.setM_mail(txt_contactoEmail.getText());
        miembros_.setM_dirección(txt_contactoDireccion.getText());


        if (chk_contactoPleno.isSelected() == true) {
            dz = 1;
        } else {
            dz = 0;
        }
        EmailValidator validarCorreo = new EmailValidator();
        if (!validarCorreo.validate(txt_contactoEmail.getText().trim())) {
            System.out.println("Correo no valido.");
        }
        if (txt_contactoNombre.getText().isEmpty()) {
            Errores.campoVacio(txt_contactoNombre.getName());

        }
        if (txt_contactoApellido.getText().isEmpty()) {
            Errores.campoVacio(txt_contactoApellido.getName());
        } else {

            int i = JOptionPane.showConfirmDialog(null, "La información se almacenará en la base de datos ¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_NO_OPTION) {
                //  System.out.println("guardado");
                daomiembros_.AgregarMiembro(miembros_);
            } else {
                System.out.println("cancelado");
            }
            //   miembros_.setM_pleno(dz);
            //daomiembros_.AgregarMiembro(miembros_);
            this.cargarListaContactos(); //Refrescamos el DataGrid
        }


        //Vaciar despues del guardado. 
        txt_contactoNombre.setText("");
        txt_contactoApellido.setText("");
        txt_contactoInstitucion.setText("");
        txt_contactoCargo.setText("");
        txt_contactoTelefono.setText("");
        txt_contactoCelular.setText("");
        txt_contactoEmail.setText("");
        txt_contactoDireccion.setText("");
        //
        if (chk_contactoPleno.isSelected() == true) {
            chk_contactoPleno.setSelected(false);
        }
    }//GEN-LAST:event_btn_guardarContactoActionPerformed

    private void listar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listar
        // TODO add your handling code here:
        int columna = tabla_contactos.getSelectedRow();
        llenarInformacionContacto((int) tabla_contactos.getModel().getValueAt(columna, 0));
    }//GEN-LAST:event_listar

    private void btn_mEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mEditarActionPerformed
        // TODO add your handling code here:
        //Activar nuevamente los txt para permitir la edición de la información
        txt_rsnombres.setEditable(true);
        txt_rsapellidos.setEditable(true);
        txt_rsinstitucion.setEditable(true);
        txt_rscargo.setEditable(true);
        txt_rstelefono.setEditable(true);
        txt_rscelular.setEditable(true);
        txt_rsmail.setEditable(true);
        txt_rsdireccion.setEditable(true);
        chk_rspleno.setEnabled(true);

        btn_mGuardar.setEnabled(true); //Activamos el botón de guardado
        btn_mEditar.setEnabled(false); //Desactivamos el botón de edición hasta que se guarde la información
    }//GEN-LAST:event_btn_mEditarActionPerformed

    private void btn_mGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mGuardarActionPerformed
        // TODO add your handling code here:
       

        miembros_.setM_nombres(txt_rsnombres.getText());
        miembros_.setM_apellidos(txt_rsapellidos.getText());
        miembros_.setM_institucion(txt_rsinstitucion.getText());
        miembros_.setM_cargo(txt_rscargo.getText());
        miembros_.setM_telefono(txt_rstelefono.getText());
        miembros_.setM_celular(txt_rscelular.getText());
        miembros_.setM_mail(txt_rsmail.getText());
        miembros_.setM_dirección(txt_rsdireccion.getText());

        dz = (chk_rspleno.isSelected() == true) ? 1 : 0;
        /* if (chk_rspleno.isSelected() == true) {
         dz = 1;
         } else {
         dz = 0;
         }*/
        miembros_.setM_pleno(dz);

        dmiembros.ModificarMiembro(clavemiembro, miembros_);
        this.cargarListaContactos(); //Refrescamos el DataGrid

        //Vaciar despues del guardado. 
        txt_rsnombres.setText("");
        txt_rsapellidos.setText("");
        txt_rsinstitucion.setText("");
        txt_rscargo.setText("");
        txt_rstelefono.setText("");
        txt_rscelular.setText("");
        txt_rsmail.setText("");
        txt_rsdireccion.setText("");
        //
        if (chk_rspleno.isSelected() == true) {
            chk_rspleno.setSelected(false);
        }

        txt_rsnombres.setEditable(false);
        txt_rsapellidos.setEditable(false);
        txt_rsinstitucion.setEditable(false);
        txt_rscargo.setEditable(false);
        txt_rstelefono.setEditable(false);
        txt_rscelular.setEditable(false);
        txt_rsmail.setEditable(false);
        txt_rsdireccion.setEditable(false);

        btn_mGuardar.setEnabled(false); //Activamos el botón de guardado
        btn_mEditar.setEnabled(true); //Desactivamos el botón de edición hasta que se guarde la información

    }//GEN-LAST:event_btn_mGuardarActionPerformed

    private void btn_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoriaActionPerformed
        contacto_panel.setSelectedIndex(2);
    }//GEN-LAST:event_btn_categoriaActionPerformed

    private void combo_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_listaActionPerformed
        // TODO add your handling code here:
        // System.out.println(combo_lista.getSelectedIndex()+1);
       
    }//GEN-LAST:event_combo_listaActionPerformed

    private void btn_listasNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listasNewActionPerformed
        // TODO add your handling code here:
        txt_listas.setEditable(true);
        btn_listasEdit.setEnabled(false);
    }//GEN-LAST:event_btn_listasNewActionPerformed

    private void listarListas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarListas
        // TODO add your handling code here:
        int columna_ = tabla_listas.getSelectedRow();
        llenarInformacionLista((int) tabla_listas.getModel().getValueAt(columna_, 0));
    }//GEN-LAST:event_listarListas

    private void btn_listasEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listasEditActionPerformed
        // TODO add your handling code here:
        txt_listas.setEditable(true);
        btn_listasNew.setEnabled(false);
        
    }//GEN-LAST:event_btn_listasEditActionPerformed

    private void btn_editSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editSaveActionPerformed
        // TODO add your handling code here:
        grupos.setGrupo(txt_listas.getText());
        dgrupos.ModificarGrupo(clavegrupo, grupos);
        this.cargarGrupos();
        btn_listasNew.setEnabled(true);
        btn_listasEdit.setEnabled(true);
        txt_listas.setText("");
        txt_listas.setEditable(false);
    }//GEN-LAST:event_btn_editSaveActionPerformed
    public void llenarInformacionLista(int clave) {
        ArrayList<grupos> grupos_ = dgrupos.ListarGrupos(clave);
        Iterator iterator = grupos_.iterator();
        System.out.println(iterator);
        try {
            while (iterator.hasNext()) {
                grupos grupo__;
                grupo__ = (grupos) iterator.next();
                clavegrupo = grupo__.getIdgrupo();
                txt_listas.setText(grupo__.getGrupo());
            }
        } catch (Exception e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_categoria;
    private javax.swing.JButton btn_editSave;
    private javax.swing.JButton btn_guardarContacto;
    private javax.swing.JButton btn_listasEdit;
    private javax.swing.JButton btn_listasNew;
    private javax.swing.JButton btn_mEditar;
    private javax.swing.JButton btn_mGuardar;
    private javax.swing.JComboBox cbn_grupos;
    private javax.swing.JCheckBox chk_contactoPleno;
    private javax.swing.JCheckBox chk_rspleno;
    private javax.swing.JComboBox combo_lista;
    private javax.swing.JTabbedPane contacto_panel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel panel_infoContacto;
    private javax.swing.JPanel panel_usrInfo;
    private javax.swing.JTable tabla_contactos;
    private javax.swing.JTable tabla_listas;
    private javax.swing.JTextField txt_contactoApellido;
    private javax.swing.JTextField txt_contactoCargo;
    private javax.swing.JTextField txt_contactoCelular;
    private javax.swing.JTextArea txt_contactoDireccion;
    private javax.swing.JTextField txt_contactoEmail;
    private javax.swing.JTextField txt_contactoInstitucion;
    private javax.swing.JTextField txt_contactoNombre;
    private javax.swing.JTextField txt_contactoTelefono;
    private javax.swing.JTextField txt_listas;
    private javax.swing.JTextField txt_rsapellidos;
    private javax.swing.JTextField txt_rscargo;
    private javax.swing.JTextField txt_rscelular;
    private javax.swing.JTextArea txt_rsdireccion;
    private javax.swing.JTextField txt_rsinstitucion;
    private javax.swing.JTextField txt_rsmail;
    private javax.swing.JTextField txt_rsnombres;
    private javax.swing.JTextField txt_rstelefono;
    // End of variables declaration//GEN-END:variables
}
