/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Timo
 */
public class XMLLoader {

    public static Object deserializeFromXML(ESaveObject SaveObject) throws IOException {
        File file = new File("./XMLFiles/" + SaveObject.toString() + ".xml");
        if (!file.exists()) {
            FileOutputStream fos = new FileOutputStream(file);
            file.createNewFile();
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

    public static ArrayList<NormalesMitglied> loadMitglieder() throws IOException {
        Object UncastedMitglieder = deserializeFromXML(ESaveObject.normalesMitglied);
        if (UncastedMitglieder == null) {
            return new ArrayList<NormalesMitglied>();
        }
        return (ArrayList<NormalesMitglied>) UncastedMitglieder;
    }

    public static ArrayList<Profispieler> loadProfiSpieler() throws IOException {
        Object UncastedSpieler = deserializeFromXML(ESaveObject.profiSpieler);
        if (UncastedSpieler == null) {
            return new ArrayList<Profispieler>();
        }
        return (ArrayList<Profispieler>) UncastedSpieler;
    }

    public static ArrayList<Mannschaft> loadMannschaft() throws IOException {
        Object UncastedMannschaft = deserializeFromXML(ESaveObject.mannschaft);
        if (UncastedMannschaft == null) {
            return new ArrayList<Mannschaft>();
        }
        return (ArrayList<Mannschaft>) UncastedMannschaft;
    }

    public static ArrayList<Trainer> loadTrainer() throws IOException {
        Object UncastedTrainer = deserializeFromXML(ESaveObject.trainer);
        if (UncastedTrainer == null) {
            return new ArrayList<Trainer>();
        }
        return (ArrayList<Trainer>) UncastedTrainer;
    }

    public static ArrayList<Spiel> loadSpiel() throws IOException {
        Object UncastedSpiel = deserializeFromXML(ESaveObject.spiel);
        if (UncastedSpiel == null) {
            return new ArrayList<Spiel>();
        }
        return (ArrayList<Spiel>) UncastedSpiel;
    }

}
