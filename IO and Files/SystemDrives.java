import java.io.*;

class SystemDrives
{
 public static void main(String args[])
 {
   File allDrives[] = File.listRoots();
   for(File f : allDrives)
   {
    System.out.println("-------------------");
    System.out.println(f.getAbsolutePath());
    System.out.println(f.exists() ? "Ready for use" : "No Disk");
    System.out.println("Total Space : " + f. getTotalSpace()/(1024*1024*1024.0) + " gb");
    System.out.println("UsableSpace : " + f. getUsableSpace()/(1024*1024*1024.0) + " gb");
	
    System.out.println("-------------------");
   }
 }//main
}//SystemRoots