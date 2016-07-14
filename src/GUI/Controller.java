// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package GUI;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

	@FXML
	private TextArea Area1;
	@FXML
	private TextArea Area2;

    private static Ampel ampel;

	@FXML
	protected void SwitchArea() {
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
	protected void Test() {
        ampel.wechselZuRot(true);
    }

    @FXML
    protected void Test2() {

	}

    public static void setAmpel(Ampel amp) {
        ampel = amp;
    }
}
