package hw4;
/**
* Janiel Reyes
* 111307845
* HW # 4 
* Section 12
* Charles Chen
* Tim Zhang
*/
public class Student{
    private static int studentCounter=0;
    private int studentID;
    private int timeArrived;
    private int timeRequired;
    private Course course ;
    /**
     * Initializes the student to the given parameters
     * @param initTimeArrived
     * @param course
     * @param timeRequired
     * @throws IllegalArgumentException 
     */
    public Student(int initTimeArrived, Course course, int timeRequired)throws IllegalArgumentException{
        if(initTimeArrived <=0) throw new IllegalArgumentException("Time out of bounds");
       studentCounter++;
       studentID = studentCounter;
       this.timeRequired = timeRequired;
       timeArrived = initTimeArrived;
       this.course = course;
    }
/**
 * Retrieves the StudentCounter 
 * @return studentCounter
 */
    public static int getStudentCounter() {
        return studentCounter;
    }
/**
 * Retrieves StudentID
 * @return studentID
 */
    public int getStudentID() {
        return studentID;
    }
/**
 * Retrieves Time Arrived
 * @return timeArrived
 */
    public int getTimeArrived() {
        return timeArrived;
    }
/**
 * Retrieves Time Required
 * @return timeRequired
 */
    public int getTimeRequired() {
        return timeRequired;
    }
/**
 * Retrieves the course the student is in
 * @return 
 */
    public Course getCourse() {
        return course;
    }
    /**
     * Prints out student
     */
    public String toString(){
        return String.format("%-15s%-15s%-20s%-30s", studentID, course.getCourseNumber(), timeRequired, timeArrived);
    }
  
}   
