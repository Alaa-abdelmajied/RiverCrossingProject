package Actors;

import java.awt.image.BufferedImage;

public class Plant implements ICrosser {


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
	public boolean canSail() {
		return false;
	}
	
	@Override
	public int getEatingRank() {
		return 0;
	}

	@Override
	public BufferedImage[] getImages() {
		return null;
	}

	@Override
	public ICrosser makeCopy() {
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

	
}
