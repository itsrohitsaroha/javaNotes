package steganography;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;

public class Embed 
{
    File fileImg, fileDoc;
    String password;
    
    Embed(String iFile, String dFile, String password) throws Exception
    {
        fileImg = new File(iFile);
        fileDoc = new File(dFile);
        
        if(!fileImg.exists())
            throw new Exception(iFile + " not found");
        if(!fileDoc.exists())
            throw new Exception(dFile + " not found");
        
        this.password = password;
    }
    
    String embed() throws Exception
    {
        //load the image in memory
        BufferedImage bImg = ImageIO.read(fileImg);
        //open the document for reading
        FileInputStream fin = new FileInputStream(fileDoc);
        //compose the header
        String header = HeaderManager.getHeader(fileDoc.getAbsolutePath());
        //get the writable raster ( a matrix that contains the pixels of the image)
        WritableRaster wraster = bImg.getRaster();
        //Byte Manager
        ByteManager bMgr = new ByteManager(password);

        //general properties
        int w,h,x,y,r,g,b,i,data;
        int arr[];

        w = wraster.getWidth();
        h = wraster.getHeight();

        long need = fileDoc.length()+ HeaderManager.HEADER_LENGTH;
        long capacity = w*h;
        if(need > capacity)
            throw new Exception("File Too Large To Embed");

        data = 0;
        i =0;

        for(y =0; y < h && data != -1; y++)
        {//for the rows
            for(x = 0; x < w; x++)
            {//for the cols
                r = wraster.getSample(x, y, 0);//red band
                g = wraster.getSample(x, y, 1);//green band
                b = wraster.getSample(x, y, 2);//blue band

                //free the last 3 bits of r and g 
                //free the last 2 bits of b
                r = r & (~0x7);
                g = g & (~0x7);
                b = b & (~0x3);

                //embed
                if(i < HeaderManager.HEADER_LENGTH)
                    data = header.charAt(i++);
                else
                    data = fin.read();

                if(data == -1)//EOF
                    break;

                data = bMgr.encryptTheByte(data);
                arr = bMgr.splitTheByte(data);

                r = r | arr[0];
                g = g | arr[1];
                b = b | arr[2];

                //update the raster
                wraster.setSample(x, y, 0, r);//red band
                wraster.setSample(x, y, 1, g);//green band
                wraster.setSample(x, y, 2, b);//blue band

            }//for(x
        }//for(y
        //close the file
        fin.close();

        //update the bufferedImage
        bImg.setData(wraster);

        //save the bImg
        String newName = getNewName(fileImg.getAbsolutePath());
        File target = new File(newName);
        ImageIO.write(bImg, "PNG", target);

        return newName;
            
    }
    
    private static String getNewName(String fn)
    {//fn : d:/images/tiger.png
        File f = new File(fn);
        String parent = f.getParent();//d:/images
        String name = "copy_" + f.getName();//copy_tiger.png
        return parent + "/" + name;
    }
}
