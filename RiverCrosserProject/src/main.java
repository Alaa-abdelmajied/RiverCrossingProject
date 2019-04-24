
import LevelCreater.*;
import java.util.ArrayList;
import java.util.List;
import Actors.*;
import Actors.Carnivorous;
import Actors.Farmer;
import Actors.Herbivorous;
import Actors.ICrosser;
import Actors.Plant;
import GameEngine.Game;

public class main {
	
	

	public static void main(String[] args) {
		
		List <ICrosser> boat =new ArrayList <ICrosser>();
		List <ICrosser> right =new ArrayList <ICrosser>();
		List <ICrosser> left =new ArrayList <ICrosser>();
		Level level = new Level (new Level2());
		//right=level.getInitialCrossers();
		
		/*ICrosser farmer1 = new Farmer();
		ICrosser farmer2 = new Farmer();
		ICrosser goat = new Herbivorous();
		ICrosser farmer3 = new Farmer();
		ICrosser farmer4 = new Farmer();*/
		Farmer farmer1 = new Farmer ();
		farmer1.setWeight(90);
		Farmer farmer2 = new Farmer ();
		farmer2.setWeight(80);
		Farmer farmer3 = new Farmer ();
		farmer3.setWeight(60);
		Farmer farmer4 = new Farmer ();
		farmer4.setWeight(40);
		
		
		Herbivorous plant = new Herbivorous ();
        
		plant.setWeight(20);
		
		boat.add(farmer1);
		right.add(plant);
		boat.add(farmer3);
		left.add(farmer4);

		left.add(farmer2);

		boolean x = level.isValid(right,left,boat);
		
		System.out.println(x);
		Game game =new Game ();
		ICrossingStrategy level2 = new Level2();
		game.newGame(level2);
		System.out.println(game.getInstructions()[2]);
	}
	/*intialCrossers.add(lion);
	intialCrossers.add(goat);
	intialCrossers.add(plant);*/


	
}