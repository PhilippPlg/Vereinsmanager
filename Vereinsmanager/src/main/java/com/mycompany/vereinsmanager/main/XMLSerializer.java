package com.mycompany.vereinsmanager.main;

import com.mycompany.vereinsmanager.Enums.ESaveObject;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hilfsklasse zum Speichern von Objekten in unseren XMLFiles
 * @author Timo
 */
public class XMLSerializer {

    /**
     * Schreibt ein object in XML-Form und speichert es in XMLFiles/"SaveObject".xml
     * @param object das zu speichernde object
     * @param SaveObject ESaveObject Zugehörigkeit/Object-type
     * @throws IOException 
     */
    public static void serializeToXML(ArrayList<Object> object, ESaveObject SaveObject) throws IOException {
        File XMLFile = new File("./XMLFiles/" + SaveObject.toString() + ".xml");
        if (!XMLFile.exists()) {
            XMLFile.getParentFile().mkdirs();
            XMLFile.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(XMLFile);
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener((Exception e) -> {
            System.out.println("Exception! :" + e.toString());
        });
        encoder.writeObject(object);
        encoder.close();
        fos.close();
    }

}
