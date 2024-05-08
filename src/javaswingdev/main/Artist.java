/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaswingdev.main;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Artist {
    private int id;
    private String name;
    private String nationality;
    private Date birthdate;

    public Artist(int id, String name, String nationality, Date birthdate) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public static List<Artist> parseArtistsFromXML(String filePath) {
        List<Artist> artists = new ArrayList<>();
        try {
            File file = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("artist");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String nationality = element.getElementsByTagName("nationality").item(0).getTextContent();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthdate = sdf.parse(element.getElementsByTagName("birthdate").item(0).getTextContent());
                    artists.add(new Artist(id, name, nationality, birthdate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artists;
    }

    public static void main(String[] args) {
        List<Artist> artists = parseArtistsFromXML("artists.xml");
        for (Artist artist : artists) {
            System.out.println(artist.getId() + ", " + artist.getName() + ", " + artist.getNationality() + ", " + artist.getBirthdate());
        }
    }
}
