package com.mycompany.vereinsmanager.Entities;

/**
 *
 * @author masia
 */
public class Trainingszeit {

    /**
     * Wochentag der Trainingseinheit
     */
    private String wochentag;
    /**
     * Anfangszeit der Trainingseinheit 
     */
    private String anfangszeit;
    /**
     * Endzeit der Trainingseinheit
     */
    private String endzeit;
    /**
     * Erstellt eine neue Trainingszeit
     */
    public Trainingszeit() {
    }
    /**
     * Erstellt eine neue Trainingszeit mit den übergebenen Attributen
     * @param wochentag Wochentag
     * @param anfangszeit Startzeit
     * @param endzeit Endzeit
     */
    public Trainingszeit( String wochentag, String anfangszeit, String endzeit ) {
        this.wochentag = wochentag;
        this.anfangszeit = anfangszeit;
        this.endzeit = endzeit;
    }
    /**
     * Gibt den Wochentag des Trainings zurück
     * @return Wochentag
     */
    public String getWochentag() {
        return wochentag;
    }
    /**
     * Setzt den Wochentag der Trainingseinheit auf den übergebenen Tag
     * @param wochentag 
     */
    public void setWochentag(String wochentag) {
        this.wochentag = wochentag;
    }
    /**
     * Gibt die Anfangszeit der Trainingseinheit zurück
     * @return Trainingsstart
     */
    public String getAnfangszeit() {
        return anfangszeit;
    }
    /**
     * Setzt die Anfagszeit der Trainingseinheit auf die übergebene Anfangszeit
     * @param anfangszeit 
     */
    public void setAnfangszeit(String anfangszeit) {
        this.anfangszeit = anfangszeit;
    }
    /**
     * Gibt die Endzeit der Trainingseinheit zurück
     * @return Trainingsschluss
     */
    public String getEndzeit() {
        return endzeit;
    }
    /**
     * Setzt das Trainingsende auf die übergebene Uhrzeit
     * @param endzeit 
     */
    public void setEndzeit(String endzeit) {
        this.endzeit = endzeit;
    }
}
