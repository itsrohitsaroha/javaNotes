/*
Stream redirection is changing the target/source
of preestablished output/input streams.
The 3 streams that can be redirected are:
System.in, System.out and System.err

The methods: 
System.setOut(ObjectPrintStream)
System.setErr(ObjectPrintStream)
System.setIn(ObjectInputStream)
are used for redirection.

FYI:
-------
Custom streams doesnt require any redirection because 
they are establised as per a chosen source/target.
*/

import java.io.*;

class StreamRedirection
{
 public static void main(String args[])
 {
  try
  {
    System.err.println("Hi, I am System.err");
    System.err.println("By default, I output to the monitor");
    System.err.println("I support redirection");
    
    //backup System.err
    PrintStream temp = System.err;

    //file would be created/overwritten
    PrintStream ps = new PrintStream("d:\\q.txt");
    System.setErr(ps);//redirection
    System.err.println("This data goes into a file");
    System.err.println("We can use redirection as an error logging mechanism");
    ps.close();
          
    System.setErr(temp);//redirection
    System.err.println("Go and check d:\\q.txt");

  }
  catch(Exception ex)
  {
   System.out.println(ex);
  }    
 }//main
}//StreamRedirection