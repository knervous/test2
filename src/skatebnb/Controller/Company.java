/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skatebnb.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import skatebnb.Models.*;
import skatebnb.View.*;

/**
 *
 * @author Paul
 */
public class Company extends JPanel {
    
    protected Buttons buttons;
    protected ViewCustomerInfo viewCustomer;
    protected ViewCheckout viewCheckout;
    protected ViewLocation viewLocation;
    protected ViewMain viewMain;
    protected ViewLender viewLender;
    protected SkatePopup skatePopup;
    protected ResPopup resPopup;
    private ArrayList<Customer> customers;
    private Location location;
    private Invoice invoice;

    
    public Company()
    {
        setBackground(Color.gray);		
        setLayout(new BorderLayout());
        
        
        location = new Location();
        customers = new ArrayList<>();
        invoice = new Invoice();
        customers.add(new Customer());

        
        viewMain = new ViewMain();
        viewLocation = new ViewLocation(location);
        viewCheckout = new ViewCheckout();
        viewCustomer = new ViewCustomerInfo();
        viewLender = new ViewLender();
        skatePopup = new SkatePopup();
        resPopup = new ResPopup();
        buttons = new Buttons();
        
        add(buttons, BorderLayout.SOUTH);
        add(viewMain);
        
        
     
        
        buttons.switchToMain(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e)
            {
                clearTopPanel();
                add(viewMain, BorderLayout.CENTER);
            }
        }); 
        buttons.switchToLenderInfo(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e)
            {
                clearTopPanel();
                add(viewLender, BorderLayout.CENTER);
            }
        }); 
        buttons.switchToBrowseLoc(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e)
            {
                clearTopPanel();
                add(viewLocation, BorderLayout.CENTER);
            }
        });

        buttons.switchToCustomerInfo(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e)
            {
                clearTopPanel();
                add(viewCustomer, BorderLayout.CENTER);
            }
        }); 

        viewLocation.getRightPanel().switchToCheckoutView(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e)
            {
                clearTopPanel();
                add(viewCheckout, BorderLayout.CENTER);
            }
        }); 
        
        
        viewLender.getLeftPanel().submitSkate(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                Skateboard infSkate = viewLender.getLeftPanel().getBoard();
                viewLocation.setSkateData(infSkate);
            }
            
        });
        
        viewLender.getRightPanel().submitRes(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                Residence infRes = viewLender.getRightPanel().getRes();
                viewLocation.setResData(infRes);
            }
            
        });
        
        
        viewLocation.getRightPanel().getSkateLabel().skateTable(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                JTable target = (JTable)e.getSource();
                int row = target.getSelectedRow();
                int col = target.getSelectedColumn();
                skatePopup.dispose();
                skatePopup = new SkatePopup(viewLocation.getRightPanel().getCityName(), viewLocation.getSkateData().get(viewLocation.getRightPanel().getCityName()).get(row));
                skatePopup.skateConfirm(new ActionListener() {    
                @Override
                public void actionPerformed(ActionEvent e)
                {
                viewCheckout.addToSkateList(skatePopup.getBoard(), skatePopup.getPrice());
                skatePopup.close();
                }
                }); 
                    }
                    });
        
        viewLocation.getRightPanel().getResLabel().resTable(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                JTable target = (JTable)e.getSource();
                int row = target.getSelectedRow();
                int col = target.getSelectedColumn();
                resPopup.dispose();
                resPopup = new ResPopup(viewLocation.getRightPanel().getCityName(), viewLocation.getResData().get(viewLocation.getRightPanel().getCityName()).get(row));
                resPopup.resConfirm(new ActionListener() {    
                @Override
                public void actionPerformed(ActionEvent e)
                {
                viewCheckout.addToResList(resPopup.getRes(), resPopup.getPrice());
                resPopup.close();
                }
                }); 
                    }
                    });
        
        
    }
    
    
    public void clearTopPanel()
    {
        remove(viewMain);
        remove(viewLender);
        remove(viewLocation);
        remove(viewCheckout);
        remove(viewCustomer);
        revalidate();
        repaint();
    }
    
    public Location getLoc()
    {
        return location;
    }
    
    public ViewCheckout getViewCheckout()
    {
        return viewCheckout;
    }
    
    
    

    
}
