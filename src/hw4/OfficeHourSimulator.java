package hw4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
* Janiel Reyes
* 111307845
* HW # 4 
* Section 12
* Charles Chen
* Tim Zhang
*/
public class OfficeHourSimulator {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize the list for inputs one is int for regular numbers and the other is double for the decimals
        ArrayList<Integer> inputValues = new ArrayList<Integer>();
        ArrayList<Double> doubleValues = new ArrayList<Double>();
        int[] courses;
        Course[] courseNum;
        double[] arrivalProb;
        Scanner scan= new Scanner(System.in);
        System.out.println("Welcome to the Office Hours Simulation \n"
                + "Please enter a file name:");
        
        
        // Reading the Text File
        try{
            File file = new File(scan.nextLine());
            scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String afterColon = line.substring(line.indexOf(":")+1);     
                String[] values = afterColon.split(" ");
                for(int i = 0; i<values.length;i++){
                    if(Double.parseDouble(values[i])<1) 
                        doubleValues.add(Double.parseDouble(values[i]));
                    else inputValues.add(Integer.parseInt(values[i]));
                }
            }
            //Making the course array and arrivalProbabilities to arrays
  
            courses = new int[inputValues.get(0)];   
            courseNum = new Course[courses.length];
            arrivalProb = new double[doubleValues.size()];
           
