package p1;

public class NonDerived 
{
 Base ref;

 public NonDerived()
 {
  System.out.println("p1 NonDerived NonDerived()");
  ref = new Base();
  //ref.i++;
  ref.j++;
  ref.k++;
  ref.l++;
 }//NonDerived()

 public void display()
 {
  System.out.println("p1 NonDerived display()");
  System.out.println("ref.i : not accessible");
  System.out.println("ref.j : " + ref.j);
  System.out.println("ref.k : " + ref.k);
  System.out.println("ref.l : " + ref.l);
  System.out.println("--------------------------");
  ref.display();
 }//display()

}//Derived