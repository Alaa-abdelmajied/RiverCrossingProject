package Actors;

import java.awt.image.BufferedImage;

public class Farmer implements ICrosser {

	
	/*
	 * Attributes
	 */
	
	private double weight;
	
	/*
	 * Getters and setters
	 */
	
	
	/*
	 * Behavior
	 */
	
	public Farmer(double weight) {
		this.weight = weight;
	}

	@Override
	public boolean canSail() {
		return true;
	}
	
	@Override
	public int getEatingRank() {
		return 5;
	}

	@Override
	public BufferedImage[] getImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICrosser makeCopy() {
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

	@Override
	public double getweight() {
		return weight;
	}

	
	
}
