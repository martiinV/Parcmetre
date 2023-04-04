package atelier.atelierTDD;


public class App 
{
    public static void main( String[] args )
    {
        Voiture v = new Voiture("AX-141-XD");
        System.out.println(v.getPlaqueImmatriculation());
        Ticket ticket = new Ticket(v, 4.0, null);
        Imprimante impr = new Imprimante();
        System.out.println(impr.imprimer(ticket));
    }
}
