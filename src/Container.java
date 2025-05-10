// Mother abstract class that will be inherited by its children

public abstract class Container {
    
    protected int containerID;
    protected int weight;
    protected int consumptionPerKiloPerKm; // does not have a setter as its value is final // only a getter is applied to get the value of consumption of each container

    
    // Crating the constructor for the abstract class Container
    public Container(int containerID, int weight) {
    	this.containerID = containerID;
    	this.weight = weight;
  
    }
    
    
    //Creating getters for the abstract class
    public abstract int getWeigth();
    public abstract int getContainerID();
    public abstract int getConsumptionPerKiloPerKm();
    
    //Creating setters for the abstract class
    public abstract void setContainerID(int containerID);
    public abstract void setWeigth(int weight);
    
    
    // abstract class to calculate the fuel that the ship needs to travel between ports with the loaded containers
    public abstract double calculateFuelConsumption(double travelDistance);

    

}
