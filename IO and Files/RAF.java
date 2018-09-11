/*
RandomAccessFile is used to establish bidirectional (r/w) channels with files.
It supports reading and writing of bytes and primtive Java datatypes.

Other major supported operations:
seek(int offset) : Allows positioning the file pointer at a place of choice in the file wrt BOF. In case seek value > file size then the file expands to make the seek success.
getFilePointer() : Fetch current file pointer position as an offset from the BOF.
length() : Size of the file in bytes.
*/

import java.io.*;

class RAF
{
 static void demoRWSeek()
 {
  try
  {
   //open a file for r/w
   String fname = "d:\\a.txt";
   String mode = "rw";
   RandomAccessFile raf = new RandomAccessFile(fname, mode);//creates or opens the file

   int x;
   byte arr[] = new byte[1024];

   //read
   raf.seek(0);//file pointer is positioned at 0 offset from BOF

   while((x = raf.read()) != -1)
     System.out.write(x);    
   System.out.flush();
 
   //write check
   raf.seek(3);//file pointer is positioned at 3 offset from BOF
   raf.write('q');

   System.out.println();
   System.out.println();

   //read
   raf.seek(0);//file pointer is positioned at 0 offset from BOF

   while((x = raf.read(arr)) != -1)
     System.out.write(arr,0,x);    
   System.out.flush();
   
   //close the file
   raf.close();
  }
  catch(Exception ex)
  {
   System.out.println(ex);
  }  
 } 

 static void demoPrimitiveTypesRW()
 {
  try
  {
   //delete the file if existing
   String fname = "d:\\b.txt";
   File f = new File(fname);
   f.delete();//permanantly remove a file/empty directory
    
   String mode = "rw";
   RandomAccessFile raf = new RandomAccessFile(fname, mode);//create or open

   int i1, i2;
   double d1,d2;
   String s1,s2;
   boolean b1,b2;
   char c1, c2;

   i1 = 35656;
   d1 = 45.56573;
   s1 = "This is a sample string";
   b1 = true;
   c1 = 'q';

   raf.writeInt(i1);
   raf.writeDouble(d1);
   raf.writeUTF(s1);
   raf.writeBoolean(b1);
   raf.writeChar(c1);
   
   raf.seek(0); //rewind

   i2 = raf.readInt();   
   d2 = raf.readDouble();   
   s2 = raf.readUTF();   
   b2 = raf.readBoolean();   
   c2 = raf.readChar();   

   //close the file
   raf.close();

   System.out.println(i1 + "  "  + i2);
   System.out.println(d1 + "  "  + d2);
   System.out.println(s1 + "  "  + s2);
   System.out.println(b1 + "  "  + b2);
   System.out.println(c1 + "  "  + c2);

  }
  catch(Exception ex)
  {
   System.out.println(ex);
  }  
 } 

 public static void main(String args[])
 {
   //demoRWSeek();  
   demoPrimitiveTypesRW();
 }//main
}//RAF

