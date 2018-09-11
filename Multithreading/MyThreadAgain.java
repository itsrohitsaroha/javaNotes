/*
Define a class that implements Runnable Interface
Refer : Multithreading.txt
*/

class MyThreadAgain implements Runnable
{
 Thread t;

 MyThreadAgain()
 {
  t = new Thread(this);
  t.start();
 } 

 public void run()
 {
  int i;
  for(i =0 ; i < 1000; i++)
   System.out.print("T");
 }

 public static void main(String args[])
 {
  MyThreadAgain mta = new MyThreadAgain();
  
  int i;
  for(i =0 ; i < 1000; i++)
   System.out.print("M");
 }//main
}//MyThreadAgain


/*
public class Thread implements Runnable
{
 Runnable ref;  

 Thread()
 {
   ref = this;
   ...
 }

 Thread(Runnable q)
 {
   ref = q;
   ...
 }

 public void start()
 {
  thread activation process
  ...
  ref.run();
 }
  
 public void run()
 {empty}
 
 
}

*/