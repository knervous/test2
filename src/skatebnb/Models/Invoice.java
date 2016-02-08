
package skatebnb.Models;


public class Invoice {
    
    
    private int totalCost;
    
    public Invoice()
    {
        totalCost=0;
    }
    
    public float computeBoardCost(int quantity, int price)
    {
        return price*quantity;
    }
    
    public float computeResidenceCost(int days, int price)
    {
        return price*days;
    }
    
    public float computeTotalCost(float boardCoast, float residenceCost)
    {
        return boardCoast+residenceCost;
    }
    
   
}
