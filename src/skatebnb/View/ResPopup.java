
package skatebnb.View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import skatebnb.Models.Residence;


public class ResPopup extends JFrame{
    
    
    private JPanel panel;
    private JPanel buttonPanel;
    private JButton addToCart;
    private JButton cancel;
    private JLabel resInfo;
    private String city;
    private String pet;
    private String getRes;
    private double getPrice;
    
    public ResPopup()
    {
        super();
        setVisible(false);
    }
    public ResPopup(String infCity, Residence infRes)
    {
        super("Rental Unit Information");
        Residence res = infRes;
        city = infCity;
        getRes = res.getResidence();
        getPrice = res.getPrice();
        
        if(res.getPet()==true)
            pet="Yes";
        else 
            pet="No";
        
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

        
        NumberFormat formatter = new DecimalFormat("#0.00");
        
        resInfo.setText("<html><font size= \"5\">"
                + "<center>&nbsp;&nbsp;<u>Unit Information</u></center>"
                + "&nbsp; City: "+city
                + "<br>&nbsp; Residence Type: "+res.getResidence()
                + "<br>&nbsp; Cost Per Night: $"+formatter.format(res.getPrice())
                + "<br>&nbsp; Pet Friendly: "+pet
                + "<br>&nbsp; Max Occupancy: "+res.getMaxOcc()
                + "<br>&nbsp; Current Rooms Available: "+res.getCurrentOcc()+"</html>");
        
        
        
    }
    
    public String getRes()
    {
        return getRes+" in "+city;
    }
    public double getPrice()
    {
        return getPrice;
    }
    
    public void resConfirm(ActionListener al)
    {
        addToCart.addActionListener(al);
    }
    
    public void close()
    {
        setVisible(false);
        dispose();
    }
    
    
    
    
    
}
