package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("D:\\Eclipse\\Innefu_Crpf\\Configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is " + e.getMessage());
		}

		
		
}
	
	public String GetApplicationURL() {

		String url = pro.getProperty("URL");
		return url;

	}

	public String Getchromepath() {

		String chromepath = pro.getProperty("chromepath");
		return chromepath;

	}

	public String Getfirefoxpath() {

		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;

	}

	public String GetIEPath() {

		String IEPath = pro.getProperty("IEPath");
		return IEPath;

	}

	
	public String Getusername() {

		String username = pro.getProperty("username");
		return username;

	}

	
	public String Getpassword() {

		String password = pro.getProperty("password");
		return password;

	}
	
	public String Getinvalid_username() {
		
		String invalid_username=pro.getProperty("invalid_username");
		return invalid_username;
	}

	
    public String Getinvalid_password() {
    	String invalid_password=pro.getProperty("invalid_password");
    	return invalid_password;
    }
    
    public String Getblank_username() {
    	String blank_username=pro.getProperty("blank_username");
    	return blank_username;
    }
    
    public String Getblank_password() {
    	String blank_password=pro.getProperty("blank_password");
    	return blank_password;
    }
    public String Getinvalidusername() {
    	String invalidusername=pro.getProperty("invalidusername");
    	return invalidusername;
    }
    public String Getinvalidpassword() {
    	String invalidpassword=pro.getProperty("invalidpassword");
    	return invalidpassword;
    }
    public String Getblankusername() {
    	String blankusername=pro.getProperty("blankusername");
    	return blankusername;
    }
    
    public String Getblankpassword() {
    	String blankpassword=pro.getProperty("blankpassword");
    	return blankpassword;
}
    
    public String Getstate() {
    	String state=pro.getProperty("state");
		return state;
    	
    }
}