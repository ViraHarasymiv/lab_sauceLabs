package com.IFNTUNG.edu.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SauceLabsDataReader {
    private static final Properties properties = new Properties();
    private static SauceLabsDataReader instance;

    private SauceLabsDataReader(){}

    public static SauceLabsDataReader get(){
        if(instance == null){
            instance = new SauceLabsDataReader();
            try{
                properties.load(new FileInputStream("src/main/resources/sauceLabs/sauceLabs.properties"));
            } catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
        return instance;
    }
    public String getSauceLabsUserName(){return properties.getProperty("sauceLabs.userName");}
    public String getSauceLabsAccessKey(){return properties.getProperty("sauceLabs.accessKey");}
}
