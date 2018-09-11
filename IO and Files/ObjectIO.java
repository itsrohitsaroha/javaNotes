//Object Serialization and DeSerialization
/*
Serialization is the process of converting
an object in a series of bytes so that it 
can be stored (in a file) or transferred 
using a stream.

Deserialization is the process of converting
a series of bytes, that come from a file 
or a stream, into an object.

For serialization and deserialization

1) The class of the object must implement Serializable interface.
It is an empty interface and is implemented for type compatibility only.

2) Use the methods :
  writeObject(obj) of the class ObjectOutputStream.
  obj = readObject() of the class ObjectInputStream.

FYI
----
transient fields are not serialized.

*/

import java.io.*;

class Student implements Serializable
{
 int rno;
 String name;
 /*transient*/ double percentage;

 Student()
 {
  //constructor delegation
  this(19, "Manoj", 67.43);
 }

 Student(int r, String n, double p)
 {
  rno = r;
  name = n;
  percentage = p;
 }
 void increment()
 {
  percentage++;
 }

 void display()
 {
  System.out.println("--------------------");
  System.out.println("Rno : " + rno);
  System.out.println("Name : " + name);
  System.out.println("Percentage : " + percentage);
  System.out.println("--------------------");
 }

}//Student

class ObjectIO
{
 public static void main(String args[])
 {
  try
  {
   Student s1 = new Student(12, "Anil", 76.44);
   Student s2 = new Student(15, "Vikas", 63.44);

   //select a file to store the serialized object
   FileOutputStream fos = new FileOutputStream("d:\\q.txt"); 
   ObjectOutputStream oos = new ObjectOutputStream(fos);
   //ObjectOutputStream oos = new ObjectOutputStream(System.out);
   oos.writeObject(s1);
   oos.writeObject(s2);

   oos.close();

   FileInputStream fis = new FileInputStream("d:\\q.txt");
   ObjectInputStream ois = new ObjectInputStream(fis);
 
   Student s3 = (Student) ois.readObject();
   Student s4 = (Student) ois.readObject();

   s1.display();
   s2.display();

   //s1.increment();
   
   s3.display();
   s4.display();
  }
  catch(Exception ex)
  {

  } 
 }//main
}//ObjectIO
