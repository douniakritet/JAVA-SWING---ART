package javaswingdev.form;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.card.ModelCard;
import javaswingdev.main.Add_Transition;
import javaswingdev.main.Update_Exposition;
import javaswingdev.main.Update_Transition;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;

public class Transition extends javax.swing.JPanel {

    public Transition() {
        initComponents();
        Connect(); // Connexion à la base de données
    Fetch(); // Récupérer les données de la base de données
    init(); // Initialiser les autres composants personnalisés
    textFieldAnimation2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchTerm = textFieldAnimation2.getText().trim();
            searchTransition(searchTerm);
        }
    });
TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
            int row2 = table.getSelectedRow();
            if (row != -1) {
                String idToUpdate = table.getModel().getValueAt(row, 0).toString();
                String idOeuve = table.getModel().getValueAt(row, 1).toString();
                String idExposition = table.getModel().getValueAt(row, 2).toString();
                String nomClient = table.getModel().getValueAt(row, 3).toString();
                String dateVente = table.getModel().getValueAt(row, 4).toString();
                String statut = table.getModel().getValueAt(row, 5).toString();

                // Assuming txtId is a JTextField for ID
                JTextField txtId = new JTextField();
                Update_Transition updateForm = new Update_Transition();
                updateForm.setVisible(true);
                updateForm.setArtistData(idToUpdate, idOeuve, idExposition, nomClient,dateVente,statut);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a row to update.");
            }              }

            @Override
             public void onDelete(int row) {
    if (table.isEditing()) {
        table.getCellEditor().stopCellEditing();
    }
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    
    // Get the ID of the exhibition to be deleted
    String idToDelete = model.getValueAt(row, 0).toString();
    
    // Remove the row from the table model
    model.removeRow(row);
    
    // Delete the corresponding record from the database
    try {
        // Establish database connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/art", "root", "");

        // Prepare the delete statement for "exposition" table
        PreparedStatement pstExposition = (PreparedStatement) con.prepareStatement("DELETE FROM transaction WHERE idT = ?");
        pstExposition.setString(1, idToDelete);
        pstExposition.executeUpdate();

        // Close the statement
        pstExposition.close();

        // Close the connection
        con.close();
    } catch (SQLException ex) {
        // Handle any SQL exceptions
        ex.printStackTrace();
        // You might want to show an error message to the user here
    }
}

            
        };
        table.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
        table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
         table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
          table.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
           table.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });           table.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
                   table.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.LEFT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
    }
Connection con;
    com.mysql.jdbc.PreparedStatement pst;
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
    private void Fetch(){
    int q;
    try {
        pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("SELECT * FROM transaction");
        rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();
        q = rss.getColumnCount();
        DefaultTableModel df = (DefaultTableModel)table.getModel();
        df.setRowCount(0);
        while(rs.next()){
            Vector<Object> v2 = new Vector<>();
            for(int a=1;a<=q;a++){
                v2.add(rs.getString(a)); // Use a 1-based index for ResultSet
            }
           
           
            df.addRow(v2);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Artistes.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    private void init() {
        table.fixTable(jScrollPane1);
        
        //  init card data
        int totalArtists = Statistiques.getTotalArtists();
      card1.setData(new ModelCard(null, null, null, totalArtists + "", "Artists"));

      int totalArtworks = Statistiques.getTotalArtworks();
      card2.setData(new ModelCard(null, null, null, totalArtworks + " ", "Artworks"));

      int totalExhibitions = Statistiques.getTotalExhibitions();
      card3.setData(new ModelCard(null, null, null, totalExhibitions + " ", "Expositions"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new javaswingdev.card.Card();
        card2 = new javaswingdev.card.Card();
        card3 = new javaswingdev.card.Card();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javaswingdev.swing.table.Table();
        jButton3 = new javax.swing.JButton();
        textFieldAnimation2 = new swing.TextFieldAnimation();

        setOpaque(false);

        card1.setIcon(javaswingdev.GoogleMaterialDesignIcon.PERSON);

        card2.setColor1(new java.awt.Color(95, 211, 226));
        card2.setColor2(new java.awt.Color(26, 166, 170));
        card2.setIcon(javaswingdev.GoogleMaterialDesignIcon.IMAGE);

        card3.setColor1(new java.awt.Color(95, 243, 140));
        card3.setColor2(new java.awt.Color(3, 157, 27));
        card3.setIcon(javaswingdev.GoogleMaterialDesignIcon.EVENT);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID TABLE", "ID EXPOSITION", "CLIENT NAME", "DATE OF SELL", "STATUS", "ACTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(25, 118, 211));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-30.png"))); // NOI18N
        jButton3.setText("Add Transition");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFieldAnimation2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(textFieldAnimation2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents
private void searchTransition(String searchTerm) {
    try {
        // Prepare the SQL statement to search for transactions
        String query = "SELECT * FROM transaction WHERE idT LIKE ? OR nomClient LIKE ?";
        pst = (PreparedStatement) con.prepareStatement(query);
          pst.setString(1, "%" + searchTerm + "%"); // Search by idT
        pst.setString(2, "%" + searchTerm + "%"); // Search by nomClient
        rs = pst.executeQuery();

        // Clear the table before adding search results
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Populate the table with search results
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs.getString("idT"));
            row.add(rs.getString("idOeuvre"));
            row.add(rs.getString("idExposition"));
            row.add(rs.getString("nomClient"));
            row.add(rs.getString("dateVente"));
            row.add(rs.getString("statut"));
            model.addRow(row);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Transition.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void textFieldAnimation2ActionPerformed(java.awt.event.ActionEvent evt) {                                                    
    String searchTerm = textFieldAnimation2.getText().trim();
    searchTransition(searchTerm);
}
    
    
    private void jButton3jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            setVisible(false);

            // Create and display the Add_Artiste frame
            Add_Transition addArtisteFrame = new Add_Transition();
            addArtisteFrame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            // Add more specific error handling or logging here
        }
    }//GEN-LAST:event_jButton3jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.card.Card card1;
    private javaswingdev.card.Card card2;
    private javaswingdev.card.Card card3;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private javaswingdev.swing.table.Table table;
    private swing.TextFieldAnimation textFieldAnimation2;
    // End of variables declaration//GEN-END:variables
}
