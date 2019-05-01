package saving;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Actors.ActorFactory;
import Actors.Carnivorous;
import Actors.Farmer;
import Actors.Herbivorous;
import Actors.ICrosser;
import Actors.Plant;
import LevelCreater.ICrossingStrategy;
import LevelCreater.Level1;
import LevelCreater.Level2;

public class FileReaderUtils {
	private List<ICrosser> CrossersOnRightBank = new ArrayList<ICrosser>();
	private List<ICrosser> CrossersOnLeftBank = new ArrayList<ICrosser>();
	private ICrossingStrategy gameStrategy;
	private boolean isBoatOnTheLeftBank;
	private int numberOfSails ;
	private ActorFactory actorFactory;
	Plant plant = Plant.getInstance();
	//ICrosser plant =actorFactory.getcrosser("plant");
	Farmer farmer =new Farmer();
	Farmer farmer2 =new Farmer();
	Farmer farmer3=new Farmer();
	Farmer farmer4 =new Farmer();

	//ICrosser farmer = actorFactory.getcrosser("farmer");
	//ICrosser wolf = actorFactory.getcrosser("Carnivorous");
	//ICrosser goat =actorFactory.getcrosser("Herbivorous");
	Carnivorous wolf = new Carnivorous();
	Herbivorous goat = new Herbivorous();
	
	
	public List<ICrosser> getCrossersOnRightBank() {
		return CrossersOnRightBank;
	}


	public List<ICrosser> getCrossersOnLeftBank() {
		return CrossersOnLeftBank;
	}


	public ICrossingStrategy getGameStrategy() {
		return gameStrategy;
	}


	public boolean getisBoatOnTheLeftBank() {
		return isBoatOnTheLeftBank;
	}


	public int getNumberOfSails() {
		return numberOfSails;
	}


	


