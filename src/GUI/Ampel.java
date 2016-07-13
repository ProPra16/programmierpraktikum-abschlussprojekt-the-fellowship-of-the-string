package GUI;

//bugs gefixt mit hilfe von https://kjswebdevelopment.wordpress.com/2014/06/12/simple-java-traffic-light/

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Ampel{
	private Label label,satz;
	private Rectangle labelkasten, grund, satzkasten;
	private Circle rot, gelb, gruen;
	private double paneWidth = 300;
	
	public Ampel(){
			
		StackPane spane = new StackPane();
		labelkasten = new Rectangle(70,20);
		labelkasten.setStroke(Color.BLACK);
		labelkasten.setFill(Color.TRANSPARENT);
			
		spane.getChildren().addAll(labelkasten);
		label = new Label();	
		label.setText("Erweiterung");
		spane.getChildren().add(label);
		
		StackPane pane = new StackPane();
		grund = new Rectangle(125, 250, 100, 240);
		pane.getChildren().add(grund);
		grund.setFill(Color.BLACK);
		grund.setStroke(Color.GREY);
		 
		GridPane pane1 = new GridPane();
		pane1.setAlignment(Pos.CENTER);
		pane1.setPadding(new Insets(5, 5, 5, 5));
		pane1.setHgap(5);
		pane1.setVgap(5);
		pane.getChildren().add(pane1);
		 
		Circle rot = new Circle(paneWidth / 2, 60, 30);
		rot.setStroke(Color.BLACK);
		rot.setFill(Color.LIGHTGREY);
		pane1.add(rot, 1, 1);
		 
		Circle gelb = new Circle(paneWidth / 2, 60, 30);
		gelb.setStroke(Color.BLACK);
		gelb.setFill(Color.LIGHTGREY);
		pane1.add(gelb, 1, 2);
		 
		Circle gruen = new Circle(paneWidth / 2, 60, 30);
		gruen.setStroke(Color.BLACK);
		gruen.setFill(Color.LIGHTGREY);
		pane1.add(gruen, 1, 3);
		
		StackPane pane2 = new StackPane();
		satzkasten = new Rectangle(200,20);
		satzkasten.setStroke(Color.BLACK);
		satzkasten.setFill(Color.TRANSPARENT);
		
		pane2.getChildren().addAll(satzkasten);
		
		satz = new Label();
		satz.setText("Statussatz");
		pane2.getChildren().add(satz);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(10,10,10,10));
		borderPane.setCenter(pane);
		borderPane.setTop(spane);
		borderPane.setBottom(pane2);
			
		}
	
		public void setBaby(boolean status){
			if(status == true) label.setText("Babysteps");
			else label.setText("keine");
		}
		
		public void setTracking(boolean status){
			if(status == true) label.setText("Tracking");
			else label.setText("keine");
		}
		
		public void wechselZuGruen(boolean status){
			if(status == true){
				rot.setFill(Color.BLACK);
				gruen.setFill(Color.YELLOWGREEN);
				satz.setText("make the Test pass");
			}
			else{
				rot.setFill(Color.RED);
				satz.setText("write a failing Test");
			}
				
		}
		public void wechselZuGelb(boolean  status){
			if(status == true){
				gruen.setFill(Color.BLACK);
				gelb.setFill(Color.YELLOW);
				satz.setText("refactor");
			}
			else{
				gruen.setFill(Color.YELLOWGREEN);
				satz.setText("make the Test pass");
			}
			
		}
		public void wechselZuRot(boolean status){
			if(status == true){
				gelb.setFill(Color.BLACK);
				rot.setFill(Color.RED);
				satz.setText("write a failing Test");
			}
			else{
				gelb.setFill(Color.YELLOW);
				satz.setText("refactor");
			}
		}
}
