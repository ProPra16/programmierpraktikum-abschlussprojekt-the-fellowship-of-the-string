// Copyright (c) <2016> <Marcel Beeck, Patrick Pirig, Phillippe Weise, Sabine Timmer>

package FileHandling;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoadTest extends Application {
Exercise exer;
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		Button start=new Button("StartTest");
		Scene scene=new Scene(start,100,100);
		stage.setScene(scene);
		stage.show();
		
		Exercise exer=null;
		
		
		start.setOnAction(e-> {
			Loader.loadExcercise(exer);
			/*StackPane pane=exer.display();
			Scene scene2=new Scene(pane,500,500);
			stage.setScene(scene2);*/
		});
		
		 
		/*System.out.println(new File(".").getAbsolutePath());
		Exercise exer=new Exercise("BESCHREIBUNG",null,null,false,true);
		StackPane stack=exer.display();
		Scene scene=new Scene(stack,300,200);
		stage.setScene(scene);
		stage.show();
	*/
	}
}
