package atelier.atelierTDD;

public class Imprimante {

	public String imprimer(Ticket ticket) {
		return "impression du ticket \n"+ticket.getTexte()+"\nBonne soirée";
	}
}
