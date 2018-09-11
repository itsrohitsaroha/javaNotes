class InvalidInputException extends Exception
{
 String msg;
 InvalidInputException(String q)
 {
  msg = q;
 } 

 void display()
 {
  System.out.println("InvalidInputException : " + msg);
 }

 //override
 public String toString()
 {
  return "InvalidInputException : " + msg;
 }

}//InvalidInputException 

class Myself
{
 String name;
 int age;

 Myself(String n, int a) throws InvalidInputException
 {
  setName(n);
  setAge(a);
 }

 void setName(String n) throws InvalidInputException
 {
  char temp;
  int i;
  for(i =0 ; i < n.length(); i++)
  {
   temp = n.charAt(i); 
   if( ! ((temp >= 'A' && temp <= 'Z') || (temp >= 'a' && temp <= 'z')) )
   {//not an alphabet, raise an exception
     //1) create object of the exception
     InvalidInputException iie = new InvalidInputException("Non Alphabet Found in name : "  + n);
     //2) throw (raise) it
     throw iie;
   }
  }//for  
  name = n;
 }

 void setAge(int a) throws InvalidInputException
 {
  if(a < 0 || a > 100)
  {//invalid age, raise an exception

    //1) create object of the exception
     InvalidInputException iie = new InvalidInputException("Age out of range 0-100 : "  + a);
     //2) throw (raise) it
     throw iie;
    
  }
  age = a;
 }

 void display()
 {
  System.out.println("name : " + name);
  System.out.println("age : " + age);
 }
}//Myself

class CustomExceptions
{
 public static void main(String args[]) 
 {
  try
  {
   String a;
   int b;
   a = args[0];
   b = Integer.parseInt(args[1]);

   Myself m = new Myself(a,b);
   m.display();
  }
  catch(ArrayIndexOutOfBoundsException ex)
  {
    System.out.println("Usage : Java CustomExceptions <name> <age>");
  }
  catch(NumberFormatException ex)
  {
    System.out.println("Usage : Java CustomExceptions <name> <age>");
  }
  catch(InvalidInputException ex)
  {
    ex.display();    
  }
  catch(Exception ex)
  {
    System.out.println(ex);//ex.toString()
  }

  
 }//main
}//CustomExceptions