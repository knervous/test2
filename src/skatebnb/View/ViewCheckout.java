
package skatebnb.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Scrollable;


public class ViewCheckout extends JPanel {
    
    
    private final SkateDisplay skateDisplay;
    private final ResDisplay resDisplay;
    private final JScrollPane skateScroll;
    private final JScrollPane resScroll;
    private final ArrayList<JLabel> boardList;
    private final ArrayList<JLabel> resList;
    private final ArrayList<JLabel> skatePrices;
    private final ArrayList<JLabel> resPrices;
    private final ArrayList<Double> sPrice;
    private final ArrayList<Double> rPrice;
    private final ArrayList<JCheckBox> rental;
    private final ArrayList<JTextField> days;
    private final ArrayList<JTextField> rentDays;
    private final JButton update;
    private final JButton clear;
    private JPanel skateView;
    private JPanel resView;
    private double skateTotal=0;
    private double resTotal=0;
    private double total=0;
    private final NumberFormat formatter = new DecimalFormat("#0.00");
    private final JLabel displayTotal;
    
    public ViewCheckout()
    {
        super();
        setLayout(null);
        
        setVisible(true);
        
        JLabel skateHeader = new JLabel("<html><center><font size = \"5\"><u>SKATEBOARDS IN CART</u>: Rent or Buy + Days</font></center></html>");
        JLabel resHeader = new JLabel("<html><center><font size = \"5\"><u>RENTAL UNITS IN CART</u>: Enter Length in # Days</font></center></html>");

        
        boardList = new ArrayList<>();
        resList = new ArrayList<>();
        skateDisplay = new SkateDisplay();
        resDisplay = new ResDisplay();
        skatePrices = new ArrayList<>();
        resPrices = new ArrayList<>();
        rental = new ArrayList<>();
        sPrice = new ArrayList<>();
        rPrice = new ArrayList<>();
        days = new ArrayList<>();
        rentDays = new ArrayList<>();
        clear = new JButton("<html><font size = \"4\">Clear Entries</font></html>");
        update = new JButton("<html><font size = \"4\">Update Price</font></html>");
        clear.setBounds(500,65,200,50);
        update.setBounds(500,130,200,50);
        clear.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                clearAll();
            }
            
            
        });
        update.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                updateTotal();
            }
            
        });
        displayTotal = new JLabel("<html><font size = \"5\">Total for this order will be: "
                + "$"+formatter.format(total)+"</font><html>");
        displayTotal.setBounds(500,200,250,200);
        skateScroll = new JScrollPane(skateDisplay,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        skateScroll.setBounds(skateDisplay.getX(),skateDisplay.getY(),Double.valueOf(skateDisplay.getWidth()).intValue(),Double.valueOf(skateDisplay.getHeight()).intValue());
        resScroll = new JScrollPane(resDisplay,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        resScroll.setBounds(resDisplay.getX(),resDisplay.getY(),Double.valueOf(resDisplay.getWidth()).intValue(),Double.valueOf(resDisplay.getHeight()).intValue());
        skateScroll.getViewport().setLayout(null);
        resScroll.getViewport().setLayout(null);
        
        
        skateHeader.setBounds(0,0,400,35);
        resHeader.setBounds(0,260,450,35);
        
        add(skateHeader);
        add(resHeader);
        add(clear);
        add(update);
        add(skateScroll);
        add(resScroll);
        add(displayTotal);
        
        skateView = ((JPanel)skateScroll.getViewport().getView());
        resView = ((JPanel)resScroll.getViewport().getView());
        

    }
    
    public class SkateDisplay extends JPanel implements Scrollable
    {
        
        
        public SkateDisplay()
        {
            super();
            setVisible(true);
            setLayout(null);
            setBackground(Color.white);
            setBounds(0,35,450,230);
            
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return getPreferredSize();
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle rctngl, int i, int i1) {
            return 5;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle rctngl, int i, int i1) {
            return 5;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return false;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return true;
        }
        
        
        
 
    }
    
    public class ResDisplay extends JPanel implements Scrollable
    {
        
        
        public ResDisplay()
        {
            super();
            setVisible(true);
            setLayout(null);
            setBackground(Color.white);
            setBounds(0,295,450,230);
            
        }
        
        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return getPreferredSize();
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle rctngl, int i, int i1) {
            return 5;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle rctngl, int i, int i1) {
            return 5;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return false;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return true;
        }
    }
    
    public void addToSkateList(String board, final double price)
        {
            
            boardList.add(new JLabel(board));
            skatePrices.add(new JLabel("Cost: $"+formatter.format(price)));
            sPrice.add(price);
            rentDays.add(new JTextField("1"));
            rental.add(new JCheckBox("Rent"));
            
            
            for(int i=0;i<boardList.size();i++)
            {
                final int y = i;
                rental.get(i).addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                
                if(e.getStateChange() == ItemEvent.SELECTED) 
                {
                    sPrice.set(y,price/12);
                    rentDays.get(y).setBounds(375,10+(y*20),30,20);
                    
                } else 
                {
                    sPrice.set(y,price);
                    rentDays.get(y).setBounds(0,0,0,0);
                    rentDays.get(y).setText("1");
                }
                skatePrices.get(y).setText("Cost: $"+formatter.format(sPrice.get(y)));
                updateTotal();
                }
                });
                updateTotal();
                skateView.add(boardList.get(i));
                skateView.add(skatePrices.get(i));
                skateView.add(rental.get(i));
                skateView.add(rentDays.get(i));
                skateScroll.setPreferredSize(new Dimension(800,800));
                boardList.get(i).setBounds(0,(i*20),200,40);
                skatePrices.get(i).setBounds(175,(i*20),100,40);
                rental.get(i).setBounds(300,10+(i*20),55,20);
                
                skateView.revalidate();
            }
            
            
        }
    public void addToResList(String residence, double price)
        {
            resList.add(new JLabel(residence));
            resPrices.add(new JLabel("Cost: $"+formatter.format(price)));
            days.add(new JTextField("1"));
            rPrice.add(price);
            for(int i=0;i<resList.size();i++)
            {
                resView.add(days.get(i));
                resView.add(resList.get(i));
                resView.add(resPrices.get(i));
                
                
                updateTotal();
                resScroll.setPreferredSize(new Dimension(800,800));
                resView.validate();
                days.get(i).setBounds(350,10+(i*20),50,20);
                resList.get(i).setBounds(0,(i*20),200,40);
                resPrices.get(i).setBounds(200,(i*20),150,40);
                
            }
            
        }

    
    public SkateDisplay getSkateDisplay()
    {
        return skateDisplay;
    }
    
    public ResDisplay getResDisplay()
    {
        return resDisplay;
    }
    
    public void updateTotal()
    {
        ArrayList<Double> tempRPrice = (ArrayList<Double>) rPrice.clone();
        ArrayList<Double> tempSPrice = (ArrayList<Double>) sPrice.clone();
        total=0;
        for(int i=0;i<sPrice.size();i++)
        {
            try{
                    int set = Integer.parseInt(rentDays.get(i).getText());
                    tempSPrice.set(i, (set*sPrice.get(i)));
                }
                
                catch(Exception e){
                    rentDays.get(i).setText("1");
                }
            skatePrices.get(i).setText("Cost: $"+formatter.format(tempSPrice.get(i)));
        }
        
        for (Double sPrice1 : tempSPrice) 
        {
            total+=sPrice1;
        }
        
        for(int i=0;i<rPrice.size();i++)
        {
            try{
                    int set = Integer.parseInt(days.get(i).getText());
                    tempRPrice.set(i, (set*rPrice.get(i)));
                }
                
                catch(Exception e){
                    days.get(i).setText("1");
                }
            resPrices.get(i).setText("Cost: $"+formatter.format(tempRPrice.get(i)));
        }
        
        for (Double rPrice1 : tempRPrice) 
        {
            total+=rPrice1;
        }
        
        displayTotal.setText("<html><font size = \"5\">Total for this order will be: "
                + "$"+formatter.format(total)+"</font><html>");
        
    }
    
    public void clearAll()
    {
        skateView.removeAll();
        resView.removeAll();
        boardList.clear();
        resList.clear();
        skatePrices.clear();
        resPrices.clear();
        sPrice.clear();
        rPrice.clear();
        rental.clear();
        days.clear();
        repaint();
    }
    
    
}
