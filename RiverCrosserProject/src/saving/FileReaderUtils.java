package saving;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileReaderUtils {

	public void read() {

		try {

			File fXmlFile = new File("crossers.txt");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			System.out.println("----------------------------");

			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("ICrossers");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					System.out.println("left:" + eElement.getElementsByTagName("left").item(0).getTextContent());
					System.out.println("right:" + eElement.getElementsByTagName("right").item(0).getTextContent());
					System.out.println("boat:" + eElement.getElementsByTagName("boat").item(0).getTextContent());
					// System.out.println("Number of moves = " +
					// eElement.getElementsByTagName("numberOfMoves=").item(0).getTextContent());
					System.out.println("Boat at the left"
							+ eElement.getElementsByTagName("boatAtTheLeft").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
			System.out.println("fff");
		}
	}

}
