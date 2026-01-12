import java.util.Random;

/**
 * Class that holds the hidden board contents (treasures and bombs)
 */

public class TreasureGrid {
	
	private static final int initialBombs = 4; 
    private static final int minGridSize = 4;    
    private static final int maxGridSize = 8;    

    private final boolean[][] treasures;
    private final boolean[][] bombs; 
    private final int size;  
    private final int treasureCount; 
    private final int maxBombs;      
    private final Random random;      

   
    
    /**
     * Creates a new board with the default number of bombs
     * @param size grid size (X by X)
     * @param treasureCount number of treasures to place
     */
    public TreasureGrid(int s, int t) {
        size = s;
        treasureCount = t;
        
        maxBombs = initialBombs;
        random = new Random();
        
        treasures = new boolean[size][size];
        bombs = new boolean[size][size];

        placeTreasures();
        placeBombs();
    }
    
    /**
     * Randomly places treasures on empty squares
     */
    private void placeTreasures() {
        Random random = new Random();
        int placed = 0;

        while (placed < treasureCount) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);

            // only place if empty
            if (!treasures[row][col] && !bombs[row][col]) {
                treasures[row][col] = true;
                placed++;
            }
        }
    }
    
    /**
     * Randomly places bombs on empty squares
     */ 
    private void placeBombs() {
    	Random r = new Random();
    	int numBombs = 0;
    	
    	while (numBombs < initialBombs) {
    		int v = r.nextInt(size);
    		int h = r.nextInt(size);
    		
    		// only place if empty again
    		if (!bombs[v][h] && !treasures[v][h]) {
    			bombs[v][h] = true;
    			numBombs ++;
    		}
    	}
    }
    
    /**
     * Returns whether a treasure exists at the given position
     *
     * @param row row index
     * @param col column index
     * @return true if treasure is present
     */   
    public boolean hasTreasure(int row, int col) {
        return treasures[row][col];
    }
    
    /**
     * Returns whether a bomb exists at the given position
     *
     * @param row row index
     * @param col column index
     * @return true if bomb is present
     */
    public boolean hasBomb(int r, int c) {
    	return bombs[r][c];
    }
    
    /**
     * @return board size (X by X)
     */
    public int getSize() {
        return size;
    }
    
    /**
     * @return number of treasures placed on the board
     */
    public int getTreasureCount() {
        return treasureCount;
    }
}
