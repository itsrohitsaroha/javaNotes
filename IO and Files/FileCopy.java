//Program to copy a file using byte read/write
import java.io.*;

class FileCopy
{
 public static void main(String args[])
 {
  try
  {
   String fname1 = args[0];
   String fname2 = args[1];

   //Open a file for reading : Establish an input stream between the file and the program.
   FileInputStream fin = new FileInputStream(fname1); //IOException to raise if file doesnt exist or permission to open it is denied

   //Open a file for writing : Establish an output stream between the program and the file. 
   FileOutputStream fout = new FileOutputStream(fname2); //File would be created or overwritten. IOException to raise if path is invalid or permission to create it is denied

   //copy : utilize the streams
   int x, cnt;
   cnt = 0;
   while((x = fin.read()) != -1)
   {
     fout.write(x); 
     cnt++;
   }
   fout.flush();

   //close the file : deallocate the stream
   fin.close();
   fout.close();

   System.out.println("\n File copied in " + cnt + " cycles");
  }
  catch(IOException ex)
  {
   System.out.println(ex);
  }
  catch(ArrayIndexOutOfBoundsException ex)
  {
   System.out.println("Usage : java FileRead <fileName>");
  }

 }//main
}//FileCopy