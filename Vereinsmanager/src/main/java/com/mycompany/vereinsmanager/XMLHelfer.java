/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;

/**
 *
 * @author Tim
 */
public class XMLHelfer {
    
    private ArrayList eintraege;
    
    public XMLHelfer() {
        //this.eintraege = new ArrayList<>();
    }
    
    public void translateFile( String file, String rootNode ) {
        try {
            //Mitgliederliste laden und parsen
            File xmlFile = new File( "./XMLFiles/" + file );
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse( xmlFile );
            doc.getDocumentElement().normalize();
            
            NodeList mitglieder = doc.getElementsByTagName( rootNode );
            // Eintraege nicht doppelt laden sondern erst rauswerfen
            if( !this.eintraege.isEmpty()) {
                this.eintraege.clear();
            }
            for (int i = 0; i < mitglieder.getLength(); i++) {
                Node nNode = mitglieder.item(i);   
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) nNode;
                    Date date = new Date();
                    // Objekt erzeugen und zu Einträgen fügen
                    this.eintraege.add( new Object() );
                }
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
    
    protected DefaultListModel getEintraegeList( ArrayList list ) {
        DefaultListModel objectList = new DefaultListModel();
        
        list.forEach( (object) -> {
            objectList.addElement( object.toString() );
        });
        
        return objectList;
    }
    
    // XML Text node erzeugen
    protected Node getElement(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
    
}
