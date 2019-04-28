package application;
import java.awt.List;
import java.util.ArrayList;

import Actors.Carnivorous;
import Actors.Farmer;
import Actors.Herbivorous;
import Actors.ICrosser;
import Actors.Plant;
import GameEngine.Game;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.fxxxbutton;
import model.Levelsbuttons;
import model.farmer_subscene;
//import model.resources.farmersubs;
import model.fxxsubscene;
import model.goatsubscene;
import model.plantsubscene;
import model.wolfsubscene;

public class level2 {
	private AnchorPane mainPane;
	private Scene level1Scene;
	private Stage level1Stage;
	private fxxsubscene creditssub;
	Scene scene;
	Stage menustage;
	
	private farmer_subscene farmer1;
	private model.farmer2 farmer2;
	private model.farmer3 farmer3;
	private model.farmer4 farmer4;
	private goatsubscene goat;
	
	
	
	private boolean farmeronboat = false;
	
	 ArrayList<ICrosser> crossersOnBoat = new ArrayList<>();
	java.util.List<ICrosser> crossers = new ArrayList<ICrosser>();
viewmanager fring=new viewmanager();
public void createsubscene() {
	creditssub = new fxxsubscene();
	mainPane.getChildren().add(creditssub);
	goat = new goatsubscene(crossers.get(2));
	mainPane.getChildren().add(goat);
	farmer1 = new farmer_subscene(crossers.get(0));
	mainPane.getChildren().add(farmer1);
	farmer2 = new model.farmer2(crossers.get(0));
	mainPane.getChildren().add(farmer2);
	farmer3 = new model.farmer3(crossers.get(0));
	mainPane.getChildren().add(farmer3);
	farmer4 = new model.farmer4(crossers.get(0));
	mainPane.getChildren().add(farmer4);
	
	}
public void createlevel2(Stage menustage) {
	this.menustage = menustage;
	this.menustage.hide();
	level1Stage.show();

}

	public level2(java.util.List<ICrosser> crossers, Game game) {
		this.crossers = crossers;
		System.out.println("ssssss" + this.crossers.get(0));
		viewmanager x = new viewmanager();
		mainPane = new AnchorPane();
		String mainPanestyle = "-fx-background-image: url('file:backgrounfinal.jpeg');";
		mainPane.setStyle(mainPanestyle);
		level1Scene = new Scene(mainPane, 800, 600);
		level1Stage = new Stage();
		level1Stage.setScene(level1Scene);
		Levelsbuttons button1 = new Levelsbuttons("GO!!");
		Levelsbuttons button2 = new Levelsbuttons("goat");
		Levelsbuttons button3 = new Levelsbuttons("undo");
		Levelsbuttons button4 = new Levelsbuttons("redo");

		VBox v = new VBox();
		v.getChildren().add(button1);
		//v.getChildren().add(button2);
		HBox h=new HBox();
		h.getChildren().add(button3);
		h.getChildren().add(button4);
		h.setSpacing(600);
		h.setLayoutX(0);
		h.setLayoutY(0);

		v.setSpacing(50);
		mainPane.getChildren().add(v);
		mainPane.getChildren().add(h);
		
		v.setLayoutX(350);
		v.setLayoutY(50);

		button1.setOnAction(m -> {
			boolean goatonboat = false;
			boolean farmer1onboat = false;
			boolean farmer2onboat = false;
			boolean farmer3onboat = false;
			boolean farmer4onboat=false;
			 ArrayList<ICrosser> crossersOnBoat = new ArrayList<>();

			//ArrayList<ICrosser> crossersOnBoat = new ArrayList<>();
			if ((creditssub.getTranslateX() > -430) || (creditssub.getTranslateX() < -537)) {
				if ((goat.getTranslateX() < -318 && goat.getTranslateX() > -430)
						^ (goat.getTranslateX() < -537 && goat.getTranslateX() > -655)) {
					// crossersOnBoat.add(crossers.get(2));

					goatonboat = true;
					// System.out.println("goat on boat"+crossers.get(2));
				}
			}
			if ((farmer1.getTranslateX() < -318 && farmer1.getTranslateX() > -430)
					^ (farmer1.getTranslateX() < -537 && farmer1.getTranslateX() > -655)) {
				// crossersOnBoat.add(crossers.get(0));
				farmer1onboat = true;
			}
			if ((farmer4.getTranslateX() < -318 && farmer4.getTranslateX() > -430)
					^ (farmer1.getTranslateX() < -537 && farmer1.getTranslateX() > -655)) {
				// crossersOnBoat.add(crossers.get(0));
				farmer1onboat = true;
			}

			if ((farmer3.getTranslateX() < -318 && farmer3.getTranslateX() > -430)
					^ (farmer3.getTranslateX() < -537 && farmer3.getTranslateX() > -655)) {
				// crossersOnBoat.add(crossers.get(3));
				farmer3onboat = true;
			}
			if ((farmer2.getTranslateX() < -318 && farmer2.getTranslateX() > -430)
					^ (farmer2.getTranslateX() < -537 && farmer2.getTranslateX() > -655)) {
				// crossersOnBoat.add(crossers.get(1));
				farmer2onboat = true;
			}
			if(game.isBoatOnTheLeftBank()==false) {

			if (farmer1onboat == true) {
				System.out.println(crossers.size());
				for (int j = 0; j < crossers.size(); j++) {
					if (crossers.get(j) instanceof Farmer) 
						crossersOnBoat.add(crossers.get(j));
				}
			}

			if (goatonboat == true) {
				for (int j = 0; j < crossers.size(); j++) {
					if (crossers.get(j) instanceof Herbivorous)
						crossersOnBoat.add(crossers.get(j));
				}
			}

			if (farmer2onboat == true) {
				for (int j = 0; j < crossers.size(); j++) {
					if (crossers.get(j) instanceof Carnivorous)
						crossersOnBoat.add(crossers.get(j));
				}
			}

			if (farmer3onboat == true) {
				for (int j = 0; j < crossers.size(); j++) {
					if (crossers.get(j) instanceof Plant)
						crossersOnBoat.add(crossers.get(j));
				}
				if (farmer4onboat == true) {
					for (int j = 0; j < crossers.size(); j++) {
						if (crossers.get(j) instanceof Plant)
							crossersOnBoat.add(crossers.get(j));
					}}
			}}
			else
			{
				if (farmer1onboat == true) {
					System.out.println(game.getCrossersOnLeftBank().size());
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j) instanceof Farmer) 
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}

				if (goatonboat == true) {
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j) instanceof Herbivorous)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}

