package builderWSDL.model;

public class ComplexType {

	//Optional. Specifies a unique ID for the element
	public String id;
	//Optional. Specifies a name for the element
	public String name;	
	//Optional. Specifies whether the complex type can be used in an instance document. True indicates that an element cannot use this complex type directly but must use a complex type derived from this complex type. Default is false
	public boolean abstract_;	
	//Optional. Specifies whether character data is allowed to appear between the child elements of this complexType element. Default is false. If a simpleContent element is a child element, the mixed attribute is not allowed!
	public boolean mixed;

}
