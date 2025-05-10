// The class Barrel is the subclass of HeavyContainer and inherits all the attributes of Container class

public class Barrel extends HeavyContainer {

	// Creating the constructor of Barrel class
    public Barrel(int containerID, int weight) {
    	super(containerID, weight);
    	this.consumptionPerKiloPerKm = 27;
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

	@Override
	public double calculateFuelConsumption(double travelDistance) {
		
		return (this.consumptionPerKiloPerKm * travelDistance * (this.weight/1000));
	}
	
}
