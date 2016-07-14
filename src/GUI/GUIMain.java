<<<<<<< HEAD
/*******************************************************************************
 * Copyright (c) 2016 The Fellowship of the String and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Marcel Beek - initial API and implementation
 *     Patrick Pirig - initial API and implementation
 *     Phillippe Weise - initial API and implementation
 *     Sabine Timmer - initial API and implementation
 *******************************************************************************/
=======
// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
>>>>>>> c61c09cb1dfefceb323f01129e25c7ff5c414aaf

package GUI;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;

public class GUIMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("ProPra.fxml"));
		Ampel A = new Ampel();
        Controller.setAmpel(A);
		BorderPane bp = A.returnPane();
		bp.setPrefSize(350, 350);
		bp.setLayoutX(1070);
		bp.setLayoutY(150);
		root.getChildren().add(bp);
		Scene scene = new Scene(root);
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();
	}
}
