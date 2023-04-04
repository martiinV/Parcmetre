package atelier.atelierTDD;
import java.time.LocalDateTime;

public class Ticket {
	
	private Voiture voiture;
	private Double sommePayee;
	private LocalDateTime dateSortie;
	private LocalDateTime dateEntree;
	private String texteTicket;
	
	public Ticket(Voiture voiture, Double sommePayee, IHorloge dateEntree) {
		this.voiture = voiture;
		this.sommePayee = sommePayee;
		this.dateEntree = dateEntree.maintenant();
	}
	
	public Voiture getVoiture() {
		return voiture;
	}
	
	public String getTexte() {
		return texteTicket;
	}
	
	public LocalDateTime getDateSortie() {
		return dateSortie;
	}
	
	public LocalDateTime getDateEntree() {
		return dateEntree;
	}
	
	public void setTexte(String s) {
		texteTicket = s;
	}
	
	public double getSommePaye() {
		return sommePayee;
	}

	public void setDateSortie(LocalDateTime dateSortie) {
		this.dateSortie = dateSortie;
		
	}
}
