//import java.lang.*;
//Program to implement
//Exception handling across dependent methods of an operation

class EDemo1
{
 int a, b, c;

 EDemo1()
 {
   a = 10; 
   b = 2; 
   c = 0;
 }

 EDemo1(String arr[]) throws NumberFormatException, ArrayIndexOutOfBoundsException
 {
   a = Integer.parseInt(arr[0]); 
   b = Integer.parseInt(arr[1]); 
   c = 0;
 }

 void process() throws ArithmeticException
 {
   c = a/b;
 }

 void display()
 {
   System.out.println(a + " / " + b + " = " + c);
 }

 public static void main(String args[])
 {
  System.out.println("Program Starts");

  try
  {
    EDemo1 ed1;
    try
    {
      ed1 = new EDemo1(args);
    }
    catch(ArrayIndexOutOfBoundsException ex)
    {
      System.out.println("Command Line Arguments Missing.");
      System.out.println("Using Defaults : 10,2");
      ed1 = new EDemo1();
    }

    ed1.process();
    ed1.display();

  }
  catch(NumberFormatException ex)
  {
    System.out.println("Invalid Input");
  }
  catch(ArithmeticException ex)
  {
    System.out.println("INFINITY");
  }
  finally
  {
   System.out.println("FINALLY");
  }
  System.out.println("Program Ends");
 }//main
}//EDemo1