/*
Thread Interrupts

Thread Interrupts are signals exchanged across 
the threads of an application.

Thread Interrupts do the following:
* Bring a thread out of wait, join or sleep by 
causing an exception in it.
* Send a terminate signal to the thread (doesnt cause termination).


*/

class TInterrupts implements Runnable
{
 Thread t1, t2;

 TInterrupts()
 {
  t1 = new Thread(this);
  t2 = new Thread(this);
  t1.start();
  t2.start();
 }//TInterrupts

 public void run()
 {
  Thread current = Thread.currentThread();
  if(current == t1)//reference comparison
    fx1();
  else if(current == t2)//reference comparison
    fx2();
 } 

/*
 void fx1()
 {
  int i;
  for(i =0 ; i < 1000; i++)
  {
    System.out.print("| ");
    if(i == 500)
    { 
     try
     { 
       System.out.println("\n About to enter sleep");
       Thread.sleep(3000);
       //t1.join();//self ko join
       System.out.println("\n Out of sleep");
     }
     catch(InterruptedException ex)
     {
      System.out.println("\n Sleep Interrupted");
     }
    }//if 
  }//for
  System.out.println("\n fx1 ends");

 }//fx1 
*/

 void fx1()
 {
  int i;
  for(i =0 ; i < 4000; i++)
  {
    System.out.print("| ");
    //if(t1.isInterrupted())//Is there an interrupt signal for  t1
    if(Thread.interrupted())//Is there an interrupt signal for current thread, if yes then reset it as well.
      System.out.print("i ");
  }//for
  System.out.println("\n fx1 ends");

 }//fx1 

 void fx2()
 {
  int i;
  for(i =0 ; i < 1000; i++)
    System.out.print("- ");
  t1.interrupt();	
  System.out.println("\n fx2 ends");
 }

 public static void main(String args[])
 {
   TInterrupts ti = new TInterrupts();
 }//main 
}