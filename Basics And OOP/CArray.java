class Student
{
 String name;
 int rno;

 Student()
 {
  System.out.println("Student()");
  name = "Vikas";
  rno = 10;
 }

 Student(String a, int b)
 {
  System.out.println("Student(String, int)");
  name = a;
  rno = b;
 }

 void display()
 {
  System.out.println("[ " + name + ", " + rno + " ]");
 } 

}//Student

class CArray
{
 public static void main(String args[])
 {
  Student arr[] = new Student[3];
  arr[0] = new Student("Manoj", 11);
  arr[1] = new Student();
  arr[2] = new Student("Anil", 1);

  //use an array for group processing
  //use an array for application of algorithms

/*
  int i;
  for(i =0 ; i < arr.length ; i++)
    arr[i].display();
*/

  for(Student x : arr)
    x.display();
 }//main
}