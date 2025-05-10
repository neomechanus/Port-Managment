import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;


import org.xml.sax.SAXException;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PortStatusScreen implements ActionListener {
     
    
    JFrame portFrame;
    JLabel titleLabel; 
    JPanel mainPanel;
    JLabel[] labels;
    

    JPanel piraeusPanel;
    JLabel piraeusID;
    JLabel piraeusIDValue;
    JLabel piraeusName;
    JLabel piraeusNameValue;
    JLabel piraeusLat;
    JLabel piraeusLatValue;
    JLabel piraeusIon;
    JLabel piraeusIonValue;
    JLabel piraeusContainers;
    JLabel piraeusContainersValue;
    JLabel piraeusShips;
    JLabel piraeusShipsValue;
    
    JPanel patrasPanel;
    JLabel patrasID;
    JLabel patrasIDValue;
    JLabel patrasName;
    JLabel patrasNameValue;
    JLabel patrasLat;
    JLabel patrasLatValue;
    JLabel patrasIon;
    JLabel patrasIonValue;
    JLabel patrasContainers;
    JLabel patrasContainersValue;
    JLabel patrasShips;
    JLabel patrasShipsValue;
    
    JPanel valenciaPanel;
    JLabel valenciaID;
    JLabel valenciaIDValue;
    JLabel valenciaName;
    JLabel valenciaNameValue;
    JLabel valenciaLat;
    JLabel valenciaLatValue;
    JLabel valenciaIon;
    JLabel valenciaIonValue;
    JLabel valenciaContainers;
    JLabel valenciaContainersValue;
    JLabel valenciaShips;
    JLabel valenciaShipsValue;
    
    JPanel alexandriaPanel;
    JLabel alexandriaID;
    JLabel alexandriaIDValue;
    JLabel alexandriaName;
    JLabel alexandriaNameValue;
    JLabel alexandriaLat;
    JLabel alexandriaLatValue;
    JLabel alexandriaIon;
    JLabel alexandriaIonValue;
    JLabel alexandriaContainers;
    JLabel alexandriaContainersValue;
    JLabel alexandriaShips;
    JLabel alexandriaShipsValue;
    
    JPanel genovaPanel;
    JLabel genovaID;
    JLabel genovaIDValue;
    JLabel genovaName;
    JLabel genovaNameValue;
    JLabel genovaLat;
    JLabel genovaLatValue;
    JLabel genovaIon;
    JLabel genovaIonValue;
    JLabel genovaContainers;
    JLabel genovaContainersValue;
    JLabel genovaShips;
    JLabel genovaShipsValue;
    

    JPanel buttonPanel;
    JButton okButton;
    
    public ArrayList<Port> myPorts = new ArrayList<>();
    
    PortStatusScreen(ArrayList<Port> myPorts){
        this.myPorts = myPorts;
        
        System.out.println(myPorts.get(0).getPortID());
        portFrame = new JFrame();

        titleLabel = new JLabel("Ports Status",JLabel.CENTER);
        titleLabel.setBounds(0, 20, 1500, 35);
        titleLabel.setFont(new Font("Arial",Font.BOLD,30));
        titleLabel.setForeground(Color.WHITE);
        portFrame.add(titleLabel);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,2,20,20));
        mainPanel.setBackground(new Color(54,58,69)); 
        mainPanel.setBounds(0,90, 1500, 1100);
    
        piraeusPanel = new JPanel();
        piraeusPanel.setLayout(new GridLayout(6, 2, 10, 5));
        piraeusPanel.setBackground(new Color(54,58,128));
        piraeusPanel.setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.black));
        
        patrasPanel = new JPanel();
        patrasPanel.setLayout(new GridLayout(6, 2, 5, 5));
        patrasPanel.setBackground(new Color(54,58,128));
        patrasPanel.setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.black));

        valenciaPanel = new JPanel();
        valenciaPanel.setLayout(new GridLayout(6, 2, 10, 5));
        valenciaPanel.setBackground(new Color(54,58,128));
        valenciaPanel.setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.black));

        genovaPanel = new JPanel();
        genovaPanel.setLayout(new GridLayout(6, 2, 10, 5));
        genovaPanel.setBackground(new Color(54,58,128));
        genovaPanel.setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.black));

        alexandriaPanel = new JPanel();
        alexandriaPanel.setLayout(new GridLayout(6, 2, 10, 5));
        alexandriaPanel.setBackground(new Color(54,58,128));
        alexandriaPanel.setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.black));
        
        
        piraeusID = new JLabel("ID: ");
        String getPiraeusID = Integer.toString(myPorts.get(0).getPortID());
        piraeusIDValue = new JLabel(getPiraeusID);
        
        piraeusName = new JLabel("Name: ");
        String getPiraeusName = myPorts.get(0).getName();
        piraeusNameValue = new JLabel(getPiraeusName);
        
        piraeusLat = new JLabel("Lat: ");
        String getPiraeusLat = Double.toString(myPorts.get(0).getLat());
        piraeusLatValue = new JLabel(getPiraeusLat);
        
        piraeusIon = new JLabel("Ion: ");
        String getPiraeusIon = Double.toString(myPorts.get(0).getIon());
        piraeusIonValue = new JLabel(getPiraeusIon);
        
        piraeusContainers = new JLabel("Containers: ");
        String getPiraeusContainers = containerCheck(myPorts);
        piraeusContainersValue = new JLabel(getPiraeusContainers);
       
        piraeusShips = new JLabel("Ships: ");
        String getPiraeusShips = shipCheck(myPorts);
        piraeusShipsValue = new JLabel(getPiraeusShips);


        //Setting up the Patras labes to display information
        patrasID = new JLabel("ID: ");
        String getPatrasID = Integer.toString(myPorts.get(1).getPortID());
        patrasIDValue = new JLabel(getPatrasID);
        
        patrasName = new JLabel("Name: ");
        String getPatrasName = myPorts.get(1).getName();
        patrasNameValue = new JLabel(getPatrasName);
        
        patrasLat = new JLabel("Lat: ");
        String getPatrasLat = Double.toString(myPorts.get(1).getLat());
        patrasLatValue = new JLabel(getPatrasLat);
        
        patrasIon = new JLabel("Ion: ");
        String getPatrasIon = Double.toString(myPorts.get(1).getIon());
        patrasIonValue = new JLabel(getPatrasIon);
        
        patrasContainers = new JLabel("Containers: ");
        String getPatrasContainers = Integer.toString(myPorts.get(1).getPortContainers().size());
        patrasContainersValue = new JLabel(getPatrasContainers);
        
        patrasShips = new JLabel("Ships: ");
        String getPatrasShips = Integer.toString(myPorts.get(1).getPortShips().size());
        patrasShipsValue = new JLabel(getPatrasShips);
        
        
        //Setting up the Valencia labes to display information
        valenciaID = new JLabel("ID: ");
        String getValenciaID = Integer.toString(myPorts.get(2).getPortID());
        valenciaIDValue = new JLabel(getValenciaID);
        
        valenciaName = new JLabel("Name: ");
        String getValenciaName = myPorts.get(2).getName();
        valenciaNameValue = new JLabel(getValenciaName);
        
        valenciaLat = new JLabel("Lat: ");
        String getValenciaLat = Double.toString(myPorts.get(2).getLat());
        valenciaLatValue = new JLabel(getValenciaLat);
        
        valenciaIon = new JLabel("Ion: ");
        String getValenciaIon = Double.toString(myPorts.get(2).getIon());
        valenciaIonValue = new JLabel(getValenciaIon);
        
        valenciaContainers = new JLabel("Containers: ");
        String getValenciaContainers = Integer.toString(myPorts.get(2).getPortContainers().size());
        valenciaContainersValue = new JLabel(getValenciaContainers);
        
        valenciaShips = new JLabel("Ships: ");
        String getValenciaShips = Integer.toString(myPorts.get(2).getPortShips().size());
        valenciaShipsValue = new JLabel(getValenciaShips);

        
        //Setting up the Alexandria labes to display information
        alexandriaID = new JLabel("ID: ");
        String getAlexandriaID = Integer.toString(myPorts.get(3).getPortID());
        alexandriaIDValue = new JLabel(getAlexandriaID);
        
        alexandriaName = new JLabel("Name: ");
        String getAlexandriaName = myPorts.get(3).getName();
        alexandriaNameValue = new JLabel(getAlexandriaName);
        
        alexandriaLat = new JLabel("Lat: ");
        String getAlexandriaLat = Double.toString(myPorts.get(3).getLat());
        alexandriaLatValue = new JLabel(getAlexandriaLat);
        
        alexandriaIon = new JLabel("Ion: ");
        String getAlexandriaIon = Double.toString(myPorts.get(3).getIon());
        alexandriaIonValue = new JLabel(getAlexandriaIon);
        
        alexandriaContainers = new JLabel("Containers: ");
        String getAlexandriaContainers = Integer.toString(myPorts.get(3).getPortContainers().size());
        alexandriaContainersValue = new JLabel(getAlexandriaContainers);
        
        alexandriaShips = new JLabel("Ships: ");
        String getAlexandriaShips = Integer.toString(myPorts.get(3).getPortShips().size());
        alexandriaShipsValue = new JLabel(getAlexandriaShips);
        


        //Setting up the Genova labes to display information
        genovaID = new JLabel("ID: ");
        String getGenovaID = Integer.toString(myPorts.get(4).getPortID());
        genovaIDValue = new JLabel(getGenovaID);
        
        genovaName = new JLabel("Name: ");
        String getGenovaName = myPorts.get(4).getName();
        genovaNameValue = new JLabel(getGenovaName);
        
        genovaLat = new JLabel("Lat: ");
        String getGenovaLat = Double.toString(myPorts.get(4).getLat());
        genovaLatValue = new JLabel(getGenovaLat);
        
        genovaIon = new JLabel("Ion: ");
        String getGenovaIon = Double.toString(myPorts.get(4).getIon());
        genovaIonValue = new JLabel(getGenovaIon);
        
        genovaContainers = new JLabel("Containers: ");
        String getGenovaContainers = Integer.toString(myPorts.get(4).getPortContainers().size());
        genovaContainersValue = new JLabel(getGenovaContainers);
        
        genovaShips = new JLabel("Ships: ");
        String getGenovaShips = Integer.toString(myPorts.get(4).getPortShips().size());
        genovaShipsValue = new JLabel(getGenovaShips);

        
        labels = new JLabel[60];

        labels[0] = piraeusID;
        labels[1] = piraeusIDValue;
        labels[2] = piraeusName;
        labels[3] = piraeusNameValue;
        labels[4] = piraeusLat;
        labels[5] = piraeusLatValue;
        labels[6] = piraeusIon;
        labels[7] = piraeusIonValue;
        labels[8] = piraeusContainers;
        labels[9] = piraeusContainersValue;
        labels[10] = piraeusShips;
        labels[11] = piraeusShipsValue;
        labels[12] = patrasID;
        labels[13] = patrasIDValue;
        labels[14] = patrasName;
        labels[15] = patrasNameValue;
        labels[16] = patrasLat;
        labels[17] = patrasLatValue;
        labels[18] = patrasIon;
        labels[19] = patrasIonValue;
        labels[20] = patrasContainers;
        labels[21] = patrasContainersValue;
        labels[22] = patrasShips;
        labels[23] = patrasShipsValue;
        labels[24] = valenciaID;
        labels[25] = valenciaIDValue;
        labels[26] = valenciaName;
        labels[27] = valenciaNameValue;
        labels[28] = valenciaLat;
        labels[29] = valenciaLatValue;
        labels[30] = valenciaIon;
        labels[31] = valenciaIonValue;
        labels[32] = valenciaContainers;
        labels[33] = valenciaContainersValue;
        labels[34] = valenciaShips;
        labels[35] = valenciaShipsValue;
        labels[36] = alexandriaID;
        labels[37] = alexandriaIDValue;
        labels[38] = alexandriaName;
        labels[39] = alexandriaNameValue;
        labels[40] = alexandriaLat;
        labels[41] = alexandriaLatValue;
        labels[42] = alexandriaIon;
        labels[43] = alexandriaIonValue;
        labels[44] = alexandriaContainers;
        labels[45] = alexandriaContainersValue;
        labels[46] = alexandriaShips;
        labels[47] = alexandriaShipsValue;
        labels[48] = genovaID;
        labels[49] = genovaIDValue;
        labels[50] = genovaName;
        labels[51] = genovaNameValue;
        labels[52] = genovaLat;
        labels[53] = genovaLatValue;
        labels[54] = genovaIon;
        labels[55] = genovaIonValue;
        labels[56] = genovaContainers;
        labels[57] = genovaContainersValue;
        labels[58] = genovaShips;
        labels[59] = genovaShipsValue;


        //for every title of value
        for(int i=0;i<60;i++){
            labels[i].setFont(new Font("Arial",Font.PLAIN,30));
            labels[i].setForeground(Color.WHITE);
        }
        // for every value
        for(int i=0;i<60;i=i+2){
            labels[i].setFont(new Font("Arial",Font.BOLD,30));
            labels[i].setForeground(Color.WHITE);
        }

        //adding to piraeus panel the accordingly labels
        for(int i=0;i<12;i++){
            piraeusPanel.add(labels[i]);
        }

        for(int i=12; i<24;i++){
            patrasPanel.add(labels[i]);
        }

        for(int i=24;i<36;i++){
            valenciaPanel.add(labels[i]);
        }

        for(int i=36;i<48;i++){
            alexandriaPanel.add(labels[i]);
        }

        for(int i=48;i<60;i++){
            genovaPanel.add(labels[i]);
        }
        
        
        okButton = new JButton("Exit");
        okButton.addActionListener(this);
        okButton.setFocusable(false);
        okButton.setBackground(new Color(54,58,128));
        okButton.setFont(new Font("Arial",Font.BOLD,50));
        okButton.setForeground(Color.WHITE);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,1));
        buttonPanel.setBackground(new Color(54,58,128));
        buttonPanel.setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.black));
        buttonPanel.add(okButton);
        

        
        mainPanel.add(piraeusPanel);
        mainPanel.add(patrasPanel);
        mainPanel.add(valenciaPanel);
        mainPanel.add(genovaPanel);
        mainPanel.add(alexandriaPanel);
        mainPanel.add(buttonPanel);
        
        portFrame.setResizable(true);
        portFrame.setTitle("Ports Status");
        portFrame.getContentPane().setBackground(new Color(54,58,69));
        portFrame.setSize(1500,1300);
        portFrame.setLayout(null);
        portFrame.setLocationRelativeTo(null);
        portFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        portFrame.setVisible(true);
        portFrame.add(mainPanel);
        
        

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==okButton){
            portFrame.dispose();
        }
        
    }


    public String containerCheck(ArrayList<Port> myPorts){
        if(myPorts.get(0).getPortContainers().size()<=0){
            return "No Containers";
        }
        else{
             String containerCount = Integer.toString(myPorts.get(0).getPortContainers().size());
             return  containerCount;   
        }      
    }

    public String shipCheck(ArrayList<Port> myPorts){
        if(myPorts.get(0).getPortShips().size()<=0){
            return "No Ships";
        }
        else{
             String shipCount = Integer.toString(myPorts.get(0).getPortShips().size());
             return  shipCount;   
        }      
    }


}

