/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager;

/**
 *
 * @author masia
 */
public class NormalesMitglied extends Mitglied{
    private double zuZahlenderBetrag;

    public NormalesMitglied() {
    }

    public double getZuZahlenderBetrag() {
        return zuZahlenderBetrag;
    }

    public void setZuZahlenderBetrag(double zuZahlenderBetrag) {
        this.zuZahlenderBetrag = zuZahlenderBetrag;
    }
    
    
}
