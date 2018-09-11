//Program to test IO methods

import java.io.*;

class IO
{
 static void ioTest1()
 {
  try
  {
   int x;
   int cnt = 0;
   do
   {
     x = System.in.read();  
     System.out.write(x);
     cnt++;
   }while(System.in.available() > 0);
   System.out.flush();
      

   System.out.println("counter : " + cnt);
  }//try
  catch(IOException ex)
  {
   System.out.println(ex);
  }    
 }

 static void ioTest2()
 {
  try
  {
   int n;
   byte arr[] = new byte[512];
   int cnt = 0;
   do
   {
     n = System.in.read(arr);  
     System.out.write(arr, 0, n);
     cnt++;
   }while(System.in.available() > 0);
   System.out.flush();
      

   System.out.println("counter : " + cnt);
  }//try
  catch(IOException ex)
  {
   System.out.println(ex);
  }    
 }

 public static void main(String args[])
 {
   //ioTest1();
   ioTest2();
 }//main
}//IO