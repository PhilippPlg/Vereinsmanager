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
public class Trainingszeit {

    public Trainingszeit() {
    }

    private String wochentag;
    private String anfangszeit;
    private String endzeit;
    
    public String getWochentag() {
        return wochentag;
    }

    public void setWochentag(String wochentag) {
        this.wochentag = wochentag;
    }

    public String getAnfangszeit() {
        return anfangszeit;
    }

    public void setAnfangszeit(String anfangszeit) {
        this.anfangszeit = anfangszeit;
    }

    public String getEndzeit() {
        return endzeit;
    }

    public void setEndzeit(String endzeit) {
        this.endzeit = endzeit;
    }
}
