import java.util.ArrayList;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		int width = 4;
		int height = 4;
		
		int[][] grid = new int[width][height];
		
		display(grid);
		
	}	
	
	public static void display(int[][] arr) {
		int numRows = arr.length;
		int numColumns = arr[0].length;
		
		for (int r = 0; r < numRows; r++) {
			for (int c =0; c <numColumns; c++) {
				System.out.print("0 ");
			}
			System.out.println();
		}
		
	}
	
	public static int random() {
		Random randomNum = new Random();
		
		int num = randomNum.nextInt(3);
		return num;
	}
}

