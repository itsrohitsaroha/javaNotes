//Program to study : NonDaemon and Daemon Threads
//See : DNDThreads.png
//Refer : Multithreading.txt

import java.awt.*;

class DNDThreads extends Thread
{
 int flag;
 DNDThreads(int x)
 {
  flag = x;
  if(flag == 2)
    setDaemon(true);
  start();//activate the threads
 }

 public void run()
 {
   if(flag == 1)
    fx1();
   else if(flag == 2)
    fx2();
 }//run()

 void fx2()
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


 void fx1()
 {
  int i;
  for(i =0; i < 5000; i++)
   System.out.print("  T ");

 }

 public static void main(String args[])
 {
  DNDThreads t1 = new DNDThreads(1);
  DNDThreads t2 = new DNDThreads(2);

  int i;
  for(i =0; i < 5000; i++)
   System.out.print("  M ");
 }//main
}