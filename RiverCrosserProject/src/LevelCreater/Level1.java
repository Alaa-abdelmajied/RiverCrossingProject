package LevelCreater;

import java.util.ArrayList;
import java.util.List;

import Actors.Carnivorous;
import Actors.Farmer;
import Actors.Herbivorous;
import Actors.ICrosser;
import Actors.Plant;
import Actors.ActorFactory;

public class Level1 implements ICrossingStrategy {

	/*
	 * Attributes
	 */

	/*
	 * Getters and setters
	 */

	/*
	 * Behavior
	 */

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) {

		for (int i = 0; i < boatRiders.size(); i++) {
			if (!boatRiders.get(i).canSail())
				return false;
		}

		if (rightBankCrossers.size() == 2) {
			if (Math.abs(rightBankCrossers.get(0).getEatingRank() - rightBankCrossers.get(1).getEatingRank()) == 1)
				return false;
		}

		if (leftBankCrossers.size() == 2) {
			if (Math.abs(leftBankCrossers.get(0).getEatingRank() - leftBankCrossers.get(1).getEatingRank()) == 1)
				return false;
		}

		return true;
	}

	@Override
	public List<ICrosser> getInitialCrossers() {
		
		List<ICrosser> intialCrossers = new ArrayList<ICrosser>();
		
		ActorFactory factory = new ActorFactory();
		ICrosser farmer =factory.getcrosser("farmer");
		farmer.setLabelToBeShown("Can not eat anything");
		ICrosser goat =factory.getcrosser("herbivorous");
		goat.setLabelToBeShown("Can eat plant");
		ICrosser lion =factory.getcrosser("carnivorous");
		lion.setLabelToBeShown("Can eat goat");
		ICrosser plant =factory.getcrosser("plant");
		plant.setLabelToBeShown("Can not eat anything");
		
		intialCrossers.add(farmer);
		intialCrossers.add(lion);
		intialCrossers.add(goat);
		intialCrossers.add(plant);
		
		return intialCrossers;
	}

	@Override
	public String[] getInstructions() {
		String[] instructions = new String[3];
		instructions[0] = "Help the farmer to move lion, goat and plant across the river";
		instructions[1] = "The boat can not move without the farmer";
		instructions[2] = "When the farmer is not nearby the wolf will eat the goat and the goat will eat the plant but you can leave the 3 of them alone";
		return instructions;
	}

}
