
public class GestorLloguersLite {

	public static void main(String[] args) {
		// construcció d'un client, amb el meu nom
		Client c1 = new Client("12334569-C", "Christian", "622454554");
		
		// construcció d'un vehicle de categoria BASIC
		Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);

		// construccuó d'un lloguer amb una data
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = dateFormat.parse("2/8/2013");
		Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);

		// formatat d'una data
		System.out.println(dateFormat.format(lloguerBasic.getData()));
		
		public static String mostrar(Client c1, Lloguer) {
			return System.out.println("Client: " + client.c1 + "Lloguers: " + Lloguer);
		}

	}

}
