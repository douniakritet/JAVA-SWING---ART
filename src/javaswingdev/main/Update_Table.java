/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswingdev.main;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.form.Form_Dashboard;
import java.sql.ResultSet;


import javaswingdev.form.Artistes;
import javaswingdev.form.Artistes;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author ME1
 */
public class Update_Table extends javax.swing.JFrame {
          private String idToUpdate;


    /**
     * Creates new form login
     */
    public Update_Table() {
        initComponents();
       // txtusername.setBackground(new java.awt.Color(0,0,0,1));
       // txtusername1.setBackground(new java.awt.Color(0,0,0,1));
       // jDateChooser1.setBackground(new java.awt.Color(0,0,0,1));
        Connect();
        LoadId();
    }
Connection con;
PreparedStatement pst;
String ImgPath =null;
   ResultSet rs;

    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/art","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Artistes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Artistes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public ImageIcon ResizeImage(String imagePath, byte[] pic) {
     ImageIcon myImage = new ImageIcon(imagePath);
    Image img = myImage.getImage();
    Image img2 = img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
    return new ImageIcon(img2);

}
   public void LoadId(){
        try {
            pst = (PreparedStatement) con.prepareStatement("SELECT idAr FROM artiste");
            rs = pst.executeQuery();
            IDlist.removeAllItems();
            while(rs.next()){
            IDlist.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Update_Table.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        xx = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();
        IDlist = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        title = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        prix = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Add Table");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 420, 41));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(199, 226, 255));
        jLabel5.setText("ID Artiste");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 341, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_________________________________________");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 290, 39));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Cancel");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 680, 100, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(199, 226, 255));
        jLabel10.setText("Title");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 341, -1));

        xx.setForeground(new java.awt.Color(255, 255, 255));
        xx.setText("_________________________________________");
        jPanel2.add(xx, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 290, 39));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(199, 226, 255));
        jLabel12.setText("Description");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 341, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("_________________________________________");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 290, 39));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(25, 118, 211));
        jButton2.setText("Add");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 680, 100, 40));
        jPanel2.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 240, 30));

        IDlist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(IDlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 102, 240, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(199, 226, 255));
        jLabel14.setText("Image");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 341, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("_________________________________________");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 290, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(199, 226, 255));
        jLabel16.setText("Date of production");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 341, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("_________________________________________");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 290, 39));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(199, 226, 255));
        jLabel18.setText("Price");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 341, -1));

        image.setBackground(new java.awt.Color(255, 255, 255));
        image.setOpaque(true);
        jPanel2.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 150, 120));

        jButton3.setText("Browse");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, -1, -1));
        jPanel2.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 240, 30));

        description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionActionPerformed(evt);
            }
        });
        jPanel2.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 240, 110));
        jPanel2.add(prix, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 462, 250, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 800));

        setSize(new java.awt.Dimension(588, 732));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <=1.0; i = i+0.1){
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(50);
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        // Create and display the Add_Artiste frame
        dashboard addArtisteFrame = new dashboard();
        addArtisteFrame.setVisible(true);
        /*try {
            setVisible(false);
            // Create and display the Add_Artiste frame
            Artistes addArtisteFrame = new Artistes();
            addArtisteFrame.setVisible(true);    } catch (Exception ex) {
            ex.printStackTrace();
            // Add more specific error handling or logging here
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed
public boolean checkInputs() {
    if (IDlist.getSelectedItem() == null 
            || description.getText()== null 
            || title.getText() == null
            || prix.getText() == null
            || date.getDate() == null
           /* || ImgPath == null*/) { // Vérifie si une image a été sélectionnée
        return false;
    } else {
        try {
            Float.parseFloat(prix.getText()); // Tente de convertir le prix en nombre flottant
            return true; // Si aucune exception n'est levée, l'entrée est valide
        } catch (NumberFormatException ex) {
            return false; // Si la conversion échoue, l'entrée est invalide
        }
    }
}


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
  if (checkInputs()) {
        String artiste = IDlist.getSelectedItem().toString();
        String titre = title.getText();
        Date date1 = date.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datee = dateFormat.format(date1);
        String desc = description.getText();
        String price = prix.getText();
        // Check if a new image is selected
        if (ImgPath != null && !ImgPath.isEmpty()) {
            // Update the artist in the database with the image path
            updateArtistInDatabase(artiste, titre, datee, desc, price, ImgPath);
        } else {
            // Update the artist in the database without changing the image path
            updateArtistInDatabase(artiste, titre, datee, desc, price, null);
        }
    } else {
        JOptionPane.showMessageDialog(this, "One or more fields are empty");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    
  private byte[] getImageBytes(ImageIcon imageIcon) {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(baos)) {
        oos.writeObject(imageIcon);
        return baos.toByteArray();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}

    public void setArtistData(String idToUpdate, String artiste, String titre, String date2,String desc, String price, String img) {
                this.idToUpdate = idToUpdate;

         
        // Utilisez SimpleDateFormat pour convertir la date de naissance de String en Date
        try {
        // Stockez les valeurs récupérées dans des variables
        String selectedTable = artiste;
        title.setText(titre);
   
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
        date.setDate(date1);
        
        description.setText(desc);
        prix.setText(price);
        ImageIcon icon = new ImageIcon(img);
        image.setIcon(icon);
        // Définissez les valeurs des éléments de l'interface utilisateur
        IDlist.setSelectedItem(selectedTable);
      

    } catch (ParseException ex) {
        Logger.getLogger(Update_Exposition.class.getName()).log(Level.SEVERE, null, ex);
    }    }
   

   private void updateArtistInDatabase(String artiste, String title, String date, String desc, String price, String imagePath) {
    try {
        String query;
        if (imagePath == null || imagePath.isEmpty()) {
            // Query to update all fields except the image
            query = "UPDATE oeuvre SET idArtiste=?, titre=?, aneeCreation=?, description=?, prix=? WHERE idO=?";
        } else {
            // Query to update all fields including the image path
            query = "UPDATE oeuvre SET idArtiste=?, titre=?, aneeCreation=?, description=?, prix=?, image=? WHERE idO=?";
        }
        pst = (PreparedStatement) con.prepareStatement(query);
        pst.setString(1, artiste);
        pst.setString(2, title);
        pst.setString(3, date);
        pst.setString(4, desc);
        pst.setString(5, price);
        if (imagePath != null && !imagePath.isEmpty()) {
            pst.setString(6, imagePath);
            pst.setString(7, idToUpdate);
        } else {
            pst.setString(6, idToUpdate);
        }

        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Data updated successfully");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update data");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Update_Table.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(Update_Table.class.getName()).log(Level.SEVERE, null, ex);
    }
}
   
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
    file.setCurrentDirectory(new File(System.getProperty("user.home")));
    FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
    file.addChoosableFileFilter(filter);
    int result = file.showSaveDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = file.getSelectedFile();
        ImgPath = selectedFile.getAbsolutePath(); // Mise à jour de ImgPath avec le chemin d'accès sélectionné
        String path = ImgPath;
        image.setIcon(ResizeImage(path, null));

    } else {
        System.out.println("No File Selected!");
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionActionPerformed

 
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Update_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_Table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> IDlist;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField description;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField prix;
    private javax.swing.JTextField title;
    private javax.swing.JLabel xx;
    // End of variables declaration//GEN-END:variables

    
}
