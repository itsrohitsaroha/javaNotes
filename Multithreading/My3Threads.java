//Program to implement 3 threads doing 3 different tasks

import java.awt.*;

class My3Threads extends Thread
{
 int flag;
 My3Threads(int x)
 {
  flag = x;
  start();//activate the threads
 }

 public void run()
 {
   if(flag == 1)
    fx1();
   else if(flag == 2)
    fx2();
 }//run()

 void fx1()
 {
  Toolkit t = Toolkit.getDefaultToolkit();
  int i; 
  for(i =0; i < 20; i++)
  {
    t.beep();
    try
    {
       Thread.sleep(1000);
    }
    catch(InterruptedException ex)
    {} 
  }//for 

 }


 void fx2()
 {
  int i;
  for(i =0; i < 5000; i++)
   System.out.print("  T ");

 }

 public static void main(String args[])
 {
  My3Threads m1 = new My3Threads(1);
  My3Threads m2 = new My3Threads(2);

  int i;
  for(i =0; i < 5000; i++)
   System.out.print("  M ");
 }//main
}