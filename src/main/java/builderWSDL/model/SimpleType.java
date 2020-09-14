package builderWSDL.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import builderWSDL.general.Contants;

public class SimpleType {

	public String id;
	public String name;
	public RestrictionAttr restriction;

	
	
	private String resourceToString(String filePath) throws IOException, URISyntaxException{
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
		return IOUtils.toString(inputStream);
	}
	
	public List<SimpleType> parseFromFile() throws IOException, URISyntaxException{
		return 	parseFromFile( Contants.C_FILE_SAMPLE_XSD );

	}
	
	public List<SimpleType> parseFromFile(String filename) throws IOException, URISyntaxException{
		List<SimpleType> ret = new ArrayList<SimpleType>();
		String texto = resourceToString(filename); 
		//System.out.print(texto);
		//xsd:simpleType
	
		String SIMPLE_TYPE_INI = "simpleType";
		String SIMPLE_TYPE_END = "simpleType>";
		
		String XSD_PREFIX  = "<xsd:";
		String XS__PREFIX  = "<xs:";
		String XSD_PRE_USE = XSD_PREFIX;
		if ( (texto.indexOf(XSD_PREFIX) ==-1) && (texto.indexOf(XS__PREFIX) >0  ) ) 
		XSD_PRE_USE = XS__PREFIX;

		int lenghtTexto = texto.length();
		
		int    ini_Tag_SimpleType = texto.indexOf(XSD_PRE_USE + SIMPLE_TYPE_INI ); 
		int    end_Tag_SimpleType = texto.indexOf(SIMPLE_TYPE_END, ini_Tag_SimpleType) + SIMPLE_TYPE_INI.length() +1 ; 
		String xml_SimpleType     = texto.substring(ini_Tag_SimpleType, end_Tag_SimpleType );
		System.out.print("xml_SimpleType = [\n"+xml_SimpleType+"]");
		
		while (end_Tag_SimpleType < lenghtTexto ) {
			
		}
		
		return ret;
	}
	
	
	public static void main(String[] args) {
		try {
			
			SimpleType st = new SimpleType();
			
			List<SimpleType> ltSimpleTypes = st.parseFromFile();
			for (SimpleType simpleType : ltSimpleTypes) {
				System.out.println("simpleType=["+simpleType.name+"]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
