/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vereinsmanager.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    public static boolean isValidEmail( String email ) {
        Pattern p = Pattern.compile( "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE );
        Matcher m = p.matcher( email );
        return m.matches();
    }
    
    public static boolean isValidDate( String date ) {
        Pattern p = Pattern.compile( "^\\d{1,2}\\.\\d{1,2}\\.\\d{4}$" );
        Matcher m = p.matcher( date );
        if( m.matches() ) {
            // Wenn das Datum nicht geparst werden kann wird false return
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate localDate = formatter.parse(date, LocalDate::from);
            } catch (DateTimeParseException e) {
                return false;
            }
        }
        return true;
    }
    
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
}
