package com.mycompany.vereinsmanager.Entities;

/**
 *
 * @author masia
 */
public class Mannschaft {
    /**
     * Name der Mannschaft
     */
    private String bezeichnung;
    /**
     * Name des Trainers
     */
    private String trainer;
    /**
     * Liste der Trainingszeiten
     */
    private Trainingszeit[] trainingszeiten;
    /**
     * Das letzte Spiel
     */
    private Spiel letztesErgebnis;
    /**
     * Das nächste Spiel
     */
    private Spiel naechstesSpiel;

    /**
     * Gibt das nächste Spiel zurück
     * @return Spiel
     */
    /**
     * Liste der Spiele der Mannschaft
     */
    private Spiel[] spiele;

    /**
     * Erstellt eine neue Mannschaft
     */
    public Mannschaft() {
    }
    /**
     * Erstellt eine neue Mannschaft mit der angegeben Bezeichnung
     * @param bezeichnung Bezeichnung der Mannschaft
     */
    public Mannschaft(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    public Spiel getNaechstesSpiel() {
        return naechstesSpiel;
    }

    /**
     * Gibt das letzte Spiel zurück
     * @return Spiel
     */
    public Spiel getLetztesErgebnis() {
        return letztesErgebnis;
    }

    /**
     * Setzt das Ergebnis des letzten Spiel der Mannschaft
     * @param letztesErgebnis Spiel mit Ergebnis
     */
    public void setLetztesErgebnis(Spiel letztesErgebnis) {
        this.letztesErgebnis = letztesErgebnis;
    }

    /**
     * Gibt die Bezeichnung der Mannschaft zurück
     * @return bezeichnung
     */
    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Setzt übergebene Bezeichung als Bezeichnung der Mannschaft ein
     * @param bezeichnung Mannschaftsbezeichnung
     */
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    /**
     * gibt den Namen des Trainers der Mannschaft zurück
     * @return Name des Trainers
     */
    public String getTrainer() {
        return trainer;
    }

    /**
     * Speichert den übergeben Trainer als Trainer der Mannschaft
     * @param trainer
     */
    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    /**
     * Gibt die Trainingszeiten der Mannschaft zurück
     * @return Trainingszeit[]
     */
    public Trainingszeit[] getTrainingszeiten() {
        return trainingszeiten;
    }

    /**
     * Speichert die angegeben Trainingszeiten als Trainingszeiten der Mannschaft
     * @param trainingszeiten
     */
    public void setTrainingszeiten(Trainingszeit[] trainingszeiten) {
        this.trainingszeiten = trainingszeiten;
    }

    /**
     * Gibt die Spiele der Mannschaft zurück
     * @return Spiel[]
     */
    public Spiel[] getSpiele() {
        return spiele;
    }

}
