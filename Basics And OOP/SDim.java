/*
Study of Single Dimensional Array
Interpret the code and comments
Refer : the note below
See : SDim.png

*/

class SDim
{
 public static void main(String args[])
 {
  //C : int arr[4];
  //Java
  int arr[] = new int[4];

  int i;

  //display
  System.out.println();
  for(i=0 ; i < arr.length; i++)
   System.out.print(arr[i] + " ");


  //initialization
  for(i =0 ; i < arr.length; i++)
    arr[i] = i+ 10;


  //display
  System.out.println();
  for(int x : arr)
   System.out.print(x + " ");


 }//main
}//SDim

/*
In Java, an array is a fixed sized collection of homogenous values.
It is dynamically allocated ( in the heap segment of RAM ) using the new statement.
Its minimum size is ZERO.
Its maximum size is system dependent.
It gets a clear allocation.

The declaration statment :
   int arr[] = new int[4];

int arr[] declares an integer array reference.
(Reference is a variable that can store memory address and can be dereferenced)

new int[4] allocates an int array of 4 elements in heap segment of RAM.
Its address must be received in a reference for use.

arr.length
----------------
length is a system defined read only attribute of an array.
It returns the size of the array.

Reference declaration alternative
------------------------------------------
Java allows declaration of array reference 
in 2 ways :
1) datatype referenceName[];
    (int arr[])
2) datatype []referenceName;
    (int []arr)

Learn the difference by example.

int arr[], a, b;
declares arr as int array reference and a,b as int variables.

int []arr, a, b;
declares arr, a and b (all identifiers) as int array references.


Array Declaration Alternative
----------------------------------
Array can be alternatively declared using an initializer, as follows.

int arr[] = {6, 3, 1, 9, 4};

*/