package application;

import java.awt.List;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.fxxxbutton;
import model.farmer_subscene;
//import model.resources.farmersubs;
import model.fxxsubscene;
import model.goatsubscene;
import model.plantsubscene;
import model.wolfsubscene;

public class level1 {
viewmanager x;

private AnchorPane mainPane;
private Scene level1Scene;
private Stage level1Stage;
 private fxxsubscene creditssub;
 Scene scene;
 Stage menustage;
 private goatsubscene goat;
 private farmer_subscene farmer;
 private wolfsubscene wolf;
 private plantsubscene plant;
 ArrayList<Integer> crossers = new ArrayList<Integer>();
public void createsubscene() {
	creditssub=new fxxsubscene();
	mainPane.getChildren().add(creditssub);
	goat=new goatsubscene();
	mainPane.getChildren().add(goat);
	farmer=new farmer_subscene();
	mainPane.getChildren().add(farmer);
	wolf=new wolfsubscene();
	mainPane.getChildren().add(wolf);
	plant=new plantsubscene();
	mainPane.getChildren().add(plant);




	
	
	
	
}



public void createlevel1(Stage menustage) {
	this.menustage=menustage;
	this.menustage.hide();
	level1Stage.show();
	
	
	
	
}



	public level1() {
		x=new viewmanager();
		mainPane = new AnchorPane();
		String	mainPanestyle= "-fx-background-image: url('file:/C:/Users/SPIDER/Desktop/backgrounfinal.jpeg');" ;
		mainPane.setStyle(mainPanestyle);
	level1Scene= new Scene(mainPane,800,600);
	level1Stage=new Stage();
	level1Stage.setScene(level1Scene);
	fxxxbutton button1= new fxxxbutton("GO!!");
	fxxxbutton button2= new fxxxbutton("goat");

	VBox v=new VBox();
	v.getChildren().add(button1);
	v.getChildren().add(button2);

	v.setSpacing(50);
	mainPane.getChildren().add(v);
	v.setLayoutX(300);
	v.setLayoutY(50);
	    
	
	button1.setOnAction(m->{
		if((creditssub.getTranslateX()>-430)||(creditssub.getTranslateX()<-537)) {
			if((goat.getTranslateX()<-318&&goat.getTranslateX()>-430)^(goat.getTranslateX()<-537&&goat.getTranslateX()>-655 )) {crossers.add(0);}
			if((farmer.getTranslateX()<-318&&farmer.getTranslateX()>-430)^(farmer.getTranslateX()<-537&&farmer.getTranslateX()>-655 )) {crossers.add(1);}
			if((plant.getTranslateX()<-318&&plant.getTranslateX()>-430)^(plant.getTranslateX()<-537&&plant.getTranslateX()>-655 )) {crossers.add(2);}
			if((wolf.getTranslateX()<-318&&wolf.getTranslateX()>-430)^(wolf.getTranslateX()<-537&&wolf.getTranslateX()>-655 )) {crossers.add(3);}

			
			
		}
  		
		
		
		if(((goat.getTranslateX()<-318&&goat.getTranslateX()>-430 )^(wolf.getTranslateX()<-318&&wolf.getTranslateX()>-430 )^(plant.getTranslateX()<-318&&plant.getTranslateX()>-430 ))) {
			boolean k=  creditssub.moveSubscene();
			goat.moveSubscene(k);
   	farmer.moveSubscene(k);
   	wolf.moveSubscene(k);
   	plant.moveSubscene(k);}
		
   	System.out.println("the is at"+goat.getTranslateX());
   	// if(goat.getx()==2) {
   		// goat.moveSubscene();
   	if(((goat.getTranslateX()<-537&&goat.getTranslateX()>-655 )^(wolf.getTranslateX()<-537&&wolf.getTranslateX()>-655 )^(plant.getTranslateX()<-537&&plant.getTranslateX()>-655 ))) {
		boolean k=  creditssub.moveSubscene();
		goat.moveSubscene(k);
	farmer.moveSubscene(k);
	wolf.moveSubscene(k);
	plant.moveSubscene(k);}
   	
   	if(!((goat.getTranslateX()<-537&&goat.getTranslateX()>-655 )^(wolf.getTranslateX()<-537&&wolf.getTranslateX()>-655 )^(plant.getTranslateX()<-537&&plant.getTranslateX()>-655 ))&&(farmer.getTranslateX()<-537&&farmer.getTranslateX()>-655 )) {
		boolean k=  creditssub.moveSubscene();
		goat.moveSubscene(k);
	farmer.moveSubscene(k);
	wolf.moveSubscene(k);
	plant.moveSubscene(k);}
   	 
   	 
   	// }
   	 
	});
	
	//button2.setOnAction(m->{
		
	   	 //goat.moveSubscene();
	   	 
	//	});
	
	
	createsubscene();
	boolean k=creditssub.moveSubscene();
	goat.moveSubscene(k);
	farmer.moveSubscene(k);
	wolf.moveSubscene(k);
	plant.moveSubscene(k);
	
	
	}

}
