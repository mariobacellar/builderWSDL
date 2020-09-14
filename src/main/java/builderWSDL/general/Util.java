package builderWSDL.general;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {

  public static Properties loadProp() {

	Properties  prop  = new Properties();
	InputStream input = null;

	try {
	
		String filename = "config.properties";

		input = Util.class.getClassLoader().getResourceAsStream(filename);
		
		if(input==null){
	        System.out.println("Sorry, unable to find " + filename);
		    return null;
		}

		//load a properties file from class path, inside static method
		prop.load(input);
		

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		System.out.println(prop.getProperty("targetnamespace"));
		return prop;

	} catch (IOException ex) {
		ex.printStackTrace();
		return null;
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
  }


	public static void main(String[] args) {
		
		Properties p = loadProp();
		
	}

}

