public class Ship {
    private int len = 3;
    private int[][] locationCells = new int[3][2];
    private int numOfHits = 0;

    public String check(int[] g) {
        // compare user guess to location cell
        for (int i = 0; i < locationCells.length; i++) {
            //look for hit, if guess is a location...
            if (locationCells[i][0] == g[0] && locationCells[i][1] == g[1]) {
                // increase num of hits
                numOfHits++;
                // shrink locationsCells and remove the hit location
                shrinkLocations(g);
                
                if (locationCells.length == 0) {
                    return "kill";
                }
                else {
                    return "hit";
                }
            }
        }
        
        return "miss";
    }

    public void shrinkLocations(int[] guess) {
        int[][] temp = new int[locationCells.length - 1][2];
        int currentPos = 0;

        for (int i = 0; i < locationCells.length; i++) {
            if (!(locationCells[i][0] == guess[0] && locationCells[i][1] == guess[1])) {
                temp[currentPos] = locationCells[i];
                currentPos++;
            }
        }
        setLocationCells(temp);
    }
    
    public void setLocationCells(int[][] locations) {
        this.locationCells = locations;
    }
    public int[][] getLocationCells() {
        return this.locationCells;
    }
    public void setLen(int len) {
        this.len = len;
    }
    public int getLen() {
        return len;
    }
    public int getNumOfHits() {
        return numOfHits;
    }
    
}