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
public class Profispieler extends Mitglied{
    private double Gehalt;

    public Profispieler() {
    }
    
    public Profispieler(String vorname, String nachname, String strasse, String plz, String ort, Date geburtsDatum, String email, String telefonNr) {
        super( vorname, nachname, strasse, plz, ort, geburtsDatum, email, telefonNr );
    }

    public double getGehalt() {
        return Gehalt;
    }

    public void setGehalt(double Gehalt) {
        this.Gehalt = Gehalt;
    }
    
}
