package lab02;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];//instantiation of the 2D array 
	
	// default constructor
	public Matrix(){}
	
	// constructor 1 - Constructor for new zero matrix
	public Matrix(int rowDim, int colDim){
		/*
		* TODO: write a constructor that would create a matrix
		* of correct size and initialize it to 0. 
		*/
		numRows=rowDim; 
		numColumns=colDim;
		data = new int [rowDim][colDim]; //assigning values to array
	}
	
	
	// constructor 2 - Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		/* 1) put the numRows to be the number of 1D arrays in the 2D array
		*  2) specify the numColumns and set it
		*  3) be careful of special cases you are supposed to handle them properly. 
		*  4) create a new matrix to hold the data
		*  5) copy the data over
		*/
		numRows = d.length;  //making numRows the column in the 2d array
		numColumns = d[0].length;
		
		if(numRows == 0) {
			numColumns =0;
		}
		else {
			numColumns = d[0].length;
			}
		 data = new int [numRows][numColumns];
		for(int i=0;i<numRows;i++) {
			for (int j=0;j<numColumns;j++) {
				data[i][j]=d[i][j];
		
			}
		}
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()//check notes Labo02 for info on toString method
	{
		String matrixString = "";
		for (int row=0; row<numRows; row++) {
			for(int col=0; col<numColumns; col++) {
				matrixString += data[row][col];
				matrixString += " ";
			}
			matrixString += "\n";
		}
		/*
		 * TODO: replace the below return statement with the correct code, you must return a String that represents this 
		 * 			matrix, as specified in the instruction for M1 - anything else IS NOT acceptable
		 */
		return matrixString; // placeholder		
	}
	
	// *** you will implement the rest of the methods for your assignment
	// *** don't touch them before finishing the lab portion
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		
		for (int i=0; i<m.data.length;i++) {
			for(int j=0;j<m.data[i].length;j++) {
				if(!(m.data[i][j]==data[i][j]))
				//if(Arrays.deepEquals(m.data, data));
				return false;
				else 
				continue;
			}
			
		}
		
		/*
		 * TODO: replace the below return statement with the correct code, you must return the correct value
		 * 			after determining if this matrix is equal to the input matrix
		 */
		
		
		return true; // placeholder
	}

	public Matrix mult(Matrix m)
	{
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for multiplication, if not, return null.
		 *  If they are compatible, determine the dimensions of the resulting matrix, and fill it in with
		 *  the correct values for matrix multiplication
		 */
		//he number of columns of first matrix must be equal to the number of rows of second matrix.
		int firstMatrixRows = data[0].length;
		int secondMatrixCol = m.numColumns;
		
		if(data[numRows]!=m.data[numColumns]) {
			return null;
		}
		Matrix multMatrix = new Matrix(firstMatrixRows,secondMatrixCol);
		for(int i = 0;i<multMatrix.numRows;i++) {
			for(int j = 0;j<multMatrix.numColumns;j++) {
				for(int k = 0;k<data.length;k++) {
					multMatrix.data[i][j]+=(data[i][k]*m.data[k][j]);
				}
			}
		}
		return multMatrix ; // remember to return a matrix
	}
	
	public Matrix add(Matrix m)
	{
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for addition, if not, return null.
		 *  If they are compatible, create a new matrix and fill it in with
		 *  the correct values for matrix addition
		 */
		if (!(numRows==m.numRows && numColumns == m.numColumns)) {
		//said something about using m.m
		return null;} // placeholder
		
		int i = data.length;
    	int j = data[0].length;
    	
    	
    	Matrix sumMatrix = new Matrix(i,j);
    	
    	for(int x = 0; x < i; x++) {
    		for(int y = 0; y < j; y++) {
    			sumMatrix.data[x][y]= (m.data[x][y]+data[x][y]); //data pertains to m1 and m.data pertains to m2
    		}
    	}
		//don't forget to have a return statement
    	return sumMatrix;
	}
    
    public Matrix transpose()
    {
        /*
         * TODO: replace the below return statement with the correct code,
         */
    	//Matrix M1 = new Matrix(2, 3)
    	int i = data.length;
    	int j = data[0].length;
    	
    	System.out.println(i);
    	System.out.println(j);
    	Matrix localMatrix = new Matrix(i,j);
    	//localMatrix(i,j)=transpose(j,i);
    	
    	for(int x = 0; x < i; x++) {
    		for(int y = 0; y < j; y++) {
    			
    			localMatrix.data[x][y] = data[y][x];
    		}
    	}
    	
        return localMatrix; 
    }
}
