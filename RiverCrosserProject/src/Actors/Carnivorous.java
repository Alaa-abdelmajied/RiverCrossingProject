package Actors;

import java.awt.image.BufferedImage;

public class Carnivorous implements ICrosserModified {
	
	private double weight ; 
	private String label;
	
	@Override
	public double getweight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int getEatingRank() {
		// TODO Auto-generated method stub
		return 2;
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
