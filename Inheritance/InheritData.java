class A
{
 int x, y;

 {
  System.out.println("A NSIB");
 }

 A()
 {
  System.out.println("A()");
  x = 10;
  y = 20;
 }

 A(int q, int w)
 {
  System.out.println("A(int,int)");
  x = q;
  y = w;
 }

 void display()
 {
  System.out.println(x +" " + y);
 }
}//A

class B extends A
{
 int z;

 {
  System.out.println("B NSIB");
 }

 B()
 {
  //super();
  System.out.println("B()");
  z = x + y;
 }

 B(int q, int w)
 {
  super(q,w);//passing parameters to invoke A(int,int). It must be the first statement in the sub class contructor.
  System.out.println("B(int,int)");
  z = x+ y;
 }

 //override
 void display()
 {
  System.out.println(x + " + " + y + " = " + z);
 }
}//B

class InheritData
{
 public static void main(String args[])
 {
  System.out.println("-------------");
  //B objB = new B();
  B objB = new B(1,2);
  System.out.println("-------------");
  objB.display();
 }
}