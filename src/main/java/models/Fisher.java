package models;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import dao.FisherDao;
import java.util.List;
/**
 * @author Andrei Vasilencko
 */





public class Fisher {
    private String id;
    private String displayName;
    private double totalWeightKG = 0;
    private int fishCount = 0;
    
    private static FisherDao fisherDao = new FisherDao();
        
    public Fisher(){}
    
     public Fisher(String displayName){
        this.displayName = displayName;
        id = UUID.randomUUID().toString();
 
    }
     
     
    
    private void addFish(double weight){
        fishCount++;
        totalWeightKG+=weight;
    }
    
    
    public String getName(){
        return this.displayName;
    }
    
    public String getID(){
        return this.id;
    }
    
    public void setName(String displayName){
        this.displayName = displayName;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    
    public double catchFish(){
        double weight = ThreadLocalRandom.current().nextDouble(1, 10 + 1);
        addFish(weight);
        return weight;
    }
   
    public void save(){
        fisherDao.insert(this);
    }
   
  
    public double getCatch(){
        return totalWeightKG;
    }
    
    public int getCountOfFish() {
        return fishCount;
    }
    
    @Override
    public String toString() { 
        return String.format(id + "  weight:" + totalWeightKG + " count:" + fishCount ); 
    } 
    public static List<Fisher> getAll(){
        return fisherDao.selectAllFishers();
    }
    
     public static boolean deleteOne(String username){
        return false;
    }

}


