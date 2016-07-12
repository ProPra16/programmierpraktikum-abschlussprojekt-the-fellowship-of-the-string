import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.geometry.*;



public class Ampel extends Pane{
	private Label label,satz;
	private Rectangle labelkasten, grund, satzkasten;
	private Circle rot, gelb, gruen;

	public Ampel(){
		VBox box = new VBox(10);
		VBox ampel = new VBox(20);

		Pane pane = new Pane();
		labelkasten = new Rectangle(5,1,50,50);
		label = new Label();

		pane.getChildren().addAll(labelkasten,label);
		box.getChildren().add(pane);

		Text zeit = new Text("hier aktuelle zeit einfuegen");
		box.getChildren().add(zeit);

		Pane pane1 = new Pane();
		Rectangle grund = new Rectangle(50,100);
		grund.setFill(Color.GREY);

		rot = new Circle();
		rot.setLayoutX(10);
		rot.setLayoutY(18);
		rot.setRadius(10);
		rot.setStroke(Color.BLACK);
		rot.setFill(Color.RED);

		gelb = new Circle();
		gelb.setLayoutX(10);
		gelb.setLayoutY(31);
		gelb.setRadius(10);
		gelb.setStroke(Color.BLACK);
		gelb.setFill(Color.YELLOW);


		gruen = new Circle();
		gruen.setLayoutX(10);
		gruen.setLayoutY(44);
		gruen.setRadius(10);
		gruen.setStroke(Color.BLACK);
		gruen.setFill(Color.YELLOWGREEN);

		Pane pane2 = new Pane();
		satzkasten = new Rectangle(1,60,20,2);
		satz = new Label();

		ampel.getChildren().addAll(rot, gelb, gruen);
		pane1.setPrefSize(50, 50);
		pane1.getChildren().addAll(grund, ampel);
		pane2.getChildren().addAll(satzkasten,satz);

		box.getChildren().addAll(pane1,pane2);
		this.getChildren().add(box);

	}
	public void setBaby(boolean status){
		if(status == true) label.setText("Babysteps");
		else label.setText("keine Erweiterung eingeschaltet");
	}

	public void setTracking(boolean status){
		if(status == true) label.setText("Tracking");
		else label.setText("keien Erweiterung eingeschaltet");
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
