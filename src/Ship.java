// Ship Class

import java.util.ArrayList;

public class Ship {
	
	
	// Declaring class attributes -- All private to ensure encapsulation
	private int shipID;						// ship's ID
	private String name;					// the name of the ship
	private double consumptionPerKm;		// the consumption that the ship has every KM
	
	private int maxContainersWeigth;		// how much is the max weight of containers the ship can carry	
	private int currentContainersWeight;	// the current max weight of containers loaded in the ship -> in order to make a comparison between the maxValue	
	
	private int maxContainersQuantity; 		// how many are the max containers the ship can carry
	private int currentContainersQuantity;	// the current container loaded in the ship -> in order to make a comparison between the maxValue
	
	private int maxHeavyContainersQuantity;	// how many are the max heavy containers the ship can carry
	private int currentHeavyContainers;		// the current max containers the ship can carry
	
	private int currentPort;				// the port that the ship is -> it will be a number between 1 and 5 that will point to a port
	private double currentFuel;				// the fuel that the ship is loaded with
	private ArrayList<Container> containersLoaded = new ArrayList<>();	// the containers that the ship is loaded with
	
	
	// Declaring the constructor with its parameters
	
	public Ship(int shipID, String name, double consumptionPerKm, int maxContainersWeigth, int maxContainersQuantity  ,int maxHeavyContainersQuantity, int currentPort ) {
        
        // setting the values inside the costructor

        this.shipID = shipID;											           
		this.name = name;
		this.consumptionPerKm = consumptionPerKm;
		this.maxContainersWeigth = maxContainersWeigth;
		this.maxContainersQuantity = maxContainersQuantity;
		this.maxHeavyContainersQuantity = maxHeavyContainersQuantity;
		this.currentPort = currentPort; 
        this.currentFuel = 0.0;                                               // initializing the currentFuel to zero as the ship has no fuel loaded at first
        this.containersLoaded.clear();                                      // initializing the containersLoaded to zero as the ship has no containers loaded at first  
		this.currentContainersWeight = 0;                                   // initializing the currentContainersWeight to zero as the ship has no containers loaded at first  
		this.currentContainersQuantity = 0;                                 // initializing the currentContainersQuantity to zero as the ship has no containers loaded at first  
		this.currentHeavyContainers = 0;                                    // initializing the currentHeavyContainers to zero as the ship has no containers loaded at first  
		
		
	}
	
	// Method to addContainer into the ship
	public void addContainer(Container container){
		containersLoaded.add(container);
	}

	// Method to removeContainer from the ship
	public void removeContainer(Container container){
		containersLoaded.remove(container);
	}
	
	// Method to calculate how much fuel is needed
	public double fuelCalculation(double distanceTraveled){
		
		double containersTotalConsumption = 0;
		for(int i=0; i<this.containersLoaded.size();i++) {
			containersTotalConsumption += containersLoaded.get(i).calculateFuelConsumption(distanceTraveled);	// every container calculate on its own how much fuel it needs
		}
		
		return this.getConsumptionPerKm()*distanceTraveled + containersTotalConsumption;	// finally all the containers fuel needed is counted and is summed in the consumption the ship needs to travel by its own
	}
	
	// Method to load the necessary fuel into the ship -- takes as parameter what the calculation will be from the method: fuelCalculation
    public void loadFuel(double fuelNeeded){
        this.setCurrentFuel(fuelNeeded);
    }
	
	//Method to remove fuel from the ship 
    public void removeFuel(double fuelConsumed){
        this.setCurrentFuel(this.getCurrentFuel() - fuelConsumed);
    }
	
	//toString method 
	@Override
	public String toString(){
		String strFormat = ("ID: %d \tName: %s \tContainersCarried: %d,\nContainersWeight: %d\tHeavy Containers Carried %d");
		return String.format(strFormat,getshipID(),getName(),getCurrentContainersQuantity(),getCurrentContainersWeight(),getCurrentHeavyContainers());
	}



	// Creating Setters and Getter for every Attribute
	public int getshipID() {
		return shipID;
	}
	public void setID(int shipID) {
		this.shipID = shipID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getConsumptionPerKm() {
		return consumptionPerKm;
	}
	public void setConsumptionPerKm(double consumptionPerKm) {
		this.consumptionPerKm = consumptionPerKm;
	}
	public int getCurrentPort() {
		return currentPort;
	}
	public void setCurrentPort(int currentPort) {
		this.currentPort = currentPort;
	}
	public double getCurrentFuel() {
		return currentFuel;
	}
	public void setCurrentFuel(double currentFuel) {
		this.currentFuel = currentFuel;
	}
	public int getMaxContainersWeigth() {
		return maxContainersWeigth;
	}
	public void setMaxContainersWeigth(int maxContainersWeigth) {
		this.maxContainersWeigth = maxContainersWeigth;
	}
	public int getMaxContainersQuantity() {
		return maxContainersQuantity;
	}
	public void setMaxContainersQuantity(int maxContainersQuantity) {
		this.maxContainersQuantity = maxContainersQuantity;
	}
	public int getMaxHeavyContainersQuantity() {
		return maxHeavyContainersQuantity;
	}
	public void setMaxHeavyContainersQuantity(int maxHeavyContainersQuantity) {
		this.maxHeavyContainersQuantity = maxHeavyContainersQuantity;
	}
	public int getCurrentContainersWeight() {
		return currentContainersWeight;
	}
	public void setCurrentContainersWeight(int currentContainersWeight) {
		this.currentContainersWeight = currentContainersWeight;
	}
	public int getCurrentContainersQuantity() {
		return currentContainersQuantity;
	}
	public void setCurrentContainersQuantity(int currentContainersQuantity) {
		this.currentContainersQuantity = currentContainersQuantity;
	}
	public int getCurrentHeavyContainers() {
		return currentHeavyContainers;
	}
	public void setCurrentHeavyContainers(int currentHeavyContainers) {
		this.currentHeavyContainers = currentHeavyContainers;
	}
	public ArrayList<Container> getContainersLoaded() {
		return containersLoaded;
	}
	public void setContainerArray(ArrayList<Container> containerArray) {
		this.containersLoaded = containerArray;
	}
	
	
}
