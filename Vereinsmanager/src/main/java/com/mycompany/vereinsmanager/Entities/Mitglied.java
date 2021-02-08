package com.mycompany.vereinsmanager.Entities;

import java.util.Date;

/**
 *
 * @author masia
 */
public class Mitglied {
    /**
     * vorname des Mitglieds
     */
    protected String vorname;
    /**
     * nachname des Mitglieds
     */
    protected String nachname;
    /**
     * strasse des Mitglieds
     */
    protected String strasse;
    /**
     * Postleitzahl des Mitglieds
     */
    protected String plz;
    /**
     * Wohnort des Mitglieds
     */
    protected String ort;
    /**
     * Geburtsdatum des Mitglieds
     */
    protected Date geburtsDatum;
    /**
     * email-Adresse des Mitglieds
     */
    protected String email;
    /**
     * Telefonnummer des Mitglieds
     */
    protected String telefonNr;
    /**
     * Mannschaftsbezeichnung der mannschaft des Mitglieds
     */
    protected String mannschaft;

    /**
     * Erstellt ein neues Mitglied mit den angegeben Daten
     * @param vorname vorname
     * @param nachname nachname
     * @param strasse strasse
     * @param plz Postleitzahl
     * @param ort ort
     * @param geburtsDatum Geburtsdatum
     * @param email email-Adresse
     * @param telefonNr Telefonnummer
     */
    public Mitglied(String vorname, String nachname, String strasse, String plz, String ort, Date geburtsDatum, String email, String telefonNr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
        this.geburtsDatum = geburtsDatum;
        this.email = email;
        this.telefonNr = telefonNr;
    }

    /**
     * Erstellt ein neues Mitglied
     */
    public Mitglied() {
    }
    /**
     * Gibt den Vornamen des Mitglieds zurück
     * @return Vorname
     */
    public String getVorname() {
        return vorname;
    }
    /**
     * Setzt den übergeben Vornamen als Vornamen des Mitglieds
     * @param vorname 
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    /**
     * Gibt den Nachnamen des Mitglieds zurück
     * @return Nachname
     */
    public String getNachname() {
        return nachname;
    }
    /**
     * Setzt den übergebenen Nachnamen als Nachnamen des Mitglieds
     * @param Nachname 
     */
    public void setNachname(String Nachname) {
        this.nachname = Nachname;
    }
    /**
     * Gibt die Straße des Mitglieds zurück
     * @return Straße
     */
    public String getStrasse() {
        return strasse;
    }
    /**
     * Setzt die übergebene Straße als Straße des Mitglieds
     * @param strasse Straße
     */
    public void setStraße(String strasse) {
        this.strasse = strasse;
    }
    /**
     * Gibt die Postleitzahl des Mitglieds zurück
     * @return Postleitzahl
     */
    public String getPLZ() {
        return plz;
    }
    /**
     * Setzt die übergebene Postleitzahl als Postleitzahl des Mitglieds
     * @param plz Postleitzahl
     */
    public void setPLZ(String plz) {
        this.plz = plz;
    }
    /**
     * Gibt den Ort des Mitglieds zurück
     * @return Ort
     */
    public String getOrt() {
        return ort;
    }
    /**
     * Setzt den übergeben Ort als Ort des Mitglieds
     * @param ort Ort
     */
    public void setOrt(String ort) {
        this.ort = ort;
    }
    /**
     * Gibt das Geburtsdatum des Mitglieds zurück
     * @return Geburtsdatum
     */
    public Date getGeburtsDatum() {
        return geburtsDatum;
    }
    /**
     * Setzt das übergebene Geburtsdatum als Geburtsdatum des Mitglieds
     * @param GeburtsDatum 
     */
    public void setGeburtsDatum(Date GeburtsDatum) {
        this.geburtsDatum = GeburtsDatum;
    }
    /**
     * Gibt die Email-Adresse des Mitglieds zurück
     * @return Email-Adresse
     */
    public String getEmail() {
        return email;
    }
    /**
     * Setzt die übergebene Email-Adresse als Email-Adresse des Mitglieds
     * @param email Email-Adresse
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Gibt die Telefonnummer des Mitglieds zurück
     * @return Telefonnummer
     */
    public String getTelefonNr() {
        return telefonNr;
    }
    /**
     * Setzt die übergebene Telefonnummer als Telefonnummer des Mitglieds
     * @param telefonNr 
     */
    public void setTelefonNr(String telefonNr) {
        this.telefonNr = telefonNr;
    }
    /**
     * Gibt den Namen der Mannschaft des Mitglieds zurück
     * @return Mannschaftsbezeichnung
     */
    public String getMannschaft() {
        return mannschaft;
    }
    /**
     * Setzt die übergebene Mannschaft als Mannschaft des Mitglieds
     * @param mannschaft Mannschaftsbezeichnung
     */
    public void setMannschaft(String mannschaft) {
        this.mannschaft = mannschaft;
    }
    
    /**
     * Formatiert ein Mitglied als String
     * @return Name des Mitglieds
     */
    @Override
    public String toString() {
        return this.vorname + " " + this.nachname;
    }
}
