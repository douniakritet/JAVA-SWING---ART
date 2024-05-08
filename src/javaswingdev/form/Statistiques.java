/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaswingdev.form;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author zineb
 */
public class Statistiques {
    public static int getTotalArtists() {
        int totalArtists = 0;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/art", "root", "");
             PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM artiste");
             ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                totalArtists = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalArtists;
    }

    public static int getTotalArtworks() {
        int totalArtworks = 0;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/art", "root", "");
             PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM oeuvre");
             ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                totalArtworks = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalArtworks;
    }

    public static int getTotalExhibitions() {
        int totalExhibitions = 0;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/art", "root", "");
             PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM exposition");
             ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                totalExhibitions = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalExhibitions;
    }
}

