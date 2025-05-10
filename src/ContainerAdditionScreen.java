import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContainerAdditionScreen implements ActionListener, MouseListener{

    JFrame frame;
    JButton button;
    JTextField textField;
    JComboBox<String> comboBox;
    JPanel panel;
    JLabel label;
    
    
    public ArrayList<Port> myPorts = new ArrayList<>();
    ContainerAdditionScreen(ArrayList<Port> myPorts){
        
    	this.myPorts = myPorts;
    	
    	
    	String[] shipCategories = {"simple", "barrel", "fridge"}; 
        frame = new JFrame("Container Addition");
       
        button = new JButton("OK");
        button.setBounds(550, 100, 100, 200);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial",Font.BOLD,24));
        button.setFocusable(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
        button.addActionListener(this);

        label = new JLabel("Add Container Info",JLabel.CENTER);
        label.setBounds(0, 0, 700, 100);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial",Font.BOLD,30));
        label.addMouseListener(this);
        
        textField = new JTextField("Write the weight of the container",JTextField.CENTER);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setHorizontalAlignment((JTextField.CENTER));
        textField.setFont(new Font("Arial",Font.BOLD,20));
        textField.setEditable(true);
        textField.addMouseListener(this);

        comboBox = new JComboBox<>(shipCategories);
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(Color.BLACK);
        comboBox.setFont(new Font("Aria",Font.BOLD,20));
        
        
        panel = new JPanel();
        panel.setBounds(0, 100, 500, 200);
        panel.setLayout(new GridLayout(2,1,10,20));
        panel.setBackground(new Color(54,58,69));
        
        panel.add(comboBox);
        panel.add(textField);
        
        


        
        frame.setLayout(null);
        frame.add(label);
        frame.add(panel);
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(700,400);
        frame.getContentPane().setBackground(new Color(54,58,69));
        


    }


    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {
            try {
                // Get the selected item from the combo box and cast it to a String
                String containerTypeUser = (String) comboBox.getSelectedItem();
                
                // Attempt to get the text from the text field and convert it to an integer
                int containerWeightUser = Integer.parseInt(textField.getText());
                
                // Call the userAddContainer method from the Main class, passing the necessary parameters
                Main.userAddContainer(containerTypeUser, containerWeightUser, myPorts);
                
                // Dispose of the current frame (close the window)
                frame.dispose();
            } catch (NumberFormatException ex) {
                // If the input is not a valid integer, print an error message to the terminal
                AddContainerErrorScreen aces = new AddContainerErrorScreen();
            }
        }
        
    }
    // Deleting the text inside the textField by clicking it with the mouse
    @Override
    public void mouseClicked(MouseEvent e) {
    	textField.setText("");
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
       
    }
    @Override
    public void mouseReleased(MouseEvent e) {
       
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
       
    }
}
