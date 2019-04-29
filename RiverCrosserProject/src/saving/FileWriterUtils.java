package saving;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.omg.CosNaming.IstringHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import Actors.Farmer;
import Actors.Herbivorous;
import Actors.ICrosser;
import Actors.Plant;
import LevelCreater.ICrossingStrategy;
import LevelCreater.Level1;

public class FileWriterUtils {
	private List<ICrosser> CrossersOnRightBank = new ArrayList<ICrosser>();
	private List<ICrosser> CrossersOnLeftBank = new ArrayList<ICrosser>();
	//private List<ICrosser> Crossers = new ArrayList<ICrosser>();
	private ICrossingStrategy gameStrategy;
	private boolean isBoatOnTheLeft;
	private int numberOfSails;
	private String level ;
	private String BoatOnTheLeft;
	private String numOfSails;

	
	public void setCrossersOnRightBank(List<ICrosser> crossersOnRightBank) {
		CrossersOnRightBank = crossersOnRightBank;
	}

	public void setCrossersOnLeftBank(List<ICrosser> crossersOnLeftBank) {
		CrossersOnLeftBank = crossersOnLeftBank;
	}

/*	public void setCrossers(List<ICrosser> crossers) {
		Crossers = crossers;
	}*/

	public void setGameStrategy(ICrossingStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
		if(this.gameStrategy instanceof Level1)
			level="level1";
		else 
			level ="level2";
	}
	
	public void setBoatOnTheLeft(boolean isBoatOnTheLeft) {
		this.isBoatOnTheLeft = isBoatOnTheLeft;
		if (this.isBoatOnTheLeft == true)
			BoatOnTheLeft = "true";
		else 
			BoatOnTheLeft ="false";
	}

	public void setNumberOfSails(int numberOfSails) {
		this.numberOfSails = numberOfSails;
	    numOfSails=String.valueOf(numberOfSails);
	   
	}

	public  void write() {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		List<ICrosser> CrossersOnRightBank = new ArrayList<ICrosser>();

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// add elements to Document
			//Element rootElement = doc.createElement("Crossers");

			// append root element to document
			// doc.appendChild(rootElement);

			// append first child element to root element
		if(level.equalsIgnoreCase("level1")) {
			
			Element root = doc.createElement("level1");
			doc.appendChild(root);
			Element rootElement = doc.createElement("Crossers");
			 doc.appendChild(rootElement);

			
			
			
			
			for (ICrosser crosser : CrossersOnRightBank) {
				
				
				
			}
		}
			// for output to file, console
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// for pretty print
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);

			// write to console or file
			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(new File("crossers.txt"));

			// write data
			transformer.transform(source, console);
			transformer.transform(source, file);
			System.out.println("DONE");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void main1( String[] args) {
	 * 
	 * List<ICrosser> CrossersOnRightBank = new ArrayList<ICrosser>(); Farmer farmer
	 * = new Farmer (); Farmer farmer2 = new Farmer (); Herbivorous goat = new
	 * Herbivorous(); CrossersOnRightBank.add(farmer);
	 * CrossersOnRightBank.add(farmer2); CrossersOnRightBank.add(goat);
	 * 
	 * 
	 * }
	 */
}