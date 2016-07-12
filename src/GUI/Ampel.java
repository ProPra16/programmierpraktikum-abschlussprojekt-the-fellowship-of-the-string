package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Ampel extends StackPane{
	private Label label,satz;
	private Rectangle labelkasten, grund, satzkasten;
	private Circle rot, gelb, gruen;
	public Ampel(){
		
		
		VBox box = new VBox(10);
		
		StackPane pane = new StackPane();
		labelkasten = new Rectangle(5,1,10,2);
		label = new Label();
		
		pane.getChildren().addAll(labelkasten,label);
		box.getChildren().add(pane);
		
		Text zeit = new Text("hier aktuelle zeit einfügen");
		box.getChildren().add(zeit);
		
		StackPane pane1 = new StackPane();
		grund = new Rectangle(3,10,14,42);
		pane1.getChildren().add(grund);
		grund.setStroke(Color.BLACK);
		grund.setFill(Color.GREY);
		
		GridPane gpane = new GridPane();
		gpane.setAlignment(Pos.CENTER);
		gpane.setPadding(new Insets(5, 5, 5, 5));
		gpane.setHgap(5);
		gpane.setVgap(5);
		pane.getChildren().add(pane1);
		
		rot = new Circle();
		rot.setCenterX(10);
		rot.setCenterY(18);
		rot.setRadius(5);
		rot.setStroke(Color.BLACK);
		rot.setFill(Color.RED);
		gpane.add(rot,1,1);
		
		gelb = new Circle();
		gelb.setCenterX(10);
		gelb.setCenterY(31);
		gelb.setRadius(5);
		gelb.setStroke(Color.BLACK);
		gelb.setFill(Color.YELLOW);
		gpane.add(gelb,1,2);

		gruen = new Circle();
		gruen.setCenterX(10);
		gruen.setCenterY(44);
		gruen.setRadius(5);
		gruen.setStroke(Color.BLACK);
		gruen.setFill(Color.YELLOWGREEN);
		gpane.add(gruen,1,3);
		
		StackPane pane2 = new StackPane();
		satzkasten = new Rectangle(1,60,20,2);
		satz = new Label();
		
		pane2.getChildren().addAll(satzkasten,satz);
		
		box.getChildren().addAll(gpane,pane2);
		
		}
	
		public void setBaby(boolean status){
			if(status == true) label.setText("Babysteps");
			else label.setText("keine Erweiterung eingeschaltet");
		}
		
		public void setTracking(boolean status){
			if(status == true) label.setText("Tracking");
			else label.setText("keien Erweiterung eingeschaltet");
		}
		
		public void wechselZuGrün(boolean status){
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
