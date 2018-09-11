import learning.*;//to access all public entities of the package learning
import learning.java.*;//to access all public entities of the package learning.java

class Student
{
 public static void main(String args[])
 {
  C objC = new C();
  CPP objCPP = new CPP();
  HTML objHTML = new HTML();
  CoreJava objCJ = new CoreJava();
  AdvancedJava objAJ = new AdvancedJava();

  objC.aboutC();
  objCPP.aboutCPP();
  objHTML.aboutHTML();
  objCJ.aboutCoreJava();
  objAJ.aboutAdvancedJava();
 

 }
}
