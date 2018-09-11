abstract class TimeTable
{
 void period1()
 {
  System.out.println("-----Period1-----");
  System.out.println("TOC");
 }

 void period2()
 {
  System.out.println("-----Period2-----");
  System.out.println("OS");
 }

 abstract void practical();
 abstract void games();

}//TimeTable

class Group1 extends TimeTable
{
 void practical()
 {
  System.out.println("-----Group1 Practical-----");
  System.out.println("Java");
 }

 void games()
 {
  System.out.println("-----Group1 Games-----");
  System.out.println("Football");
 }
 
}

class Group2 extends TimeTable
{
 void practical()
 {
  System.out.println("-----Group2 Practical-----");
  System.out.println("RDBMS");
 }

 void games()
 {
  System.out.println("-----Group2 Games-----");
  System.out.println("Basketball");
 }
 
}

class AbstractDemo
{
 static void workDay(TimeTable t)
 {
  System.out.println("Day Starts");
  t.period1();
  t.period2();
  t.practical();
  t.games();
  System.out.println("Day Ends");

 }

 public static void main(String args[])
 {
   Group1 g1 = new Group1();
   Group2 g2 = new Group2();
  
   workDay(g1);
   workDay(g2);
 }
}