/*
Thread Sleep
--------------
Sleep ceases the execution of the current thread
for specific time period.
It auto resumes execution as the sleep time elapses. 

Accuracy of sleep depends on Systems timers and
schedulers.

Thread.sleep(milliSeconds) throws InterruptedException
which the caller must handle.
*/

class TSleep extends Thread
{
 TSleep()
 {
  start();//thread activation
 }

 public void run() //thread life cycle method
 {
  int i;
  for(i =0; i < 10; i++)
  {
   System.out.println(System.currentTimeMillis());
   try
   {
     Thread.sleep(1000);//1000 milli seconds
   }
   catch(InterruptedException ex)
   {}
  }//for
 }//run()

 public static void main(String args[])
 {
  TSleep ts = new TSleep();//custom thread
 }
}