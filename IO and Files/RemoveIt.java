import java.io.File;
import java.util.Date;

class RemoveIt
{

 static void delDirectory(File f)
 {//f represents a directory 
   String contents[] = f.list();
   File current;
   for(String s : contents)
   {
     current = new File(f,s);//parent, name of current 
     if(current.isFile())
      current.delete();
     else if(current.isDirectory())
     {
       delDirectory(current);       
       current.delete();
     }
   }
 }

 public static void main(String args[])
 {
  try
  {
   File f = new File(args[0]);
   if(f.exists())
   {
     if(f.isFile())
       f.delete();
     else if(f.isDirectory())
     {
       delDirectory(f);
       f.delete();
     }
   }
   else
     System.out.println(args[0] + " doesnt exists");

  }//try
  catch(ArrayIndexOutOfBoundsException ex)
  {
   System.out.println("Usage : java RemoveIt <file/drirectory/drive>");
  }
  catch(Exception ex)
  {
   System.out.println(ex);
  }
 }//main
}//FileTest