package GameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import LevelCreater.Level2;
import Actors.ICrosser;
import LevelCreater.ICrossingStrategy;
import LevelCreater.Level1;
import application.level1;
import application.viewmanager;

public class Game implements IRiverCrossingController {

	private List<ICrosser> CrossersOnRightBank = new ArrayList<ICrosser>();
	private List<ICrosser> CrossersOnLeftBank = new ArrayList<ICrosser>();
	// private List<ICrosser> CrossersOnRightBankCopy = new ArrayList<ICrosser>();
	private List<ICrosser> Crossers = new ArrayList<ICrosser>();
	private ICrossingStrategy gameStrategy;
	private boolean isBoatOnTheLeftBank = false;
	public int numberOfSails = 0;
//	List <List<ICrosser>> state = new ArrayList <>();
	Stack<List<List<ICrosser>>> undo = new Stack<>();
	Stack<List<List<ICrosser>>> redo = new Stack<>();
	viewmanager obj = new viewmanager();
	// ArrayList<List> undoredo = new ArrayList<List>();
	int cnt = 0;
	private viewmanager view = new viewmanager();
	private ICrossingStrategy level1logic = new Level1();
	private ICrossingStrategy level2logic = new Level2();
	private Invoker invoker = new Invoker();

	public void setview(viewmanager view) {
		this.view = view;
	}

	public ICrossingStrategy getLevel2logic() {
		return level2logic;
	}

	public ICrossingStrategy getLevel1logic() {
		return level1logic;
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {

		undo.clear();
		redo.clear();
		Crossers.clear();
		CrossersOnLeftBank.clear();
		CrossersOnRightBank.clear();
		isBoatOnTheLeftBank = false;
		numberOfSails = 0;
		this.gameStrategy = gameStrategy;
		LevelCreater.Level level = new LevelCreater.Level(gameStrategy);
		CrossersOnRightBank = level.getInitialCrossers();

	}

	@Override
	public void resetGame() {

		//newGame(gameStrategy);
		view.getButton2().fire();
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

	// adema
	@Override
	public boolean isBoatOnTheLeftBank() {
		return isBoatOnTheLeftBank;
	}

//	@Override
	/*
	 * public boolean isBoatOnTheLeftBank() { if(numberOfSails%2==0) { return false;
	 * } return true; //return isBoatOnTheLeftBank; }
	 */

	@Override
	public int getNumberOfSails() {
		return numberOfSails;
	}

//can move el adema 
	/*
	 * @Override public boolean canMove(List<ICrosser> crossers, boolean
	 * fromLeftToRightBank) { if( gameStrategy.isValid(getCrossersOnRightBank(),
	 * getCrossersOnLeftBank(), crossers)) {
	 * //System.out.println(gameStrategy.isValid(getCrossersOnRightBank(),
	 * getCrossersOnLeftBank(), crossers)); return true; } else return false; /* if
	 * (fromLeftToRightBank) { for (int i = 0; i < crossers.size(); i++) {
	 * CrossersOnLeftBank.remove(crossers.get(i));
	 * CrossersOnRightBank.add(crossers.get(i));
	 * 
	 * }
	 * 
	 * } else { for (int i = 0; i < crossers.size(); i++) {
	 * CrossersOnLeftBank.add(crossers.get(i));
	 * CrossersOnRightBank.remove(crossers.get(i)); } } if(canMove) return true;
	 * else return false; }
	 */
	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		System.out.println("makan el boat " + fromLeftToRightBank);
		if (fromLeftToRightBank == false) {
			for (int i = 0; i < crossers.size(); i++)
				getCrossersOnRightBank().remove(crossers.get(i));
		}
		if (fromLeftToRightBank == true) {
			for (int i = 0; i < crossers.size(); i++)

				getCrossersOnLeftBank().remove(crossers.get(i));
		}
		System.out.println(gameStrategy.isValid(getCrossersOnRightBank(), getCrossersOnLeftBank(), crossers));
		if (!gameStrategy.isValid(getCrossersOnRightBank(), getCrossersOnLeftBank(), crossers)) {
			if (fromLeftToRightBank == false) {
				for (int i = 0; i < crossers.size(); i++)

					getCrossersOnRightBank().add(crossers.get(i));
			}
			if (fromLeftToRightBank == true) {
				for (int i = 0; i < crossers.size(); i++)

					getCrossersOnLeftBank().add(crossers.get(i));
			}
			return false;
		}
		return true;
	}

//adema 
	/*
	 * @Override public void doMove(List<ICrosser> crossers, boolean
	 * fromLeftToRightBank) { //if(canMove(crossers, fromLeftToRightBank)) { if
	 * (fromLeftToRightBank) { for (int i = 0; i < crossers.size(); i++) {
	 * CrossersOnLeftBank.remove(crossers.get(i));
	 * CrossersOnRightBank.add(crossers.get(i));
	 * 
	 * }
	 * 
	 * state.add(CrossersOnLeftBank); state.add(crossers);
	 * state.add(CrossersOnRightBank); undo.push(state); numberOfSails ++;
	 * 
	 * } else { for (int i = 0; i < crossers.size(); i++) {
	 * CrossersOnLeftBank.add(crossers.get(i));
	 * CrossersOnRightBank.remove(crossers.get(i));
	 * 
	 * } state.add(CrossersOnLeftBank); state.add(crossers);
	 * state.add(CrossersOnRightBank); undo.push(state); numberOfSails ++;
	 * 
	 * }
	 * 
	 * //} }
	 */
	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		this.Crossers = crossers;
		if (fromLeftToRightBank == false) {
			for (int i = 0; i < crossers.size(); i++)
				getCrossersOnLeftBank().add(crossers.get(i));

		} else {
			for (int i = 0; i < crossers.size(); i++)

				getCrossersOnRightBank().add(crossers.get(i));
		}
		if (isBoatOnTheLeftBank == true)
			isBoatOnTheLeftBank = false;
		else
			isBoatOnTheLeftBank = true;
		// }
		List<List<ICrosser>> state = new ArrayList<>();

		state.add(CrossersOnLeftBank);
		System.out.println("jjjjjj" + CrossersOnLeftBank.size());
		state.add(this.Crossers);
		state.add(CrossersOnRightBank);
		undo.push(state);
		// System.out.println("size of crossers in do move of
		// undo"+state.get(1).size());
		// System.out.println("size of undo"+undo.size());
		// undoredo.add(crossers);
		numberOfSails++;
	}

