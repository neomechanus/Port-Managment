// HeavyContainer is a Subclass of Container & Heavy Container have two children 
// 1. Fridge || 2. Barrel

// Creating the abstract constructor of abstract class HeavyContainer
public abstract class HeavyContainer extends Container {

    public HeavyContainer(int containerID, int weight) { 
    	super(containerID, weight);
    	
    }
    
    
    //Creating getters for the abstract class
    public abstract int getWeigth();
    public abstract int getContainerID();
    public abstract int getConsumptionPerKiloPerKm();
    
    //Creating setters for the abstract class
    public abstract void setContainerID(int containerID);
    public abstract void setWeigth(int weight);
    
    
    // Declaring the abstract method to calculate the fuel that the ship needs to travel between ports with the heavyContainers loaded 
    public abstract double calculateFuelConsumption(double travelDistance); // it gets the travelDistance parameter that the ship needs to travel that we will get from port method distanceCalculator
    

}
