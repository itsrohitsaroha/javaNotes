//Program to read a file using buffered read/write
import java.io.*;

class FileRead1
{
 public static void main(String args[])
 {
  try
  {
   String fname = args[0];

   //Open a file for reading : Establish an input stream between the file and the program.
   FileInputStream fin = new FileInputStream(fname); //IOException to raise if file doesnt exist or permission to open it is denied
   
   //read : utilize the stream
   int n, cnt;
   byte arr[] = new byte[512];
   cnt = 0;
   while((n = fin.read(arr)) != -1)
   {
     System.out.write(arr, 0, n); 
     cnt++;
   }
   System.out.flush();

   //close the file : deallocate the stream
   fin.close();

   System.out.println("\n File read in " + cnt + " cycles");
  }
  catch(IOException ex)
  {
   System.out.println(ex);
  }
  catch(ArrayIndexOutOfBoundsException ex)
  {
   System.out.println("Usage : java FileRead1 <fileName>");
  }

 }//main
}//FileRead1
