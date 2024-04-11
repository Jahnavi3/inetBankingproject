package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.print("Exception is " + e.getMessage());
		}
	}
	public String getAppUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}
	public String getUsername() {
		String user = pro.getProperty("username");
		return user;
	}
	public String getPwd() {
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
}
