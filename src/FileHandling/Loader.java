package FileHandling;
import org.xml.sax.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.w3c.dom.*;

import java.io.IOException;

import javax.xml.parsers.*;


public class Loader {
	
	public Exercise loadExcercise(){
		Stage loadStage= new Stage();
		TextField fileName=new TextField("Katalogdatei");
		Label anzeige=new Label("");
		Document xmldoc;
		
		
		
		Button laden=new Button("Katalog laden");
		laden.setOnAction(e-> laden());
		
		
		
		
		
		return null;
	}

	private Object laden() {
		
		return null;
	}
	private Document loadDoc(String fileLocation) throws SAXException, IOException{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		Document toReturn;
		factory.setIgnoringComments(true);
		factory.setValidating(true);
		
		
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			return builder.parse(new InputSource(fileLocation));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
			
		
			
		
		
	}
}
