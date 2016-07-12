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
package FileHandling;

import org.xml.sax.*;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.w3c.dom.*;

import java.io.IOException;

import javax.xml.parsers.*;

public class Loader {

	public Exercise loadExcercise() {
		Stage loadStage = new Stage();
		TextField fileName = new TextField("Katalogdatei");
		Label anzeige = new Label("");

		Button laden = new Button("Katalog laden");
		laden.setOnAction(e -> laden(fileName.getText(), anzeige, loadStage));

		return null;
	}

	private void laden(String filename, Label anzeige, Stage stage) {
		try {
			Document xmldoc = loadDoc(filename);
			Scene choiseScreen = katalogView(xmldoc);

		} catch (SAXException | IOException e) {
			anzeige.setText("Datei nicht vorhanden oder nicht kompatibel");
			e.printStackTrace();
		}

	}

	private Scene katalogView(Document xmldoc) {

		return null;
	}

	private Document loadDoc(String fileLocation) throws SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
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
