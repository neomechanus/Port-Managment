import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.xml.sax.SAXException;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class FirstScreen implements ActionListener{
    
	
	
	
    JButton simulationA;
    JButton simulationB;
    JButton reset;
    JButton addContainer;
    JButton portStatus;
    JButton shipStatus;
    JButton[] buttons; 
    JLabel title;
    JLabel actionDescription;
    JPanel panel;
    JFrame mainFrame;
    public ArrayList<Port> myPorts = new ArrayList<>();


    FirstScreen(ArrayList<Port> myPorts){
        this.myPorts = myPorts;
        
        mainFrame = new JFrame();
    	
        //String test = Integer.toString(myPorts.get(0).getPortID());
    
        panel = new JPanel();
        panel.setBounds(0,119, 840, 250);
        panel.setBackground(new Color(54,58,69));
        panel.setLayout(new GridLayout(3,3,20,20));
        
        buttons = new JButton[6];
        simulationA = new JButton("Simulation A");
        simulationB = new JButton("Simulation B");
        reset = new JButton("Reset ");
        addContainer = new JButton("Add Container");
        portStatus = new JButton("Port Status");
        shipStatus = new JButton("Ship Status");
        
        buttons[0] = simulationA;
        buttons[1] = simulationB;
        buttons[2] = reset;
        buttons[3] = addContainer;
        buttons[4] = portStatus;
        buttons[5] = shipStatus;

        
        for(int i=0; i<6;i++){
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("Arial",Font.BOLD,24));
            buttons[i].setFocusable(false);
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setForeground(Color.WHITE);
        }

        for(int i=0; i<6; i++){
            panel.add(buttons[i]);
        }


        // Setting up the title of the frame
        title = new JLabel("Management System", JLabel.CENTER);
        title.setBounds(0, 20, 840, 35);
        title.setFont(new Font("Arial",Font.BOLD,30));
        title.setForeground(Color.WHITE);
        
        title.setBackground(Color.BLACK);
        
        //Setting up the subtitle of the frame
        actionDescription = new JLabel("Select Your Action", JLabel.CENTER);
        actionDescription.setBounds(0, 65, 840, 35);
        actionDescription.setFont(new Font("Arial",Font.BOLD,20));
        actionDescription.setForeground(Color.WHITE);
        actionDescription.setBackground(Color.BLACK);
        actionDescription.setVerticalTextPosition(JLabel.CENTER);

        // Setting up the frame 
        
        mainFrame.getContentPane().setBackground(new Color(54,58,69));
        mainFrame.setSize(840,500);
        mainFrame.setTitle("Management System");
        mainFrame.setLayout(null);
        mainFrame.add(title);
        mainFrame.add(actionDescription);
        mainFrame.add(panel);
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==simulationA){
           Main.simulationA(myPorts);
        }
        if(e.getSource()==simulationB){
            Main.simulationB(myPorts);
        }
        if(e.getSource()==reset){
            Main.reset(myPorts);
        }
        if(e.getSource()==addContainer){
            ContainerAdditionScreen addContScreen = new ContainerAdditionScreen(myPorts);
        }
        if(e.getSource()==portStatus){
            PortStatusScreen pss = new PortStatusScreen(myPorts);
        }
        if(e.getSource()==shipStatus){
            ShipStatusScreen sss = new ShipStatusScreen(myPorts);
        }
    }

	
}
