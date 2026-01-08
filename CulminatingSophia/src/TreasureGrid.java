import java.util.Random;

public class TreasureGrid {
    private boolean[][] treasures;
    private int size;
    private int treasureCount;
    private boolean[][] bombs;

    public TreasureGrid(int s, int t) {
        size = s;
        treasureCount = t;
        treasures = new boolean[size][size];
        bombs = new boolean[size][size];

        placeTreasures();
        placeBombs();
    }

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
    
    private void placeBombs() {
    	Random r = new Random();
    	int numBombs = 0;
    	
    	while (numBombs < 4) {
    		int v = r.nextInt(size);
    		int h = r.nextInt(size);
    		
    		// only place if empty again
    		if (!bombs[v][h] && !treasures[v][h]) {
    			bombs[v][h] = true;
    			numBombs ++;
    		}
    	}
    }
    

    public boolean hasTreasure(int row, int col) {
        return treasures[row][col];
    }
    
    public boolean hasBomb(int r, int c) {
    	return bombs[r][c];
    }

    public int getSize() {
        return size;
    }

    public int getTreasureCount() {
        return treasureCount;
    }
}
