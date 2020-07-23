import java.util.Random;

public class ShipLocations {
    // array that holds the nine total ship locations
    private static int len = 3;
    private static int[][] usedLocations = new int[9][2];
    
    public static int[][] createLocations(){
        int[][] newShipLocations = new int[len][2];
        // need to know if you are going to position ship up or down.
        Random randint = new Random();
        // control boolean for do-while loop below
        boolean locationsHaveBeenUsed = false; 
        boolean placementIsValid = false;
        int xLoc;
        int yLoc;
        int direction = randint.nextInt(2);
        // generate locations until the initial location isnt already used
        do {
            // x location starts at 1 and goes to a point where it will still fit on the board
            xLoc = randint.nextInt(8 - len) + 1;
            // y location starts at 1 and goes to a point where it will still fit on the board
            yLoc = randint.nextInt(8 - len) + 1;

            locationsHaveBeenUsed = hasBeenUsed(xLoc, yLoc);
            
            //generate new direction and try again.
            direction = randint.nextInt(2);
            placementIsValid =  validPlacement(xLoc, yLoc, direction);
            // only place if the locations have not been NOT been used
            if (placementIsValid && !locationsHaveBeenUsed) {
                //make a call to place at those locations.
                newShipLocations = placeShipLocations(xLoc, yLoc, direction);
            }
        // stop once both the locations haven't been used and the placement is not valid    
        } while (locationsHaveBeenUsed || !placementIsValid);
        
        // current shipLocations array has been altered, return.
        return newShipLocations;

    }

    public static boolean hasBeenUsed(int xLoc, int yLoc) {
        
        for (int[] loc : usedLocations) {
            // if the randomly generated location has already been used, generate again.
            if (loc[0] == xLoc && loc[1] == yLoc) {
                return true;
            }
        }
        // if not found in usedLocaations return false
        return false;
    }

    public static void placeInNonEmpty(int xLoc, int yLoc) {
        // add the location to used locations in the slot that is first available (non-double zeros)
        for (int j = 0; j < usedLocations.length; j++) {
            if (usedLocations[j][0] == 0 && usedLocations[j][1] == 0) {
                usedLocations[j][0] = xLoc;
                usedLocations[j][1] = yLoc;
                break; 
            }
        }
    }

    public static int[][] placeShipLocations(int x, int y, int direction) {
        int[][] locations = new int[3][2];
        for (int i = 0; i < len; i++) {
            // place in UsedLocations array
            placeInNonEmpty(x, y);
            // place in current shipLocations
            locations[i][0] = x;
            locations[i][1] = y;
            if (direction == 1) {
                // moving location up and down
                y++;
            }
            else {
                // moving location left and right
                x++;
            }
        }
        return locations;
    }

    public static boolean validPlacement(int x, int y, int direction) {

        for (int i = 1; i < len; i++) {
            
            if (direction == 1) {
                // moving location up and down
                y++;
            }
            else {
                // moving location left and right
                x++;
            }
            
            for (int[] loc : usedLocations) {
                // check through each location in usedLocations
                if (loc[0] == x && loc[1] == y) {
                    // moving in that direction is not compatible return false and try again
                    return false;
                }
            }
        }
        // if it makes it through that checking minefield return true.
        return true;
    }

    public static int[][] getUsedLocations() {
        return usedLocations;
    }
}