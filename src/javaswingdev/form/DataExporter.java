package javaswingdev.form;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DataExporter {

    public static void exportDataToXML() {
        try {
            // Connexion à la base de données
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/art", "root", "");

            // Exécution de la requête SQL pour récupérer les données
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM oeuvre");
            ResultSet rs = stmt.executeQuery();

            // Création du document XML
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Création de l'élément racine du document
            Element rootElement = doc.createElement("data");
            doc.appendChild(rootElement);

            // Parcours des données de la base de données
            while (rs.next()) {
                // Création d'un élément pour chaque enregistrement
                Element recordElement = doc.createElement("record");
                rootElement.appendChild(recordElement);

                // Ajout des données de chaque colonne comme des sous-éléments
                Element idOElement = doc.createElement("idO");
                idOElement.appendChild(doc.createTextNode(rs.getString("idO")));
                recordElement.appendChild(idOElement);

                Element idArtisteElement = doc.createElement("idArtiste");
                idArtisteElement.appendChild(doc.createTextNode(rs.getString("idArtiste")));
                recordElement.appendChild(idArtisteElement);

                Element titreElement = doc.createElement("titre");
                titreElement.appendChild(doc.createTextNode(rs.getString("titre")));
                recordElement.appendChild(titreElement);

                Element aneeCreationElement = doc.createElement("aneeCreation");
                aneeCreationElement.appendChild(doc.createTextNode(rs.getString("aneeCreation")));
                recordElement.appendChild(aneeCreationElement);

                Element descriptionElement = doc.createElement("description");
                descriptionElement.appendChild(doc.createTextNode(rs.getString("description")));
                recordElement.appendChild(descriptionElement);

                Element prixElement = doc.createElement("prix");
                prixElement.appendChild(doc.createTextNode(rs.getString("prix")));
                recordElement.appendChild(prixElement);

                Element imageElement = doc.createElement("image");
                imageElement.appendChild(doc.createTextNode(rs.getString("image")));
                recordElement.appendChild(imageElement);

                // Ajout d'autres colonnes si nécessaire...
            }

            // Écriture du document XML dans un fichier
            File file = new File("donnees.xml");
            FileOutputStream fos = new FileOutputStream(file);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(fos);
            transformer.transform(source, result);
            fos.close();

            System.out.println("Données exportées avec succès vers le fichier XML.");

            // Fermeture des ressources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ParserConfigurationException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}