/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaswingdev.form;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.List;
import javaswingdev.main.Artist;
/**
 *
 * @author zineb
 */
public class ImportArtist extends JFrame {
    private JTable table;

    public ImportArtist(List<Artist> artists) {
        setTitle("Liste des Artistes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"ID", "Nom", "Nationalité", "Date de Naissance"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        for (Artist artist : artists) {
            Object[] rowData = {
                    artist.getId(),
                    artist.getName(),
                    artist.getNationality(),
                    sdf.format(artist.getBirthdate())
            };
            model.addRow(rowData);
        }

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        List<Artist> artists = Artist.parseArtistsFromXML("artists.xml");
        SwingUtilities.invokeLater(() -> new ImportArtist(artists));
    }

    ImportArtist() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
