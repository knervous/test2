
package skatebnb.Models;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Hashtable;


public class Skateboard {
    
    private String[] deck;
    private String[] bearings;
    private String[] gripTape;
    private String[] trucks;
    private String[] wheels;
    private String[] board;
    private String cityLocation;
    private Hashtable<String, Integer> priceList;
    private int[] prices;
    private ArrayList<Integer> randoms;
    
    public Skateboard()
    {
        board = new String[5];
        priceList = new Hashtable<String, Integer>();
        deck = new String[] {"Globe","Mystery","Darkstar","Skate Warehouse","Stereo"};
        bearings = new String[] {"11:11","Lucky","Modus","Independent","Diamond"};
        gripTape = new String[] {"High Times","Bullet","Kayo","Krux","Zero"};
        trucks = new String[] {"Destructo","Paris","Independent Trucks","Venture","Royal","Destructo"};
        wheels = new String[] {"Spitfire","Plan B","Chocolate","Orbs","Element"};
        prices = new int[] {    20,25,28,21,20,
                                10,30,15,12,15,
                                5,10,8,12,7,
                                33,30,28,25,18,
                                45,40,60,39,50};
        populateHash();
        createBoard();
    }
    
    public Skateboard(String[] parts, int[] infPrices, String infLoc)
    {
        cityLocation = infLoc;
        board = parts;
        prices = infPrices;
        priceList = new Hashtable<String, Integer>();
        populateHash(board, prices);
    }
    

    public void createBoard()
    {
        randoms = new ArrayList<Integer>();
        double rand=0;
        for(int i = 0;i<5;i++)
        {
            rand = Math.random()*5;
            randoms.add(Double.valueOf(rand).intValue()); 
        }
        board[0]=deck[randoms.get(0)];
        board[1]=bearings[randoms.get(1)];
        board[2]=gripTape[randoms.get(2)];
        board[3]=trucks[randoms.get(3)];
        board[4]=wheels[randoms.get(4)];
        
    }
    
    public void populateHash()
    {
        for(int i=0;i<5;i++)
        {
            priceList.put(deck[i], prices[i]);
        }
        for(int i=0;i<5;i++)
        {
            priceList.put(bearings[i], prices[i+5]);
        }
        for(int i=0;i<5;i++)
        {
            priceList.put(gripTape[i], prices[i+10]);
        }
        for(int i=0;i<5;i++)
        {
            priceList.put(trucks[i], prices[i+15]);
        }
        for(int i=0;i<5;i++)
        {
            priceList.put(wheels[i], prices[i+20]);
        }
                
    }
    
    public void populateHash(String[] infBoard, int[] infPrices)
    {
        for(int i=0;i<5;i++)
        {
            
            priceList.put(infBoard[i], infPrices[i]);
        }
    }
    
    public void listSpecs()
    {
        System.out.println("Deck: "+board[0]);
        System.out.println("bearings: "+board[1]);
        System.out.println("Grip Tape: "+board[2]);
        System.out.println("Trucks: "+board[3]);
        System.out.println("Wheels: "+board[4]);
        
    }
    
    public String[] getBoard()
    {
        return board;
    }
    
    
    public int[] getPrices()
    {
        return prices;
    }
    
    public Hashtable<String, Integer> getPriceList()
    {
        return priceList;
    }
    
    public String getCityLoc()
    {
        return cityLocation;
    }
    
    
}
