import java.util.ArrayList;
import java.util.Iterator;

public class Port {

    //Declaring class attributes == All private to ensure encapsulation
    
    private int portID;                   // port's ID
	private String name;                  // name of the port
	private double lat;                   // latitude of port
	private double ion;                   // ion of the port 
	private ArrayList<Container> portContainers = new ArrayList<>();    // an arrayList type of Container that will hold the containers that are stored in the port
	private ArrayList<Ship> portShips = new ArrayList<>();              // an arrayList type of Ship that will hold the ships that are stored in the port

    //Constuctor of the Port Class
    public Port(int portID, String name, double lat, double ion){

        this.portID = portID;
        this.name = name;
		this.lat = lat;
		this.ion = ion;
        this.portContainers.clear();        // initializing the arrayList of containers with zero cause there are no containers in the port
        this.portShips.clear();             // initializing the arrayList of ships with zero cause there are no ships in the port 
    }


    // Method that will give the distance that the ship will sail from one port to another
    // distance will be used to calculate the fuelConsumption that the ship will have and the fuel that will need
    
    public double distanceCalculator(double lat1, double ion1, double lat2, double ion2) {
		
        return (Math.acos((Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))) + (Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))) * (Math.cos(Math.toRadians(ion2) - Math.toRadians(ion1)))) * 6371);

	}

    //Method that will add containers in the port -> we want the index so that any user added containers be placed manually in the first index and then increment the indexes of the other containers
    public void addContainer(int ContainerID, Container container){
        portContainers.add(ContainerID-1, container);
    }
    
    // Method that will remove the container from port
    public void removeContainer(Container container){
        portContainers.remove(container);
    }

    // Method that will add ship from the port
    public void addShip(Ship ship){
        portShips.add(ship);
    }

    // Method that will remove a ship from the port 
    public void removeShip(Ship ship){
        portShips.remove(ship);
    }


    // Method to load the containers with the simulationA way
    public void loadContainersToShipsA(){

        for(Ship ship : this.getPortShips()){
            Iterator<Container> iterator = this.getPortContainers().iterator();
            while(iterator.hasNext()){
                
                Container container = iterator.next();

                if(ship.getCurrentContainersQuantity()>=ship.getMaxContainersQuantity())
                    break;
                else if(ship.getCurrentContainersWeight()>=ship.getMaxContainersWeigth())
                    break;
                else if (ship.getCurrentHeavyContainers()>=ship.getMaxHeavyContainersQuantity())
                    break;

                ship.addContainer(container);
                ship.setCurrentContainersQuantity(ship.getCurrentContainersQuantity()+1);
                ship.setCurrentContainersWeight(ship.getCurrentContainersWeight()+container.getWeigth());
                if(container instanceof Fridge || container instanceof Barrel){
                    ship.setCurrentHeavyContainers(ship.getCurrentHeavyContainers()+1);  
                }
                
                iterator.remove();

            }
        }
    }

    // Method to load the containers with the simulationB way
    public void loadContainersToShipsB(){
        int checkHeavy =0;
        int checkWeight = 0;
        for(Ship ship : this.getPortShips()){
            Iterator<Container> iterator = this.getPortContainers().iterator();
            while(iterator.hasNext()){
                
                Container container = iterator.next();

                
                if(ship.getCurrentContainersQuantity()<ship.getMaxContainersQuantity()){
                    ship.setCurrentContainersWeight(ship.getCurrentContainersWeight()+container.getWeigth());
                    checkWeight=1;
                    if(ship.getCurrentContainersWeight()<ship.getMaxContainersWeigth()){
                        if(!(container instanceof Fridge || container instanceof Barrel)){
                            ship.setCurrentHeavyContainers(ship.getCurrentHeavyContainers()-1);
                            checkHeavy = 1;
                        }
                        if(ship.getCurrentHeavyContainers()<ship.getMaxHeavyContainersQuantity()){
                            ship.addContainer(container);
                            ship.setCurrentContainersQuantity(ship.getCurrentContainersQuantity()+1);
                            ship.setCurrentContainersWeight(ship.getCurrentContainersWeight()+container.getWeigth());
                            if(container instanceof Fridge || container instanceof Barrel)
                                ship.setCurrentHeavyContainers(ship.getCurrentHeavyContainers()+1);  
                            if(checkHeavy==1){
                                ship.setCurrentHeavyContainers(ship.getCurrentHeavyContainers()+1);
                                checkHeavy=0;
                            }
                                
                            iterator.remove(); 
                        }
                    }
                }
                
                if(checkWeight==1){
                    ship.setCurrentContainersWeight(ship.getCurrentContainersWeight()-container.getWeigth());
                    checkWeight=0;
                }
            }
        }
    }

    // Method to unload the containers from ships into their ports 
    public void unloadContainersFromShips(){
        int i=1;
        for(Ship shipToBeUnloaded : this.getPortShips()){
            
            Iterator<Container> iterator = shipToBeUnloaded.getContainersLoaded().iterator();
            
            
            while(iterator.hasNext()){
                
                Container container = iterator.next();
                this.addContainer(i, container);
                iterator.remove();
                i++;
            }
        }
    }
    //Method to make ships move from one port to another according to the instuctions of the pdf
    public void travelShip(ArrayList<Port> ports){
        
        Iterator<Ship> iterator = this.getPortShips().iterator();
        int i=1;
        int x = i+1;
        while(iterator.hasNext()){
            
            Ship ship = iterator.next();
            
            ports.get(i).addShip(ship);
            ports.get(i).getPortShips().get(0).setCurrentPort(x);;
            iterator.remove();
            i++;
            x++;
        } 
     }
    
     
     // toString method to print all the elements you want
     @Override
     public String toString(){
        String lineBreaker = "-";   
        char line = '-';
        for(int i=0;i<100;i++){
            lineBreaker+= line;
        }
        String shipInfo = getPortShips().get(0).toString();
        String strFormat = ("ID: %d\t Name: %s\t Lat: %f\t Ion: %f\t ContainersStored: %d\n\n\t\t\t ShipDockedInfo\n\n%s\n\n%s");
        
        return String.format(strFormat,getPortID(),getName(),getLat(),getIon(),getPortContainers().size(),shipInfo,lineBreaker);
     }
    
    // Creating the getters and getters for Port Class
        
    public int getPortID() {
        return portID;
    }
    public String getName() {
        return name;
    }
    public double getLat() {
        return lat;
    }
    public double getIon() {
        return ion;
    }
    public ArrayList<Container> getPortContainers() {
        return portContainers;
    }
    public ArrayList<Ship> getPortShips() {
        return portShips;
    }
    public void setPortID(int portID) {
        this.portID = portID;
    }
    public void setName(String name) {
        this.name= name;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public void setIon(double ion) {
        this.ion = ion;
    }
    public void setPortContainers(ArrayList<Container> portContainers) {
       this.portContainers = portContainers;
    }
    public void setPortShips(ArrayList<Ship> portShips) {
        this.portShips = portShips;
    }

}
