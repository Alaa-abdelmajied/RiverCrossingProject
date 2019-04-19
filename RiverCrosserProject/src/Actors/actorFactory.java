package Actors;

public class actorFactory {
	public ICrosser getcrosser (String crosserType) {
		if(crosserType==null)
			return null;
		if(crosserType.equalsIgnoreCase("farmer"))
			return new Farmer();
		else if (crosserType.equalsIgnoreCase("animal"))
			return new Animal();
		else if (crosserType.equalsIgnoreCase("plant"))
			return new Plant ();
		return null;
	}

}
