import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
	static ArrayList<Port> myPorts = new ArrayList<Port>();
	public static String portFileDestination = "C:\\Users\\ANASTASIA\\Desktop\\ERGASIA_JAVA_2023-2024_v1\\ports.txt";	
	public static String shipFileDestination = "C:\\Users\\ANASTASIA\\Desktop\\ERGASIA_JAVA_2023-2024_v1\\ships.txt";
	public static String ContainerFileDestination = "C:\\Users\\ANASTASIA\\Desktop\\ERGASIA_JAVA_2023-2024_v1\\containersEnglish.txt";
	    public static void main(String[] args) throws Exception {

		createPorts(myPorts,portFileDestination);
		createShips(shipFileDestination,myPorts);
		createContainers(ContainerFileDestination,myPorts);
        System.out.println("Hello");
		
        //simulationA(myPorts);
		//simulationA(myPorts);
        
		FirstScreen fs = new FirstScreen(myPorts);
        

        
    }


	//Method of running the simulation A as described in the pdf
    public static void simulationA(ArrayList<Port> myPorts){
        
        myPorts.get(0).loadContainersToShipsA();
        double distance=0;
        double fuelneeded=0;

        int currentShipID = 0;
        for(Ship ship : myPorts.get(0).getPortShips()){
            currentShipID = ship.getshipID();
            distance = myPorts.get(0).distanceCalculator(myPorts.get(0).getLat(),myPorts.get(0).getIon(),myPorts.get(currentShipID).getLat(), myPorts.get(currentShipID).getIon());
            fuelneeded = ship.fuelCalculation(distance);
            ship.loadFuel(fuelneeded); 
        }
        
        myPorts.get(0).travelShip(myPorts);
        for(int i=1;i<myPorts.size();i++){
            myPorts.get(i).unloadContainersFromShips();
        }
		
		System.out.println("\t\t\t\tPorts Information\n");
		
		for(int i=1;i<myPorts.size();i++){
			System.out.println(myPorts.get(i).toString());
		}	
    }

	//Method of running the simulation B as described in the pdf -- Calling the loadContainerToShipB
	public static void simulationB(ArrayList<Port> myPorts){
        
		myPorts.get(0).loadContainersToShipsB();
		double distance=0;
		double fuelneeded=0;

		int currentShipID = 0;
		for(Ship ship : myPorts.get(0).getPortShips()){
			currentShipID = ship.getshipID();
			distance = myPorts.get(0).distanceCalculator(myPorts.get(0).getLat(),myPorts.get(0).getIon(),myPorts.get(currentShipID).getLat(), myPorts.get(currentShipID).getIon());
			fuelneeded = ship.fuelCalculation(distance);
			ship.loadFuel(fuelneeded); 
			}
			
		myPorts.get(0).travelShip(myPorts);
		for(int i=1;i<myPorts.size();i++){
			myPorts.get(i).unloadContainersFromShips();
		}
			
		System.out.println("\t\t\t\tPorts Information\n");
			
		for(int i=1;i<myPorts.size();i++){
			System.out.println(myPorts.get(i).toString());
		}	
	}
    
    



    // Method that container is added from the user to the first port and in the first place of the portContainer array
    public static void userAddContainer(String containerType, int containerWeight, ArrayList<Port>myPorts){
        Container container;
        for(int i=0;i<myPorts.get(0).getPortContainers().size();i++){
            int incrementID = myPorts.get(0).getPortContainers().get(i).getContainerID()+1;
            myPorts.get(0).getPortContainers().get(i).setContainerID(incrementID);
        }
        
        switch(containerType) {
            case "barrel":
            container = new Barrel(1, containerWeight);
                break;
            case "fridge":
                container = new Fridge(1, containerWeight);
                break;
            case "lightContainer":
                default    : 
                container = new LightContainer(1, containerWeight);
                break;
            }
       
            myPorts.get(0).addContainer(1, container);
    }
    
    // Loading data from ports.txt
	public static void createPorts(ArrayList<Port> portArray,String portFileDestination) throws NumberFormatException, IOException {
		FileReader reader;
		Port aPort;
		
																		
        try {
			reader = new FileReader(portFileDestination);
			BufferedReader bfrReader = new BufferedReader(reader);			
			String line;

			while((line = bfrReader.readLine())!=null) {
				String[] portInfo = line.split(",");
				int portID = Integer.parseInt(portInfo[0].trim());
				String portName = portInfo[1].trim();
				double portlat = Double.parseDouble(portInfo[2].trim());
				double portIon = Double.parseDouble(portInfo[3].trim());
				aPort = new Port(portID,portName,portlat,portIon);
				myPorts.add(aPort);
			}
			bfrReader.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}



    // Loading data from ships.txt
	public static void createShips(String shipFileDestination, ArrayList<Port> myPorts) throws NumberFormatException, IOException {
		FileReader reader;
		Ship aShip;
	
		try {
			reader = new FileReader(shipFileDestination);
			BufferedReader bfrReader = new BufferedReader(reader);			
			String line;

			while((line = bfrReader.readLine())!=null) {
				String[] shipInfo = line.split(",");
				int shipID = Integer.parseInt(shipInfo[0].trim());
				String shipName = shipInfo[1].trim();
				double shipConsumptionPerKm = Double.parseDouble(shipInfo[2].trim());
				int shipmaxContainerWeigth = Integer.parseInt(shipInfo[3].trim());
				int shipMaxTotalContainersCarried = Integer.parseInt(shipInfo[4].trim());
				int shipMaxHeavyContainersCarried = Integer.parseInt(shipInfo[5].trim());
				int shipCurrentPort = Integer.parseInt(shipInfo[6].trim()) - 1;
										
				aShip = new Ship(shipID,shipName,shipConsumptionPerKm,shipmaxContainerWeigth,shipMaxTotalContainersCarried,shipMaxHeavyContainersCarried,shipCurrentPort);
				myPorts.get(0).addShip(aShip);	
			}
			bfrReader.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}


    // Loading data from containers.txt
	public static void createContainers(String containerileDestination, ArrayList<Port> port) throws NumberFormatException, IOException {
		FileReader reader;
		Container aContainer;
			 
		try {
			reader = new FileReader(containerileDestination);
			BufferedReader bfrReader = new BufferedReader(reader);			
			String line;
			int ContainerIDAddition=1;
			while((line = bfrReader.readLine())!=null) {
				String[] containerInfo = line.split(",");
					
				int containerID = ContainerIDAddition;
				String containerCategory = containerInfo[0];
				int containerWeight = Integer.parseInt(containerInfo[1].trim());
					
				switch(containerCategory) {
				case "barrel":
					aContainer = new Barrel(containerID, containerWeight);
					break;
				case "fridge":
					aContainer = new Fridge(containerID, containerWeight);
					break;
				case "lightContainer":
				    default    : 
					aContainer = new LightContainer(containerID, containerWeight);
					break;
				}
				port.get(0).addContainer(containerID,aContainer);
				ContainerIDAddition++;
					
			}
			bfrReader.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}	

	//Method to return ships and their cargo all to Piraeus Port -- Reset Program
	public static void reset(ArrayList<Port> myPorts){	
		myPorts.clear();
		try{
			
			createPorts(myPorts,portFileDestination);
			createShips(shipFileDestination,myPorts);
			createContainers(ContainerFileDestination,myPorts);
		}
		catch(Exception e){
			System.out.println("File not found");
		}




	}



}
