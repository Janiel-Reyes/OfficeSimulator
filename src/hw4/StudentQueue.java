package hw4;
import hw4.Student;
import java.util.*;
/**
* Janiel Reyes
* 111307845
* HW # 4 
* Section 12
* Charles Chen
* Tim Zhang
*/
public class StudentQueue extends ArrayList<Student> {
    
    public StudentQueue(){
        super();
    }
    /**
     *   Enqueues the passed in Student into the specified StudentQueue.
     * Preconditions: The StudentQueue object should be instantiated.
     * Postconditions:Given that the Student specified was not null,
     * the Student should be added to the proper position of the StudentQueue.
     * @param s is added to the queue 
     */
    public void enqueue(Student studentAdd){
        boolean placed = false;

        if(studentAdd != null){
            if(isEmpty()){
                add(studentAdd);
            }else{
                for(int i = 0;i < size(); i++){
                    if(studentAdd.getCourse().getCourseNumber()>= get(i).getCourse().getCourseNumber()&&!placed){
                        placed = true;
                        add(i,studentAdd);
                    }
                }
            if(!placed)
                add(studentAdd);
            }
        }
        else 
       System.out.println("Student entered is null it has not been added to queue");
    }
    /**
     * Returns the Student dequeued.
     * Precondition: The first Student in the StudentQueue should have the highest course number 
     * as well as have arrived first with respect to the rest of the Student’s in the same course.
     * @return the student that was removed from dequeue
     */
    public Student dequeue(){
        return remove(0);
    }
    /**
     * Returns top of queue
     * @return get(0)
     */
    public Student peek(){
        return get(0);
    }
    /**
     * Returns the current number of Students waiting in the StudentQueue
     * @return the queue's size
     */
    public int size(){
        return super.size();
    }
    /**
     *Checks if the specified StudentQueue is empty.
     * Returns true if the StudentQueue is empty, else false.
     * Preconditions:
     * The StudentQueue object should be instantiated.
     * @return true if it is empty false if it isn't 
     */
    public boolean isEmpty(){
        return super.isEmpty();
    }
    /**
     * prints out queue so i dont have to do it in main
     */
    public void printQueue(){
        System.out.println("Student Queue: \n"
                + "Student ID     Course        Required Time        Arival Time");
      for(int i = 0;i<size();i++){
          System.out.println(get(i).toString());
      
      }
    
}
}
