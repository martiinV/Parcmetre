package atelier.AtelierTDD;

import java.time.LocalDateTime;
import java.util.Date;

import atelier.atelierTDD.IHorloge;

public class FausseHorloge implements IHorloge {
	
	private LocalDateTime dateEntree;
	
	public FausseHorloge(LocalDateTime dateEntree) {
		this.dateEntree = dateEntree;
	}

	@Override
	public LocalDateTime maintenant() {
		return dateEntree;
	}

}
