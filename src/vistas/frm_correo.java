/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import datos.excepciones;
import java.awt.Color;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author DiWolf
 */
public final class frm_correo extends javax.swing.JInternalFrame {

    /**
     * Creates new form frm_correo
     */
    DefaultTableModel buzonEntrada;
    Properties propiedades = new Properties();
    StyledDocument documento = new DefaultStyledDocument();
    SimpleAttributeSet atributos = new SimpleAttributeSet();
    String[] fontTypes = {"SansSerif", "Serif", "Monospaced", "Dialog", "DialogInput"};

    public frm_correo() throws IOException {
        initComponents();
        llenarFuentes();
        //  cargarBuzonEntrada();
    }

    //Llenar tamaño fuente
    public void llenarFuentes() {
        combo_size.removeAll();
        for (int i = 10; i <= 24; i += 2) {
            combo_size.addItem(i);
        }

    }
    //cargar buzon de entrada. 

    public void cargarBuzonEntrada() throws IOException {
        buzonEntrada = new DefaultTableModel(null, getInboxColumnas());
        table_recibir.setModel(buzonEntrada);
        setLlenarInbox();
    }

    private String[] getInboxColumnas() {
        String columnas[] = new String[]{"Remitente", "Asunto", "Fecha"};
        return columnas;
    }

