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
public class NormalesMitglied extends Mitglied{
    private double zuZahlenderBetrag;

    public NormalesMitglied() {
    }
    
    public NormalesMitglied( String vorname, String nachname, String straße, String PLZ, String ort, Date geburtsDatum, String email, String telefonNr ) {
        super( vorname, nachname, straße, PLZ, ort, geburtsDatum, email, telefonNr);
    }

    public double getZuZahlenderBetrag() {
        return zuZahlenderBetrag;
    }

    public void setZuZahlenderBetrag(double zuZahlenderBetrag) {
        this.zuZahlenderBetrag = zuZahlenderBetrag;
    }
    
    
}
