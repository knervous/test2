
package skatebnb.View;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import skatebnb.Models.Residence;
import skatebnb.Models.Skateboard;


public class ViewLender extends JPanel{
    
    
    private final LeftPanel leftPanel;
    private final RightPanel rightPanel;
    
    public ViewLender()
    {
        super();
        setVisible(true);
        setLayout(new GridLayout(1,2));
        
        leftPanel = new LeftPanel();
        rightPanel = new RightPanel();
        
        add(leftPanel);
        add(rightPanel);
        
    }
    
    public class LeftPanel extends JPanel
    {

        private final String[] parts;
        private final int[] prices;
        private final ArrayList<JTextField> inParts;
        private final ArrayList<JTextField> inPrice;
        private final JTextField loc;
        private final JButton skateSubmit;
        private String cityInput;
        
        public LeftPanel()
        {
            super();
            setLayout(null);
            parts = new String[5];
            prices = new int[5];
            inParts = new ArrayList<>();
            inPrice = new ArrayList<>();
            loc = new JTextField();
            cityInput= "";
            skateSubmit = new JButton("SUBMIT ENTRY");
            
            
            JLabel skateHeader = new JLabel("<html><font size = \"5\">Enter Skateboard Info to Lend</font></html>");
            JLabel type = new JLabel("<html><font size = \"4\">TYPE</font></html>");
            JLabel labelPrice = new JLabel("<html><font size = \"4\">PRICE</font></html>");
            JLabel deckType = new JLabel("<html><font size = \"3\">Deck: </font></html>");
            JLabel bearingsType = new JLabel("<html><font size = \"3\">Bearings: </font></html>");
            JLabel gripTapeType = new JLabel("<html><font size = \"3\">Griptape: </font></html>");
            JLabel trucksType = new JLabel("<html><font size = \"3\">Trucks: </font></html>");
            JLabel wheelsType = new JLabel("<html><font size = \"3\">Wheels: </font></html>");
            JLabel location = new JLabel("<html><font size = \"5\">Enter Location</font></html>");
            
            
            skateHeader.setBounds(60,10,300,50);
            type.setBounds(100,50,50,50);
            labelPrice.setBounds(290,50,50,50);
            deckType.setBounds(10,75,50,50);
            bearingsType.setBounds(10,100,50,50);
            gripTapeType.setBounds(10,125,50,50);
            trucksType.setBounds(10,150,50,50);
            wheelsType.setBounds(10,175,50,50);
            location.setBounds(130,300,300,50);
            loc.setBounds(108,350,175,30);
            skateSubmit.setBounds(95,400,200,50);
            
            
            add(skateHeader);
            add(type);
            add(labelPrice);
            add(deckType);
            add(bearingsType);
            add(gripTapeType);
            add(trucksType);
            add(wheelsType);
            add(location);
            add(loc);
            add(skateSubmit);
            
            for(int i=0;i<5;i++)
            {
                inParts.add(new JTextField("ENTER PART"));
                inPrice.add(new JTextField("0"));
                inParts.get(i).setBounds(90,92+25*i,120,20);
                inPrice.get(i).setBounds(270,92+25*i,75,20);
                add(inParts.get(i));
                add(inPrice.get(i));
            }
        }
        
        public void submitSkate(ActionListener al)
        {
            skateSubmit.addActionListener(al);
            
        }
        
        public Skateboard getBoard()
        {
            cityInput=loc.getText();
            for(int i=0;i<5;i++)
            {
                parts[i] = inParts.get(i).getText();
                
                try{
                    prices[i] = Integer.parseInt(inPrice.get(i).getText());
                }
                catch(Exception e)
                {
                    prices[i] = 0;
                }

            }

            Skateboard skateboard = new Skateboard(parts, prices, cityInput);
            
            return skateboard;
        }
    }
    
    
    
    
    public class RightPanel extends JPanel
    {
        private final JLabel resHeader;
        private final ArrayList<JTextField> inputs;
        private final JTextField loc;
        private final JButton resSubmit;
        private String cityInput;
        private final String info[];
        private int iMaxOcc=0;
        private int iCurOcc=0;
        private int price=0;
        
        public RightPanel()
        {
            super();
            setLayout(null);
            
            resHeader = new JLabel("<html><font size = \"5\">Enter Residence Info to Lend</font></html>");
            JLabel resType = new JLabel("<html><font size = \"3\">Residence Type: </font></html>");
            JLabel costPerNight = new JLabel("<html><font size = \"3\">Cost Per Night: </font></html>");
            JLabel petFriendly = new JLabel("<html><font size = \"3\">Pet Friendly: </font></html>");
            JLabel maxOcc = new JLabel("<html><font size = \"3\">Max Occupants: </font></html>");
            JLabel currentOcc = new JLabel("<html><font size = \"3\">Current Occupants: </font></html>");
            JLabel location = new JLabel("<html><font size = \"5\">Enter Location</font></html>");
            resSubmit = new JButton("SUBMIT ENTRY");
            loc = new JTextField();
            inputs = new ArrayList<>();
            cityInput="";
            info = new String[2];
            
            resHeader.setBounds(60,10,300,50);
            resType.setBounds(10,75,100,50);
            costPerNight.setBounds(10,100,100,50);
            petFriendly.setBounds(10,125,100,50);
            maxOcc.setBounds(10,150,100,50);
            currentOcc.setBounds(10,175,120,50);
            location.setBounds(130,300,300,50);
            loc.setBounds(108,350,175,30);
            resSubmit.setBounds(95,400,200,50);
            
            for(int i=0;i<5;i++)
            {
                inputs.add(new JTextField("ENTER INFO"));
                inputs.get(i).setBounds(140,92+25*i,120,20);
                add(inputs.get(i));
            }
 
            add(resHeader);
            add(resType);
            add(costPerNight);
            add(petFriendly);
            add(maxOcc);
            add(currentOcc);
            add(location);
            add(loc);
            add(resSubmit);
        }
        
        public void submitRes(ActionListener al)
        {
            resSubmit.addActionListener(al);
        }
        
        public Residence getRes()
        {
            cityInput=loc.getText();
            info[0] = inputs.get(0).getText();
            info[1] = inputs.get(2).getText();
            
                
                try{
                    price = Integer.parseInt(inputs.get(1).getText());
                }
                catch(Exception e)
                {
                    price = 0;
                }
                try{
                    iMaxOcc = Integer.parseInt(inputs.get(3).getText());
                }
                catch(Exception e)
                {
                    iMaxOcc = 0;
                }
                try{
                    iCurOcc = Integer.parseInt(inputs.get(4).getText());
                }
                catch(Exception e)
                {
                    iCurOcc = 0;
                }

            Residence residence = new Residence(info[0],info[1],iMaxOcc,iCurOcc,price,cityInput);
            
            return residence;
        }
    }
    
    public LeftPanel getLeftPanel()
    {
        return leftPanel;
    }
    
    public RightPanel getRightPanel()
    {
        return rightPanel;
    }
    
}
