package Actors;

import java.awt.image.BufferedImage;

public class Herbivorous implements ICrosser {


	/*
	 * Attributes
	 */
	
	private double weight ; 
	
	/*
	 * Getters and setters
	 */
	

	@Override
	public double getweight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEatingRank() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public BufferedImage[] getImages() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setLabelToBeShown(String label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLabelToBeShown() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/*
	 * Behavior
	 */
	
	
	@Override
	public boolean canSail() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public ICrosser makeCopy() {
		// TODO Auto-generated method stub
		return null;
	}

}
