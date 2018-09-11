/*
Command line arguments are parameters passed from the shell to the main method of the Java application.

System fetches the command line arguments and forms a String array.

The reference to the String array is passed as a parameter to main method.

The signature of the main method is preset to receive the String array reference.

Next the main method can utilize the String array.
*/

class CmdLine
{
 public static void main(String args[])
 {
   System.out.println("Number of command line arguments : " + args.length);

/*  
   int i;
   for(i =0; i < args.length; i++)
     System.out.println(args[i]);
*/
    	  
   for(String s : args)
     System.out.println(s);

 }
}