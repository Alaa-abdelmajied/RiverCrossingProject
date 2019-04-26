package Actors;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Farmer implements ICrosserModified {

	/*
	 * Attributes
	 */

	private double weight;

	/*
	 * Getters and setters
	 */

	@Override
	public int getEatingRank() {
		return 5;
	}

	@Override
	public BufferedImage[] getImages() {
		BufferedImage[] bufferedImages = new BufferedImage[1];
		 File initialImage = new File("C://Users/Fujitsu/Desktop/farmer.png");
		 try {
			bufferedImages[0] = ImageIO.read(initialImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bufferedImages;
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
	

	public void setWeight(double weight) {
		this.weight = weight;
	}

	

	/*
	 * Behavior
	 */

	@Override
	public boolean canSail() {
		return true;
	}

	@Override
	public ICrosser makeCopy() {
		// TODO Auto-generated method stub
		return null;
	}

}
