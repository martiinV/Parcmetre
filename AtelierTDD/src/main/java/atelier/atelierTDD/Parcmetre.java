package atelier.atelierTDD;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

public class Parcmetre {

	private static final int ONE_HOUR = 60;

	public Ticket creationTicket(Voiture voiture, Double sommePayee, IHorloge dateEntree) {
		Ticket ticket = new Ticket(voiture, sommePayee, dateEntree);
		calculerDateSortie(ticket);
		return ticket;
	}



	public void calculerTempsRestant(Ticket ticket) {
		int minuteAjoutee = 0;
		double sommeRestante = ticket.getSommePaye();
		if(sommeRestante > 14) {
			sommeRestante = 14;
		}
		if(sommeRestante > 0.5) {
			if(sommeRestante > 2) {
				minuteAjoutee += ONE_HOUR * 4;
				sommeRestante = sommeRestante - 2;	
				int x = (int) ((sommeRestante) / 0.05);	
				minuteAjoutee += x;
			} else {
				for(;sommeRestante >= 0.5; sommeRestante -= 0.5) {
					minuteAjoutee += ONE_HOUR;
				}
			}
		}
		LocalDateTime dateSortie = ticket.getDateEntree();
		dateSortie = dateSortie.plusMinutes(minuteAjoutee);
		if(dateSortie.getHour() >= 19) {
			ticket.setTexte("Vous pouvez rester jusqu'à la fin de la journée");
			dateSortie = LocalDateTime.of(dateSortie.getYear(), dateSortie.getMonth(),dateSortie.getDayOfMonth(), 19, 0, 0);
		} else {
			ticket.setTexte("Vous pouvez rester jusqu'à "+dateSortie.getHour());
		}
		ticket.setDateSortie(dateSortie);
	}

	public void calculerDateSortie(Ticket ticket) {
		LocalDateTime dateEntree = ticket.getDateEntree();
		if(dateEntree.getDayOfWeek() == DayOfWeek.SUNDAY) {
			ticket.setTexte("C'est le week-end, pas besoin de payer");
		} else if (dateEntree.getMonth() == Month.AUGUST && dateEntree.getDayOfMonth() <= 14) {
			ticket.setTexte("C'est les vacances du 1 au 14 aout, pas besoin de payer");
		} else {
			calculerTempsRestant(ticket);
		}
	}

}
