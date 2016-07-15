// Copyright (c) <2016> <Marcel Beeck, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package GUI;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import FileHandling.*;
import application.logik.Logik;
import java.io.IOException;

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

    private static Logik log;
    private static Ampel ampel;
    private Exercise e=null;

    @FXML
    public void initialize(){
        e = new Exercise();
        Loader.loadExcercise(e);
        log = new Logik(e);
        Area1.setText(e.getCode());
        Area2.setText(e.getTest());
    }
    //public Controller() {
    //    Area1 = new TextArea();
    //    Area2 = new TextArea();
    //    e = new Exercise();
    //    Area1.setText(e.getCode());
    //    Area2.setText(e.getTest());
    //    log = new Logik(e);
    //    Loader.loadExcercise(e);
    //}
    @FXML
    protected void save() {
        try {
            e.save();
        } catch (IOException i) {
            System.out.println("Fehler!");
        }
    }

    @FXML
    protected void diagram() {
        log.stats();
    }

    @FXML
    protected void load() {
        Loader.loadExcercise(e);
        Area1.setText(e.getCode());
        Area2.setText(e.getTest());
        ampel.wechselZuRot(true);
        log=new Logik(e);
        Area1.setDisable(true);
        Area2.setDisable(false);
        bGreen.setDisable(false);
        bRed.setDisable(true);
        bYellow.setDisable(true);
    }


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
        System.out.println("toRed");
        String code = Area1.getText();
        if (log.nextStep(code)) {
            ampel.wechselZuRot(true);
            SwitchArea();
            // Button aktivieren
            bGreen.setDisable(false);

            // Buttons deaktivieren
            bYellow.setDisable(true);
            bRed.setDisable(true);
        }
    }

    @FXML
    protected void toGreen() {
        System.out.println("toGreen");
        String code = Area2.getText();
        if (log.nextStep(code)) {
            ampel.wechselZuGruen(true);
            SwitchArea();
            // Button aktivieren
            bYellow.setDisable(false);

            // Buttons deaktivieren
            bGreen.setDisable(true);
            bRed.setDisable(true);
        }
    }

    @FXML
    protected void toYellow() {
        System.out.println("toYellow");
        String code = Area1.getText();
        if (log.nextStep(code)) {
            ampel.wechselZuGelb(true);
            //SwitchArea();
            // Button aktivieren
            bRed.setDisable(false);

            // Buttons deaktivieren
            bYellow.setDisable(true);
            bGreen.setDisable(true);
        }
    }

    // Ampel referenz übergeben
    public static void setAmpel(Ampel amp) {
        ampel = amp;
    }
    
}
