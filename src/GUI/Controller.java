
// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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

	private void SwitchArea() {
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

    public static void setAmpel(Ampel amp) {
        ampel = amp;
    }
}
