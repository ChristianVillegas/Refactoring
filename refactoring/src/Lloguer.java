import java.util.Date;

public class Lloguer {
	private Date data;
	private int dies;
	private Vehicle vehicle;
	private static final int UNITAT_DE_COST_BASIC = 3;
	private static final int PREU_DIES_INICIAL_BASIC = 3;
	private static final double INCREMENT_BASIC = 1.5;
	private static final int UNITAT_DE_COST_GENERAL = 4;
	private static final int PREU_DIES_INICIAL_GENERAL = 2;
	private static final double INCREMENT_GENERAL = 2.5;
	private static final int UNITAT_DE_COST_LUXE = 6;
	
	public Lloguer(Date data, int dies, Vehicle vehicle) {
		this.data = data;
		this.dies = dies;
		this.vehicle = vehicle;
	}
	
	public Date getData()		{ return data;	}
	public int getDies()		{ return dies;  }
	public Vehicle getVehicle()		{ return vehicle; }
	
	public void setData(Date data) { this.data = data; }
	public void setDies(int dies) { this.dies = dies; }
	public void setVehiche(Vehicle vehicle) { this.vehicle = vehicle; }

	 public double cost() {
		 //Com que aquest mètode calcula el cost del lloguer del vehicle, he cambiat la variable quantitat per cost (que crec que és més representatiu)
	    	double cost = 0;
	    	
	    	switch (vehicle.getCategoria()) {
	        case Vehicle.BASIC:
	            cost += UNITAT_DE_COST_BASIC;
	            if (dies > PREU_DIES_INICIAL_BASIC) {
	                cost += (dies - PREU_DIES_INICIAL_BASIC) * INCREMENT_BASIC;
	            }
	            break;
	        case Vehicle.GENERAL:
	            cost += UNITAT_DE_COST_GENERAL;
	            if (dies > PREU_DIES_INICIAL_GENERAL) {
	                cost += (dies - PREU_DIES_INICIAL_GENERAL) * INCREMENT_GENERAL;
	            }
	            break;
	        case Vehicle.LUXE:
	            cost += dies * UNITAT_DE_COST_LUXE;
	            break;  
	    	}
	    	return cost;
	    }
	 
	 public int bonificacions() {
	    int bonificacions = 1;
	    if (vehicle.getCategoria() == Vehicle.LUXE &&
	    	dies > 1 ) {
	        bonificacions ++;
	    }
	    return bonificacions;
	}
}
