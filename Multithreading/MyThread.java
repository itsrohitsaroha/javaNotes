//Program to implement multithreading
//Refer : multithreading.txt

import java.awt.*;

class MyThread extends Thread
{

 public void run()
 {
   Toolkit t= Toolkit.getDefaultToolkit();
   int i;
   for(i=0 ; i < 100; i++)
   {
    //System.out.print("T");
    t.beep();
   
    try{  Thread.sleep(100); }catch(InterruptedException ex){}
   }
 }

 public static void main(String args[])
 {
  MyThread mt = new MyThread();//custom thread
  mt.start();//thread activation

  System.out.println("Active Threads : " + Thread.activeCount());
   for(int i=0 ; i < 5000; i++)
    System.out.print(" M ");

 }
}