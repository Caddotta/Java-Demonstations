package assignment_8;

public class car 
{
	private String make;
	private String model;
	private int year;
	private double MPG;
	private double milesDriven;
	private double fuelCapacity;
	private double fuelRemaining;
	
	public car(String make, String model, int year, double MPG, double fuelCapacity, double fuelRemaining){
		this.make = make;
		this.model = model;
		this.year = year;
		this.MPG = MPG;
		this.fuelCapacity = fuelCapacity;
		this.fuelRemaining = fuelRemaining;
		}
	
	public String getMake() {
		return this.make;
		}
	public String getModel() {
		return this.model;
		}
	public int getYear() {
		return this.year;
	}
	public double getMPG() {
		return this.MPG;
	}
	public double getMilesDriven() {
		return this.milesDriven;
	}
	public double getFuelCapacity() {
		return this.fuelCapacity;
	}
	public double fillTank(double g) {
		if (g + this.fuelRemaining <= this.fuelCapacity) {
			this.fuelRemaining+=g;
		}else{
			this.fuelRemaining=this.fuelCapacity;
		}
		return this.fuelRemaining;
	}
	public double drive(double m) {
		this.milesDriven += m;
		this.fuelRemaining -= (m/this.MPG);
		return(this.milesDriven);
	}
	public String toString(){
		return "Make: "+make+"\nmodel: "+model+"\nyear: "+year+"\nMPG: "+MPG+"\nMiles driven: "+milesDriven+" \n"
				+ "Fuel Capacity: "+fuelCapacity+" \nFuel Remaining: "+fuelRemaining;
	}
	public double getFuelRemaining() {
		return fuelRemaining;
	}
}
