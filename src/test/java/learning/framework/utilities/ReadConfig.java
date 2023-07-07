package learning.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public String getApplUrl() {
		String url = pro.getProperty("url");
		return url;
	}

	public String getUsrNm() {
		String usrNm = pro.getProperty("userName");
		return usrNm;
	}

	public String getPwd() {
		String pwd = pro.getProperty("password");
		return pwd;
	}

	public String getChromeDr() {
		String chromeDr = pro.getProperty("chromepath");
		return chromeDr;
	}
	
	public String getFirefoxDr() {
		String firefoxDr = pro.getProperty("firefoxpath");
		return firefoxDr;
	}
}