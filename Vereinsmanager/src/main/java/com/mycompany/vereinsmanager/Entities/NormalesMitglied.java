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
     * @param straße Straße des Mitglieds
     * @param PLZ Postleitzahl des Mitglieds
     * @param ort Ort des Mitglieds
     * @param geburtsDatum Geburtsdatum des Mitglieds
     * @param email Email-Adresse des Mitglieds
     * @param telefonNr Telefonnummer des Mitglieds
     * @param beitrag zu zahlender Beitrag
     */
    public NormalesMitglied( String vorname, String nachname, String straße, String PLZ, String ort, Date geburtsDatum, String email, String telefonNr, Double beitrag ) {
        super( vorname, nachname, straße, PLZ, ort, geburtsDatum, email, telefonNr);
        this.zuZahlenderBetrag = beitrag;
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
     * @param zuZahlenderBetrag 
     */
    public void setZuZahlenderBetrag(double zuZahlenderBetrag) {
        this.zuZahlenderBetrag = zuZahlenderBetrag;
    }
    
    
}
