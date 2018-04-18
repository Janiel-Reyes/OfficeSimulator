
package hw4;
/**
* Janiel Reyes
* 111307845
* HW # 4 
* Section 12
* Charles Chen
* Tim Zhang
*/
public class Helper {
    private int timeLeftTilFree;
    private int TANum;
    private final boolean isProfessor;
    private Student studentBeingHelped;
    public Helper(boolean isProfessor,int TANum){
        timeLeftTilFree =0;
        this.isProfessor=isProfessor;
        this.TANum = TANum; 
    }
    /**
     * Sets the time free for helper
     * @param timeLeftTilFree based on maxTime and minTime passed
     */
    public void setTimeLeftTilFree(int timeLeftTilFree) {
        if(isProfessor) this.timeLeftTilFree = timeLeftTilFree;
        else this.timeLeftTilFree= timeLeftTilFree*2;
    }
    /**
     * Gets time until free of helper
     * @return timeLeftTilFree
     */
    public int getTimeLeftTilFree() {
        return timeLeftTilFree;
    }
    /**
     * Sets the current that is being worked on used to hold the time required variable
     * @param student1 
     */
    public void setStudentHelping(Student student1){
        studentBeingHelped = student1;
    }
    /**
     * Prints out information of professor and helpers side
     */
    public void printHelperTime(){
        if(timeLeftTilFree ==0){
             if(isProfessor) System.out.println("Professor is waiting for next student to arrive");
             else System.out.println("TA "+TANum+" is waiting for next student to arrive");
        }
        else{
            if(isProfessor) System.out.println("Professor is helping student "+ studentBeingHelped.getStudentID()+" "+studentBeingHelped.getTimeRequired()+" remaining");
            else System.out.println("TA "+TANum+" is helping student "+studentBeingHelped.getStudentID()+" "+studentBeingHelped.getTimeRequired()+" remaining.");
        }    
    }
    /**
     * Gets the boolean if the helper is a professor or not
     * @return isProfessor true is professor false is ta
     */
    public boolean isProfessor(){
        return isProfessor;
    }
}
