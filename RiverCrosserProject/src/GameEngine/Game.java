package GameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Actors.ICrosser;
import LevelCreater.ICrossingStrategy;
import application.level1;
import application.viewmanager;

public class Game implements IRiverCrossingController {

	private List<ICrosser> CrossersOnRightBank = new ArrayList<ICrosser>();
	private List<ICrosser> CrossersOnLeftBank = new ArrayList<ICrosser>();
	//private List<ICrosser> CrossersOnRightBankCopy = new ArrayList<ICrosser>();
	private List<ICrosser> Crossers = new ArrayList<ICrosser>();
	private ICrossingStrategy gameStrategy;
	private boolean isBoatOnTheLeftBank = false;
	private int numberOfSails = 0;
	List <List> state = new ArrayList <>();
	Stack<List> undo = new Stack<List> ();
	Stack<List> redo = new Stack<List> ();
	viewmanager obj= new viewmanager();

	
	

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {

		this.gameStrategy = gameStrategy;
		LevelCreater.Level level = new LevelCreater.Level(gameStrategy);
		CrossersOnRightBank = level.getInitialCrossers();
		
		

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
	// adema
	@Override
	public boolean isBoatOnTheLeftBank() {
		return isBoatOnTheLeftBank;
	}

//	@Override
/*	public boolean isBoatOnTheLeftBank() {
		if(numberOfSails%2==0)
		{
			return false;
		}
		return true;
		//return isBoatOnTheLeftBank;
	}*/

	@Override
	public int getNumberOfSails() {
		return numberOfSails;
	}
	
//can move el adema 
	/*@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		if( gameStrategy.isValid(getCrossersOnRightBank(), getCrossersOnLeftBank(), crossers)) {
			//System.out.println(gameStrategy.isValid(getCrossersOnRightBank(), getCrossersOnLeftBank(), crossers));
			return true;
		}
		else
			return false;
	/*	if (fromLeftToRightBank) {
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
		if(canMove)
			return true;
		else 
			return false;
	}*/
@Override
public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
	System.out.println("makan el boat "+fromLeftToRightBank);
	if (fromLeftToRightBank==false)
	{	for(int i = 0; i <crossers.size();i++)
		getCrossersOnRightBank().remove(crossers.get(i));
	}
	if(fromLeftToRightBank==true)
	{for(int i = 0; i <crossers.size();i++)

		getCrossersOnLeftBank().remove(crossers.get(i));
	}
	System.out.println(gameStrategy.isValid(getCrossersOnRightBank(), getCrossersOnLeftBank(), crossers));
	if(!gameStrategy.isValid(getCrossersOnRightBank(), getCrossersOnLeftBank(), crossers)) {
		if (fromLeftToRightBank==false) {
		for(int i = 0; i <crossers.size();i++)

           getCrossersOnRightBank().add(crossers.get(i));
		}
		if(fromLeftToRightBank==true)	{	
			for(int i = 0; i <crossers.size();i++)
		

           getCrossersOnLeftBank().add(crossers.get(i));
	}
	return false ;
	}
		return true ;
}

//adema 
	/*@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		//if(canMove(crossers, fromLeftToRightBank)) {
			if (fromLeftToRightBank) {
				for (int i = 0; i < crossers.size(); i++) {
					CrossersOnLeftBank.remove(crossers.get(i));
					CrossersOnRightBank.add(crossers.get(i));

				}
				
				state.add(CrossersOnLeftBank);
				state.add(crossers);
				state.add(CrossersOnRightBank);
				undo.push(state);
				numberOfSails ++;

			} 
			else {
				for (int i = 0; i < crossers.size(); i++) {
					CrossersOnLeftBank.add(crossers.get(i));
					CrossersOnRightBank.remove(crossers.get(i));
					
				}
				state.add(CrossersOnLeftBank);
				state.add(crossers);
				state.add(CrossersOnRightBank);
				undo.push(state);
				numberOfSails ++;

			}
			
		//}
	}*/
@Override
public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
	if(fromLeftToRightBank==false)
	{
	   for(int i = 0 ;i<crossers.size();i++)
		getCrossersOnLeftBank().add(crossers.get(i));

	}
	else 
	{	
		for(int i = 0 ;i<crossers.size();i++)
	

		getCrossersOnRightBank().add(crossers.get(i));
	}
		if(isBoatOnTheLeftBank==true)
			isBoatOnTheLeftBank=false;
		else
			isBoatOnTheLeftBank=true;
	//}
	numberOfSails++;
	state.add(CrossersOnLeftBank);
	state.add(crossers);
	state.add(CrossersOnRightBank);
	undo.push(state);
	numberOfSails ++;
}

	@Override
	public boolean canUndo() {
		if(undo.empty())
			return false ;
		return true;
	}

	@Override
	public boolean canRedo() {
		if(redo.empty())
			return false ;
		return true;	
	}

	@Override
	public void undo() {
		List<List> undoArray =new ArrayList<List>();
		undoArray=undo.pop();
		redo.push(undoArray);
		CrossersOnLeftBank=undoArray.get(0);
		Crossers=undoArray.get(1);
		CrossersOnRightBank=undoArray.get(2);
		numberOfSails ++;


	}

	@Override
	public void redo() {
		List<List> redoArray =new ArrayList<List>();
		redoArray=redo.pop();
		undo.push(redoArray);
		CrossersOnLeftBank=redoArray.get(0);
		Crossers=redoArray.get(1);
		CrossersOnRightBank=redoArray.get(2);
		numberOfSails ++;

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
