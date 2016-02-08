/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skatebnb.View;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Paul
 */
public class ViewMain extends JPanel {
    
    
    
    public ViewMain()
    {
        super();
        setLayout(null);
        setBackground(Color.gray);
        setVisible(true);
        
        JLabel pic = new JLabel(new ImageIcon("src\\images\\skate.jpg"));
        pic.setBounds(130,140,500,330);
        JLabel header = new JLabel("<html><font size = \"6\">WELCOME TO SKATE n BATE<br> &nbsp &nbsp &nbsp LUXURY VACATIONS</font>/<html>");
        add(header);
        add(pic);
        header.setBounds(200,20,400,100);
    }
    
}
