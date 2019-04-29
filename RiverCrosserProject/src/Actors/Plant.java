package Actors;

import java.awt.image.BufferedImage;

public class Plant implements ICrosserModified {

	private double weight;
	private String label;
	private static Plant instance ;
	
	private Plant () {
		
	}
	
	public static Plant getInstance () {
		if(instance == null) {
			instance = new Plant ();
		}
		return instance;	

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
	public void setLabelToBeShown(String label) {
		this.label = label;
		
	}

	@Override
	public String getLabelToBeShown() {
		return label;
	}

	@Override
	public double getweight() {
		return weight;
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
		return null;
	}

}
