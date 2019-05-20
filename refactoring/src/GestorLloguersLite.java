import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorLloguersLite {

	public static void main(String[] args) {
		// construcció d'un client, amb el meu nom
		Client c1 = new Client("12334569-C", "Christian", "622454554");
		
		// construcció d'un vehicle de categoria BASIC
		Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);

		// construcció d'un lloguer amb una data
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		try {
			date = dateFormat.parse("3/8/2018");
		} catch (Exception e) {
			System.out.println("Error! Format incorrecte.");
		}
		Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);
		
		c1.afegeix(lloguerBasic);

		// formatat d'una data
		System.out.println(dateFormat.format(lloguerBasic.getData()));
		
		// crida mètode mostrar, on mostrarà totes les dades
		String informacio = mostrar(c1);
		System.out.println(informacio);
	}
	
	public static String mostrar(Client client) {
		String informacio = "";
		informacio += "Client: " + client.getNom() + "\n";
		informacio += "\t" + client.getNif() + "\n";
		informacio += "\t" + client.getTelefon() + "\n";
		informacio += "Lloguers: " + client.getLloguers().size() + "\n";
		for (int i = 0; i < client.getLloguers().size(); i++) {
			informacio += "\t" + (i+1) + ". vehicle: " + client.getLloguers().get(i).getVehicle().getMarca() + " " + client.getLloguers().get(i).getVehicle().getModel() + "\n";
			informacio += "\t   data d'inici: " + client.getLloguers().get(i).getData() + "\n";
			informacio += "\t   dies llogats: " + client.getLloguers().get(i).getDies() + "\n";
		}
		return informacio;
	}
}
