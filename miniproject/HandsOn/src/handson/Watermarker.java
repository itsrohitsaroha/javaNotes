package handson;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Watermarker 
{
    static String markString(String ifile, String mark)
    {   
        try
        {
            //load the image in memory
            File fImage = new File(ifile);
            BufferedImage bImg = ImageIO.read(fImage);
            //get a handle to the Graphics pen of the bImg
            Graphics pen = bImg.getGraphics();
            //set pen properties
            pen.setFont(new Font("Comic Sans MS", Font.BOLD,40));
            pen.setColor(Color.red);
            //write
            pen.drawString(mark, 100, 100);

            //save back
            String newName = getNewName(ifile);
            File target = new File(newName);
            ImageIO.write(bImg, "PNG", target);
            
            return newName;
        }
        catch(Exception ex)
        {
            return null;
        }
        
    }

    static String stringOnImage(String mark)
    {   
        try
        {
            //load the image in memory
            BufferedImage bImg = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            //get a handle to the Graphics pen of the bImg
            Graphics pen = bImg.getGraphics();
            //set pen properties
            pen.setColor(Color.YELLOW);
            pen.fillRect(0, 0, bImg.getWidth(), bImg.getHeight());
            pen.setFont(new Font("Comic Sans MS", Font.BOLD,40));
            pen.setColor(Color.RED);
            //write
            pen.drawString(mark, 100, 100);

            //save back
            String newName = getNewName("d:\\q.png");
            File target = new File(newName);
            ImageIO.write(bImg, "PNG", target);
            
            return newName;
        }
        catch(Exception ex)
        {
            return null;
        }
        
    }
    
    private static String getNewName(String fn)
    {//fn : d:/images/tiger.png
        File f = new File(fn);
        String parent = f.getParent();//d:/images
        String name = "copy_" + f.getName();//copy_tiger.png
        return parent + "/" + name;
    }

    static String markImage(String ifile, String mfile)
    {   
        try
        {
            //load the image in memory
            File fImage = new File(ifile);
            BufferedImage bImg = ImageIO.read(fImage);
            //get a handle to the Graphics pen of the bImg
            Graphics pen = bImg.getGraphics();
            //set pen properties
            pen.setFont(new Font("Comic Sans MS", Font.BOLD,40));
            pen.setColor(Color.red);
            //write
            File fMark = new File(mfile);
            BufferedImage bImg2 = ImageIO.read(fMark);
            pen.drawImage(bImg2, 100, 100, null);
            //save back
            String newName = getNewName(ifile);
            File target = new File(newName);
            ImageIO.write(bImg, "PNG", target);
            
            return newName;
        }
        catch(Exception ex)
        {
            return null;
        }
        
    }

    
    
}
