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
	private Test test;
	private boolean baby, timer;

	public Exercise(String description, CodeList klassen, Test test , boolean baby, boolean timer) {
		this.description = description;
		this.klassen = klassen;
		this.test = test;
		this.baby = baby;
		this.timer = timer;
	}

	public Exercise() {

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
		return this.baby;
	}
	
	public boolean tracking(){
		return this.timer;
	}
	
	public StackPane display(){
		Label baby=new Label("Babysteps");
		Label time=new Label("Timetracking");
		HBox hbox=new HBox(50);
		hbox.getChildren().addAll(baby,time);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10,10,10,10));
		
		baby.setVisible(this.baby);
		time.setVisible(this.timer);
		
		Rectangle background=new Rectangle(300,150);
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
	
}