            //Course number array
            for(int i =0; i< courses.length;i++)
                courses[i]=inputValues.get(i+1);
            //Arrival Probabilities array
            for(int j =0; j< doubleValues.size();j++)
                arrivalProb[j]=doubleValues.get(j);
            //Course Array of courses
            for(int k = 0; k<courseNum.length;k++){
                courseNum[k]= new Course(courses[k],arrivalProb[k]);
            }
             //Start the simulate method
             Simulate((inputValues.get(inputValues.size()-2)),arrivalProb,courseNum,(inputValues.get(inputValues.size()-5)),(inputValues.get(inputValues.size()-4)),(inputValues.get(inputValues.size()-3)),(inputValues.get(inputValues.size()-1)));

        }
        catch(FileNotFoundException ex){
            System.out.println("File not found");
        }
   
    }
    public static void Simulate(int officeHrTime, double[] arrivalProbability, Course[] courses, int minTime, int maxTime, int numCups, int numTAs){
        boolean run = false;
        StudentQueue students = new StudentQueue();
        int currentTime = 0;
        int incrementTime = 1;
        int waitTimeTotal =0;
        int waitTimeCourseOne = 0;
        int waitTimeCourseTwo = 0;
        int waitTimeCourseThree = 0;
        int studentCourseOne =0;
        int studentCourseTwo =0;
        int studentCourseThree=0;
        Helper[] peopleHelp = new Helper[numTAs+1];
        peopleHelp[0]= new Helper(true,0);
        for(int i = 1; i< peopleHelp.length; i++){
            peopleHelp[i]= new Helper(false,i);
        }
        //Showing Inputs from Text File
        System.out.println("Course                    Probability");
        for(int i = 0; i<courses.length;i++)
        System.out.println(courses[i].getCourseNumber()+"           "+"             "+arrivalProbability[i]);
        System.out.println("Number of TAs: "+ numTAs);
        System.out.println("Coffee Cups: "+ numCups);
        System.out.println("Base Time Interval "+minTime+"-"+maxTime+" minutes" );
        System.out.println("Time: "+ officeHrTime+" minutes");
        System.out.println("Begin Simulation ");
        while(run!=true){
            if(currentTime == officeHrTime){
               run = true;     
                System.out.println("End of Simulation");
                 System.out.println("Course       Students Helped       Avg Time");
                 System.out.println("Total                  "+(studentCourseOne+studentCourseTwo+studentCourseThree)+"                 "+waitTimeTotal);
                 System.out.println(courses[0].getCourseNumber()+"                    "+ studentCourseOne+"                 "+waitTimeCourseOne);
                 System.out.println(courses[1].getCourseNumber()+"                    "+ studentCourseTwo+"                  "+waitTimeCourseTwo);
                 System.out.println(courses[2].getCourseNumber()+"                    "+ studentCourseThree+"                  "+waitTimeCourseThree);
               System.out.println("We hope you have a pleasant visit in your next actual office hours, good bye!");                
               System.exit(0);
            }
            System.out.println("Time Step "+currentTime+":");
            currentTime = currentTime+incrementTime;
            BooleanSource course1 = new BooleanSource(arrivalProbability[0]);
            BooleanSource course2 = new BooleanSource(arrivalProbability[1]);
            BooleanSource course3 = new BooleanSource(arrivalProbability[2]);
            
            try{
                if(course1.occurs()){
                    Student student1 = new Student(currentTime,courses[0], (int)(Math.random()*maxTime+minTime) );
                    students.enqueue(student1);
                    System.out.println("Student "+ student1.getStudentCounter()+" has arrived for "+courses[0].getCourseNumber()+" requiring "+ student1.getTimeRequired());
                }
                else System.out.println("No Students have arrived for "+ courses[0].getCourseNumber());
            }catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                if(course2.occurs()){
                    Student student2 = new Student(currentTime,courses[1], (int)(Math.random()*maxTime+minTime) );
                    students.enqueue(student2);
                    System.out.println("Student "+ student2.getStudentCounter()+" has arrived for "+courses[1].getCourseNumber()+" requiring "+ student2.getTimeRequired());
                }
                else System.out.println("No Students have arrived for "+ courses[1].getCourseNumber());
            }
            catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
        }
            try{
                if(course3.occurs()){
                    Student student3 = new Student(currentTime,courses[2], (int)(Math.random()*maxTime+minTime) );
                    students.enqueue(student3);
                    System.out.println("Student "+ student3.getStudentCounter()+" has arrived for "+courses[2].getCourseNumber()+" requiring "+ student3.getTimeRequired());
                }
                else System.out.println("No Students have arrived for "+ courses[2].getCourseNumber());
            }catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage()); 
            }
            try {
                for(int i = 0; i<peopleHelp.length;i++){
                    if(peopleHelp[i].getTimeLeftTilFree()==0){
                        Student temp = students.peek();
                        peopleHelp[i].setStudentHelping(temp);
                        if(peopleHelp[i].isProfessor())
                            peopleHelp[i].setTimeLeftTilFree(temp.getTimeRequired()-numCups);
                        else
                            peopleHelp[i].setTimeLeftTilFree(temp.getTimeRequired());
                        if(temp.getCourse().getCourseNumber()== courses[0].getCourseNumber()){
                             studentCourseOne++;
                             waitTimeCourseOne = temp.getTimeRequired();
                             waitTimeTotal = waitTimeTotal + waitTimeCourseOne;
                        }
                            else if(temp.getCourse().getCourseNumber()== courses[1].getCourseNumber()){
                                studentCourseTwo++;
                                waitTimeCourseTwo = temp.getTimeRequired();
                                waitTimeTotal = waitTimeTotal + waitTimeCourseTwo;
                            }
                            else if(temp.getCourse().getCourseNumber()== courses[2].getCourseNumber()){
                            studentCourseThree++;
                            waitTimeCourseThree = temp.getTimeRequired();
                             waitTimeTotal = waitTimeTotal + waitTimeCourseThree;
                            }
                        students.dequeue();
                    }
                    else{
                        peopleHelp[i].setTimeLeftTilFree(peopleHelp[i].getTimeLeftTilFree()-1);
                    }
              
                }
            }catch (Exception ex){
               System.out.println(ex.getClass().getCanonicalName());
                
            } 
            
            //Printing Stuff
            for(int j = 0; j<peopleHelp.length;j++){
                peopleHelp[j].printHelperTime();
            }
            students.printQueue();
        }
    }
    
}
        
