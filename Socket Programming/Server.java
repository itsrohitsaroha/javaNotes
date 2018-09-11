import java.net.*;
import java.io.*;

class Server implements Runnable
{
 boolean flag;
 Thread connectionThread;
 ServerSocket port;


 Server(int x) throws Exception
 {
  //open a port
  port = new ServerSocket(x); 
  //success
  //limit accept block time to 5000 milliseconds 
  port.setSoTimeout(5000); 

  connectionThread = new Thread(this);
  connectionThread.start();
 }//Server(int)

 public void run()//connectionThread
 {
  acceptConnections();
  shutDown();
 }

 void acceptConnections()
 {
  Socket clnt;
  flag = true;

  while(flag)
  {
   try
   {
     //accept a client connection
     //1. Blocks the program control until 
     //1.1. A client requests a connection
     //1.2. timeout
     //2. On request, form a connection
     //3. Return a Socket object that represents connection with the client 
 
     System.out.println("Server waiting for client connection request ...");
     clnt = port.accept();
     System.out.println("Server formed a client connection");
     new ProcessConnection(clnt);
   }
   catch(Exception ex)
   {}
  }//while

 }//acceptConnections

 void shutDown() 
 {
   try
   {
    port.close();
   }
   catch(Exception ex)
   {}
 }

 public static void main(String args[])
 {
  try
  {
   new Server(9876);
   //...job ahead 
  }
  catch(Exception ex)
  {
   System.out.println(ex); 
  }
 }//main

}//Server


class ProcessConnection extends Thread
{
 Socket clnt;

 ProcessConnection(Socket s)
 {
   clnt = s;
   start();//activate the thread
 }

 public void run()
 {
  try
  {
   //fetch the i/o streams
   DataInputStream din = new DataInputStream( clnt.getInputStream() );
   DataOutputStream dout = new DataOutputStream( clnt.getOutputStream() );

   double a,b,c;
   int op;
   boolean ch = true;

   while(ch)
   {
     op = din.readInt();

     switch(op)
     {
       case 1://addition
        a = din.readDouble();
        b = din.readDouble();
        c = ArithmeticService.add(a,b);  
        dout.writeDouble(c);
        break;

       case 2://subtraction
        a = din.readDouble();
        b = din.readDouble();
        c = ArithmeticService.subtract(a,b);  
        dout.writeDouble(c);
        break;

       case 3://multiplication
        a = din.readDouble();
        b = din.readDouble();
        c = ArithmeticService.multiply(a,b);  
        dout.writeDouble(c);
        break;

       case 4://division
        a = din.readDouble();
        b = din.readDouble();
        c = ArithmeticService.divide(a,b);  
        dout.writeDouble(c);
        break;

       case 6://exit
         ch = false;
         break;
     }//switch  

   }//while

   clnt.close();

  }//try
  catch(IOException ex)
  {
   ex.printStackTrace();
   System.out.println(ex);
  }

 }//run

}//ProcessConnection

class ArithmeticService
{
 static double add(double x, double y)
 {
   return x+y;
 }

 static double subtract(double x, double y)
 {
   return x-y;
 }

 static double multiply(double x, double y)
 {
   return x*y;
 }

 static double divide(double x, double y)
 {
   return x/y;
 }
}//ArithmeticService

