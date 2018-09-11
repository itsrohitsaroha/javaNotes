/*
Varargs is a helper syntax and it enables 
use of variable number of arguments in a 
method call. 

In method definition variable aruguments are 
indicated by elipsis (…) and is called as 
‘variable arity method’ and ‘variable arity parameter’ 
in java. 

While invoking the varargs method any number 
of arguments of type specified and separated 
by comma.

Internally:
* System converts the variable arguments
into array and pass to method.
* The variable arity parameter is treated as
a array reference by Java.


*/

class VarArgs
{
 static int addition(int ... all)
 {
  int sum = 0;
  for(int x : all)
   sum += x;

  return sum;
 }

 static void fx(String ... params)
 {
  System.out.println("----------------");
  for(String p : params)
   System.out.println(p);
  System.out.println("----------------");
 }

 public static void main(String args[])
 {
   fx("hello", "Java");
   fx("hello", "Variable" , "Arguments");
   fx("Java", "Uses", "Array", "To", "Handle", "Variable" , "Arguments");

   int result;
   result = addition(1,2);
   System.out.println("Addition : "  + result);

   result = addition(1,2,3);
   System.out.println("Addition : "  + result);

   result = addition(11,22,33,44);
   System.out.println("Addition : "  + result);

    
 }//main
}//VarArgs