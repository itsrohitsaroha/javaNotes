/*
Program to demonstrate : final method

Note:
Final method is a method that cannot be overridden.
*/
class A
{
 final void fx()
 {
  System.out.println("A final method cannot be overridden");
 }
}//A

class B extends A
{
 /*void fx()
 {
   System.out.println("B fx()"); 
 }*/

}//B

class FMethod
{
 public static void main(String args[])
 {
  B obj = new B();
  obj.fx();
 } 
}