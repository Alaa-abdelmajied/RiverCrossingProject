package GameEngine;

import java.util.ArrayList;
import java.util.List;
import Actors.ICrosser;
import LevelCreater.ICrossingStrategy;

public class Game implements IRiverCrossingController {

	private List<ICrosser> CrossersOnRightBank = new ArrayList<ICrosser>();
	private List<ICrosser> CrossersOnLeftBank = new ArrayList<ICrosser>();
	
	private ICrossingStrategy gameStrategy;
	private boolean isBoatOnTheLeftBank = false;
	private int numberOfSails = 0;

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {

		this.gameStrategy = gameStrategy;
		LevelCreater.Level level = new LevelCreater.Level(gameStrategy);
		CrossersOnLeftBank = level.getInitialCrossers();

	}

	@Override
	public void resetGame() {

		newGame(gameStrategy);

	}

	@Override
	public String[] getInstructions() {

		String[] instructions = gameStrategy.getInstructions();
		return instructions;

	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return CrossersOnRightBank;
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return CrossersOnLeftBank;
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		return isBoatOnTheLeftBank;
	}

	@Override
	public int getNumberOfSails() {
		return numberOfSails;
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		if (fromLeftToRightBank) {
			for (int i = 0; i < crossers.size(); i++) {
				CrossersOnLeftBank.remove(crossers.get(i));
				CrossersOnRightBank.add(crossers.get(i));

			}

		} else {
			for (int i = 0; i < crossers.size(); i++) {
				CrossersOnLeftBank.add(crossers.get(i));
				CrossersOnRightBank.remove(crossers.get(i));

			}
		}
		boolean canMove = gameStrategy.isValid(getCrossersOnRightBank(), getCrossersOnLeftBank(), crossers);
		if(canMove)
			return true;
		else {
			if (fromLeftToRightBank) {
				for (int i = 0; i < crossers.size(); i++) {
					CrossersOnLeftBank.add(crossers.get(i));
					CrossersOnRightBank.remove(crossers.get(i));
				}

			} else {
				for (int i = 0; i < crossers.size(); i++) {
					CrossersOnLeftBank.remove(crossers.get(i));
					CrossersOnRightBank.add(crossers.get(i));

				}
			}
			return false;
		}
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

	}

	@Override
	public boolean canUndo() {
		return false;
	}

	@Override
	public boolean canRedo() {
		return false;
	}

	@Override
	public void undo() {

	}

	@Override
	public void redo() {

	}

	@Override
	public void saveGame() {

	}

	@Override
	public void loadGame() {

	}

	@Override
	public List<List<ICrosser>> solveGame() {
		return null;
	}

}
