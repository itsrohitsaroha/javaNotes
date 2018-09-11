/*
final variables and references
---------------------------
Java allows declaration of member
and local variables and references
as final.
The final variables and references 
can be assigned a value once, next
they can be used as read only.



*/

import java.util.Random ;
class A
{
  final int x;
  int sum;
  final int arr[];

  A()
  {
   x = 5;//preset value
   arr = new int[x];//allocation
   //arr = new int[x];//reassignment : not allowed for a final reference
   sum =0;//preset value
  }

  A(int q)
  {
   x = q;//parameter value
   arr = new int[x];//allocation
   sum =0;//preset value
  }

  void set()
  {
   Random r = new Random();
   int i;
   sum =0 ;
   for(i =0; i < arr.length; i++)
   {
     arr[i] = r.nextInt(100);
     sum += arr[i];
   }
  }

  void display()
  {
   System.out.println(" Array Length : " + x);
   for(int i : arr)
     System.out.print(i + "  ");

   System.out.println("\nsum : " + sum);
  }
}

class FVariable
{
 public static void main(String args[])
 {
  A objA = new A();
  System.out.println("-----------");
  objA.set();
  objA.display();
  System.out.println("-----------");
  objA.set();
  objA.display();
  System.out.println("-----------");

  final int q;
  q = 10;
  //here after q is read only
  System.out.println("q : " + q); 
 }
}