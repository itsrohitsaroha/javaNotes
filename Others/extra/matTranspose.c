//Program to perform : 
//Matrix Transpose
#include<stdio.h>
#define SIZE 3


void transpose(int mat[][SIZE])
{
    int i, j;
    int temp;
    
    for(i =0 ; i< SIZE-1; i++)
    {
        for(j = i+1; j < SIZE; j++)
        {
            temp = mat[i][j];
            mat[i][j] = mat[j][i];
            mat[j][i] = temp;
        }
    }
}

void scan(int mat[][SIZE]) //formal parameter is a matrix reference
{
    int i, j;
    for(i =0; i< SIZE; i++)
    {
        for(j =0; j < SIZE; j++)
        {
            printf("\n Enter data for mat[%d][%d] ", i, j);
            scanf("%d", &mat[i][j]);
        }
    }
}

void display(int (*p)[SIZE]) //formal parameter is a matrix pointer
{
    int i, j;
    
    printf("\n");
    for(i =0 ; i< SIZE; i++)//row
    {
        printf("\n");
        for(j =0 ; j< SIZE; j++)//column representation
        {
            printf(" %3d ", *(*(p+i)+j));
        }
    }
}

int main()
{
    int mat[SIZE][SIZE];
    
    scan(mat);
    
    display(mat);
    transpose(mat);
    display(mat);
    
    return 0;
}