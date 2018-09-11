/*
Implementing Thread Yield
Refer : Multithreading.txt
*/

class TYield implements Runnable
{
 Thread t;

 TYield()
 {
  t = new Thread(this);//custom thread
  t.start();
 } 

 public void run()
 {
  int i;
  for(i =0 ; i < 10; i++)
  {
   System.out.print("T");
   Thread.yield();
  }
 }

 public static void main(String args[])
 {
  TYield ty = new TYield();
  
  int i;
  for(i =0 ; i < 10; i++)
  {
   System.out.print("M");
   Thread.yield();
  }
 }//main
}//TYield
