import java.util.Vector;

public class Client {
    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers;
    private static final double EUROS_PER_UNITAT_DE_COST = 30;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }
    public Vector<Lloguer> getLloguers() { return lloguers; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }
    
    public String informe() {
    	    return composaCapçalera() +
    	    		composaDetall() +
    	    		composaPeu();
    	}
    
    public String informeHTML() {
    	return composaCapçaleraHTML() +
	    		composaDetallHTML() +
	    		composaPeuHTML();
    }
    
    public double importTotal() {
    	double total = 0;
    	for (Lloguer lloguer: lloguers) {
    		total += lloguer.cost() * EUROS_PER_UNITAT_DE_COST;
    	}
    	return total;
    }
    
    public int bonificacionsTotals() {
    	int bonificacions = 0;
    	for (Lloguer lloguer: lloguers) {
    		bonificacions += lloguer.bonificacions();
    	}
    	return bonificacions;
    }
    
    public String composaCapçalera() {
    	String resultat = "Informe de lloguers del client " +
    	        getNom() +
    	        " (" + getNif() + ")\n";
    	return resultat;
    }
    
    public String composaCapçaleraHTML() {
    	String resultat = "<h1>Informe de lloguers</h1>\n" +
    					  "<p>Informe de lloguers del client <em>" +
    	        getNom() +
    	        "</em> (<strong>" + getNif() + "</strong>)</p>\n";
    	return resultat;
    }
    
    public String composaDetall() {
    	String resultat = "";
    	for (Lloguer lloguer: lloguers) {
	        resultat += "\t" +
	            lloguer.getVehicle().getMarca() +
	            " " +
	            lloguer.getVehicle().getModel() + ": " +
	            (lloguer.cost() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
	    }
    	return resultat;
    }
    
    public String composaDetallHTML() {
    	String resultat = "<table>\n<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>";
    	for (Lloguer lloguer: lloguers) {
	        resultat += "<tr><td>" +
	            lloguer.getVehicle().getMarca() +
	            "</td><td>" +
	            lloguer.getVehicle().getModel() + "</td><td>" +
	            (lloguer.cost() * EUROS_PER_UNITAT_DE_COST) + "€" + "</td></tr>\n";
	    }
    	resultat += "</table>\n";
    	return resultat;
    }
    
    public String composaPeu() {
	    String resultat = "Import a pagar: " + importTotal() + "€\n" +
	        "Punts guanyats: " + bonificacionsTotals() + "\n";
	    return resultat;
    }
    
    public String composaPeuHTML() {
	    String resultat = "<p>Import a pagar: <em>" + importTotal() + "€</em></p>\n" +
	        "<p>Punts guanyats: <em>" + bonificacionsTotals() + "</em></p>\n";
	    return resultat;
    }
}