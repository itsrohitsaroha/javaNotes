/*
Study of 2 dimensional Ragged Array

Ragged Array is a 2 dimensional
array for which the rows have varying
number of columns.

Allocation
A ragged array is allocated in 2 steps.
1) Row allocation.
2) Column allocation per row.

Row allocation approach:
 int ragged[][] = new int[3][];
This allocates a row reference 
array with elements set to NULL.


Column allocation approach:
 ragged[0] = new int[3];
 ragged[1] = new int[4];
 ragged[2] = new int[2];

Hereafter the ragged array can be used.

See : Ragged.png
*/

import java.util.Random;

class Ragged
{
 public static void main(String args[])
 {
  //Java :
  int mat[][]= new int[3][];
  mat[0] = new int[3];
  mat[1] = new int[4];
  mat[2] = new int[2];


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
}//Ragged