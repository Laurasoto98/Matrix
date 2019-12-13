package lab02;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// default constructor
	public Matrix(){} //default constructor that gives the initial values if the parameter is ().
	
	// constructor 1 - Constructor for new zero matrix
	
	public Matrix(int rowDim, int colDim){ //Constructor that would be used if the parameter has two int numbers. 
		
		numRows = rowDim;
		numColumns = colDim;
		data= new int[numRows][numColumns];
		
		for(int i=0; i<numRows; i++) {
			for(int j=0; j<numColumns; j++) {
				
				data[i][j]= 0;
			}
		}
		
		
	}
	
	
	public Matrix(int d[][]) //Constructor when the parameters give the initial dimensions of the array.
	{
		
		numRows= d.length;
		numColumns= d[0].length;
		
		data= new int[numRows][numColumns];
		
		for(int i=0; i<numRows; i++) {
			for(int j=0; j<numColumns; j++) {
				
				data[i][j]= d[i][j];
			}
		}
		/* 1) put the numRows to be the number of 1D arrays in the 2D array
		*  2) specify the numColumns and set it
		*  3) be careful of special cases you are supposed to handle them properly
		*  4) create a new matrix to hold the data
		*  5) copy the data over
		*/
	}	
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	
	public String toString()
	{
		String answ = "\n";
		
		
		for(int i=0; i<numRows; i++) {
			
			for(int j=0; j<numColumns; j++) {
				
				answ += (data[i][j]) + " ";
			}
			
			answ += "\n";
		}
		
		return answ;
		
		/*
		 * TODO: replace the below return statement with the correct code, you must return a String that represents this 
		 * 			matrix, as specified in the instruction for M1 - anything else IS NOT acceptable
		 */
		// placeholder	
		
	}
	
	// *** you will implement the rest of the methods for your assignment
	// *** don't touch them before finishing the lab portion
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	
	public boolean equals(Object o)
	{
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		
		boolean equal = false; 
		 	
		if( data.length == m.data.length && data[0].length == m.data[0].length) {
			
			for(int i =0; i< data.length; i++) {
				
				for(int j=0; j< data[0].length ;j++) {
					
					if (data[i][j] == m.data[i][j]) {
						
						equal= true; 
						
					}
					
					else {
						
						equal= false;
						
						i= data.length;
						
						j = i; 
						
					}
				}
			}
			
			return equal;
			
		}
		
		else {
			
			return false;
			
		}
	}

	public Matrix times(Matrix m)
	{
		if(!(m instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return null;
		
		Matrix matrix = m; 
		
		Matrix mTimes; 
		
		if(data[0].length == matrix.data.length) {
			
			mTimes = new Matrix ( new int[data.length][matrix.data[0].length]);
			
			for (int l=0; l< data.length; l++){
				
	            for (int j=0; j< matrix.data[0].length; j++){
	            	
	               for (int k=0; k< data[0].length; k++){
	            	   
	                  mTimes.data[l][j] += data[l][k] * matrix.data[k][j];
	                 
				
	               }
	            }
			}
			
			return mTimes;
								
		}
		
		else {	
			
			return null ;
			
			}
		
	}
		
		
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for multiplication, if not, return null.
		 *  If they are compatible, determine the dimensions of the resulting matrix, and fill it in with
		 *  the correct values for matrix multiplication
		 */
		
	
	
	public Matrix plus(Matrix m)
	{
		if(!(m instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return null;
		
		Matrix matrix = (Matrix) m ; 
		
		if (data.length == matrix.data.length && data[0].length == matrix.data[0].length) {
			
			Matrix sumMatrix = new Matrix( new int[data.length][data[0].length] );
			
			for(int i =0; i< data.length; i++) {
				
				for(int j=0; j< data[0].length ;j++) {
					
					sumMatrix.data[i][j] =  matrix.data[i][j] + data[i][j];
					
					
				}
			}
			
			return sumMatrix;
		}
		
		else {
			
			return null;
		}
			

		
	}	
}
