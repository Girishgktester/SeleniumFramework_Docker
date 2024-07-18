package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.LoggerFactory;

import io.opentelemetry.api.logs.Logger;

public class Config {

	   private static final org.slf4j.Logger log = LoggerFactory.getLogger(Config.class);
	    private static final String DEFAULT_PROPERTIES = "Config/default.properties";
	    private static Properties properties;

	    public static void initialize(){

	        // load default properties
	        properties = loadProperties();

	        // check for any override
	        for(String key: properties.stringPropertyNames()){
	            if(System.getProperties().containsKey(key)){
	                properties.setProperty(key, System.getProperty(key));
	            }
	        }

	        // print
	        log.info("Test Properties");
	        log.info("-----------------");
	        for(String key: properties.stringPropertyNames()){
	            log.info("{}={}", key, properties.getProperty(key));
	        }
	        log.info("-----------------");

	    }

	    public static String get(String key){
	        return properties.getProperty(key);
	    }

	    private static Properties loadProperties(){
	        Properties properties = new Properties();
	        try(InputStream stream = ResourceLoader.getResoruce(DEFAULT_PROPERTIES)){
	            properties.load(stream);
	        }catch (Exception e){
	            log.error("unable to read the property file {}", DEFAULT_PROPERTIES, e);
	        }
	        return properties;
	    }

}