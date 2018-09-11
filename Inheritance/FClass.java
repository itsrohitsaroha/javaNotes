/*
Program to demonstrate : final class

Note:
A final class is a class that cannot be inherited.
*/

final class A
{
 void fx()
 {
  System.out.println("A final class cannot be inherited");
 }
}//A

class B //extends A
{}

class FClass
{
 public static void main(String args[])
 {
  A obj = new A();
  obj.fx();
 } 
}