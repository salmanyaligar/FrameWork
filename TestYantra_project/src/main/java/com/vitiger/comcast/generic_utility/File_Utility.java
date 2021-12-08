package com.vitiger.comcast.generic_utility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * author salman1
 */
public class File_Utility {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @return the vale of key in the form of string
	 * @throws Throwable
	 */
public String getProperty(String key) throws Throwable {
	FileInputStream fis=new FileInputStream("./Datafiles/commondata.properties");
	
    Properties pobj = new Properties();
    pobj.load(fis);
    String value = pobj.getProperty(key);
    return value;
}
}
