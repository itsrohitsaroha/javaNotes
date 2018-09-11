package steganography;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

public class Extract 
{
    File fileImg;
    String password;
    
    Extract(String iFile, String password) throws Exception
    {
        fileImg = new File(iFile);
        
        if(!fileImg.exists())
            throw new Exception(iFile + " not found");
        
        this.password = password;
    }
    
    String extract() throws Exception
    {
        //load the image in memory
        BufferedImage bImg = ImageIO.read(fileImg);
        //For writing a document 
        FileOutputStream fout = null;
        //For the header
        String header = "";
        //get the readable raster ( a matrix that contains the pixels of the image)
        Raster raster = bImg.getData();
        //Byte Manager
        ByteManager bMgr = new ByteManager(password);

        //general properties
        int w,h,x,y,i,data;
        int arr[] = new int[3];
        String nm= "";
        long len;

        w = raster.getWidth();
        h = raster.getHeight();
        len = 1;//flag value
        i =0;

        for(y =0; y < h && len > 0; y++)
        {//for the rows
            for(x = 0; x < w && len > 0; x++)
            {//for the cols
                arr[0] = raster.getSample(x, y, 0);//red band
                arr[1] = raster.getSample(x, y, 1);//green band
                arr[2] = raster.getSample(x, y, 2);//blue band

                //data is in
                //the last 3 bits of r and g 
                //the last 2 bits of b
                arr[0] = arr[0] & 0x7;
                arr[1] = arr[1] & 0x7;
                arr[2] = arr[2] & 0x3;

                data = bMgr.formTheByte(arr);
                data = bMgr.decryptTheByte(data);

                //extract
                if(i < HeaderManager.HEADER_LENGTH)
                {
                    header = header + (char)data;
                    i++;
                    if(i == HeaderManager.HEADER_LENGTH)
                    {//header ready
                        len = HeaderManager.getFileSize(header);
                        nm = System.getProperty("user.home") + "/downloads/" +  HeaderManager.getFileName(header);
                        fout = new FileOutputStream(nm);
                    }
                }
                else
                {
                    fout.write(data);
                    len--;
                }   
            }//for(x
        }//for(y
        //close the file
        fout.close();

        return nm;
            
    }
    
    private static String getNewName(String fn)
    {//fn : d:/images/tiger.png
        File f = new File(fn);
        String parent = f.getParent();//d:/images
        String name = "copy_" + f.getName();//copy_tiger.png
        return parent + "/" + name;
    }
}
