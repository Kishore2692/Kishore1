package org.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyFIle extends BaseClass{
//public static void main(String[] args) throws IOException {
	
//	Properties properties = new Properties();
//	FileInputStream fileInputStream = new FileInputStream(getProjectPath()+"\\Config\\config.properties");
//	properties.load(fileInputStream);
//	fileInputStream.close();
//	properties.setProperty("kiksh", "kishore");
//	FileOutputStream fileOutputStream = new FileOutputStream(getProjectPath()+"\\Config\\config.properties");
//	fileOutputStream.close();
	
//	public class MyProperties {
	    public static void main(String[] args) throws IOException  {
//	        Properties prop = new Properties();
//	        prop.setProperty("key1", "value1");
//	        prop.setProperty("key2", "value2");
//	        prop.setProperty("key3", "value3");
//
//	        System.out.println(prop.getProperty("key2"));
	    	try {
	    	    Properties prop = new Properties();
	    	    prop.setProperty("key1", "value1");
	    	    prop.setProperty("key2", "value2");
	    	    prop.setProperty("key3", "value3");
	    	    FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir")+"/Config/config.properties");
	    	    prop.store(fileOutputStream, "Config Properties");
	    	} catch (IOException e) {
	    	    System.out.println("Error writing to config file: " + e.getMessage());
	    	}
	    	System.out.println("Writing to file: " + System.getProperty("user.dir")+"/Config/config.properties");

//	        try {
//	            prop.store(new FileOutputStream("config.properties"), null);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
	    }
	

}
