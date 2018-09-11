import java.util.Random;


class NumberHost
{
 int number;
 boolean flag;

 NumberHost() 
 {
  flag = false;
 }

 synchronized void write(int x)
 {
  if(flag == true)
  {
   try
   {
    wait();
   }
   catch(InterruptedException ex){}
  }

  System.out.println("Writing : " +x);
  number = x;
  flag = true;//data available for reading
  notify();
 }

 synchronized void read()
 {
  if(flag == false)
  {
   try
   {
    wait();
   }
   catch(InterruptedException ex){}
  }
  System.out.println("Reading : " +number);
  flag = false;//data comsumed
  notify();//bring other thread out of wait
 }

}

class Writer extends Thread
{
  NumberHost nHost;
  Writer(NumberHost nh)
  {
   nHost = nh;
   start();//activate the thread
  }
   
  public void run()
  {
    Random rnd = new Random();
    int i;
    for(i =0; i < 20; i++)
      nHost.write(rnd.nextInt(100)); 
  }
 
}//Writer

class Reader extends Thread
{
  NumberHost nHost;
  Reader(NumberHost nh)
  {
   nHost = nh;
   start();//activate the thread
  }
   
  public void run()
  {
    int i;
    for(i =0; i < 20; i++)
      nHost.read();
  }
 
}//Reader

class ThreadCoordination
{
 public static void main(String args[])
 {
  NumberHost nh = new NumberHost();
  Writer w = new Writer(nh);
  Reader r = new Reader(nh);

 }
}