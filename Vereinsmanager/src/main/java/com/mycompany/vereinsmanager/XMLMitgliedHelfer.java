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
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
/**
 *
 * @author Tim
 */
public class XMLMitgliedHelfer extends XMLHelfer {
    
    private ArrayList<Mitglied> eintraege;
    
    public XMLMitgliedHelfer() {    
        this.eintraege = new ArrayList<>();
    }
    
    /**
     * @TODO Date hinzufügen
     * @TODO Exception behandeln (?)
     * Lädt alle Mitglieder aus XMLFiles/Mitglieder.xml und speichert diese als
     * Mitglied in der ArrayList eintraege
     */
    public void translateMitglieder() {
        try {
            //Mitgliederliste laden und parsen
            File xmlFile = new File("./XMLFiles/Mitglieder.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList mitglieder = doc.getElementsByTagName("mitglied");
            // Eintraege nicht doppelt laden sondern erst rauswerfen
            if( !this.eintraege.isEmpty()) {
                this.eintraege.clear();
            }
            for (int i = 0; i < mitglieder.getLength(); i++) {
                Node nNode = mitglieder.item(i);   
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) nNode;
                    // :) todo
                    Date date = new Date();
                    
                    this.eintraege.add( new Mitglied( 
                        elem.getElementsByTagName( "vorname" ).item(0).getTextContent(), 
                        elem.getElementsByTagName( "nachname" ).item(0).getTextContent(), 
                        elem.getElementsByTagName( "strasse" ).item(0).getTextContent(), 
                        elem.getElementsByTagName( "plz" ).item(0).getTextContent(), 
                        elem.getElementsByTagName( "ort" ).item(0).getTextContent(), 
                        date, 
                        elem.getElementsByTagName( "email" ).item(0).getTextContent(), 
                        elem.getElementsByTagName( "telefonnr" ).item(0).getTextContent() ) );
                }
            }
        } catch( Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @param mitglied Mitglied das zum XMLFile hinzugefügt wird
     * @todo Unnötige Leerzeilen aus Mitglieder.xml entfernen - werden beim schreiben erzeugt
     * @todo Exceptions
     * Schreibt ein Mitglied object in Mitglieder.xml
     */
    public void addMitglied( Mitglied mitglied ) {
        try {
            //Mitgliederliste laden und parsen
            File xmlFile = new File("./XMLFiles/Mitglieder.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            // rootElement "mitglieder"
            Element root = doc.getDocumentElement();
            // Neues Mitglied als ChildNode zu root (mitglieder) hinzufügen
            root.appendChild( this.buildXMLNode( doc, mitglied ) );
            
            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                // Settings für xml-file
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                // tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Mitglieder.xml");
                // Neuen DomTree in Mitglieder.xml schreiben
                tr.transform(new DOMSource(doc), 
                             new StreamResult( xmlFile ));
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @return DefaultListModel zum Ausgeben aller Mitglieder in einem jList-Object
     */
    /*
    @Override
    public DefaultListModel getEintraegeList() {
        DefaultListModel mitgliederList = new DefaultListModel();
        this.eintraege.forEach( (mitglied) -> {
            mitgliederList.addElement( mitglied.listPrint() );
        });
        
        return mitgliederList;
    }
    */
    public ArrayList<Mitglied> getEintraege() {
        return this.eintraege;
    }
    
    private Node buildXMLNode( Document doc, Mitglied mitglied ) {
        Element node = doc.createElement( "mitglied" );
        
        node.appendChild(getElement( doc, node, "vorname", mitglied.getVorname() ) );
        node.appendChild(getElement( doc, node, "nachname", mitglied.getNachname() ) );
        node.appendChild(getElement( doc, node, "strasse", mitglied.getStraße() ) );
        node.appendChild(getElement( doc, node, "plz", mitglied.getPLZ() ) );
        node.appendChild(getElement( doc, node, "ort", mitglied.getOrt() ) );
        node.appendChild(getElement( doc, node, "geburtsdatum", mitglied.getGeburtsDatum().toString() ) );
        node.appendChild(getElement( doc, node, "email", mitglied.getEmail() ) );
        node.appendChild(getElement( doc, node, "telefonnr", mitglied.getTelefonNr() ) );
        
        return node;
    }
}


