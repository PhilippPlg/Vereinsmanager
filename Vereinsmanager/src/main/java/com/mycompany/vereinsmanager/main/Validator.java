/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tim
 */
public class Validator {
    
    /**
     * prüft ob email eine gültige Email-Adresse ist
     * @param email     der zu prüfende String
     * @return boolean  true falls email gültig ist, andernfalls false
     */
    public static boolean isValidEmail( String email ) {
        Pattern p = Pattern.compile( "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE );
        Matcher m = p.matcher( email );
        return m.matches();
    }
    
    /**
     * prüft ob date dem Format dd.mm.YYYY entspricht und sich als Date parsen lässt
     * @param date      der zu prüfende String
     * @return boolean  true falls date gültig ist, andernfalls false
     */
    public static boolean isValidDate( String date ) {
        Pattern p = Pattern.compile( "^\\d{1,2}\\.\\d{1,2}\\.\\d{4}$" );
        Matcher m = p.matcher( date );
        if( m.matches() ) {
            // Wenn das Datum nicht geparst werden kann wird false returned
            // Wenn es geparst werden kann wird true returned
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate localDate = formatter.parse(date, LocalDate::from);
            } catch (DateTimeParseException e) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * prüft ob time dem Format HH:mm entspricht und eine gültige Uhrzeit darstellt
     * @param time      der zu prüfende String
     * @return boolean  true falls date gültig ist, andernfalls false
     */
    public static boolean isValidTime( String time ) {
        Pattern p = Pattern.compile( "^\\d{2}:\\d{2}$" );
        Matcher m = p.matcher( time );
        if( m.matches() ) {
            String[] parts = time.split(":");
            if( Integer.parseInt( parts[0] ) <= 23 && Integer.parseInt( parts[1] ) <= 59 ) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * prüft ob betrag dem Format HH:mm entspricht und eine gültige Uhrzeit darstellt
     * @param betrag    der zu prüfende String
     * @return boolean  true falls betrag ein gültiger Komma-separierter double Wert ist, andernfalls false 
     */
    public static boolean isValidGeldBetrag( String betrag ) {
        Pattern p = Pattern.compile( "^\\d+(,\\d+)?$" );
        Matcher m = p.matcher( betrag );
        return m.matches();
    }
}
