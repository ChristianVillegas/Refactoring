import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.*;

public class TestClient {
	@Test
	public void testClientInforme() {
		// comprova que el mètode informe() rebi i retorni les dades correctament
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		try {
			date = dateFormat.parse("3/8/2018");
		} catch (Exception e) {
			System.out.println("Error! Format incorrecte.");
		}
		Lloguer a1 = new Lloguer(date, 5, new Vehicle("Seat", "600", Vehicle.BASIC));
		Lloguer a2 = new Lloguer(date, 3, new Vehicle("Peugeot", "207", Vehicle.GENERAL));
		Lloguer a3 = new Lloguer(date, 7, new Vehicle("Ferrari", "550", Vehicle.LUXE));
		a.afegeix(a1);
		a.afegeix(a2);
		a.afegeix(a3);
		String docu = a.informe();
		String muestra = "Informe de lloguers del client Juan (12345678-J)\n" +
						 "\t600 Seat: 180.0€\n" +
						 "\t207 Peugeot: 195.0€\n" +
						 "\t550 Ferrari: 1260.0€\n" +
						 "Import a pagar: 1635.0€\n" +
						 "Punts guanyats: 4\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeBasic() throws ParseException {
		//Client amb un sol lloguer BASIC d'un dia
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		date = dateFormat.parse("3/8/2018");
		Lloguer a1 = new Lloguer(date, 1, new Vehicle("Seat", "600", Vehicle.BASIC));
		a.afegeix(a1);
		String docu = a.informe();
		String muestra = "Informe de lloguers del client Juan (12345678-J)\n" +
						 "\t600 Seat: 90.0€\n" +
						 "Import a pagar: 90.0€\n" +
						 "Punts guanyats: 1\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeBasicDies() throws ParseException {
		//Client amb un lloguer BASIC de 5 dies
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		date = dateFormat.parse("3/8/2018");
		Lloguer a1 = new Lloguer(date, 5, new Vehicle("Seat", "600", Vehicle.BASIC));
		a.afegeix(a1);
		String docu = a.informe();
		String muestra = "Informe de lloguers del client Juan (12345678-J)\n" +
						 "\t600 Seat: 180.0€\n" +
						 "Import a pagar: 180.0€\n" +
						 "Punts guanyats: 1\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeGeneral() throws ParseException {
		//Client amb un sol lloguer GENERAL d'un dia
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		date = dateFormat.parse("3/8/2018");
		Lloguer a1 = new Lloguer(date, 1, new Vehicle("Peugeot", "207", Vehicle.GENERAL));
		a.afegeix(a1);
		String docu = a.informe();
		String muestra = "Informe de lloguers del client Juan (12345678-J)\n" +
						 "\t207 Peugeot: 120.0€\n" +
						 "Import a pagar: 120.0€\n" +
						 "Punts guanyats: 1\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeGeneralDies() throws ParseException {
		//Client amb un sol lloguer GENERAL de 5 dies
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		date = dateFormat.parse("3/8/2018");
		Lloguer a1 = new Lloguer(date, 5, new Vehicle("Peugeot", "207", Vehicle.GENERAL));
		a.afegeix(a1);
		String docu = a.informe();
		String muestra = "Informe de lloguers del client Juan (12345678-J)\n" +
						 "\t207 Peugeot: 345.0€\n" +
						 "Import a pagar: 345.0€\n" +
						 "Punts guanyats: 1\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeLuxe() throws ParseException {
		//Client amb un sol lloguer LUXE d'un dia 
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		date = dateFormat.parse("3/8/2018");
		Lloguer a1 = new Lloguer(date, 1, new Vehicle("Ferrari", "550", Vehicle.LUXE));
		a.afegeix(a1);
		String docu = a.informe();
		String muestra = "Informe de lloguers del client Juan (12345678-J)\n" +
						 "\t550 Ferrari: 180.0€\n" +
						 "Import a pagar: 180.0€\n" +
						 "Punts guanyats: 1\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeLuxeDies() throws ParseException {
		//Client amb un sol lloguer LUXE de 12 dies
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		date = dateFormat.parse("3/8/2018");
		Lloguer a1 = new Lloguer(date, 12, new Vehicle("Ferrari", "550", Vehicle.LUXE));
		a.afegeix(a1);
		String docu = a.informe();
		String muestra = "Informe de lloguers del client Juan (12345678-J)\n" +
						 "\t550 Ferrari: 2160.0€\n" +
						 "Import a pagar: 2160.0€\n" +
						 "Punts guanyats: 2\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientSenseLloguer() {
		//Client sense lloguers
		Client a = new Client ("12345678-J", "Juan", "625879632");
		String docu = a.informe();
		String muestra = "Informe de lloguers del client Juan (12345678-J)\n" +
						 "Import a pagar: 0.0€\n" +
						 "Punts guanyats: 0\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeHTML() {
		// comprova que el mètode informe() rebi i retorni les dades correctament
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		try {
			date = dateFormat.parse("3/8/2018");
		} catch (Exception e) {
			System.out.println("Error! Format incorrecte.");
		}
		Lloguer a1 = new Lloguer(date, 5, new Vehicle("Seat", "600", Vehicle.BASIC));
		Lloguer a2 = new Lloguer(date, 3, new Vehicle("Peugeot", "207", Vehicle.GENERAL));
		Lloguer a3 = new Lloguer(date, 7, new Vehicle("Ferrari", "550", Vehicle.LUXE));
		a.afegeix(a1);
		a.afegeix(a2);
		a.afegeix(a3);
		String docu = a.informeHTML();
		String muestra = "<h1>Informe de lloguers</h1>\n" +
						 "<p>Informe de lloguers del client <em>Juan</em> (<strong>12345678-J</strong>)</p>\n" +
						 "<table>\n<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>" +
						 "<tr><td>600</td><td>Seat</td><td>180.0€</td></tr>\n" +
						 "<tr><td>207</td><td>Peugeot</td><td>195.0€</td></tr>\n" +
						 "<tr><td>550</td><td>Ferrari</td><td>1260.0€</td></tr>\n" +
						 "</table>\n" +
						 "<p>Import a pagar: <em>1635.0€</em></p>\n" +
						 "<p>Punts guanyats: <em>4</em></p>\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeBasicHTML() throws ParseException {
		//Client amb un sol lloguer BASIC d'un dia
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		date = dateFormat.parse("3/8/2018");
		Lloguer a1 = new Lloguer(date, 1, new Vehicle("Seat", "600", Vehicle.BASIC));
		a.afegeix(a1);
		String docu = a.informeHTML();
		String muestra = "<h1>Informe de lloguers</h1>\n" +
				 "<p>Informe de lloguers del client <em>Juan</em> (<strong>12345678-J</strong>)</p>\n" +
				 "<table>\n<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>" +
				 "<tr><td>600</td><td>Seat</td><td>90.0€</td></tr>\n" +
				 "</table>\n" +
				 "<p>Import a pagar: <em>90.0€</em></p>\n" +
				 "<p>Punts guanyats: <em>1</em></p>\n";
				
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeBasicDiesHTML() throws ParseException {
		//Client amb un lloguer BASIC de 5 dies
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		date = dateFormat.parse("3/8/2018");
		Lloguer a1 = new Lloguer(date, 5, new Vehicle("Seat", "600", Vehicle.BASIC));
		a.afegeix(a1);
		String docu = a.informeHTML();
		String muestra = "<h1>Informe de lloguers</h1>\n" +
				 "<p>Informe de lloguers del client <em>Juan</em> (<strong>12345678-J</strong>)</p>\n" +
				 "<table>\n<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>" +
				 "<tr><td>600</td><td>Seat</td><td>180.0€</td></tr>\n" +
				 "</table>\n" +
				 "<p>Import a pagar: <em>180.0€</em></p>\n" +
				 "<p>Punts guanyats: <em>1</em></p>\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeGeneralHTML() throws ParseException {
		//Client amb un sol lloguer GENERAL d'un dia
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		date = dateFormat.parse("3/8/2018");
		Lloguer a1 = new Lloguer(date, 1, new Vehicle("Peugeot", "207", Vehicle.GENERAL));
		a.afegeix(a1);
		String docu = a.informeHTML();
		String muestra = "<h1>Informe de lloguers</h1>\n" +
				 "<p>Informe de lloguers del client <em>Juan</em> (<strong>12345678-J</strong>)</p>\n" +
				 "<table>\n<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>" +
				 "<tr><td>207</td><td>Peugeot</td><td>120.0€</td></tr>\n" +
				 "</table>\n" +
				 "<p>Import a pagar: <em>120.0€</em></p>\n" +
				 "<p>Punts guanyats: <em>1</em></p>\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeGeneralDiesHTML() throws ParseException {
		//Client amb un sol lloguer GENERAL de 5 dies
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		date = dateFormat.parse("3/8/2018");
		Lloguer a1 = new Lloguer(date, 5, new Vehicle("Peugeot", "207", Vehicle.GENERAL));
		a.afegeix(a1);
		String docu = a.informeHTML();
		String muestra = "<h1>Informe de lloguers</h1>\n" +
				 "<p>Informe de lloguers del client <em>Juan</em> (<strong>12345678-J</strong>)</p>\n" +
				 "<table>\n<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>" +
				 "<tr><td>207</td><td>Peugeot</td><td>345.0€</td></tr>\n" +
				 "</table>\n" +
				 "<p>Import a pagar: <em>345.0€</em></p>\n" +
				 "<p>Punts guanyats: <em>1</em></p>\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeLuxeHTML() throws ParseException {
		//Client amb un sol lloguer LUXE d'un dia 
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		date = dateFormat.parse("3/8/2018");
		Lloguer a1 = new Lloguer(date, 1, new Vehicle("Ferrari", "550", Vehicle.LUXE));
		a.afegeix(a1);
		String docu = a.informeHTML();
		String muestra = "<h1>Informe de lloguers</h1>\n" +
				 "<p>Informe de lloguers del client <em>Juan</em> (<strong>12345678-J</strong>)</p>\n" +
				 "<table>\n<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>" +
				 "<tr><td>550</td><td>Ferrari</td><td>180.0€</td></tr>\n" +
				 "</table>\n" +
				 "<p>Import a pagar: <em>180.0€</em></p>\n" +
				 "<p>Punts guanyats: <em>1</em></p>\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientInformeLuxeDiesHTML() throws ParseException {
		//Client amb un sol lloguer LUXE de 12 dies
		Client a = new Client ("12345678-J", "Juan", "625879632");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = null;
		date = dateFormat.parse("3/8/2018");
		Lloguer a1 = new Lloguer(date, 12, new Vehicle("Ferrari", "550", Vehicle.LUXE));
		a.afegeix(a1);
		String docu = a.informeHTML();
		String muestra = "<h1>Informe de lloguers</h1>\n" +
				 "<p>Informe de lloguers del client <em>Juan</em> (<strong>12345678-J</strong>)</p>\n" +
				 "<table>\n<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>" +
				 "<tr><td>550</td><td>Ferrari</td><td>2160.0€</td></tr>\n" +
				 "</table>\n" +
				 "<p>Import a pagar: <em>2160.0€</em></p>\n" +
				 "<p>Punts guanyats: <em>2</em></p>\n";
		Assert.assertEquals(muestra, docu);
	}
	
	@Test
	public void testClientSenseLloguerHTML() {
		//Client sense lloguers
		Client a = new Client ("12345678-J", "Juan", "625879632");
		String docu = a.informeHTML();
		String muestra = "<h1>Informe de lloguers</h1>\n" +
				 "<p>Informe de lloguers del client <em>Juan</em> (<strong>12345678-J</strong>)</p>\n" +
				 "<table>\n<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>" +
				 "</table>\n" +
				 "<p>Import a pagar: <em>0.0€</em></p>\n" +
				 "<p>Punts guanyats: <em>0</em></p>\n";
		Assert.assertEquals(muestra, docu);
	}
}
