/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Timo
 */
public class XMLLoader {

    public static Object deserializeFromXML(ESaveObject SaveObject) throws IOException {
        FileInputStream fis = new FileInputStream(SaveObject.toString() + ".xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        Object decodedEntity = decoder.readObject();
        decoder.close();
        fis.close();
        return decodedEntity;
    }

    public static ArrayList<NormalesMitglied> loadMitglieder() throws IOException {
        Object UncastedMitglieder;
        UncastedMitglieder = deserializeFromXML(ESaveObject.normalesMitglied);
        return (ArrayList<NormalesMitglied>) UncastedMitglieder;
    }

    public static ArrayList<Profispieler> loadSpieler() throws IOException {
        Object UncastedSpieler;
        UncastedSpieler = deserializeFromXML(ESaveObject.profiSpieler);
        return (ArrayList<Profispieler>) UncastedSpieler;
    }

    public static ArrayList<Mannschaft> loadMannschaft() throws IOException {
        Object UncastedMannschaft;
        UncastedMannschaft = deserializeFromXML(ESaveObject.mannschaft);
        return (ArrayList<Mannschaft>) UncastedMannschaft;
    }

    public static ArrayList<Trainer> loadTrainer() throws IOException {
        Object UncastedTrainer;
        UncastedTrainer = deserializeFromXML(ESaveObject.trainer);
        return (ArrayList<Trainer>) UncastedTrainer;
    }

    public static ArrayList<Spiel> loadSpiel() throws IOException {
        Object UncastedSpiel;
        UncastedSpiel = deserializeFromXML(ESaveObject.spiel);
        return (ArrayList<Spiel>) UncastedSpiel;
    }
}
