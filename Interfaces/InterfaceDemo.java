interface Iface1
{
 int x = 10;//public and final data member

 void a_fx1();//public and abstract method

 static void s_fx()
 {
  System.out.println("static methods of an interface provide a ready to use definition of an operation, for the implementing classes");
  System.out.println("static methods of an interface cannot be overridden");
  System.out.println("static methods are invoked through the interface reference");

 }

 default void d_fx()
 {
  System.out.println("default methods of an interface provide a ready to use definition of an operation, for the implementing classes");
  System.out.println("default methods of an interface can be overridden by the implementing class");
  System.out.println("default methods are invoked through the object of the implementing class");
 }
  
}//Iface1

interface Iface2
{
 void a_fx2();
}

interface cIface extends Iface1, Iface2
{
 void a_fx3();
}

class UseIface implements cIface
{
 public void a_fx1()
 {
  System.out.println("a_fx1() by UseIface");
 }

 public void a_fx2()
 {
  System.out.println("a_fx2() by UseIface");
 }

 public void a_fx3()
 {
  System.out.println("a_fx3() by UseIface");
 }

 public void d_fx()
 {
  System.out.println("dfx1() by UseIface");
 }


}

class InterfaceDemo
{
 public static void main(String args[])
 {
  cIface ref = new UseIface();
  ref.a_fx1();
  ref.a_fx2();
  ref.a_fx3();
  ref.d_fx();
  Iface1.s_fx();

 }//main
}//InterfaceDemo