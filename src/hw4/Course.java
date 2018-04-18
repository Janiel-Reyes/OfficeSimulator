
package hw4;
/**
* Janiel Reyes
* 111307845
* HW # 4 
* Section 12
* Charles Chen
* Tim Zhang
*/
public class Course {
    private int courseNumber;
    private int courseDiffulty;
    private double arrivalProbability;
    /**
     * Initializes the course to the number and probability that people will show
     * @param courseNumber to what ever is given
     * @param arrivalProbability to whatever decimal that is given
     */
    public Course(int courseNumber,double arrivalProbability){
        this.courseNumber=courseNumber;
        this.arrivalProbability=arrivalProbability;   
    }
    /**
     * Sets the course difficulty
     * @param courseDiffulty 
     */
    public void setCourseDiffulty(int courseDiffulty) {
        this.courseDiffulty = courseDiffulty;
    }
    /**
     * Retrieves the CourseNumber
     * @return courseNumber
     */
    public int getCourseNumber() {
        return courseNumber;
    }
    /**
     * Retrieves course difficulty
     * @return courseDifficulty
     */
    public int getCourseDiffulty() {
        return courseDiffulty;
    }
    /**
     * Retrieves Arrival Probability
     * @return arrivalProbability
     */
    public double getArrivalProbability() {
        return arrivalProbability;
    }
}
