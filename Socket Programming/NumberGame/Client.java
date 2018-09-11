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

 static String getString()
 {
  try
  {
   System.in.skip(System.in.available()); 
   byte arr[] = new byte[100];
   int n = System.in.read(arr);
   String s = new String(arr,0, n-2);
   return s;
  }
  catch(Exception ex)
  {
   return "NA"; 
  } 
 }//getString

 static char getChar()
 {
  try
  {
   System.in.skip(System.in.available()); 
   return (char) System.in.read();
  }
  catch(Exception ex)
  {
   return ' '; 
  } 
 }//getChar


 void interact() throws Exception
 {
  DataInputStream din = new DataInputStream(s.getInputStream());
  DataOutputStream dout = new DataOutputStream(s.getOutputStream());

   char ch ;
   int arr[], opt;
   int points = 0;
   String player, s;

   System.out.println("Enter players Name : ");
   player = getString();
   dout.writeUTF(player);

   do
   {
    s = din.readUTF();
    System.out.println(s);
    s = din.readUTF();  
    System.out.println(s);
  
    s = din.readUTF();    
    System.out.println(s);
    System.out.println(din.readInt()  + "," + din.readInt()+ ", " + din.readInt());
    opt = getInt();
    dout.writeInt(opt);
    s = din.readUTF();
    System.out.println(s);
    System.out.println("Play More Rounds (y/n) : ");
    ch = getChar();
    if(ch == 'y' || ch == 'Y')
     dout.writeBoolean(true);
    else
     dout.writeBoolean(false);
   }while(ch == 'y' || ch == 'Y');

   s = din.readUTF();
   System.out.println(s);   
   s = din.readUTF();
   System.out.println(s);

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