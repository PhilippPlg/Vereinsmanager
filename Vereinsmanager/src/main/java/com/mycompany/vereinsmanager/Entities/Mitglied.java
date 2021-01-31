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
public class Mitglied {
    protected String Vorname;
    protected String Nachname;
    protected String Straße;
    protected String PLZ;
    protected String Ort;
    protected Date GeburtsDatum;
    protected String Email;
    protected String TelefonNr;
    protected Mannschaft Mannschaft;

    public Mitglied(String vorname, String nachname, String straße, String PLZ, String ort, Date geburtsDatum, String email, String telefonNr) {
        Vorname = vorname;
        Nachname = nachname;
        Straße = straße;
        this.PLZ = PLZ;
        Ort = ort;
        GeburtsDatum = geburtsDatum;
        Email = email;
        TelefonNr = telefonNr;
    }

    public Mitglied() {
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String Vorname) {
        this.Vorname = Vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String Nachname) {
        this.Nachname = Nachname;
    }

    public String getStraße() {
        return Straße;
    }

    public void setStraße(String Straße) {
        this.Straße = Straße;
    }

    public String getPLZ() {
        return PLZ;
    }

    public void setPLZ(String PLZ) {
        this.PLZ = PLZ;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String Ort) {
        this.Ort = Ort;
    }

    public Date getGeburtsDatum() {
        return GeburtsDatum;
    }

    public void setGeburtsDatum(Date GeburtsDatum) {
        this.GeburtsDatum = GeburtsDatum;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefonNr() {
        return TelefonNr;
    }

    public void setTelefonNr(String TelefonNr) {
        this.TelefonNr = TelefonNr;
    }

    public Mannschaft getMannschaft() {
        return Mannschaft;
    }

    public void setMannschaft(Mannschaft Mannschaft) {
        this.Mannschaft = Mannschaft;
    }
    
    @Override
    public String toString() {
        return this.Vorname + " " + this.Nachname;
    }
}
