import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Console game for creating and printing a random treasure grid.
 */

public class ConsoleGame {


	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Grid size (Enter a value between 4 and 8): ");
		
		int width = in.nextInt();
		int height = width;
		
		while (width > 8 || width < 4) {
			System.out.print("Enter a value between 4 and 8. Try again: ");
			width = in.nextInt();
			height = width;
		}
		
		System.out.print("How many treasures do you want to try and find? ");
		int numTreasures = in.nextInt();
		// limit of treasures
		
		while(numTreasures > 5) {
			System.out.print("Enter a value less than 6: ");
			numTreasures = in.nextInt();
		}
		
		System.out.println();
		
		
		int[][] grid = new int[width][height];
		
		int treasureX = 0;
		int treasureY = 0;
		
		for (int i = 0; i < numTreasures; i++) {
			
			
			treasureX = random(width);
			treasureY = random(width);
			
			while(grid[treasureX][treasureY] == 1) { // make sure there is not already a treasure in that location
				treasureX = random(width);
			}

			grid[treasureX][treasureY] = 1;
			
		}
		
		display(grid);
		
	}	
	
	public static void display(int[][] arr) {
		int numRows = arr.length;
		int numColumns = arr[0].length;
		
		for (int r = 0; r < numRows; r++) {
			for (int c =0; c <numColumns; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
			
		}
		
	}
	
	public static int random(int w) {
		
		Random randomNum = new Random();
		
		int num = randomNum.nextInt(w);
		return num;
	}
}
