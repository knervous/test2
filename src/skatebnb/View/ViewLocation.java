
package skatebnb.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import skatebnb.Models.Location;
import skatebnb.Models.Residence;
import skatebnb.Models.Skateboard;

/**
 *
 * @author Paul
 */
public class ViewLocation extends JPanel {
    

    private final Location location;
    private final Hashtable<String,ArrayList<Skateboard>> skateData;
    private final Hashtable<String,ArrayList<Residence>> resData;
    private LeftPanel leftPanel;
    private RightPanel rightPanel;
    private String name;
    private static String globalCity="";
    private final int skateSize=0;
    private final int resSize=0;
    
    public ViewLocation(Location inf_location)
    {
        
        
        super();
        name="New York City";
        location = inf_location;
        skateData = location.getSkateData();
        resData = location.getResData();
        
        leftPanel = new LeftPanel();
        rightPanel = new RightPanel();
        
        setLayout(new BorderLayout());
        setBackground(Color.gray);
        setVisible(true);
        add(leftPanel);
        add(rightPanel);
        
        rightPanel.skateLabel.setCityName(name);
        rightPanel.resLabel.setCityName(name);
        rightPanel.cityLabel.setText("<html><font size=\"5\">Displaying results from:<font color=\"BLUE\">    "+name+"</html>");
        
        
        leftPanel.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            JTable target = (JTable)e.getSource();
            int row = target.getSelectedRow();
            int col = target.getSelectedColumn();
            name = (String) leftPanel.getTable().getModel().getValueAt(row, col);
            globalCity = name;
            rightPanel.cityLabel.setText("<html><font size=\"5\">Displaying results from:<font color=\"BLUE\">    "+name+"</html>");
            rightPanel.skateLabel.setCityName(name);
            rightPanel.resLabel.setCityName(name);
        }
        });
        
        
       
        
        
    }
    
    public class LeftPanel extends JPanel
    {
        private JTable table;
        private Enumeration e;
        private DefaultTableModel model;
        
        public LeftPanel()
        {
            super();
            setSize(300,600);
            setLayout(new BorderLayout());
            setBackground(Color.gray);
            table = new JTable();
            model = new DefaultTableModel(new Object[]{"Locations"},0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                return false;
             }
            };
            table.setModel(model);


            model = (DefaultTableModel) table.getModel();

            cityPopulate();
            
            JScrollPane scrollPane = new JScrollPane(table);
            this.removeAll();
             this.add(scrollPane);
        }
        
        public void cityPopulate()
        {
            model.setRowCount(0);
            for(int i = 0;i<location.getLoc().size();i++)
            {
                model.addRow(new Object[]{location.getLoc().get(i)});
            }
        }
        
        public JTable getTable()
        {
            return table;
        }
        
    }
    
    public class RightPanel extends JPanel
    {
        private JButton testButton = new JButton();
        private JLabel cityLabel = new JLabel("<html><font size \"5\">Displaying results from: <html>");
        private String cityName="New York City";
        private ResLabel resLabel;
        private SkateLabel skateLabel;
        private JButton checkout = new JButton("Go to Checkout");
        
        
        public RightPanel()
        {
            super();
            setSize(500,600);
            setBackground(Color.white);
            setLayout(null);
            resLabel = new ResLabel();
            skateLabel = new SkateLabel();
            add(cityLabel);
            add(resLabel);
            add(skateLabel);
            add(checkout);
            checkout.setBounds(300,450,494,75);
            cityLabel.setBounds(330,0,500,50);
            resLabel.setBounds(300,50,250,400);
            skateLabel.setBounds(550,50,250,400);
            
        }
        
        public void switchToCheckoutView(ActionListener al)
        {
            checkout.addActionListener(al);
        }
        
        public class ResLabel extends JPanel
        {
            private JTable table;
            private Enumeration e;
            private DefaultTableModel model;
            private int cellNum=0;
            
            public ResLabel()
            {
                super();
                setLayout(new BorderLayout());
                setBackground(Color.RED);
                table = new JTable();
                model = new DefaultTableModel(new Object[]{"Rental Units - Click for Info"},0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                return false;
                }
                };
                table.setModel(model);
                
                table.setBounds(550,50,250,300);
                JScrollPane scrollPane = new JScrollPane(table);
                this.removeAll();
                this.add(scrollPane);
                
               
            }
            
            public void resTable(MouseAdapter ma)
            {
                table.addMouseListener(ma);
            }
            
            public void setCityName(String name)
            {
                
                model.setRowCount(0);
                cityName = name;
                for(int i=0;i<resData.get(cityName).size();i++)
                {
                    model.addRow(new Object[]{resData.get(cityName).get(i).getResidence()});
                }
            }
            
      
        }
        public class SkateLabel extends JPanel
        {
            private JTable table;
            private DefaultTableModel model;
            private int cellNum=0;
            
            public SkateLabel()
            {
                super();
                setLayout(new BorderLayout());
                setBackground(Color.YELLOW);
                table = new JTable();
                model = new DefaultTableModel(new Object[]{"Boards - Click for Info"},0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                return false;
                }
                };
                
                table.setModel(model);
                table.setBounds(550,50,250,300);
                JScrollPane scrollPane = new JScrollPane(table);
                this.removeAll();
                this.add(scrollPane);
                  
            }
            
            public void skateTable(MouseAdapter ma)
            {
                table.addMouseListener(ma);
            }
            
            public void setCityName(String name)
            {
                model.setRowCount(0);

                
                String[] infBoard = new String[5];
                for(int i=0;i<skateData.get(name).size();i++)
                {
                    infBoard = skateData.get(name).get(i).getBoard();
                    model.addRow(new Object[]{"Board available! Deck: "+infBoard[0]});
                }
            }
            
        }
    public ResLabel getResLabel()
    {
        return resLabel;
    }
    public SkateLabel getSkateLabel()
    {
        return skateLabel;
    }
    public String getCityName()
    {
        return cityName;
    }
        
        
        
    }
    
    public void setSkateData(Skateboard board)
    {
        Enumeration e;
        boolean hasCity=false;
        e = skateData.keys();
        while(e.hasMoreElements())
        {
            if(e.nextElement().equals(board.getCityLoc()))
            {
                hasCity = true;
                
            }
        }
        if(hasCity == true)
        {
            skateData.get(board.getCityLoc()).add(board);
        }
        else
        {
            resData.put(board.getCityLoc(), new ArrayList<Residence>());
            skateData.put(board.getCityLoc(), new ArrayList<Skateboard>(Arrays.asList(board)));
        }
        
        if(!location.getLoc().contains(board.getCityLoc()))
        {
        location.addLocation(board.getCityLoc());
        }
        leftPanel.cityPopulate();
    }
    
    public void setResData(Residence res)
    {
        Enumeration e;
        boolean hasCity=false;
        e = resData.keys();
        while(e.hasMoreElements())
        {
            if(e.nextElement().equals(res.getCityLoc()))
            {
                hasCity = true;
                
            }
        }
        if(hasCity == true)
        {
            resData.get(res.getCityLoc()).add(res);
        }
        else
        {
            resData.put(res.getCityLoc(), new ArrayList<Residence>(Arrays.asList(res)));
            skateData.put(res.getCityLoc(), new ArrayList<Skateboard>());
        }
        
        if(!location.getLoc().contains(res.getCityLoc()))
        {
        location.addLocation(res.getCityLoc());
        }
        leftPanel.cityPopulate();
    }
    
    
    
    public void setResData()
    {
        
    }
    
    public Hashtable<String,ArrayList<Skateboard>> getSkateData()
    {
        return skateData;
    }
    
    public Hashtable<String,ArrayList<Residence>> getResData()
    {
        return resData;
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
