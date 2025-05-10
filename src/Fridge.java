// The class fridge is the subclass of HeavyContainer and inherits all the attributes of Container class

public class Fridge extends HeavyContainer {

	// Creating the constructor of Fridge class
	public Fridge(int containerID, int weight) {
		super(containerID, weight);
		this.consumptionPerKiloPerKm = 35;  // intializing the value of the consumption that Fridge container needs
	}
	
	//Creating Setters and Getters
	
	@Override
	public int getWeigth() {
		return weight;
	}

	@Override
	public int getContainerID() {
		return containerID;
	}

	@Override
	public int getConsumptionPerKiloPerKm() { 		
		return consumptionPerKiloPerKm;
	}

	@Override
	public void setContainerID(int containerID) {
		this.containerID = containerID;
		
	}

	@Override
	public void setWeigth(int weight) {
		this.weight = weight;
		
	}

	
	// calculating the fuel that the sheep needs carrying Fridges 
	@Override
	public double calculateFuelConsumption(double travelDistance) {
		
		return (this.consumptionPerKiloPerKm * travelDistance * (this.weight/1000));
	}
 
}
