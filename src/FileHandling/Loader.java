// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package FileHandling;

import org.xml.sax.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Loader {

	public static void loadExcercise(Exercise exer) {
		Stage loadStage = new Stage();
		TextField fileName = new TextField("KatalogBSP.xml");
		fileName.setMaxWidth(100);
		
		Label anzeige= new Label("anzeige");
		anzeige.setVisible(false);
		 
		Button laden = new Button("Katalog laden");
		laden.setOnAction(e -> laden(fileName.getText(), anzeige, loadStage,exer));
		
		VBox vBox=new VBox(10);
		vBox.getChildren().add(anzeige);
		vBox.getChildren().add(fileName);
		vBox.getChildren().add(laden);
		vBox.setAlignment(Pos.CENTER);
		vBox.setPadding(new Insets(20,20,20,20));		
		
		Scene loadScene=new Scene(vBox,300,100);
		loadStage.setScene(loadScene);
		loadStage.show();
	}

	private static void laden(String filename, Label anzeige, Stage stage,Exercise exer) {
			
			Document xmldoc;
			try {
				xmldoc = loadDoc(filename);
				katalogView(xmldoc,stage, exer);
			} catch (IOException e) {
				anzeige.setText("Datei nicht vorhanden");
				anzeige.setVisible(true);
				e.printStackTrace();
			} catch (SAXException e) {
				anzeige.setText("Datei ist kein gueltiger Katalog");
				anzeige.setVisible(true);
				e.printStackTrace();
			}
			

	}

	private static Exercise katalogView(Document xmldoc,Stage stage,Exercise exer) {
		
		ArrayList<Exercise> exerList=parseExercises(xmldoc);
		VBox vbox=new VBox(10);
		vbox.setPadding(new Insets(5,5,5,5));
		for(int i=0;i<exerList.size();i++){
			vbox.getChildren().add(exerList.get(i).display());
			int j=i;
			vbox.getChildren().get(i).setOnMouseClicked(e -> setExer(exer,exerList.get(j),stage));
		}
		Scene scene=new Scene(vbox,300,155*exerList.size());
		stage.setScene(scene);
		return exer;
	}

	
	
	private static  void setExer(Exercise exer, Exercise exercise,Stage stage) {
		exer=exercise;
		stage.close();
	}

	private static Document loadDoc(String file) throws   SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		factory.setIgnoringComments(true);
		factory.setValidating(true);
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
		//	builder.setErrorHandler(e-> );
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
		
		
		return builder.parse(new InputSource(file));
		
				
	}
	
	
	
	private static ArrayList<Exercise> parseExercises(Document xmldoc){
		
		NodeList exerList=xmldoc.getElementsByTagName("exercise");
		//Exercise[] exerArray=new Exercise[exerList.getLength()];
		ArrayList<Exercise> exerArray=new ArrayList<Exercise>();
		String desc;
		
		for(int i=0;i<exerList.getLength();i++){
			Node exerNode=exerList.item(i);
			
			Element exerElement=(Element) exerNode;
			NodeList interList=exerElement.getChildNodes();
			
			Node descNode=interList.item(1);
			Node classesNode=interList.item(3);
			Node testsNode=interList.item(5);
			Node configNode=interList.item(7);
			
			
			Element classes=(Element) classesNode;
			Element tests=(Element) testsNode;
			Element config=(Element)  configNode;
		
			
			desc=descNode.getTextContent();
			//System.out.println(desc);
			NodeList classList=classes.getChildNodes();
			CodeList codeList=new CodeList();
			for (int j=0;j<classList.getLength();j++){
				if(j%2!=0){
					Node codeNode=classList.item(j);
					//System.out.println(codeNode.getNodeName());
					Element code=(Element)codeNode;
					//System.out.println(code.getAttribute("name"));
					//System.out.println(code.getTextContent());
					
					codeList.add(new Code(code.getAttribute("name"),code.getTextContent()));
				}
			}
			
			NodeList testList=testsNode.getChildNodes();
			Node testNameNode=testList.item(1);
			//System.out.println(testNameNode.getNodeName());
			
			Element testName=(Element) testNameNode;
			//System.out.println(testName.getAttribute("name"));
			//System.out.println();
			Test test=new Test(testName.getAttribute("name"),testName.getTextContent());
				
			NodeList configList=config.getChildNodes();
			Element babyElement=(Element) configList.item(1);
			Element timeTrack=(Element) configList.item(3);
			//System.out.println(babySteps.getNodeName());
			//System.out.println(timeTrack.getNodeName());
			
			Babysteps baby=new Babysteps(babyElement.getAttribute("value").equals("true"),Long.parseLong(babyElement.getAttribute("seconds")));
			boolean tracker=timeTrack.getAttribute("value").equals("true");
			//System.out.println(baby);
			//System.out.println(tracker);
			
			exerArray.add(new Exercise(desc,codeList,test,baby,tracker));
			
		}
		return exerArray;
	}
	
	
	
}
