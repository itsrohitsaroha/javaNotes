import java.net.*;
import java.io.*;
import java.util.Random;

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
 static NumberGame ng;
 static String baseDir;

 static
 {
  ng = new NumberGame();
  baseDir = "d:\\gol\\players";
  File f= new File(baseDir);
  if(! f.exists())
    f.mkdirs();
 }

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

   boolean ch ;
   int arr[], opt;
   int points = 0;
   String player;

   player = din.readUTF();
   String fname = baseDir + "/" + player + ".txt";
   RandomAccessFile raf = new RandomAccessFile(fname ,"rw");
   if(raf.length() == 0)
     points = 0;
   else
     points = raf.readInt();
   
   do
   {
    dout.writeUTF("Dear " + player + ", Welcome to the new round of Game Of Luck ");
    dout.writeUTF("Score : " + points);    
    dout.writeUTF("Pick a number from the following :");
    arr = ng.getNumbers();
    dout.writeInt(arr[0]);
    dout.writeInt(arr[1]);
    dout.writeInt(arr[2]);
    opt = din.readInt();
    if(arr[arr[3]] == opt)
    {
      dout.writeUTF("You WIN!!! ");
      points+=10;
    }
    else
      dout.writeUTF("You Lose");

    ch = din.readBoolean();
   }while(ch);

   dout.writeUTF("Dear " + player + ", Bye Bye");
   dout.writeUTF("Score : " + points);    

   raf.seek(0);
   raf.writeInt(points);
   raf.close();
   clnt.close();

  }//try
  catch(IOException ex)
  {
   ex.printStackTrace();
   System.out.println(ex);
  }

 }//run

}//ProcessConnection

class NumberGame
{
 Random r;
 NumberGame()
 {
  r = new Random();
 }
 
 int [] getNumbers()
 {
  int arr[] = new int[4];
  int i, temp;
  
  i=0 ;
  while(i < 3)
  {
   temp = r.nextInt(10);
   if(! inArray(arr, i, temp))
   {
     arr[i] = temp;
     i++;
   }
  }//while	  

  //answer
  arr[3] = r.nextInt(3); //0 or 1 or 2
  return arr;
 } 

 boolean inArray(int arr[], int i, int temp)
 {
   int j;
   for(j =0 ; j <=i; j++)
   {
    if(arr[j] == temp)
      return true;
   }
   return false;
 }
}
