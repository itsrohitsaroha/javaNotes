/*
Study of 2 dimensional array

In Java, an 2 dimensional array is a fixed sized collection of homogenous values.
It is dynamically allocated ( in the heap segment of RAM ) using the new statement.
It gets a clear allocation.

The declaration statment :
   int mat[][] = new int[3][4];

int mat[][] declares a reference to a 2 dimensional integer array.

new int[3][4] allocates an 3 int arrays of 4 elements each in heap segment of RAM.

TIP:
One can use a matrix initializer for direct allocation and data assignment.
int mat[][] = {{1,2,3}, {4,5,6}};

See : MDim.png

*/

import java.util.Random;

class MDim
{
 public static void main(String args[])
 {
  //C : int mat[3][4];
  //Java :
  int mat[][]= new int[3][4];


  int i, j;  
  Random r = new Random();
  //initialize

  for(i=0; i<mat.length; i++)     
   for(j=0; j<mat[i].length; j++)
    mat[i][j]= r.nextInt(100);

  //display
  System.out.println();
  for(i=0; i<mat.length; i++)     
  {
   System.out.println();
   for(j=0; j<mat[i].length; j++)
     System.out.print(mat[i][j] + " ");
  }

  int []temp;

  temp= mat[1];
  mat[1] = mat[2];
  mat[2] = temp;

  //display
  System.out.println();
  for(int x[] : mat)  
  {
   System.out.println();
   for(int y : x)
    System.out.print(y + " ");
  }

 }//main
}//MDim