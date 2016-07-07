package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {


    @FXML private TextArea Area1;
    @FXML private TextArea Area2;

    @FXML protected void SwitchArea() {
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
}
