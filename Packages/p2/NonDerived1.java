package p2;
import p1.Base;

public class NonDerived1
{
 Base ref;

 public NonDerived1()
 {
  System.out.println("p2 NonDerived1 NonDerived1()");
  ref = new Base();
  //ref.i++;
  //ref.j++;
  //ref.k++;
  ref.l++;
 }//NonDerived1()

 public void display()
 {
  System.out.println("p2 NonDerived1 display()");
  System.out.println("ref.i : not accessible");
  System.out.println("ref.j : not accessible" );
  System.out.println("ref.k : not accessible" );
  System.out.println("ref.l : " + ref.l);
  System.out.println("--------------------------");
  ref.display();
 }//display()

}//Derived