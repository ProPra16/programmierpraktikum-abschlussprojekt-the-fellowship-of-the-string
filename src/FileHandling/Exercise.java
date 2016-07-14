// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package FileHandling;

import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Exercise {

	private String description;
	private CodeList klassen;
	private TestCode test;
	private boolean timer;
	private Babysteps baby;
	
	public Exercise(String description, CodeList klassen, TestCode test , Babysteps baby, boolean timer) {
		this.description = description;
		this.klassen = klassen;
		this.test = test;
		this.baby = baby;
		this.timer = timer;
	}
	public Exercise(){
		this.description="Guten tag";
		CodeList list=new CodeList();
		Code code=new Code("here","Implement Code here");
		list.add(code);
		this.klassen=list;
		this.test=new TestCode("HelloTest","Implement Test here");
		this.baby=new Babysteps(false,12);
		this.timer=false;
	}
	
	public boolean getBaby(){
		return this.baby.value();		
	}
	
	public boolean getTimer(){
		return this.timer;
	}
	
	public String getTest(){
		return test.getTestText();
	}
	
	public String getCode(){
		return klassen.getCodeText();
	}
	
	public void setCode(String newContent){
		klassen.setCodeText(newContent);
	}
	
	public void setTest(String newContent){
		test.setTestText(newContent);
	}

	public boolean codeCompiles() {

		return this.klassen.compilable();

	}

	public boolean testsRunning() {

		return this.test.allTestsPassing();
	}
	
	public boolean oneFailing(){
		return this.test.oneTestFailing();
	}
	
	public boolean baby(){
		return this.baby.value();
	}
	
	public long babyLimit(){
		return this.baby.limit();
	}
	public boolean tracking(){
		return this.timer;
	}
	
	public StackPane display(){
		double babyTime=Math.round((Double.parseDouble(Long.toString(this.babyLimit()))/60)*100)/100.0;
		
		Label baby=new Label("Babysteps:  "+babyTime+"min");
		Label time=new Label("Timetracking");
		baby.setUnderline(true);
		time.setUnderline(true);
		
		HBox hbox=new HBox(50);
		hbox.getChildren().addAll(baby,time);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10,10,10,10));
		
		baby.setVisible(this.baby.value());
		time.setVisible(this.timer);
		
		Rectangle background=new Rectangle(275,145);
		background.setFill(Color.BEIGE);
		background.setStroke(Color.BLACK);
		
		Label desc=new Label(this.description);
		VBox vbox=new VBox(25);
		vbox.getChildren().addAll(desc,hbox);
		vbox.setAlignment(Pos.CENTER);
		
		StackPane pane=new StackPane();
		pane.getChildren().addAll(background,vbox);
		return pane;
		
	}
	public void save() throws IOException{
		this.klassen.saveCode();
		this.test.save();
	}
	public void clone(Exercise exercise) {
		this.description=exercise.describe();
		this.klassen=CodeList.clone(exercise.klassen);
		this.test=new TestCode(exercise.getTestName(),exercise.getTest());
		this.timer=exercise.tracking();
		this.baby=new Babysteps(exercise.baby(),exercise.babyLimit());
	}
	
	private String describe() {
		return this.description;
	}
	private String getTestName() {
		return this.test.getName();
	}
	
	
	
}
