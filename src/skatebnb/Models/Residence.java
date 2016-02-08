
package skatebnb.Models;

import java.util.ArrayList;


public class Residence {
    
    
    
    private String residenceType;
    private int maxOccupancy;
    private int currentOccupancy;
    private boolean petFriendly;
    private double price;
    private String isPetFriendly;
    private String cityLoc;
    
    public Residence()
    {
        residenceType="";
        maxOccupancy=0;
        currentOccupancy=0;
        price=0;
        petFriendly=true;
        createResidence();
        
    }
    
    public Residence(String infResType, String infPetFriendly, int infMaxOcc, int infCurrentOcc, int infPrice, String infCityLoc)
    {
        residenceType = infResType;
        isPetFriendly = infPetFriendly;
        maxOccupancy = infMaxOcc;
        currentOccupancy = infCurrentOcc;
        price = infPrice;
        cityLoc = infCityLoc;
        petFriendly = !isPetFriendly.equalsIgnoreCase("no");
    }
    
    public void createResidence()
    {

        int rand = 1+Double.valueOf(Math.random()*3).intValue();
        
        if(rand==1)
        {
            residenceType="Apartment";
            maxOccupancy = 4+Double.valueOf(Math.random()*5).intValue();
            currentOccupancy = maxOccupancy - (Double.valueOf(Math.random()*maxOccupancy).intValue());  
            price = 40 +  Double.valueOf(Math.random()*35);
            price -= Double.valueOf(Math.random()*35);
        }
        else if(rand==2)
        {
            residenceType="House";
            maxOccupancy = 4+Double.valueOf(Math.random()*12).intValue();
            currentOccupancy = maxOccupancy - (Double.valueOf(Math.random()*maxOccupancy).intValue());  
            price = 75 +  Double.valueOf(Math.random()*50);
            price -= Double.valueOf(Math.random()*50);
        }
        else if(rand==3)
        {
            residenceType="Hostel";
            maxOccupancy = 4+Double.valueOf(Math.random()*40).intValue();
            currentOccupancy = maxOccupancy - (Double.valueOf(Math.random()*maxOccupancy).intValue());  
            price = 25 +  Double.valueOf(Math.random()*20);
            price -= Double.valueOf(Math.random()*20);
        }
        
        rand = 1+Double.valueOf(Math.random()*2).intValue();
        if(rand==1)
        {petFriendly=true;}
        else if(rand==2)
        {petFriendly=false;}
        
        
    }
    
    public String getResidence()
    {
        return residenceType;
    }
    
    public int getMaxOcc()
    {
        return maxOccupancy;
    }
    
    public int getCurrentOcc()
    {
        return currentOccupancy;
    }
    
    public double getPrice()
    {
        return price;
    }
    public String getPetFriendly()
    {
        return isPetFriendly;
    }
    public boolean getPet()
    {
        return petFriendly;
    }
    public String getCityLoc()
    {
        return cityLoc;
    }
}
