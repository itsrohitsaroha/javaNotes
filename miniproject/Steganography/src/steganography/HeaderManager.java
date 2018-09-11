package steganography;
import java.io.File;

public class HeaderManager 
{
    public static final int HEADER_LENGTH = 30;
    
    static String getHeader(String fileName) throws Exception
    {//d:/images/tiger.png
     //output : tiger.png###########8765423$$$   

        File f= new File(fileName);
        if(!f.exists())
            throw new Exception(fileName + " not found");
        
        String name = f.getName();//tigersOfMadhyaPradesh.png 
        
        if(name.length() > 20)
        {//trim the name from the right
            int pos = name.lastIndexOf(".");//21 (last index of .)
            if(pos != -1)//dot found
            {
                //"computer".substring(0,4) = "comp"
                String q = name.substring(0, pos);//tigersOfMadhyaPradesh
                //"computer".substring(3) = puter
                String w = name.substring(pos);//".png";
                int l = w.length();//4
                q = name.substring(0, (20-l));//tigersOfMadhyaPr
                name = q+w;//tigersOfMadhyaPr.png
            }
            else
            {//dot not found i.e. file with no extension
                name = name.substring(0,20);
            }
        }
        else
        {//# pad
            while(name.length() < 20)
                name= name + "#";
        }
        
        //file size
        String size = String.valueOf(f.length());
        while(size.length() < 10)
            size = size + "$";
        
        return name+ size;
    }
    
    static String getFileName(String header) throws Exception
    {//tiger.png###########8765423$$$   
     //tiger.png
        String name = header.substring(0,20);//tiger.png###########
        name = name.replace('#', ' ');
        return name.trim();
    }

    static long getFileSize(String header) throws Exception
    {//tiger.png###########8765423$$$   
     //8765423
        try
        {
            String q = header.substring(20);//8765423$$$
            q = q.replace('$', ' ');
            return Long.parseLong(q.trim());
        }
        catch(Exception ex)
        {
            throw new Exception("Invalid Header");
        }
    }    
}
    
    

