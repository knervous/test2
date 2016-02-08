package skatebnb.View;


import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Buttons extends JPanel{
    JButton main;
    JButton browseLoc;
    JButton checkOut;
    JButton customerInfo;
    JButton lenderInfo;
    JButton test;

    
    public Buttons(){     
        main = new JButton("Main Screen");
        browseLoc = new JButton("Browse Locations to Rent");
        customerInfo = new JButton("Enter Customer Info");
        lenderInfo = new JButton("Enter Lender Info");

        add(main, BorderLayout.SOUTH);
        add(lenderInfo, BorderLayout.SOUTH);
        add(customerInfo, BorderLayout.SOUTH);
        add(browseLoc, BorderLayout.SOUTH);
        

        
    }

        
    public void switchToMain(ActionListener al)  {    
        main.addActionListener(al);
    }
    public void switchToLenderInfo(ActionListener al) {
        lenderInfo.addActionListener(al);
    }
    public void switchToCustomerInfo(ActionListener al) {
        customerInfo.addActionListener(al);
    }
    public void switchToBrowseLoc(ActionListener al)  {    
        browseLoc.addActionListener(al);
    }

    
}
