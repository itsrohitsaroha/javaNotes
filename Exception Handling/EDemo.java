//import java.lang.*;
//Program to implement : Exception Handling
//See : Exception Handling.png
//Refer : Exception Handling.txt

class EDemo
{
 public static void main(String args[])
 {
  System.out.println("Program Starts");
  try
  {
   int a, b, c;
   a = Integer.parseInt(args[0]); 
   b = Integer.parseInt(args[1]); 
   c = a/b;
   System.out.println(a + " / " + b + " = " + c);
  }
  catch(NumberFormatException ex)
  {
    System.out.println("Invalid Input");
  }
  catch(ArrayIndexOutOfBoundsException ex)
  {
    System.out.println("Usage : java EDemo <num1> <num2>");
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
}//EDemo