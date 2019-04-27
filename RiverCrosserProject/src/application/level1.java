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
	private boolean goatonboat = false;
	private boolean farmeronboat = false;
	private boolean wolfonboat = false;
	private boolean plantonboat = false;

	java.util.List<ICrosser> crossers = new ArrayList<ICrosser>();

	public void createsubscene() {
		creditssub = new fxxsubscene();
		mainPane.getChildren().add(creditssub);
		goat = new goatsubscene(crossers.get(2));
		mainPane.getChildren().add(goat);
		farmer = new farmer_subscene(crossers.get(0));
		mainPane.getChildren().add(farmer);
		wolf = new wolfsubscene(crossers.get(1));
		mainPane.getChildren().add(wolf);
		plant = new plantsubscene(crossers.get(3));
		mainPane.getChildren().add(plant);

	}

	public void createlevel1(Stage menustage) {
		this.menustage = menustage;
		this.menustage.hide();
		level1Stage.show();

	}

	public level1(java.util.List<ICrosser> crossers, Game game) {
		this.crossers = crossers;
		System.out.println("ssssss" + this.crossers.get(0));
		x = new viewmanager();
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
		v.setLayoutY(00);

		button1.setOnAction(m -> {
			boolean goatonboat = false;
			boolean farmeronboat = false;
			boolean wolfonboat = false;
			boolean plantonboat = false;

			ArrayList<ICrosser> crossersOnBoat = new ArrayList<>();
			if ((creditssub.getTranslateX() > -430) || (creditssub.getTranslateX() < -537)) {
				if ((goat.getTranslateX() < -318 && goat.getTranslateX() > -430)
						^ (goat.getTranslateX() < -537 && goat.getTranslateX() > -655)) {
					// crossersOnBoat.add(crossers.get(2));

					goatonboat = true;
					// System.out.println("goat on boat"+crossers.get(2));
				}
			}
			if ((farmer.getTranslateX() < -318 && farmer.getTranslateX() > -430)
					^ (farmer.getTranslateX() < -537 && farmer.getTranslateX() > -655)) {
				// crossersOnBoat.add(crossers.get(0));
				farmeronboat = true;
			}

			if ((plant.getTranslateX() < -318 && plant.getTranslateX() > -430)
					^ (plant.getTranslateX() < -537 && plant.getTranslateX() > -655)) {
				// crossersOnBoat.add(crossers.get(3));
				plantonboat = true;
			}
			if ((wolf.getTranslateX() < -318 && wolf.getTranslateX() > -430)
					^ (wolf.getTranslateX() < -537 && wolf.getTranslateX() > -655)) {
				// crossersOnBoat.add(crossers.get(1));
				wolfonboat = true;
			}
			if(game.isBoatOnTheLeftBank()==false) {

			if (farmeronboat == true) {
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

			if (wolfonboat == true) {
				for (int j = 0; j < crossers.size(); j++) {
					if (crossers.get(j) instanceof Carnivorous)
						crossersOnBoat.add(crossers.get(j));
				}
			}

			if (plantonboat == true) {
				for (int j = 0; j < crossers.size(); j++) {
					if (crossers.get(j) instanceof Plant)
						crossersOnBoat.add(crossers.get(j));
				}
			}}
			else
			{
				if (farmeronboat == true) {
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

				if (wolfonboat == true) {
					for (int j = 0; j < game.getCrossersOnLeftBank().size(); j++) {
						if (game.getCrossersOnLeftBank().get(j) instanceof Carnivorous)
							crossersOnBoat.add(game.getCrossersOnLeftBank().get(j));
					}
				}

				if (plantonboat == true) {
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
					goat.moveSubscene(k);
					farmer.moveSubscene(k);
					wolf.moveSubscene(k);
					plant.moveSubscene(k);
				

				// System.out.println("the is at"+goat.getTranslateX());
				// if(goat.getx()==2) {
				// goat.moveSubscene();
				
			}
			// }

		});

		// button2.setOnAction(m->{

		// goat.moveSubscene();

		// });

		createsubscene();
		boolean k = creditssub.moveSubscene();
		goat.moveSubscene(k);
		farmer.moveSubscene(k);
		wolf.moveSubscene(k);
		plant.moveSubscene(k);

	}

}