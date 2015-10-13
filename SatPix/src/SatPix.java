import java.io.*;
import java.util.Scanner;

public class SatPix {

	public static void main(String[] args) throws IOException
	{
		boolean[][] booleanArr = fileToBoolArray("satpix.in");
		int sizeOfLargestPasture;
		
		/* YOUR CODE GOES HERE */
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
		out.println(sizeOfLargestPasture);
		out.close();
		}
	
	private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException, IOException
	{
		Scanner scan = new Scanner(new File(fileName));
		int cols = scan.nextInt();
		int rows = scan.nextInt();
		
		boolean[][] bArray = new boolean[rows][cols];
		for(boolean[] a : bArray){
			String row = scan.next();
			for(int i=0; i<row.length(); i++){
				if(row.charAt(i) == '*'){
					a[i] = true;
				}
				else{
					a[i] = false;
				}
			}
		}
		scan.close();
		
		return bArray;
		
	}

	private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
	{
		//This recursive method employs the flood-fill algorithm to
		//count the size of a single pasture and "mark" it so it is not double-counted
		if(arr[row][col]==false || col > arr.length || row > arr.length || col<0 || row<0){
			return 0;
		}
		else{
			arr[row][col] = false;
			return 1 + recursivelyMeasureAndMarkPasture(row+1, col, arr) + recursivelyMeasureAndMarkPasture(row-1, col, arr) + recursivelyMeasureAndMarkPasture(row, col+1, arr) + recursivelyMeasureAndMarkPasture(row, col-1, arr);
		}
	}
	
}