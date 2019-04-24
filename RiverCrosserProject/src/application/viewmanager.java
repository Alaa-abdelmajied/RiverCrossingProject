package application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.fxxxbutton;
import model.fxxsubscene;

public class viewmanager {
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	 private fxxsubscene creditssub;
	// level1 level1=new level1();
	public viewmanager() {
		mainPane = new AnchorPane();
	    String mainPanestyle= "-fx-background-image: url('file:/C:/Users/SPIDER/Desktop/backgroundlevels.png');" ;
	    mainPane.setStyle(mainPanestyle);
		mainScene= new Scene(mainPane,800,600);
		mainStage=new Stage();
		mainStage.setScene(mainScene);
		
		createsubscene();
		createButton();
		
		}
	public void createsubscene() {
		creditssub=new fxxsubscene();
		mainPane.getChildren().add(creditssub);
		
		
		
	}
	
	public Stage getMainStage() {
		return mainStage;

	}	
	
	public void createButton() {
		
		fxxxbutton button1= new fxxxbutton("CONTINUE");
		//mainPane.getChildren().add(button1);
		fxxxbutton button2= new fxxxbutton("Level 1");
		fxxxbutton button3= new fxxxbutton("Level 2");

		//mainPane.getChildren().add(button2);
		fxxxbutton button4= new fxxxbutton("EXIT");
		//mainPane.getChildren().add(button3);
		VBox v=new VBox();
		v.getChildren().add(button1);
		v.getChildren().add(button2);
		v.getChildren().add(button3);
		v.getChildren().add(button4);
		button2.setOnAction(m->{
			level1 Level1=new level1();
			Level1.createlevel1(mainStage);
			
       	 //creditssub.moveSubscene();
       //	 level1.getMainStage();
       	 
			});

		v.setSpacing(50);
		mainPane.getChildren().add(v);
		v.setLayoutX(300);
		v.setLayoutY(200);

		
		
		
		
	}
}

