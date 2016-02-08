
package skatebnb.View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import skatebnb.Models.Skateboard;


public class SkatePopup extends JFrame{
    
    
    private JPanel panel;
    private JPanel buttonPanel;
    private JButton addToCart;
    private JButton cancel;
    private JLabel resInfo;
    private String city;
    private String[] parts;
    private int[] prices;
    private int total;
    private Enumeration e;
    
    
    public SkatePopup()
    {
        super();
        setVisible(false);
    }
    
    public SkatePopup(String infCity, Skateboard infSkate)
    {
        super("Skateboard Information");
        Skateboard skate = infSkate;
        city = infCity;
        parts = skate.getBoard();
        prices = new int[5];
        panel = new JPanel();
        buttonPanel = new JPanel();
        addToCart = new JButton("Add to Cart");
        cancel = new JButton("Cancel");
        resInfo = new JLabel();
        setSize(400,300);
        setVisible(true);
        panel.setLayout(new BorderLayout());
        add(panel);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(resInfo, BorderLayout.NORTH);
        buttonPanel.add(cancel, BorderLayout.SOUTH);
        buttonPanel.add(addToCart, BorderLayout.SOUTH);
        
        
        
        
        
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent al) {
                close();
            }
        }
        
        );
        
        total = 0;
        for(int i=0;i<5;i++)
        {
            prices[i] = skate.getPriceList().get(parts[i]);
            total+=prices[i];
        }
        
        
        
        resInfo.setText("<html><font size= \"5\">"
                + "<center>&nbsp;&nbsp;<u>Skateboard Information</u></center>"
                + "&nbsp; City: "+city
                + "<br>&nbsp; Deck: "+parts[0]+" $"+prices[0]
                + "<br>&nbsp; Bearings: "+parts[1]+" $"+prices[1]
                + "<br>&nbsp; Grip Tape: "+parts[2]+" $"+prices[2]
                + "<br>&nbsp; Trucks: "+parts[3]+" $"+prices[3]
                + "<br>&nbsp; Wheels: "+parts[4]+" $"+prices[4]
                + "<br>&nbsp; Total To Rent Per Day: $"+(total/12)
                + "<br>&nbsp; Total To Own: $"+total
                +"</html>");
        
        
        
    }
    
    public String getBoard()
    {
        return parts[0]+" deck";
    }
    
    public double getPrice()
    {
        return total;
    }
    
    public void skateConfirm(ActionListener al)
    {
        addToCart.addActionListener(al);
    }
    
    public void close()
    {
        setVisible(false);
        dispose();
    }
    
    
    
    
    
}
