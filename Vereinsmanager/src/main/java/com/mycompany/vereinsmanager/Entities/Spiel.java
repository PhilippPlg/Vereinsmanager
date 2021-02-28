package com.mycompany.vereinsmanager.Entities;

import java.util.Date;

/**
 * Spielmodell
 * @author masia
 */
public class Spiel {
    /**
     * Bezeichnung des eigenen Teams
     */
    private String eigenesTeam;
    /**
     * Name des gegnerischen Teams
     */
    private String gegnerTeam;
    /**
     * eigene Punkte nach Spielende
     */
    private int eigenePunkte;
    /**
     * gegnerische Punkte nach Spielende
     */
    private int gegnerPunkte;
    /**
     * Startzeitpunkt des Spiels
     */
    private Date zeitpunkt;
    /**
     * Austragungsort
     */
    private String ort;
    /**
     * Erstellt ein neues Spiel
     */
    public Spiel() {
    }
    /**
     * Erstellt ein neues Spiel mit den angegeben Attributen
     * @param eigenesTeam Bezeichnung des eigenen Teams
     * @param gegnerTeam Name des gegnerischen Teams
     * @param zeitpunkt Startzeitpunkt des Spiels
     * @param ort Austragungsort
     */
    public Spiel(String eigenesTeam, String gegnerTeam, Date zeitpunkt, String ort) {
        this.eigenesTeam = eigenesTeam;
        this.gegnerTeam = gegnerTeam;
        this.zeitpunkt = zeitpunkt;
        this.ort = ort;
    }
    /**
     * Gibt den Ort des Spiels zurück
     * @return Ort
     */
    public String getOrt() {
        return ort;
    }
    /**
     * Setzt den übergebenen Ort als Ort des Spiels ein
     * @param ort 
     */
    public void setOrt(String ort) {
        this.ort = ort;
    }

    /**
     * Gibt den Namen des eigenen Teams zurück
     * @return Bezeichnung des Teams
     */
    public String getEigenesTeam() {
        return eigenesTeam;
    }
    /**
     * Setzt das als Bezeichnung übergebene Team als eigenes Team für dieses Spiel ein
     * @param eigenesTeam 
     */
    public void setEigenesTeam(String eigenesTeam) {
        this.eigenesTeam = eigenesTeam;
    }
    /**
     * Gibt den Namen des gegnerischen Teams zurück
     * @return Name des gegnerischen Teams
     */
    public String getGegnerTeam() {
        return gegnerTeam;
    }
    /**
     * Setzt den übergebenen Namen als Name des gegnerischen Spiels ein
     * @param gegnerTeam 
     */
    public void setGegnerTeam(String gegnerTeam) {
        this.gegnerTeam = gegnerTeam;
    }
    /**
     * Gibt die Punkte des eigenen Team nach Abschluss des Spiels an
     * @return eigene Punkte
     */
    public int getEigenePunkte() {
        return eigenePunkte;
    }
    /**
     * Trägt die vom eigenen Team erreichten Punkte nach Spielende ein
     * @param eigenePunkte 
     */
    public void setEigenePunkte(int eigenePunkte) {
        this.eigenePunkte = eigenePunkte;
    }
    /**
     * Gibt die vom Gegner erreichten Punkte nach Spielende zurück
     * @return gegnerische Punkte
     */
    public int getGegnerPunkte() {
        return gegnerPunkte;
    }
    /**
     * Setzt die Punkte des Gegners auf den übergebenen Wert
     * @param gegnerPunkte 
     */
    public void setGegnerPunkte(int gegnerPunkte) {
        this.gegnerPunkte = gegnerPunkte;
    }
    /**
     * Gibt den Startzeitpunkt des Spiels zurück
     * @return Startzeitpunkt
     */
    public Date getZeitpunkt() {
        return zeitpunkt;
    }
    /**
     * Setzt den Startzeitpunkt des Spiels fest
     * @param zeitpunkt 
     */
    public void setZeitpunkt(Date zeitpunkt) {
        this.zeitpunkt = zeitpunkt;
    }

    /**
     * Gibt das Spiel als String-Bezeichnung zurück
     * @return
     */
    @Override
    public String toString() {
        return this.eigenesTeam + " gegen " + this.gegnerTeam;
    }
}
