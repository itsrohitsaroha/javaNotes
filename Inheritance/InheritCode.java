/*
Program to demonstrate:
* Inheritance of Code
* Method Overriding


Refer : Inheritance.txt
See : Inheritance.png and InheritCode.png

*/

class A
{
 void fx1()
 {
  System.out.println("A fx1");
 }

 void fx2()
 {
  System.out.println("A fx2");
 }
}//A

class B extends A
{
 //Method overriding is redefining
 // an inherited non static method
 //in the sub class, keeping the 
 //method signature same/compatible.
 void fx2()
 {
  System.out.println("B fx2");
 }

 void fx3()
 {
  System.out.println("B fx3");
 }
 
}

class InheritCode
{
 public static void main(String args[])
 {
  B objB = new B();
  objB.fx1();//inherited code
  objB.fx2();//overridden code
  objB.fx3();//extedend code
 }//main
}//InheritCode