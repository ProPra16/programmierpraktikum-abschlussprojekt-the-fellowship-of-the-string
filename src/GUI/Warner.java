package GUI;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Warner {
	public static void display(String value){

		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("ERROR");
		Label label=new Label(value);
		Button restart=new Button("OK");
		restart.setOnAction(e -> window.close());
		VBox vbox=new VBox(10);
		
		vbox.getChildren().addAll(label,restart);
		vbox.setAlignment(Pos.CENTER);
		Scene own=new Scene(vbox,350,150);
		window.setScene(own);
		window.showAndWait();
	}
}
