/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager.Entities;
/**
 *
 * @author masia
 */
public class Mannschaft {

    private String bezeichnung;
    private Trainer trainer;
    private Profispieler[] profispieler;
    private Trainingszeit[] trainingszeiten;
    private Spiel letztesErgebnis;
    private Spiel naechstesSpiel;

    public Spiel getNaechstesSpiel() {
        return naechstesSpiel;
    }

    public void setNaechstesSpiel(Spiel naechstesSpiel) {
        this.naechstesSpiel = naechstesSpiel;
    }

    public Spiel getLetztesErgebnis() {
        return letztesErgebnis;
    }

    public void setLetztesErgebnis(Spiel letztesErgebnis) {
        this.letztesErgebnis = letztesErgebnis;
    }
    private Spiel[] spiele;

    public Mannschaft() {

    }

    public Mannschaft(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Profispieler[] getProfispieler() {
        return profispieler;
    }

    public void setProfispieler(Profispieler[] profispieler) {
        this.profispieler = profispieler;
    }

    public Trainingszeit[] getTrainingszeiten() {
        return trainingszeiten;
    }

    public void setTrainingszeiten(Trainingszeit[] trainingszeiten) {
        this.trainingszeiten = trainingszeiten;
    }

    public Spiel[] getSpiele() {
        return spiele;
    }

    public void setSpiele(Spiel[] spiele) {
        this.spiele = spiele;
    }

}
