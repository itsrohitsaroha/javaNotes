import java.io.File;
import java.util.Date;

class FileTest
{
 static void fetchFileInfo(File f)
 {//f represents a file
  System.out.println("AbsolutePath : " + f.getAbsolutePath());   
  System.out.println("Name : " + f.getName());   
  System.out.println("Parent Folder : " + f.getParent());   
  System.out.println("Date Modified : " + new Date(f.lastModified()));
  System.out.println("Readable : " + f.canRead());
  System.out.println("Writable : " + f.canWrite());
  System.out.println("Execute : " + f.canExecute());
  System.out.println("Hidden : " + f.isHidden());
  //f.delete(); 
 }

 static void fetchDirectoryInfo(File f)
 {//f represents a directory 
   String contents[] = f.list();
   File current;
   for(String s : contents)
   {
     current = new File(f,s);//parent, name of current 
     if(current.isFile())
       //System.out.println(s);//name of content[i]
       System.out.println(current.getAbsolutePath());//name of content[i]
     else if(current.isDirectory())
     {
       System.out.println(current.getAbsolutePath());//name of content[i]
       fetchDirectoryInfo(current);       

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
     {
       System.out.println(args[0] + " is a file");
       fetchFileInfo(f);
     }
     else if(f.isDirectory())
     {
       System.out.println(args[0] + " is a directory");
       fetchDirectoryInfo(f);
     }

   }
   else
   {
     System.out.println(args[0] + " doesnt exists");
     System.out.println("Do you want to create it (y/n) : ");
     System.in.skip(System.in.available());
     char ch = (char) System.in.read();
     if(ch == 'y' || ch == 'Y')
     {
      System.out.println("F/f : create as a file ");
      System.out.println("D/d : create as a directory ");
      System.out.println("Enter choice : ");
      System.in.skip(System.in.available());
      ch = (char) System.in.read();

      switch(ch)
      {
       case 'f':
       case 'F':
         f.createNewFile();
         break;
       case 'd':
       case 'D':
         f.mkdirs();
         break;
       default:
         System.out.println("Wrong Choice ");
      }//switch
     }//if create yes
   }//else if
  }//try
  catch(ArrayIndexOutOfBoundsException ex)
  {
   System.out.println("Usage : java FileTest <file/drirectory/drive>");
  }
  catch(Exception ex)
  {
   System.out.println(ex);
  }
 }//main
}//FileTest