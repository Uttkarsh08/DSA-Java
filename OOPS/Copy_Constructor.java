package OOPS;

public class Copy_Constructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Uttkarsh";
        s1.age = 20;
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;
        System.out.print("Marks of s1 = ");
        for(int i=0; i<s1.marks.length; i++){
            System.err.print(s1.marks[i] + " ");
        }
        System.out.println();
        System.err.println("s1 name : "+ s1.name);
        Student s2 = new Student(s1);
        System.out.println("s2 name : "+ s2.name);
        s1.marks[2] = 100; // s1 marks changed after making s2
        System.out.print("Marks of s2 = ");
        for(int i=0; i<s2.marks.length; i++){
            System.err.print(s2.marks[i] + " ");  // but s2 marks also changed -> Shallow constructor(pass by reference)
        }  // s2 marks donot change -> deep constructor(new array is make for s2)
    }
}

class Student{
    String name;
    int age;
    String password;
    int marks[];
    Student(){
        marks = new int[3];
    }

    // // Shallow Copy Constructor
    // Student(Student s){
    //     this.name = s.name;
    //     this.age = s.age;
    //     this.marks = s.marks;
    // }
    


    // Deep Copy Constructor
    Student(Student s){
        marks = new int[3];
        this.name = s.name;
        this.age = s.age;
        for(int i=0; i<marks.length; i++){
            this.marks[i] = s.marks[i];
        }
    }

}
