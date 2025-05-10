// The class fridge is the subclass of Container and inherits all the attributes of Container class


public class LightContainer extends Container {
	
	// Creating the constructor of LightContainer class 
	public LightContainer(int containerID, int weight) {
		
        super(containerID, weight);
		this.consumptionPerKiloPerKm = 20; // intializing the value of the consumption that Fridge container needs
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

	// calculating the fuel that the ship needs carrying LightContainers
	@Override
	public double calculateFuelConsumption(double travelDistance) {
		return (this.consumptionPerKiloPerKm * travelDistance * (this.weight/1000));
	}

    





    
}
