
package skatebnb.Models;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;


public class Location {
    
    private ArrayList<Residence> residences;
    private ArrayList<Skateboard> skateboards;
    private final ArrayList<String> locations;
    private Hashtable<String,ArrayList<Residence>> resData;
    private Hashtable<String,ArrayList<Skateboard>> skateData;
    

    
    public Location()
    {
        residences = new ArrayList<Residence>();
        skateboards = new ArrayList<Skateboard>();
        resData = new Hashtable<String,ArrayList<Residence>>();
        skateData = new Hashtable<String,ArrayList<Skateboard>>();
        locations = new ArrayList<String>();
        createLocations();
        populateHash();
        
    }
    
    public void createLocations()
    {
        locations.add("New York City");
        locations.add("Philadelphia");
        locations.add("Los Angeles");
        locations.add("Miami");
        locations.add("Detroit");
        locations.add("Kansas City");
        locations.add("Chicago");
        locations.add("Lincoln");
        locations.add("Boulder");
        locations.add("Baltimore");
    }
    
    public void populateHash()
    {
        
        for(int i = 0;i<locations.size();i++)
        {
            skateboards.clear();
            residences.clear();
            
            int randSkate=0;
            int randRes=0;
            randSkate = Double.valueOf(5+Math.random()*15).intValue();
            randRes = Double.valueOf(4+Math.random()*10).intValue();

            for(int x=0;x<randSkate;x++)
            {
                skateboards.add(new Skateboard());
            }
            for(int y=0;y<randRes;y++)
            {
                residences.add(new Residence());
            }
            
            skateData.put(locations.get(i), (ArrayList<Skateboard>)skateboards.clone());
            resData.put(locations.get(i), (ArrayList<Residence>)residences.clone());
            
            
        }

        
    }
    
    public void enterLocation(){}
    
    public ArrayList<Skateboard> getSkateboard()
    {
        return skateboards;
    }
    
    public ArrayList<Residence> getResidence()
    {
        return residences;
    }
    public ArrayList<String> getLoc()
    {
        return locations;
    }
    public void addLocation(String addCity)
    {
        locations.add(addCity);
    }
    public Hashtable<String, ArrayList<Skateboard>> getSkateData()
    {
        return skateData;
    }
    public Hashtable<String, ArrayList<Residence>> getResData()
    {
        return resData;
    }
    
}
