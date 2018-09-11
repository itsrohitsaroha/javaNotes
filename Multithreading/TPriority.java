/*
Implementing Thread Priority
Refer : Multithreading.txt
*/

class TPriority implements Runnable
{
 Thread t;

 TPriority(int x)
 {
  t = new Thread(this);//custom thread
  t.setPriority(x);//8 , above normal
  t.start();
 } 

 public void run()
 {
  int i;
  for(i =0 ; i < 2000; i++)
   System.out.print("T");
 }

 public static void main(String args[])
 {
  TPriority tp = new TPriority(8);
  
  int i;
  for(i =0 ; i < 2000; i++)
   System.out.print("M");
  
 }//main
}//TPriority
