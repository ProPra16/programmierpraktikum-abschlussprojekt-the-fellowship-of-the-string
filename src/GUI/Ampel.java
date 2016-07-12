package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Ampel extends StackPane{
	private Label label,satz;
	private Rectangle labelkasten, grund, satzkasten;
	private Circle rot, gelb, gr�n;
	public Ampel(){
		
		
		VBox box = new VBox(10);
		
		StackPane pane = new StackPane();
		labelkasten = new Rectangle(5,1,10,2);
		label = new Label();
		
		pane.getChildren().addAll(labelkasten,label);
		box.getChildren().add(pane);
		
		Text zeit = new Text("hier aktuelle zeit einf�gen");
		box.getChildren().add(zeit);
		
		StackPane pane1 = new StackPane();
		grund = new Rectangle(3,10,14,42);
		grund.setStroke(Color.BLACK);
		grund.setFill(Color.GREY);
		
		rot = new Circle();
		rot.setCenterX(10);
		rot.setCenterY(18);
		rot.setRadius(5);
		rot.setStroke(Color.BLACK);
		
		gelb = new Circle();
		gelb.setCenterX(10);
		gelb.setCenterY(31);
		gelb.setRadius(5);
		gelb.setStroke(Color.BLACK);

		
		gr�n = new Circle();
		gr�n.setCenterX(10);
		gr�n.setCenterY(44);
		gr�n.setRadius(5);
		gr�n.setStroke(Color.BLACK);
		
		pane1.getChildren().addAll(grund,rot,gelb,gr�n);
		
		StackPane pane2 = new StackPane();
		satzkasten = new Rectangle(1,60,20,2);
		satz = new Label();
		
		pane2.getChildren().addAll(satzkasten,satz);
		
		box.getChildren().addAll(pane1,pane2);
		
	}
		public void setBaby(boolean status){
			if(status == true) label.setText("Babysteps");
			else label.setText("keine Erweiterung eingeschaltet");
		}
		
		public void setTracking(boolean status){
			if(status == true) label.setText("Tracking");
			else label.setText("keien Erweiterung eingeschaltet");
		}
		
		public void wechselZuGr�n(boolean status){
			if(status == true){
				rot.setFill(Color.BLACK);
				gr�n.setFill(Color.YELLOWGREEN);
				satz.setText("make the Test pass");
			}
			else{
				rot.setFill(Color.RED);
				satz.setText("write a failing Test");
			}
				
		}
		public void wechselZuGelb(boolean  status){
			if(status == true){
				gr�n.setFill(Color.BLACK);
				gelb.setFill(Color.YELLOW);
				satz.setText("refactor");
			}
			else{
				gr�n.setFill(Color.YELLOWGREEN);
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
