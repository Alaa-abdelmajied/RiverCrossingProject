package model;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class Levelsbuttons extends Button {
	private String Font_Path="src/model/resources/kenvector_future.ttf";
	private String Button_Pressed_Style="-fx-backgroud-color: transparent;-fx-background-Image:url('/model/yellow_button00.png');";
	private String Button_free_Style="-fx-backgroud-color: transparent;-fx-background-Image:url('/model/yellow_button05.png');";
public void spacerunnerbutton(String text) {
	setText(text);
	setbuttonfont();
	
}
public void setbuttonfont() {
	try {
		setFont(Font.loadFont(new FileInputStream(Font_Path), 6));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		setFont(Font.font("verdane",23));
	}
	
	
}
private void setbuttonpressedstyle() {
	setStyle(Button_Pressed_Style);
	setPrefHeight(45);
	setLayoutY(getLayoutY()+4);
	
	
	
}
private void setbuttonfreestyle() {
	setStyle(Button_free_Style);
	setPrefHeight(45);
	setLayoutY(getLayoutY()-4);
	
	
	
}

	public Levelsbuttons(String text) {
		
		setText(text);
		setbuttonfont();
		setPrefWidth(100);
		setPrefHeight(29);
		setStyle(Button_free_Style);
		initilazebuttonlisteners();
		
		// TODO Auto-generated constructor stub
	}
private void initilazebuttonlisteners() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					
					setbuttonpressedstyle();
					
				}
				// TODO Auto-generated method stub
				
			}

			

			
			
			
		}); 
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					
					setbuttonfreestyle();
					
				}
				// TODO Auto-generated method stub
				
			}

			

			
			
			
		}); 
		
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					
					setEffect(new DropShadow());
					
				}
				// TODO Auto-generated method stub
				
			}

			

			
			
			
		}); 
		
		setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					
					setEffect(null);
					
				}
				// TODO Auto-generated method stub
				
			}

			

			
			
			
		}); 
		
		
		
		
	}
	

}
