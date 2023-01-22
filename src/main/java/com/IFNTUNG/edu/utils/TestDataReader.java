package com.IFNTUNG.edu.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {
    private static final Properties properties = new Properties();
    private static TestDataReader instance;

    private TestDataReader(){}

    public static TestDataReader get(){
        if(instance == null){
            instance = new TestDataReader();
            try{
                properties.load(new FileInputStream("src/test/resources/testData/createNewAccountData.properties"));
            } catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
        return instance;
    }
    public String getUserName(){return properties.getProperty("testdata.user_name");}
    public String getUserLastName(){ return properties.getProperty("testdata.user_last_name");}
    public String getUserBirthDay(){return properties.getProperty("testdata.dateOfBirthday");}
    public String getFixLength(){return properties.getProperty("testdata.fixLength");}
    public String getUserCompany(){return properties.getProperty("testdata.userCompany");}
    public String getUserStreet(){return properties.getProperty("testdata.userStreet");}
    public String getUserPostCode(){return properties.getProperty("testdata.postCode");}
    public String getUserCity(){ return properties.getProperty("testdata.userCity");}
    public String getUserState(){return properties.getProperty("testdata.userState");}
    public String getUserCountry(){return properties.getProperty("testdata.userCountry");}
    public String getTelephoneNumber(){return properties.getProperty("testdata.userTelephoneNumber");}
    public String getPassword(){return  properties.getProperty("testdata.userPassword");}
    public String getSuccessMessage(){return properties.getProperty("testdata.message");}
}
