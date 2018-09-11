//Program to implement :
//Sequential access of Shared Resource
//using Critical Sections of code.

//Refer : Multithreading.txt
//See : Sync1.png and Sync2.png

class Server // extends Object
{
 String msg;
 
 synchronized void print(String s)
 {
  int i;
  for(i =0 ; i < 20; i++)
  {
   msg = s.toUpperCase();
   System.out.println();
   System.out.print("{");
   System.out.print(" ");
   System.out.print( msg );
   System.out.print(" ");
   System.out.print("}");
  }//for(i
 }//print

 synchronized void display(String s)
 {
  int i;
  for(i =0 ; i < 30; i++)
  {
   msg = s.toLowerCase();
   System.out.println();
   System.out.print("[");
   System.out.print(" ");
   System.out.print( msg );
   System.out.print(" ");
   System.out.print("]");
  }//for(i
 }//display

}//Server

class Client extends Thread
{
 Server svr;
 String data;

 Client(Server sv, String st)
 {
  svr = sv;
  data = st;
  start();//activate
 }
 
 public void run()
 {
  if(data.equalsIgnoreCase("shared"))
   svr.print(data);
  else
   svr.display(data);
 }//run()
}//Client

class Sync
{
 public static void main(String args[])
 {
  Server svr = new Server();
  Client c2 = new Client(svr, "Shared");
  Client c1 = new Client(svr, "Hello");
  Client c3 = new Client(svr, "Resource");

 }//main
}//Sync