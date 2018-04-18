package hw4;
/**
* Janiel Reyes
* 111307845
* HW # 4 
* Section 12
* Charles Chen
* Tim Zhang
*/
public class BooleanSource {

    private double probability;

    public BooleanSource(double initProbability) throws IllegalArgumentException {
        if(initProbability<= 0 || initProbability > 1) throw new IllegalArgumentException("Error number out of bounds") ;
        probability = initProbability;        
    }
    public boolean occurs(){
        if(probability > Math.random()) return true;
        else return false;
    }

}
