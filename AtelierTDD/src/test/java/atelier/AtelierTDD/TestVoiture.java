package atelier.AtelierTDD;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import atelier.atelierTDD.IHorloge;
import atelier.atelierTDD.Imprimante;
import atelier.atelierTDD.Parcmetre;
import atelier.atelierTDD.Ticket;
import atelier.atelierTDD.Voiture;

public class TestVoiture {
	
	private Voiture voiture;
	private Ticket ticket;

	@Before
	public void setUp() throws Exception {
		voiture = new Voiture("AX-451-NB");
		LocalDateTime date = LocalDateTime.of(2020, 3, 15, 14, 23, 46);
		IHorloge horlogeDeTest = new FausseHorloge(date);
		Parcmetre p = new Parcmetre();
		ticket = p.creationTicket(voiture, 1.0, horlogeDeTest);
	}

	@After
	public void tearDown() throws Exception {
		voiture = null;
		ticket = null;
	}

	@Test
	public void testPlaqueImmatriculation() {
		assertEquals(9, voiture.getPlaqueImmatriculation().length());;
	}
	
	@Test
	public void testImprimante() {
		Imprimante impr = new Imprimante();
		assertNotNull(impr.imprimer(ticket));
	}

}
