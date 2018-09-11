package handson;

public class Main 
{
    public static void main(String[] args) 
    {
        //String result;
        //result = Watermarker.markString("d:/tiger.png", "This Image Belongs To AIT");
        //result = Watermarker.markImage("d:/tiger.png", "d:/a.png");
        //result = Watermarker.stringOnImage("This is a sample sentence");
        //System.out.println(result);
        
        String q, w;
        q= HiddenMark.write("d://tiger.png", "this is important information that we hide in an image");
        System.out.println(q);
        w = HiddenMark.read(q);
        System.out.println(w);
    }
}
