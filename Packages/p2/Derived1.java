package p2;
import p1.Base;

public class Derived1 extends Base
{
 public Derived1()
 {
  System.out.println("p2 Derived1 Derived1()");
  //i++;
  //j++;
  k++;
  l++;
 }//Derived1()

 public void display()
 {
  System.out.println("p2 Derived1 display()");
  System.out.println("i : not accessible" );
  System.out.println("j : not accessible" );
  System.out.println("k : " + k);
  System.out.println("l : " + l);
  System.out.println("--------------------------");
  super.display();
 }//display()

}//Derived1