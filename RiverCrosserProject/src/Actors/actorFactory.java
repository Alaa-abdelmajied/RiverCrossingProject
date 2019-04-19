package Actors;

public class actorFactory {
	public ICrosser getcrosser (String crosserType) {
		if(crosserType==null)
			return null;
		if(crosserType.equalsIgnoreCase("farmer"))
			return new Farmer();
		else if (crosserType.equalsIgnoreCase("Herbivorous"))
			return new Herbivorous();
		else if(crosserType.equalsIgnoreCase("carnivorous"))
			return new Carnivorous();
		
		else if (crosserType.equalsIgnoreCase("plant"))
			return new Plant ();
		return null;
	}

}