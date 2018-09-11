/*
Thread Join
-------------
Thread Join suspends execution of current thread
until the target thread to which it has joined completes.

Say there are two thread A and B.
thread A calls B.join()
join would suspend the thread A until thread B completes.

join() is an overloaded method, see the following signatures.
  join() : suspends until other thread compeltes
  join(milliseconds) : suspends until other trhead completes or until time period elapses, whichever first.

join() throws InterruptedException which the caller must handle.

FYI : If a thread joins to a target thread that 
is already complete then join doesnt cause any 
suspension.

*/

class TJoin extends Thread
{
 TJoin()
 {
  start();//activate the thread
 }

 public void run()
 {
  System.out.println("run starts");

  int i;
  for(i =0; i < 1000; i++)
   System.out.print("T");

  System.out.println("run ends");
 }//run

 public static void main(String args[])
 {
  TJoin tj = new TJoin();//custom thread

  int i;
  for(i =0; i < 1000; i++)
  {
   System.out.print("M");
   if(i == 500)
   {
     System.out.println("before join : " + tj.isAlive());
     try
     {
      tj.join();
     }
     catch(InterruptedException ex)
     {}
     System.out.println("after join : " + tj.isAlive());
   }//if
  }//for
 }//main
}//TJoin