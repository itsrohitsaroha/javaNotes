/*
Program to demonstrate :
static initializer block
static member variables

Read : static and nonstatic members.txt
See : Class Initialization.png
See : static and nonstatic members.png
*/
import java.util.Random;

class OnTest
{
 int x,y;//non static data
 static int q;//static data member

 static
 {
  System.out.println("In SIB of OnTest");
  q = 0;
 }

 OnTest()
 {
  System.out.println("OnTest()");
  x = y = 10;
  q++;
 }

 void change()
 {
   Random  r = new Random();
   x = r.nextInt(100);//0 to 99
   y = x*x;
 }


 void display()
 {
  System.out.println(x + " " + y );
  System.out.println("Objects created : " + q);  
 }
}//OnTest

class SIBDemo
{
 static
 {
  System.out.println("In SIB of SIBDemo");
 }
 public static void main(String args[])
 {
  System.out.println("----main----");
  System.out.println("--------------");
  OnTest  o1 = new OnTest();
  System.out.println("--------------");
  OnTest  o2 = new OnTest();
  System.out.println("--------------");

  o1.change();
  o2.change();

  o1.display();
  o2.display();

 }
}
