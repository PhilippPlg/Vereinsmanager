package com.mycompany.vereinsmanager.main;

import com.mycompany.vereinsmanager.Entities.Mannschaft;
import com.mycompany.vereinsmanager.Entities.Profispieler;
import com.mycompany.vereinsmanager.Entities.Trainer;
import com.mycompany.vereinsmanager.Entities.NormalesMitglied;
import com.mycompany.vereinsmanager.Entities.Spiel;
import com.mycompany.vereinsmanager.Enums.ESaveObject;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hilfsklasse zum Laden und Decoden von unseren in XMLFiles gespeicherten Objekten
 * @author Timo
 */
public class XMLLoader {
    
    /**
     * Liest eine ArrayList von ESaveObjects aus XMLFiles/"SaveObject".xml aus
     * und gibt diese als Obeject zurück - Das Ergebnis muss noch gecastet werden
     * @param SaveObject
     * @return Object
     * @throws IOException 
     */
    public static Object deserializeFromXML(ESaveObject SaveObject) throws IOException {
        File file = new File("./XMLFiles/" + SaveObject.toString() + ".xml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.setExceptionListener((Exception e) -> {
                System.out.println("Exception! :" + e.toString());
            });
            encoder.writeObject(null);
            encoder.close();
            fos.close();
        }

        FileInputStream fis = new FileInputStream(file);
        XMLDecoder decoder = new XMLDecoder(fis);
        Object decodedEntity = decoder.readObject();
        decoder.close();
        fis.close();
        return decodedEntity;
    }
    /**
     * Liest die Liste der normalen Mitglieder aus XMLFiles/normalesMitglied.xml
     * @return ArrayList&lt;NormalesMitglied&gt;
     * @throws IOException 
     */
    public static ArrayList<NormalesMitglied> loadMitglieder() throws IOException {
        Object UncastedMitglieder = deserializeFromXML(ESaveObject.normalesMitglied);
        if (UncastedMitglieder == null) {
            return new ArrayList<NormalesMitglied>();
        }
        return (ArrayList<NormalesMitglied>) UncastedMitglieder;
    }
    /**
     * Liest die Liste der Profispieler aus XMLFiles/profiSpieler.xml
     * @return ArrayList&lt;Profispieler&gt;
     * @throws IOException 
     */
    public static ArrayList<Profispieler> loadProfiSpieler() throws IOException {
        Object UncastedSpieler = deserializeFromXML(ESaveObject.profiSpieler);
        if (UncastedSpieler == null) {
            return new ArrayList<Profispieler>();
        }
        return (ArrayList<Profispieler>) UncastedSpieler;
    }
    /**
     * Liest die Liste der Mannschaften aus XMLFiles/mannschaft.xml
     * @return ArrayList&lt;Mannschaft&gt;
     * @throws IOException 
     */
    public static ArrayList<Mannschaft> loadMannschaft() throws IOException {
        Object UncastedMannschaft = deserializeFromXML(ESaveObject.mannschaft);
        if (UncastedMannschaft == null) {
            return new ArrayList<Mannschaft>();
        }
        return (ArrayList<Mannschaft>) UncastedMannschaft;
    }
    /**
     * Liest die Liste der Trainer aus XMLFiles/trainer.xml
     * @return ArrayList&lt;Trainer&gt;
     * @throws IOException 
     */
    public static ArrayList<Trainer> loadTrainer() throws IOException {
        Object UncastedTrainer = deserializeFromXML(ESaveObject.trainer);
        if (UncastedTrainer == null) {
            return new ArrayList<Trainer>();
        }
        return (ArrayList<Trainer>) UncastedTrainer;
    }
    /**
     * Liest die Liste der Spiele aus XMLFiles/spiel.xml 
     * @return ArrayList&lt;Spiel&gt;
     * @throws IOException 
     */
    public static ArrayList<Spiel> loadSpiel() throws IOException {
        Object UncastedSpiel = deserializeFromXML(ESaveObject.spiel);
        if (UncastedSpiel == null) {
            return new ArrayList<Spiel>();
        }
        return (ArrayList<Spiel>) UncastedSpiel;
    }

}