				if (farmer2onboat == true) {
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j) instanceof Carnivorous)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}

				if (farmer3onboat == true) {
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j) instanceof Plant)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}	
				if (farmer4onboat == true) {
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j) instanceof Plant)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}	
			}
			

			for (int i = 0; i < crossersOnBoat.size(); i++)
				System.out.println("on boat gui" + crossersOnBoat.get(i));

			if (game.canMove(crossersOnBoat, game.isBoatOnTheLeftBank())) {
				// System.out.println(game.isBoatOnTheLeftBank());
				// System.out.println(crossersOnBoat.get(1));
				// System.out.println(crossersOnBoat.get(0));

				// System.out.println(game.getCrossersOnRightBank().get(0));
				// System.out.println(game.getCrossersOnRightBank().get(1));
				// System.out.println(game.getCrossersOnRightBank().get(2));
				// System.out.println(game.getCrossersOnRightBank().get(3));

				game.doMove(crossersOnBoat, game.isBoatOnTheLeftBank());

			
					boolean k = creditssub.moveSubscene();
					goat.moveSubscene(game.isBoatOnTheLeftBank());
					farmer1.moveSubscene(game.isBoatOnTheLeftBank());
					farmer2.moveSubscene(game.isBoatOnTheLeftBank());
					farmer3.moveSubscene(game.isBoatOnTheLeftBank());
					farmer4.moveSubscene(game.isBoatOnTheLeftBank());
					//game.undo();
					//this.crossers = game.getCrossers();
					//System.out.println("hahahahah"+this.crossers.size());

					//crossersOnBoat.clear();

				// System.out.println("the is at"+goat.getTranslateX());
				// if(goat.getx()==2) {
				// goat.moveSubscene();
					System.out.println("print for go "+game.isBoatOnTheLeftBank());
			}
			// }

		});
		
		button3.setOnAction(m -> {
			if(game.canUndo()) {
				//game.undo();
				game.commandundo();
			this.crossers = game.getCrossers();
			System.out.println("print for undo "+game.isBoatOnTheLeftBank());
			System.out.println("size of crossers undo gui "+this.crossers.size());
			creditssub.moveSubscene();
			for(int i=0;i<this.crossers.size();i++) {
if((this.crossers.get(i) instanceof Farmer)&&game.isBoatOnTheLeftBank()==true){farmer1.moveSubscene(game.isBoatOnTheLeftBank());}
if((this.crossers.get(i) instanceof Farmer)&&game.isBoatOnTheLeftBank()==false){farmer1.moveSubscene(game.isBoatOnTheLeftBank()); }
if((this.crossers.get(i) instanceof Herbivorous)&&game.isBoatOnTheLeftBank()==true){goat.moveSubscene(game.isBoatOnTheLeftBank()); }
if((this.crossers.get(i) instanceof Herbivorous)&&game.isBoatOnTheLeftBank()==false){goat.moveSubscene(game.isBoatOnTheLeftBank()); }
if((this.crossers.get(i) instanceof Farmer)&&game.isBoatOnTheLeftBank()==true){farmer2.moveSubscene(game.isBoatOnTheLeftBank());}
if((this.crossers.get(i) instanceof Farmer)&&game.isBoatOnTheLeftBank()==false){farmer2.moveSubscene(game.isBoatOnTheLeftBank()); }
if((this.crossers.get(i) instanceof Farmer)&&game.isBoatOnTheLeftBank()==true){farmer3.moveSubscene(game.isBoatOnTheLeftBank()); }
if((this.crossers.get(i) instanceof Farmer)&&game.isBoatOnTheLeftBank()==false){farmer3.moveSubscene(game.isBoatOnTheLeftBank()); }
if((this.crossers.get(i) instanceof Farmer)&&game.isBoatOnTheLeftBank()==true){farmer4.moveSubscene(game.isBoatOnTheLeftBank()); }
if((this.crossers.get(i) instanceof Farmer)&&game.isBoatOnTheLeftBank()==false){farmer4.moveSubscene(game.isBoatOnTheLeftBank()); }
}}		
		
		});
		button4.setOnAction(m -> {
			level1Stage.close();
fring.button2.fire();
					
		
		});

		// button2.setOnAction(m->{

		// goat.moveSubscene();

		// });

		createsubscene();
		boolean k = creditssub.moveSubscene();
		goat.moveSubscene(game.isBoatOnTheLeftBank());
		farmer1.moveSubscene(game.isBoatOnTheLeftBank());
		farmer2.moveSubscene(game.isBoatOnTheLeftBank());
		farmer3.moveSubscene(game.isBoatOnTheLeftBank());
		farmer4.moveSubscene(game.isBoatOnTheLeftBank());

	}}