import java.util.Date;

public class Lloguer {
	private Date data;
	private int dies;
	private Vehicle vehicle;
	
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

	 public double quantitat() {
		 //Amb aquest mètode no agafa el paràmetre lloguer perqué ja ens trobem a la classe 'Lloguer' i només ha d'agafar els seus atributs
	    	double quantitat = 0;
	    	
	    	switch (vehicle.getCategoria()) {
	        case Vehicle.BASIC:
	            quantitat += 3;
	            if (dies > 3) {
	                quantitat += (dies - 3) * 1.5;
	            }
	            break;
	        case Vehicle.GENERAL:
	            quantitat += 4;
	            if (dies > 2) {
	                quantitat += (dies - 2) * 2.5;
	            }
	            break;
	        case Vehicle.LUXE:
	            quantitat += dies * 6;
	            break;  
	    	}
	    	return quantitat;
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
