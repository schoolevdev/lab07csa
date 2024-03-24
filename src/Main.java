// Lab07vst80.java
// This lab creates a "school" which has a list of students.
// Within this school you can sort.
// this is the 80-point version. The 100-point version is completely different.
// Evin Lodder 3/24/24
import java.util.ArrayList;
public class Main
{
    public static void main (String[] args)
    {
        //create the school, then sort it each way and print to check
        System.out.println("Lab07v80 by Evin Lodder");
        System.out.println();
        int size = 10;
        School bhs = new School(size);
        System.out.println(bhs);
        bhs.bubbleSort();
        System.out.println(bhs);
        bhs.selectionSort();
        System.out.println(bhs);
        bhs.insertionSort();
        System.out.println(bhs);
    }
}
class School
{
    private ArrayList<Student> students;
    private int size;
    public School (int s) {
        students = new ArrayList<Student>(s);
        size = s;
        addData();
    }

    //adds example data
    public void addData() {
        //create lists of names ages and gpas
        String[] names = new String[]{"Tom", "Ann", "Bob", "Jan", "Joe", "Sue", "Jay", "Meg", "Art", "Deb"};
        int[] ages = new int[]{21, 34, 18, 45, 27, 19, 30, 38, 40, 35};
        double[] gpas = new double[]{1.685, 3.875, 2.5, 4.0, 2.975, 3.225, 3.65, 2.0, 3.999, 2.125};
        //add new students to the array
        for(int i = 0; i < size; i++) {
            students.add(new Student(names[i], ages[i], gpas[i]));
        }
    }

    //bubble sorts the values by name
    public void bubbleSort() {
        //count backwards setting students[i] to the largest name
        for(int i = size - 1; i > 0; i--) {
            for(int f = 1; f <= i; f++) {
                //if students[f-1] name is greater than students[f], swap the values
                if(students.get(f - 1).getName().compareTo(students.get(f).getName()) > 0) {
                    Student temp = students.get(f);
                    students.set(f, students.get(f - 1));
                    students.set(f - 1, temp);
                }
            }
        }
    }
    //selection sorts the values by age
    public void selectionSort() {
        for(int i = 0; i < size; i++) {
            //start with current index, then if anything beyond this index in the list is smaller,
            //make that the new smallest index
            int smallestIndex = i;
            for(int j = i + 1; j < size; j++) {
                if(students.get(j).getAge() < students.get(smallestIndex).getAge()) {
                    smallestIndex = j;
                }
            }
            //swap the current value with the new smallest value
            Student temp = students.get(i);
            students.set(i, students.get(smallestIndex));
            students.set(smallestIndex, temp);
        }
    }
    //insertion sorts the students by GPA
    public void insertionSort() {
        for(int i = 0; i < size; i++) {
            Student insertStudent = students.get(i);
            int elements = i + 1;
            int index = 0;
            //searches through list until it finds a student with a greater GPA than the current student
            while(index < elements && insertStudent.getGPA() > students.get(index).getGPA()) {
                index++;
            }
            //shifts the entire student list right
            for(int j = elements - 1; j > index; j--) {
                students.set(j, students.get(j - 1));
            }
            //inserts the current student into the position of the other student that had a higher GPA
            students.set(index, insertStudent);
        }
    }
    public String toString() {
        //creates a stringbuilder and appends each student with a newline
        StringBuilder builder = new StringBuilder();
        for(Student stu: students) {
            builder.append(stu);
        }
        return builder.toString();
    }
}


class Student
{
    private String name;
    private int age;
    private double gpa;
    public Student (String n, int a, double g)
    {
        name = n;
        age = a;
        gpa = g;
    }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGPA() { return gpa; }
    public String toString()
    {
        return name + " " + age + " " + gpa + "\n";
    }
}