	@Override
	public boolean canUndo() {
		if (undo.empty())
			return false;
		return true;
	}

	@Override
	public boolean canRedo() {
		if (redo.empty())
			return false;
		return true;
	}

	@Override
	public void undo() {
		List<List<ICrosser>> undoArray = new ArrayList<List<ICrosser>>();
		undoArray = undo.pop();
		// System.out.println("fwefwefw"+undoArray.size());
		// System.out.println("fwefwefw22"+undo.pop().size());

		redo.push(undoArray);
		CrossersOnLeftBank = undoArray.get(0);
		Crossers = undoArray.get(1);
		CrossersOnRightBank = undoArray.get(2);
		System.out.println("logic undo" + CrossersOnLeftBank.size());
		if (isBoatOnTheLeftBank()) {
			for (int i = 0; i < this.Crossers.size(); i++) {
				CrossersOnRightBank.add(Crossers.get(i));
				CrossersOnLeftBank.remove(Crossers.get(i));
			}
		} else {
			for (int i = 0; i < this.Crossers.size(); i++) {
				CrossersOnLeftBank.add(Crossers.get(i));
				CrossersOnRightBank.remove(Crossers.get(i));
			}
		}

		numberOfSails++;
		if (isBoatOnTheLeftBank == true)
			isBoatOnTheLeftBank = false;
		else
			isBoatOnTheLeftBank = true;

	}

	/*
	 * @Override public void undo() {
	 * 
	 * }
	 */
	@Override
	public void redo() {
		List<List<ICrosser>> redoArray = new ArrayList<List<ICrosser>>();
		redoArray = redo.pop();
		undo.push(redoArray);
		CrossersOnLeftBank = redoArray.get(0);
		Crossers = redoArray.get(1);
		CrossersOnRightBank = redoArray.get(2);
		numberOfSails++;
		if (isBoatOnTheLeftBank()) {
			for (int i = 0; i < this.Crossers.size(); i++) {
				CrossersOnRightBank.add(Crossers.get(i));
				CrossersOnLeftBank.remove(Crossers.get(i));
			}
		} else {
			for (int i = 0; i < this.Crossers.size(); i++) {
				CrossersOnLeftBank.add(Crossers.get(i));
				CrossersOnRightBank.remove(Crossers.get(i));
			}
		}
		if (isBoatOnTheLeftBank == true)
			isBoatOnTheLeftBank = false;
		else
			isBoatOnTheLeftBank = true;
	}

	public void commandundo() {
		Command undo = new UndoCommand(view.game);
		invoker.setCommand(undo);
		invoker.pressButton();
	}

	public void commandredo() {
		Command redo = new RedoCommand(view.game);
		invoker.setCommand(redo);
		invoker.pressButton();
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

	public List<ICrosser> getCrossers() {
		return Crossers;
	}

}
