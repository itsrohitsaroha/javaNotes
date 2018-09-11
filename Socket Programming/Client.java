import java.io.*;
import java.net.*;

class Client
{
 Socket s;
 Client(String ip, int port) throws Exception
 {
  //request a connection
  s = new Socket(ip, port);
 }

 static double getDouble()
 {
  try
  {
   System.in.skip(System.in.available()); 
   byte arr[] = new byte[20];
   int n = System.in.read(arr);
   String s = new String(arr,0, n-2);
   return Double.parseDouble(s);
  }
  catch(Exception ex)
  {
   return 0; 
  } 
 }//getDouble

 static int getInt()
 {
  try
  {
   System.in.skip(System.in.available()); 
   byte arr[] = new byte[20];
   int n = System.in.read(arr);
   String s = new String(arr,0, n-2);
   return Integer.parseInt(s);
  }
  catch(Exception ex)
  {
   return 0; 
  } 
 }//getInt

 void interact() throws Exception
 {
  DataInputStream din = new DataInputStream(s.getInputStream());
  DataOutputStream dout = new DataOutputStream(s.getOutputStream());

  double n1,n2,ans;
  int x;
  boolean ch = true; 

  System.out.println("Enter 2 numbers ");
  n1 = getDouble();
  n2 = getDouble();

  while(ch)
  {
   System.out.println("1. Addition ");
   System.out.println("2. Subtraction");
   System.out.println("3. Multiplication ");
   System.out.println("4. Division ");
   System.out.println("5. Change the Numbers ");
   System.out.println("6. Exit ");
   x = getInt();//operation 

   dout.writeInt(x);
   
   switch(x)
   {  
     case 1://addition
      dout.writeDouble(n1);
      dout.writeDouble(n2);
      ans = din.readDouble();
      System.out.println(n1 + " + " + n2 + " = " + ans);
      break;

     case 2://subtraction
      dout.writeDouble(n1);
      dout.writeDouble(n2);
      ans = din.readDouble();
      System.out.println(n1 + " - " + n2 + " = " + ans);
      break;

     case 3://multiplication
      dout.writeDouble(n1);
      dout.writeDouble(n2);
      ans = din.readDouble();
      System.out.println(n1 + " * " + n2 + " = " + ans);
      break;

     case 4://division
      dout.writeDouble(n1);
      dout.writeDouble(n2);
      ans = din.readDouble();
      System.out.println(n1 + " / " + n2 + " = " + ans);
      break;

     case 5://change numbers
      System.out.println("Enter 2 numbers ");
      n1 = getDouble();
      n2 = getDouble();
      break;

     case 6://exit
      ch = false;
      break;
   }//switch     
  }

 }//interact
 
 void close() throws Exception
 {
   s.close();
 }
 public static void main(String args[])
 {
  try
  {
   Client c = new Client("127.0.0.1", 9876);
   c.interact();
   c.close();
  } 
  catch(Exception ex)
  {
   System.out.println(ex);
  }
 }
}