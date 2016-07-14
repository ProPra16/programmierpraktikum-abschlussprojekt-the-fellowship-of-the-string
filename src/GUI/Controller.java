package GUI;
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
// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
import javafx.fxml.FXML;
import javafx.scene.control.*;
import FileHandling.*;

public class Controller {

	@FXML
	private TextArea Area1;
	@FXML
	private TextArea Area2;
    @FXML
    private Button bRed;
    @FXML
    private Button bYellow;
    @FXML
    private Button bGreen;

    private static Ampel ampel;

	public void SwitchArea() {
		if (Area1.isDisable()) {
			Area1.setDisable(false);
			Area2.setDisable(true);
			Area1.requestFocus();
		} else {
			Area2.setDisable(false);
			Area1.setDisable(true);
			Area2.requestFocus();
		}
	}

    // Buttons verändern
    @FXML 
	protected void toRed() {
        ampel.wechselZuRot(true);
        SwitchArea();
        // Button aktivieren
        bGreen.setDisable(false);

        // Buttons deaktivieren
        bYellow.setDisable(true);
        bRed.setDisable(true);
    }

    @FXML
    protected void toGreen() {
        ampel.wechselZuGruen(true);
        SwitchArea();
        System.out.println(Area2.getText());
        // Button aktivieren
        bYellow.setDisable(false);

        // Buttons deaktivieren
        bGreen.setDisable(true);
        bRed.setDisable(true);
	}

    @FXML
    protected void toYellow() {
        ampel.wechselZuGelb(true);
        SwitchArea();
        // Button aktivieren
        bRed.setDisable(false);

        // Buttons deaktivieren
        bYellow.setDisable(true);
        bGreen.setDisable(true);
    }

    // Ampel referenz übergeben
    public static void setAmpel(Ampel amp) {
        ampel = amp;
    }
}
