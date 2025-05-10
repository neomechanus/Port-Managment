import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class ShipStatusScreen implements ActionListener {

	

    JLabel[] labels;
    JButton okButton;
    JFrame shipFrame;

    public ArrayList<Port> myPorts = new ArrayList<>();
    
    ShipStatusScreen(ArrayList<Port> myPorts){
        this.myPorts = myPorts;
        

        shipFrame = new JFrame("Ships Status");
        JLabel titleLabel = new JLabel("Ships Status",JLabel.CENTER);
        titleLabel.setBounds(0, 20, 1500, 35);
        titleLabel.setFont(new Font("Arial",Font.BOLD,30));
        titleLabel.setForeground(Color.WHITE);
        shipFrame.add(titleLabel);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,2,40,100));
        mainPanel.setBackground(new Color(54,58,69)); 
        mainPanel.setBounds(0,90, 1500, 1100);

        JPanel argoPanel = new JPanel();
        argoPanel.setLayout(new GridLayout(7, 2, 10,5));
        argoPanel.setBackground(new Color(54,58,128));
        argoPanel.setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.black));
        
        JPanel aiolosPanel = new JPanel();
        aiolosPanel.setLayout(new GridLayout(7, 2, 10, 5));
        aiolosPanel.setBackground(new Color(54,58,128));
        aiolosPanel.setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.black));

        JPanel aiasPanel = new JPanel();
        aiasPanel.setLayout(new GridLayout(7, 2, 10, 5));
        aiasPanel.setBackground(new Color(54,58,128));
        aiasPanel.setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.black));

        JPanel artemisPanel = new JPanel();
        artemisPanel.setLayout(new GridLayout(7, 2, 10, 5));
        artemisPanel.setBackground(new Color(54,58,128));
        artemisPanel.setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.black));
        

        // ARGO
        JLabel argoID = new JLabel("ID: ");
        String getArgoID = Integer.toString(myPorts.get(1).getPortShips().get(0).getshipID());
        JLabel argoIDValue = new JLabel(getArgoID);
        
        JLabel argoName = new JLabel("Name: ");
        String getArgoName = (myPorts.get(1).getPortShips().get(0).getName());
        JLabel argoNameValue = new JLabel(getArgoName);
        
        JLabel argoCurretnPort = new JLabel("Current Port: ");
        int getArgoCurrentPort = (myPorts.get(1).getPortShips().get(0).getCurrentPort());
        String getArgoCurrentPortStr = portCheck(getArgoCurrentPort);
        JLabel argoCurretnPortValue = new JLabel(getArgoCurrentPortStr);
        
        JLabel argoFuelConsumed = new JLabel("Fuel Consumed: ");
        String getArgoFuelConsumed = Double.toString(myPorts.get(1).getPortShips().get(0).getCurrentFuel());
        JLabel argoFuelConsumedValue = new JLabel(getArgoFuelConsumed);
        
        JLabel argoContainersCarried = new JLabel("Containers Carried: ");
        String getArgoContainerCarried = Integer.toString(myPorts.get(1).getPortShips().get(0).getCurrentContainersQuantity());
        JLabel argoContainersCarriedValue = new JLabel(getArgoContainerCarried);
        
        JLabel argoHeavyContainersCarried = new JLabel("Heavy Containers Carried: ");
        String getArgoHeavyContainerCarried = Integer.toString(myPorts.get(1).getPortShips().get(0).getCurrentHeavyContainers());
        JLabel argoHeavyContainersCarriedValue = new JLabel(getArgoHeavyContainerCarried);
        
        JLabel argoContainersWeight = new JLabel("Containers Weight Carried: ");
        String getArgoContainerWeight = Double.toString(myPorts.get(1).getPortShips().get(0).getCurrentContainersWeight());
        JLabel argoContainersWeightValue = new JLabel(getArgoContainerWeight+" KG");
        
        // AIOLOS
        JLabel aiolosID = new JLabel("ID: ");
        String getAiolosID = Integer.toString(myPorts.get(2).getPortShips().get(0).getshipID());
        JLabel aiolosIDValue = new JLabel(getAiolosID);
        
        JLabel aiolosName = new JLabel("Name: ");
        String getAiolosName = (myPorts.get(2).getPortShips().get(0).getName());
        JLabel aiolosNameValue = new JLabel(getAiolosName);
        
        JLabel aiolosCurretnPort = new JLabel("Current Port: ");
        int getAiolosCurrentPort = (myPorts.get(2).getPortShips().get(0).getCurrentPort());
        String getAiolosCurrentPortStr = portCheck(getAiolosCurrentPort);
        JLabel aiolosCurretnPortValue = new JLabel(getAiolosCurrentPortStr);
        
        JLabel aiolosFuelConsumed = new JLabel("Fuel Consumed: ");
        String getAiolosFuelConsumed = Double.toString(myPorts.get(2).getPortShips().get(0).getCurrentFuel());
        JLabel aiolosFuelConsumedValue = new JLabel(getAiolosFuelConsumed);
        
        JLabel aiolosContainersCarried = new JLabel("Containers Carried: ");
        String getAiolosContainerCarried = Integer.toString(myPorts.get(2).getPortShips().get(0).getCurrentContainersQuantity());
        JLabel aiolosContainersCarriedValue = new JLabel(getAiolosContainerCarried);
        
        JLabel aiolosHeavyContainersCarried = new JLabel("Heavy Containers Carried: ");
        String getAiolosHeavyContainerCarried = Integer.toString(myPorts.get(2).getPortShips().get(0).getCurrentHeavyContainers());
        JLabel aiolosHeavyContainersCarriedValue = new JLabel(getAiolosHeavyContainerCarried);
        
        JLabel aiolosContainersWeight = new JLabel("Containers Weight Carried: ");
        String getAiolosContainerWeight = Double.toString(myPorts.get(2).getPortShips().get(0).getCurrentContainersWeight());
        JLabel aiolosContainersWeightValue = new JLabel(getAiolosContainerWeight+" KG");
        
        //AIAS
        JLabel aiasID = new JLabel("ID: ");
        String getAiasID = Integer.toString(myPorts.get(3).getPortShips().get(0).getshipID());
        JLabel aiasIDValue = new JLabel(getAiasID);
        
        JLabel aiasName = new JLabel("Name: ");
        String getAiasName = (myPorts.get(3).getPortShips().get(0).getName());
        JLabel aiasNameValue = new JLabel(getAiasName);
        
        JLabel aiasCurretnPort = new JLabel("Current Port: ");
        int getAiasCurrentPort = (myPorts.get(3).getPortShips().get(0).getCurrentPort());
        String getAiasCurrentPortStr = portCheck(getAiasCurrentPort);
        JLabel aiasCurretnPortValue = new JLabel(getAiasCurrentPortStr);
        
        JLabel aiasFuelConsumed = new JLabel("Fuel Consumed: ");
        String getAiasFuelConsumed = Double.toString(myPorts.get(3).getPortShips().get(0).getCurrentFuel());
        JLabel aiasFuelConsumedValue = new JLabel(getAiasFuelConsumed);
        
        JLabel aiasContainersCarried = new JLabel("Containers Carried: ");
        String getAiasContainerCarried = Integer.toString(myPorts.get(3).getPortShips().get(0).getCurrentContainersQuantity());
        JLabel aiasContainersCarriedValue = new JLabel(getAiasContainerCarried);
        
        JLabel aiasHeavyContainersCarried = new JLabel("Heavy Containers Carried: ");
        String getAiasHeavyContainerCarried = Integer.toString(myPorts.get(3).getPortShips().get(0).getCurrentHeavyContainers());
        JLabel aiasHeavyContainersCarriedValue = new JLabel(getAiasHeavyContainerCarried);
        
        JLabel aiasContainersWeight = new JLabel("Containers Weight Carried: ");
        String getAiasContainerWeight = Double.toString(myPorts.get(3).getPortShips().get(0).getCurrentContainersWeight());
        JLabel aiasContainersWeightValue = new JLabel(getAiasContainerWeight+" KG");
        
        //Artemis
        JLabel artemisID = new JLabel("ID: ");
        String getartemisID = Integer.toString(myPorts.get(4).getPortShips().get(0).getshipID());
        JLabel artemisIDValue = new JLabel(getartemisID);
        
        JLabel artemisName = new JLabel("Name: ");
        String getartemisName = (myPorts.get(4).getPortShips().get(0).getName());
        JLabel artemisNameValue = new JLabel(getartemisName);
        
        JLabel artemisCurretnPort = new JLabel("Current Port: ");
        int getartemisCurrentPort = (myPorts.get(4).getPortShips().get(0).getCurrentPort());
        String getartemisCurrentPortStr = portCheck(getartemisCurrentPort);
        JLabel artemisCurretnPortValue = new JLabel(getartemisCurrentPortStr);
        
        JLabel artemisFuelConsumed = new JLabel("Fuel Consumed: ");
        String getartemisFuelConsumed = Double.toString(myPorts.get(4).getPortShips().get(0).getCurrentFuel());
        JLabel artemisFuelConsumedValue = new JLabel(getartemisFuelConsumed);
        
        JLabel artemisContainersCarried = new JLabel("Containers Carried: ");
        String getartemisContainerCarried = Integer.toString(myPorts.get(4).getPortShips().get(0).getCurrentContainersQuantity());
        JLabel artemisContainersCarriedValue = new JLabel(getartemisContainerCarried);
        
        JLabel artemisHeavyContainersCarried = new JLabel("Heavy Containers Carried: ");
        String getartemisHeavyContainerCarried = Integer.toString(myPorts.get(4).getPortShips().get(0).getCurrentHeavyContainers());
        JLabel artemisHeavyContainersCarriedValue = new JLabel(getartemisHeavyContainerCarried);
        
        JLabel artemisContainersWeight = new JLabel("Containers Weight Carried: ");
        String getartemisContainerWeight = Double.toString(myPorts.get(4).getPortShips().get(0).getCurrentContainersWeight());
        JLabel artemisContainersWeightValue = new JLabel(getartemisContainerWeight+" KG");    

    
        labels = new JLabel[56];

        labels[0] = argoID;
        labels[1] = argoIDValue;
        labels[2] = argoName;
        labels[3] = argoNameValue;
        labels[4] = argoCurretnPort;
        labels[5] = argoCurretnPortValue;
        labels[6] = argoFuelConsumed;
        labels[7] = argoFuelConsumedValue;
        labels[8] = argoContainersCarried;
        labels[9] =  argoContainersCarriedValue;
        labels[10] = argoHeavyContainersCarried;
        labels[11] = argoHeavyContainersCarriedValue;
        labels[12] = argoContainersWeight;
        labels[13] = argoContainersWeightValue;
        labels[14] = aiolosID;
        labels[15] = aiolosIDValue;
        labels[16] = aiolosName;
        labels[17] = aiolosNameValue;
        labels[18] = aiolosCurretnPort;
        labels[19] = aiolosCurretnPortValue;
        labels[20] = aiolosFuelConsumed;
        labels[21] = aiolosFuelConsumedValue;
        labels[22] = aiolosContainersCarried;
        labels[23] = aiolosContainersCarriedValue;
        labels[24] = aiolosHeavyContainersCarried;
        labels[25] = aiolosHeavyContainersCarriedValue;
        labels[26] = aiolosContainersWeight;
        labels[27] = aiolosContainersWeightValue;
        labels[28] = aiasID;
        labels[29] = aiasIDValue;
        labels[30] = aiasName;
        labels[31] = aiasNameValue;
        labels[32] = aiasCurretnPort;
        labels[33] = aiasCurretnPortValue;
        labels[34] = aiasFuelConsumed;
        labels[35] = aiasFuelConsumedValue;
        labels[36] = aiasContainersCarried;
        labels[37] = aiasContainersCarriedValue;
        labels[38] = aiasHeavyContainersCarried;
        labels[39] = aiasHeavyContainersCarriedValue;
        labels[40] = aiasContainersWeight;
        labels[41] = aiasContainersWeightValue;
        labels[42] = artemisID;
        labels[43] = artemisIDValue;
        labels[44] = artemisName;
        labels[45] = artemisNameValue;
        labels[46] = artemisCurretnPort;
        labels[47] = artemisCurretnPortValue;
        labels[48] = artemisFuelConsumed;
        labels[49] = artemisFuelConsumedValue;
        labels[50] = artemisContainersCarried;
        labels[51] = artemisContainersCarriedValue;
        labels[52] = artemisHeavyContainersCarried;
        labels[53] = artemisHeavyContainersCarriedValue;
        labels[54] = artemisContainersWeight;
        labels[55] = artemisContainersWeightValue;

        
        
        //for every title of value
        for(int i=0;i<56;i++){
            labels[i].setFont(new Font("Arial",Font.PLAIN,20));
            labels[i].setForeground(Color.WHITE);
        }
        // for every value
        for(int i=0;i<56;i=i+2){
            labels[i].setFont(new Font("Arial",Font.BOLD,20));
            labels[i].setForeground(Color.WHITE);
        }
        

        for(int i=0;i<14;i++){
            argoPanel.add(labels[i]);        
        }

        for(int i=14;i<28;i++){
            aiolosPanel.add(labels[i]);
        }

        for(int i=28;i<42;i++){
            aiasPanel.add(labels[i]);
        }

        for(int i=42;i<56;i++){
            artemisPanel.add(labels[i]);
        }

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBounds(600, 590, 300, 100);
        buttonPanel.setLayout(new GridLayout(1,1));
        buttonPanel.setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.black));
        okButton = new JButton("EXIT");
        okButton.setBounds(50, 50, 750, 650);
        okButton.setFocusable(false);
        okButton.setBackground(new Color(54,58,128));
        okButton.setFont(new Font("Arial",Font.BOLD,25)); 
        okButton.setForeground(Color.WHITE);   
        okButton.addActionListener(this);
       
        buttonPanel.add(okButton);




        shipFrame.add(buttonPanel);
        mainPanel.add(argoPanel);
        mainPanel.add(aiolosPanel);
        mainPanel.add(aiasPanel);
        mainPanel.add(artemisPanel);


        
        shipFrame.getContentPane().setBackground(new Color(54,58,69));
        shipFrame.setSize(1500,1300);
        shipFrame.setLayout(null);
        shipFrame.setLocationRelativeTo(null);
        shipFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shipFrame.setVisible(true);
        shipFrame.add(mainPanel);
        


    }
    
    
    
    
    
    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==okButton){
            shipFrame.dispose();
        }
		
	}

    //Method to return the appropiate String of the port corresponding in the number that is stored in the portId field of the ship
    public String portCheck(int getPortID){
        if(getPortID == 1){
            String port = "Piraeus";
            return port;
        }
        else if(getPortID==2){
            String port = "Patras";
            return port;
        }
        else if(getPortID==3){
            String port = "Valencia";
            return port;
        }
        else if(getPortID==4){
            String port = "Alexandria";
            return port;
        }
        else if(getPortID==5){
            String port = "Genova";
            return port;
        }
        return "Failed";
    }




}

