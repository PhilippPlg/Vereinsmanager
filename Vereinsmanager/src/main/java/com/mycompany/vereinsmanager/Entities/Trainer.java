package com.mycompany.vereinsmanager.Entities;

import java.util.Date;

/**
 * Trainermodell
 * @author masia
 */
public class Trainer extends Mitglied {
    /**
     * Gehalt des Trainers
     */
    private double gehalt;
    /**
     * Erstellt einen neuen Trainer
     */
    public Trainer() {
    }
    /**
     * Erstellt einen neuen Trainer mit den übergebenen Attributen
     * @param vorname Vorname des Trainers
     * @param nachname nachname des Trainers
     * @param strasse Straße des Trainers
     * @param plz Postleitzahl des Trainers
     * @param ort Ort des Trainers
     * @param geburtsDatum Geburtsdatum des Trainers
     * @param email Email-Adresse des Trainers
     * @param telefonNr Telefonnummer des Trainers
     * @param gehalt Gehalt des Trainers
     */
    public Trainer( String vorname, String nachname, String strasse, String plz, String ort, Date geburtsDatum, String email, String telefonNr, double gehalt ) {
        super( vorname, nachname, strasse, plz, ort, geburtsDatum, email, telefonNr );
        this.gehalt = gehalt;
    }

    /**
     * Gibt das Gehalt des Trainers zurück
     * @return Gehalt
     */
    public double getGehalt() {
        return gehalt;
    }
    /**
     * Setzt das Gehalt des Trainers auf das übergebene Gehalt
     * @param Gehalt 
     */
    public void setGehalt(double Gehalt) {
        this.gehalt = Gehalt;
    }
       
       
}
