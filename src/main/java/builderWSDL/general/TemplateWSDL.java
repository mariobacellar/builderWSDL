package builderWSDL.general;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

public class TemplateWSDL {

	public static StringBuffer loadFile (String name) {
		StringBuffer	sb    = new StringBuffer();
		byte[]			byts  = loadBinaryFile (name);
		String 			sbyts = byts.toString();
		sb.append(sbyts);
		return sb;
	}
	
	
	public static byte[] loadBinaryFile (String name) {
	    try {
	    	
	    	//File 			f 		= new File( Util.class.getClassLoader().getResource(name).toURI() );
	    	File 			f 		= new File( ".//src//main//resources//"+name );
	    	DataInputStream dis		 = new DataInputStream(new FileInputStream(f));
	        byte[] 			theBytes = new byte[dis.available()];

	        dis.read(theBytes, 0, dis.available());
	        dis.close();
	        return theBytes;
	    } catch (IOException ex) {
	    	ex.printStackTrace();
//	    } catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	    return null;
	} 

	public static void main(String[] args) {
		
		StringBuffer sb = TemplateWSDL.loadFile ("template.wsdl");
		System.out.println(sb.toString());
	}
}
