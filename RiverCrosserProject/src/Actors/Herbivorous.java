package Actors;

import java.awt.image.BufferedImage;

public class Herbivorous implements ICrosserModified {

	private double weight;
	private String label;
	
	@Override
	public double getweight() {
		return weight;
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
		this.label = label;
		
	}

	@Override
	public String getLabelToBeShown() {
		return label;
	}
	

	public void setWeight(double weight) {
		this.weight = weight;
	}

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
