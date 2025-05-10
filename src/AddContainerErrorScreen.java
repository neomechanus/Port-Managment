import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AddContainerErrorScreen extends JFrame implements ActionListener {

    JButton button;
    public AddContainerErrorScreen(){
        JLabel message = new JLabel("You entered string instead of Integer",JLabel.CENTER);
        message.setSize(700,150);;
        message.setFont(new Font("Arial",Font.BOLD,35));
        message.setForeground(Color.WHITE);
        

        button = new JButton("OK");
        button.setBounds(300, 150, 100, 100);
        
        button.setBackground(new Color(54,58,69));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial",Font.BOLD,35));
        button.setFocusable(false);
        button.setBorder(null);
        button.addActionListener(this);
        
        
        this.setLayout(null);
        this.add(button);
        this.add(message);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.getContentPane().setBackground(new Color(54,58,69));
        this.setLocationRelativeTo(null);
        this.setSize(700,300);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            this.dispose();
        }   
    }
}
