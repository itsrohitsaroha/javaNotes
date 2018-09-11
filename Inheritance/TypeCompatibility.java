/*
Program to demonstrate :
* Type Compatibility
* Runtime binding
* Loose and Tight Coupling

Refer : Inheritance.txt

See: TypeCompatibility.png
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
 void fx2()
 {
  System.out.println("B fx2 starts");
  fx3();//extended code
  System.out.println("B fx2 ends");
  
 }

 void fx3()
 {
  System.out.println("B fx3");
 }
 
}//B

class C extends A
{
 void fx2()
 {
  System.out.println("C fx2");
 }
 
}//C

class TypeCompatibility
{
 static void testCompatibility(A ref)
 {
  System.out.println("-----Type Compatibility-----");
  ref.fx1();//inherited method
  ref.fx2();//overridden method
  System.out.println("-------------------------");
 }

 public static void main(String args[])
 {
  A objA = new A();
  B objB = new B();
  C objC = new C();

  testCompatibility(objA);
  testCompatibility(objB);
  testCompatibility(objC);  
 }//main
}//TypeCompatibility