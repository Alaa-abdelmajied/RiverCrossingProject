package Actors;

import java.awt.image.BufferedImage;

public class Herbivorous implements ICrosserModified {

	/*
	 * Attributes
	 */

	private double weight;

	/*
	 * Getters and setters
	 */

	@Override
	public double getweight() {
		return 0;
	}

	@Override
	public int getEatingRank() {
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
	

	public void setWeight(double weight) {
		this.weight = weight;
	}


	/*
	 * Behavior
	 */

	@Override
	public boolean canSail() {
		return false;
	}

	@Override
	public ICrosser makeCopy() {
		// TODO Auto-generated method stub
		return null;
	}

}
