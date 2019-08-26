package com.isa.zajavieni.service;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationLoader {
    public void getProperties() {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("/home/kacper/Desktop/Zajavieni/target/zajavieni.properties")) {

            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
