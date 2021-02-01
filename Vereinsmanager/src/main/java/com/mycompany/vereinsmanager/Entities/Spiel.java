/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager.Entities;

import static com.mycompany.vereinsmanager.main.Validator.isValidDate;
import static com.mycompany.vereinsmanager.main.Validator.isValidTime;
import java.util.Date;

/**
 *
 * @author masia
 */
public class Spiel {

    private String eigenesTeam;
    private String gegnerTeam;
    private int eigenePunkte;
    private int gegnerPunkte;
    private Date zeitpunkt;
    private String ort;

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
    private String beginn;

    public String getBeginn() {
        return beginn;
    }

    public void setBeginn(String beginn) {
        this.beginn = beginn;
    }

    public Spiel() {
    }

    public Spiel(String eigenesTeam, String gegnerTeam, Date zeitpunkt, String ort) {
        this.eigenesTeam = eigenesTeam;
        this.gegnerTeam = gegnerTeam;
        this.zeitpunkt = zeitpunkt;
        this.ort = ort;
    }

    public String getEigenesTeam() {
        return eigenesTeam;
    }

    public void setEigenesTeam(String eigenesTeam) {
        this.eigenesTeam = eigenesTeam;
    }

    public String getGegnerTeam() {
        return gegnerTeam;
    }

    public void setGegnerTeam(String gegnerTeam) {
        this.gegnerTeam = gegnerTeam;
    }

    public int getEigenePunkte() {
        return eigenePunkte;
    }

    public void setEigenePunkte(int eigenePunkte) {
        this.eigenePunkte = eigenePunkte;
    }

    public int getGegnerPunkte() {
        return gegnerPunkte;
    }

    public void setGegnerPunkte(int gegnerPunkte) {
        this.gegnerPunkte = gegnerPunkte;
    }

    public Date getZeitpunkt() {
        return zeitpunkt;
    }

    public void setZeitpunkt(Date zeitpunkt) {
        this.zeitpunkt = zeitpunkt;
    }

    public boolean hatSpielAngefangen() {
        //CODE HERE
        return true;
    }

    public String toString() {
        return this.eigenesTeam + " gegen " + this.gegnerTeam;
    }
}
