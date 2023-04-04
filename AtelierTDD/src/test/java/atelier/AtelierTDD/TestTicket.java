package atelier.AtelierTDD;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import atelier.atelierTDD.IHorloge;
import atelier.atelierTDD.Imprimante;
import atelier.atelierTDD.Parcmetre;
import atelier.atelierTDD.Ticket;
import atelier.atelierTDD.Voiture;

public class TestTicket {
	
	private Ticket ticket;
	private Parcmetre p;

	@Before
	public void setUp() throws Exception {
		p = new Parcmetre();
		LocalDateTime date = LocalDateTime.of(2023, 3, 15, 14, 23, 46);
		IHorloge horlogeDeTest = new FausseHorloge(date);
		Voiture v = new Voiture("AX-141-XD");
		ticket = p.creationTicket(v, 4.0, horlogeDeTest);
	}

	@After
	public void tearDown() throws Exception {
		ticket = null;
		p = null;
	}

	@Test
	public void testImprimante() {
		Imprimante impr = new Imprimante();
		assertNotNull(impr.imprimer(ticket));
	}
	
	@Test
	public void dateEntree() {
		LocalDateTime date = LocalDateTime.of(2023, 3, 15, 14, 23, 46, 00);
		assertEquals(date, ticket.getDateEntree());		
	}
	
	@Test
	public void dateSortiePlusDe19Heure() {
		LocalDateTime date = LocalDateTime.of(2023, 3, 15, 19, 00, 00);
		assertEquals(date, ticket.getDateSortie());
		Imprimante impr = new Imprimante();
		String texte = "impression du ticket \nVous pouvez rester jusqu'à la fin de la journée\nBonne soirée";
		assertEquals(texte, impr.imprimer(ticket));
	}
	
	@Test
	public void dateSortieMoinsDe19Heure() {
		LocalDateTime date = LocalDateTime.of(2023, 3, 15, 13, 00, 00, 00);
		IHorloge horlogeDeTest = new FausseHorloge(date);
		Voiture v = new Voiture("AX-141-XD");
		ticket = p.creationTicket(v, 2.0, horlogeDeTest);
		date = LocalDateTime.of(2023, 3, 15, 17, 00, 00, 00);
		assertEquals(date, ticket.getDateSortie());
	}
	
	@Test
	public void testDimanche() {	
		LocalDateTime date = LocalDateTime.of(2023, 2, 26, 13, 00, 00, 00);
		IHorloge horlogeDeTest = new FausseHorloge(date);
		Voiture v = new Voiture("AX-141-XD");
		ticket = p.creationTicket(v, 2.0, horlogeDeTest);
		Imprimante impr = new Imprimante();
		String texte = "impression du ticket \nC'est le week-end, pas besoin de payer\nBonne soirée";
		assertEquals(texte, impr.imprimer(ticket));
	}
	
	@Test
	public void testVacances() {
		LocalDateTime date = LocalDateTime.of(2023, 8, 10, 13, 00, 00, 00);
		IHorloge horlogeDeTest = new FausseHorloge(date);
		Voiture v = new Voiture("AX-141-XD");
		ticket = p.creationTicket(v, 2.0, horlogeDeTest);
		Imprimante impr = new Imprimante();
		String texte = "impression du ticket \nC'est les vacances du 1 au 14 aout, pas besoin de payer\nBonne soirée";
		assertEquals(texte, impr.imprimer(ticket));
	}

}
