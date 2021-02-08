package com.mycompany.vereinsmanager.Entities;

import java.util.Date;

/**
 *
 * @author masia
 */
public class NormalesMitglied extends Mitglied {
    /**
     * zu zahlender Gesamtbetrag
     */
    private double zuZahlenderBetrag;

    /**
     * Erstellt ein neues normales Mitglied
     */
    public NormalesMitglied() {
    }
    /**
     * Erstellt ein normales Mitglied
     * @param vorname Vorname des Mitglieds
     * @param nachname Nachname des Mitglieds
     * @param strasse Straße des Mitglieds
     * @param plz Postleitzahl des Mitglieds
     * @param ort Ort des Mitglieds
     * @param geburtsDatum Geburtsdatum des Mitglieds
     * @param email Email-Adresse des Mitglieds
     * @param telefonNr Telefonnummer des Mitglieds
     * @param betrag zu zahlender Beitrag
     */
    public NormalesMitglied( String vorname, String nachname, String strasse, String plz, String ort, Date geburtsDatum, String email, String telefonNr, double betrag ) {
        super( vorname, nachname, strasse, plz, ort, geburtsDatum, email, telefonNr);
        this.zuZahlenderBetrag = betrag;
    }
    /**
     * Gibt den offenen Zahlungsbetrag zurück
     * @return betrag
     */
    public double getZuZahlenderBetrag() {
        return zuZahlenderBetrag;
    }
    /**
     * Setzt den zu zahlenden offenen Betrag auf den übergebenen Wert
     * @param betrag 
     */
    public void setZuZahlenderBetrag(double betrag) {
        this.zuZahlenderBetrag = betrag;
    }
    
    
}
