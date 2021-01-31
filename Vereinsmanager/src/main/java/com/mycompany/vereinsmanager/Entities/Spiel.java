/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager.Entities;

import java.util.Date;

/**
 *
 * @author masia
 */
public class Spiel {


    private Mannschaft eigenesTeam;
    private String gegnerTeam;
    private int eigenePunkte;
    private int gegnerPunkte;
    private Date zeitpunkt;

    public Spiel(Mannschaft eigenesTeam, String gegnerTeam, Date zeitpunkt) {
        this.eigenesTeam = eigenesTeam;
        this.gegnerTeam = gegnerTeam;
        this.zeitpunkt = zeitpunkt;
    }

    public Mannschaft getEigenesTeam() {
        return eigenesTeam;
    }

    public void setEigenesTeam(Mannschaft eigenesTeam) {
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
    
    public boolean hatSpielAngefangen(){
        //CODE HERE
        return true;
    }
}
