package main.java.com.api.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Ashlin on 7/13/2017.
 */
public class config {
    public static String get(credential variable){
        String value = null;
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("src/main/resources/env.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            value = prop.getProperty(variable.toString()).toString();

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }
}
