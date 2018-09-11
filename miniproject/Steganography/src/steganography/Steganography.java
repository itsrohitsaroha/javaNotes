package steganography;

import java.util.Arrays;

public class Steganography 
{

    public static void main(String[] args) 
    {
        try
        {
            Embed emb = new Embed("d:/home.png", "d:/tiger.png", "this is an old machine");
            String q = emb.embed();
            System.out.println(q);
           Extract ext = new Extract(q, "this is an old machine");
            q = ext.extract();
            System.out.println(q);
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
}
