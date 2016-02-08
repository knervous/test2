/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skatebnb.View;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ViewCustomerInfo extends JPanel {
    
    public ViewCustomerInfo()
    {
        super();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        setBackground(Color.gray);
        setVisible(true);
        
        JLabel header = new JLabel("<html><font size=\"7\">Under Construction</font></html>");
        header.setSize(300,200);
        
        
        add(new JLabel(new ImageIcon("src\\images\\construction.gif")));
        add(Box.createRigidArea(new Dimension(20,20)));
        add(header);
    }

 
    
}
