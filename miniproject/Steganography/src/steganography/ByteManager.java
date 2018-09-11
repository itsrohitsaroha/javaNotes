package steganography;

public class ByteManager 
{
    String password;//computer
    int pos;//-1
    int len;//8
    
    ByteManager(String s)
    {
        password = s;
        pos = -1;
        len = password.length();
    }
            
    int encryptTheByte(int data)
    {
        pos = (pos + 1) % len;
        return data ^ password.charAt(pos);
    }
    
    int decryptTheByte(int data)
    {
        pos = (pos + 1) % len;
        return data ^ password.charAt(pos);
    }
    
    int[] splitTheByte(int data)
    {//data = 11010011  = {110, 100, 11}
        int arr[] = { (data>>5) & 0x7, (data>>2)&0x7, data & 0x3};
        return arr;
    }
    
    int formTheByte(int arr[])
    {//{110, 100, 11} = 11010011
        return (((arr[0]<<3)|arr[1])<<2)|arr[2];
    }
}
