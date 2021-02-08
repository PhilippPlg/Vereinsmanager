package com.mycompany.vereinsmanager.Entities;

import java.util.Date;

/**
 *
 * @author masia
 */
public class Profispieler extends Mitglied{
    private double gehalt;
    /**
     * Erstellt einen neuen Profispieler
     */
    public Profispieler() {
    }
    /**
     * Erstellt einen neuen Profispieler mit den angegeben Attributen
     * @param vorname Vorname
     * @param nachname Nachname
     * @param strasse Straße
     * @param plz Postleitzahl
     * @param ort Ort
     * @param geburtsDatum Geburtsdatum
     * @param email Email-Adresse
     * @param telefonNr Telefonnummer
     * @param gehalt Gehalt
     */
    public Profispieler(String vorname, String nachname, String strasse, String plz, String ort, Date geburtsDatum, String email, String telefonNr, double gehalt) {
        super( vorname, nachname, strasse, plz, ort, geburtsDatum, email, telefonNr );
        this.gehalt = gehalt;
    }

    /**
     * Gibt das Gehalt des Profispielers zurück
     * @return gehalt
     */
    public double getGehalt() {
        return gehalt;
    }

    /**
     * Setzt das Gehalt auf den übergebenen Wert
     * @param Gehalt
     */
    public void setGehalt(double Gehalt) {
        this.gehalt = Gehalt;
    }
    
}