    private void setLlenarInbox() throws IOException {
        Object datos[] = new Object[3];
        try {

            /*   propiedades.put("mail.pop3.host", "pop.gmail.com");
             //propiedades.put("mail.store.protocol", "pop3s")
             propiedades.put("mail.pop3.auth", "true");
             propiedades.put("mail.pop3.port", "995");*/
            //Configuración de la SECAY
            /* propiedades.put("mail.pop3.auth", "true");
             propiedades.put("mail.pop3.host", "mail.culturayucatan.com");
             propiedades.put("mail.store.protocol", "imaps");
             propiedades.put("mail.pop3.port", "110");*/
            //propiedades.put("mail.store.protocol", "imaps");

            Session sesion = Session.getDefaultInstance(propiedades);
            Store emailstore = sesion.getStore("pop3");
            emailstore.connect("mail.culturayucatan.com", "contacto.cultura@culturayucatan.com", "}P[vTM5n+dy8"); //host, usuario, password.

            //Configuración SECAY

            // emailstore.connect("contacto.cultura@culturayucatan.com", "}P[vTM5n+dy8");

            Folder emailfolder = emailstore.getFolder("INBOX");
            emailfolder.open(Folder.READ_ONLY);
            Date recibido = null;
            Message[] messages = emailfolder.getMessages();
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                /* System.out.println("De: " + message.getFrom()[0]);
                 System.out.println("Envia: " + message.getSubject());*/
                // Date recibido= messages[i].getReceivedDate();
                datos[0] = message.getFrom()[0];
                datos[1] = message.getSubject();
                //  Object contenido = message.getContent(); 
                //datos[2] = recibido;
                // datos[2] = message.getContent();
                //  txtContenido.setText(message.getContentType());
                // txtContenido.setText((String)contenido);
                //  Multipart multi = new MimeMultipart() messages[i].getContent(); 
                if (messages[i].isMimeType("multipart/*")) {
                    Multipart multi;
                    multi = (Multipart) messages[i].getContent();
                    for (int j = 0; j < multi.getCount(); j++) {
                        Part unaParte = multi.getBodyPart(j);
                    }
                    txtContenido.setText(messages[i].getContent().toString());
                }
                try {
                    recibido = message.getReceivedDate();
                    System.out.println("Recibido: " + message.getReceivedDate());
                } catch (MessagingException e) {
                    System.out.println("MessagingException caught during getReceivedDate(): " + e);
                }

                buzonEntrada.addRow(datos);
            }

            emailfolder.close(false);
            emailstore.close();
        } catch (NoSuchFieldError e) {
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(frm_correo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(frm_correo.class.getName()).log(Level.SEVERE, null, ex);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        editor = new javax.swing.JEditorPane();
        txt_contactosEnvio = new javax.swing.JTextField();
        btn_contactos = new javax.swing.JButton();
        btn_enviarMail = new javax.swing.JButton();
        txt_asuntomail = new javax.swing.JTextField();
        barra_herramientas = new javax.swing.JToolBar();
        btn_negrita = new javax.swing.JButton(new StyledEditorKit.BoldAction());
        cursiva = new javax.swing.JToggleButton(new StyledEditorKit.ItalicAction());
        subrayado = new javax.swing.JToggleButton(new StyledEditorKit.UnderlineAction());
        combo_size = new javax.swing.JComboBox();
        fuentes = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_recibir = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtContenido = new javax.swing.JTextPane();

        setClosable(true);
        setTitle("Administrador de Correo Electrónico");

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel1.setText("Para:");

        jLabel2.setText("Asunto:");

        jLabel3.setText("Cotenido:");

        editor.setContentType("text/HTML");
        editor.setEditorKit(new HTMLEditorKit());
        jScrollPane2.setViewportView(editor);

        txt_contactosEnvio.setToolTipText("Escriba las direcciones de correo electrónico.");
        txt_contactosEnvio.setName("Destinatario"); // NOI18N

        btn_contactos.setText("...");
        btn_contactos.setToolTipText("Visualizar lista de Correo");
        btn_contactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_contactosActionPerformed(evt);
            }
        });

        btn_enviarMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sendmail-24.png"))); // NOI18N
        btn_enviarMail.setText("Enviar");
        btn_enviarMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarMailActionPerformed(evt);
            }
        });

        barra_herramientas.setRollover(true);

        btn_negrita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_negrita.setText("N");
        btn_negrita.setToolTipText("Negrita");
        btn_negrita.setFocusable(false);
        btn_negrita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_negrita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_negrita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_negritaActionPerformed(evt);
            }
        });
        barra_herramientas.add(btn_negrita);

        cursiva.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        cursiva.setText("K");
        cursiva.setToolTipText("Cursiva");
        cursiva.setFocusable(false);
        cursiva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cursiva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_herramientas.add(cursiva);

        subrayado.setText("U");
        subrayado.setToolTipText("Subrayado");
        subrayado.setFocusable(false);
        subrayado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        subrayado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_herramientas.add(subrayado);

        combo_size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_sizeActionPerformed(evt);
            }
        });
        barra_herramientas.add(combo_size);

        fuentes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arial", "SansSerif", "Serif", "Monospaced" }));
        fuentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuentesActionPerformed(evt);
            }
        });
        barra_herramientas.add(fuentes);
        barra_herramientas.add(jSeparator1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_enviarMail)
                .addGap(104, 104, 104))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barra_herramientas, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_contactosEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                            .addComponent(txt_asuntomail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(btn_contactos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btn_contactos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_contactosEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_asuntomail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(barra_herramientas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btn_enviarMail)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nuevo Correo", new javax.swing.ImageIcon(getClass().getResource("/img/message-already-read.png")), jPanel1); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Enviados", new javax.swing.ImageIcon(getClass().getResource("/img/Forward (1).png")), jPanel2); // NOI18N

        table_recibir.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_recibir);

        jScrollPane3.setViewportView(txtContenido);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 88, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Correos Fallidos", new javax.swing.ImageIcon(getClass().getResource("/img/Error.png")), jPanel3); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enviarMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarMailActionPerformed
        // TODO add your handling code here:
        //Configuraciones de Correo de Gmail.
       /* propiedades.put("mail.smtp.auth", "true");
         propiedades.put("mail.smtp.starttls.enable", "true");
         propiedades.put("mail.smtp.host", "smtp.gmail.com");
         propiedades.put("mail.smtp.port", "587");*/
        //Fin configuraciones de Correo. 
        if(txt_contactosEnvio.getText().isEmpty()){
            excepciones.CamposVacios(title);
        }
        //Configuraciones de Correo de SECAY
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.host", "mail.culturayucatan.com");
        propiedades.put("mail.smtp.port", "26");
        //Fin Configuraciones de Correo de SECAY
        Session session = Session.getDefaultInstance(propiedades,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("contacto.cultura@culturayucatan.com", "}P[vTM5n+dy8");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("contacto.cultura@culturayucatan.com", "Francisco"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(txt_contactosEnvio.getText()));
            message.setSubject(txt_asuntomail.getText());
            message.setContent(editor.getText(), "text/html");
            Transport.send(message);
            //System.out.println("Done");
            JOptionPane.showMessageDialog(rootPane, "El correo se envió correctamente", "Entregado", JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(frm_correo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_enviarMailActionPerformed

    private void btn_contactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_contactosActionPerformed
        // TODO add your handling code here:
      /*  frm_contactos contactos = new frm_contactos(); 
         if(contactos == null || contactos.isClosed()){
         // frm_principal.escritorio.add(contactos);
         }*/
        //this.dispose();
        frm_listas listas = new frm_listas(null, closable);
        listas.setVisible(true);
        //listas.show();
        int columna = listas.tablaContactos.getSelectedRow();
        txt_contactosEnvio.setText((String) listas.tablaContactos.getValueAt(columna, 2));
        // txt_contactosEnvio.setText(listas.txt_test.getText());

    }//GEN-LAST:event_btn_contactosActionPerformed

    private void btn_negritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_negritaActionPerformed
        // TODO add your handling code here:
        // editor
    }//GEN-LAST:event_btn_negritaActionPerformed

    private void combo_sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_sizeActionPerformed
        // TODO add your handling code here:
        int v = (int) combo_size.getSelectedItem();
        combo_size.setAction(new StyledEditorKit.FontSizeAction(String.valueOf(v), v));
    }//GEN-LAST:event_combo_sizeActionPerformed

    private void fuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuentesActionPerformed
        // TODO add your handling code here:
        System.out.println(fuentes.getSelectedItem());
        fuentes.setAction(new StyledEditorKit.FontFamilyAction((String) fuentes.getSelectedItem(), (String) fuentes.getSelectedItem()));
    }//GEN-LAST:event_fuentesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barra_herramientas;
    private javax.swing.JButton btn_contactos;
    private javax.swing.JButton btn_enviarMail;
    private javax.swing.JButton btn_negrita;
    public javax.swing.JComboBox combo_size;
    private javax.swing.JToggleButton cursiva;
    private javax.swing.JEditorPane editor;
    private javax.swing.JComboBox fuentes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton subrayado;
    private javax.swing.JTable table_recibir;
    private javax.swing.JTextPane txtContenido;
    private javax.swing.JTextField txt_asuntomail;
    public javax.swing.JTextField txt_contactosEnvio;
    // End of variables declaration//GEN-END:variables
}
