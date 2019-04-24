package Actors;

import java.awt.image.BufferedImage;

public class Plant implements ICrosserModified {

	/*
	 * Attributes
	 */
	
	private double weight;

	/*
	 * Getters and setters
	 */
	
	@Override
	public int getEatingRank() {
		return 0;
	}

	@Override
	public BufferedImage[] getImages() {
		return null;
	}

	@Override
	public void setLabelToBeShown(String label) {

	}

	@Override
	public String getLabelToBeShown() {
		return null;
	}

	@Override
	public double getweight() {
		return 0;
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
		return null;
	}

}
