package com.crm.FreeCRMTest.FileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./TestData/FreeCrmPropertyFile.txt");
		Properties p=new Properties();
		p.load(fis);
		String Data= p.getProperty(key);
		return Data;
		
	}

}