	public void read() {

		try {

			File fXmlFile = new File("crossers.txt");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);


			doc.getDocumentElement().normalize();
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			if(doc.getDocumentElement().getNodeName().equalsIgnoreCase("level1")) {
				gameStrategy = new Level1 ();

			NodeList nList = doc.getElementsByTagName("crossersOnRightBank");
//System.out.println(nList.getLength());
Node nNode = nList.item(0);


				//Node nNode = nList.item(temp);

				//System.out.println("\nCurrent Element :" + nNode.getNodeName());
				//for (int temp = 0; temp < nList.getLength(); temp++) {

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

				//System.out.println(eElement.getTextContent());
				String str []=eElement.getTextContent().split("\\r?\\n");
				//System.out.println(str.length);
				for (int temp = 0; temp < str.length; temp++) {

//System.out.println(str[temp]);
				if(str[temp].equalsIgnoreCase("0"))
				CrossersOnRightBank.add(plant);
				else if(str[temp].equalsIgnoreCase("1"))
					CrossersOnRightBank.add(goat);
				else if(str[temp].equalsIgnoreCase("2")) 
					 CrossersOnRightBank.add(wolf);

				else if (str[temp].equalsIgnoreCase("5"))
					CrossersOnRightBank.add(farmer);

				}
				//System.out.println(CrossersOnRightBank.size());

			}
				NodeList nList2 = doc.getElementsByTagName("crossersOnLeftBank");
				//System.out.println("jhg"+nList2.getLength());
				Node nNode2 = nList2.item(0);
				//System.out.println("\nCurrent Element :" + nNode2.getNodeName());
				if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode2;

				//System.out.println(eElement.getTextContent());
				String str []=eElement.getTextContent().split("\\r?\\n");
				//System.out.println(str.length);
				for (int temp = 0; temp < str.length; temp++) {

				if(str[temp].equalsIgnoreCase("0"))
					CrossersOnLeftBank.add(plant);
				else if(str[temp].equalsIgnoreCase("1"))
					CrossersOnLeftBank.add(goat);
				else if(str[temp].equalsIgnoreCase("2")) 
					CrossersOnLeftBank.add(wolf);

				else if (str[temp].equalsIgnoreCase("5"))
					CrossersOnLeftBank.add(farmer);

				}
			//	System.out.println(CrossersOnLeftBank.size());

			}
				NodeList nList3 = doc.getElementsByTagName("isBoatOnTheLeftBank");
				//System.out.println("jhg"+nList3.getLength());
				Node nNode3 = nList3.item(0);
				//System.out.println("\nCurrent Element :" + nNode3.getNodeName());
				if (nNode3.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode3;
					//System.out.println("7777"+eElement.getTextContent());
					String str []=eElement.getTextContent().split("\\r?\\n");
					//System.out.println(str.length);
					for (int temp = 0; temp < str.length; temp++) {

					if(str[temp].equalsIgnoreCase("true"))
						isBoatOnTheLeftBank=true;
					else
						isBoatOnTheLeftBank=false;
				}
		}
				//System.out.println(isBoatOnTheLeftBank);
				NodeList nList4 = doc.getElementsByTagName("numberOfSails");
				//System.out.println("jhg"+nList4.getLength());
				Node nNode4 = nList4.item(0);
				//System.out.println("\nCurrent Element :" + nNode4.getNodeName());
				if (nNode4.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode4;
					//System.out.println("7777"+eElement.getTextContent());
					String str []=eElement.getTextContent().split("\\r?\\n");
					//System.out.println(str.length);
					//for (int temp = 0; temp < str.length; temp++) {
                     numberOfSails=Integer.parseInt(str[1]);
					
				//}
				//	System.out.println(numberOfSails);
	   	}
				}else {
					gameStrategy = new Level2 ();

					NodeList nList = doc.getElementsByTagName("crossersOnRightBank");
					//System.out.println(nList.getLength());
					Node nNode = nList.item(0);



									System.out.println("\nCurrent Element :" + nNode.getNodeName());

									if (nNode.getNodeType() == Node.ELEMENT_NODE) {

										Element eElement = (Element) nNode;

									System.out.println(eElement.getTextContent());
									String str []=eElement.getTextContent().split("\\r?\\n");
									//System.out.println(str.length);
									for (int temp = 0; temp < str.length; temp++) {

					//System.out.println("split"+str[temp]);
									if(str[temp].equalsIgnoreCase("90.0")) {
										System.out.println(45454);
                                        farmer.setWeight(90);
										CrossersOnRightBank.add(farmer);
									}
									else if(str[temp].equalsIgnoreCase("80.0")) {
										farmer2.setWeight(80);
										CrossersOnRightBank.add(farmer2);
									}
									
									else if(str[temp].equalsIgnoreCase("60.0")) {
										farmer3.setWeight(60);
										 CrossersOnRightBank.add(farmer3);
									}
									else if (str[temp].equalsIgnoreCase("40.0")) {
										farmer4.setWeight(40);
										CrossersOnRightBank.add(farmer4);
									}
									else if (str[temp].equalsIgnoreCase("20.0")) {
										goat.setWeight(20);
										CrossersOnRightBank.add(goat);

									}
									//System.out.println("rightfe reader"+CrossersOnRightBank.size());

								}
					
				}
									NodeList nList2 = doc.getElementsByTagName("crossersOnLeftBank");
									//System.out.println(nList.getLength());
									Node nNode2 = nList2.item(0);



													System.out.println("\nCurrent Element :" + nNode2.getNodeName());

													if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

														Element eElement = (Element) nNode2;

													System.out.println(eElement.getTextContent());
													String str []=eElement.getTextContent().split("\\r?\\n");
													//System.out.println(str.length);
													for (int temp = 0; temp < str.length; temp++) {

									//System.out.println("split"+str[temp]);
													if(str[temp].equalsIgnoreCase("90.0")) {
				                                        farmer.setWeight(90);
				                                        CrossersOnLeftBank.add(farmer);
													}
													else if(str[temp].equalsIgnoreCase("80.0")) {
														farmer2.setWeight(80);
														CrossersOnLeftBank.add(farmer2);
													}
													
													else if(str[temp].equalsIgnoreCase("60.0")) {
														farmer3.setWeight(60);
														CrossersOnLeftBank.add(farmer3);
													}
													else if (str[temp].equalsIgnoreCase("40.0")) {
														farmer4.setWeight(40);
														CrossersOnLeftBank.add(farmer4);
													}
													else if (str[temp].equalsIgnoreCase("20.0")) {
														goat.setWeight(20);
														CrossersOnLeftBank.add(goat);

													}
													//System.out.println("rightfe reader"+CrossersOnRightBank.size());

												}
									
								}
													NodeList nList3 = doc.getElementsByTagName("isBoatOnTheLeftBank");
													//System.out.println("jhg"+nList3.getLength());
													Node nNode3 = nList3.item(0);
													//System.out.println("\nCurrent Element :" + nNode3.getNodeName());
													if (nNode3.getNodeType() == Node.ELEMENT_NODE) {

														Element eElement = (Element) nNode3;
														//System.out.println("7777"+eElement.getTextContent());
														String str []=eElement.getTextContent().split("\\r?\\n");
														//System.out.println(str.length);
														for (int temp = 0; temp < str.length; temp++) {

														if(str[temp].equalsIgnoreCase("true"))
															isBoatOnTheLeftBank=true;
														else
															isBoatOnTheLeftBank=false;
													}
											}
													//System.out.println(isBoatOnTheLeftBank);
													NodeList nList4 = doc.getElementsByTagName("numberOfSails");
													//System.out.println("jhg"+nList4.getLength());
													Node nNode4 = nList4.item(0);
													//System.out.println("\nCurrent Element :" + nNode4.getNodeName());
													if (nNode4.getNodeType() == Node.ELEMENT_NODE) {

														Element eElement = (Element) nNode4;
														//System.out.println("7777"+eElement.getTextContent());
														String str []=eElement.getTextContent().split("\\r?\\n");
														//System.out.println(str.length);
														//for (int temp = 0; temp < str.length; temp++) {
									                     numberOfSails=Integer.parseInt(str[1]);
														
													//}
													//	System.out.println(numberOfSails);
													}
		}	
		} catch (Exception e) {
			System.out.println("fff");
		}
	}

}
