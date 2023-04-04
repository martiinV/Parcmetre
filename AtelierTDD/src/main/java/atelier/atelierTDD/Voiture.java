package atelier.atelierTDD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Voiture {
	
	private  String plaqueImmatriculation = "";
	
	public Voiture(String plaqueImma) throws IllegalArgumentException{
		if(!isPlaqueValid(plaqueImma)) {
			throw new IllegalArgumentException("Plaque non valide");
		}
		plaqueImmatriculation = plaqueImma;
	}
	
	public String getPlaqueImmatriculation() {
		return plaqueImmatriculation;
	}
	
	public boolean isPlaqueValid(String plaqueImma) {
		Pattern p = Pattern.compile("^[A-Z]{2}-\\d{3}-[A-Z]{2}$");
		Matcher m = p.matcher(plaqueImma);
		return m.find();
	}

}
