/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Remmi
 */
public class frm_correonoEntregado extends javax.swing.JInternalFrame {

    /**
     * Creates new form frm_correonoEntregado
     */
    DefaultTableModel buzonEntrada;
    Properties propiedades = new Properties();

    public frm_correonoEntregado() throws IOException {
        initComponents();
        cargarBuzonEntrada();
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
            propiedades.put("mail.pop3.auth", "true");
            propiedades.put("mail.pop3.host", "mail.culturayucatan.com");
            propiedades.put("mail.store.protocol", "imaps");
            propiedades.put("mail.pop3.port", "110");
            propiedades.put("mail.store.protocol", "imaps");

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
                datos[0] = message.getFrom()[0];
                datos[1] = message.getSubject();
                buzonEntrada.addRow(datos);
                try {
                    Multipart mp = (Multipart) message.getContent();
                    BodyPart bp = mp.getBodyPart(i);
                    txtContenido.setText((String) bp.getContent());
                } catch (Exception ex) {
                }
//               
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table_recibir = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtContenido = new javax.swing.JTextPane();

        setClosable(true);

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
        table_recibir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                llenarContenido(evt);
            }
        });
        table_recibir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                table_recibirMouseDragged(evt);
            }
        });
        jScrollPane1.setViewportView(table_recibir);

        jScrollPane3.setViewportView(txtContenido);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_recibirMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_recibirMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_table_recibirMouseDragged

    private void llenarContenido(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_llenarContenido
        // TODO add your handling code here:
        System.out.println("entre");


    }//GEN-LAST:event_llenarContenido
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table_recibir;
    private javax.swing.JTextPane txtContenido;
    // End of variables declaration//GEN-END:variables
}