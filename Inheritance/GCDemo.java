import java.util.Random;

class Myclass //extends Object
{
 int arr[];
 String label;

 Myclass(String x)
 {
  label = x;
  Random r = new Random();
  arr = new int[r.nextInt(10000)]; 
 }

 void display()
 {
  System.out.println("Array size for object " + label + " is " + arr.length);
 }

 //override the finalize
 protected void finalize()
 {
  System.out.println("in finalize for object : " + label);
 }
}//Myclass

class GCDemo
{
 public static void main(String args[])
 {
  Myclass o1 = new Myclass("A");
  Myclass o2 = new Myclass("B");
  Myclass o3 = new Myclass("C");
  Myclass ref = o3;

  o1.display();
  o2.display();
  o3.display();

  //drop 3 references
  o1 = null;
  o2 = null;
  o3 = null;

  //explicit req for garbage collection
  System.gc();

  //delay for 2 seconds
  try
  {
   Thread.sleep(2000);
  }
  catch(InterruptedException ex)
  {}

 }//main
}//GCDemo