public class BattleShipsGame {
    public static void main(String[] args) {
        int numGuesses = 0;
        int killCount = 0;
        // create ships array of length 3
        Ship[] ships = new Ship[3];
        
        // initializing each ship, create locations, and set locations
        for (int i = 0; i < ships.length; i++) {
            // create ship of length 3
            ships[i] = new Ship();
            ships[i].setLocationCells(ShipLocations.createLocations());
        }
        
        // while ships still remain on the board NOTE: NEED TO FIND A WAY TO DECREASE NUMBER OF SHIPS 
        while (killCount < 3) {
            String guess = GameHelper.getUserInput("Enter numbers: x,y");
           
            if (guess.equals("q")) break;

            String[] coords = guess.split(",");
            // create int arry 
            int[] intCoords = new int[coords.length];
            // for each string in string array conver to int and place in int array
            for (int i = 0; i < intCoords.length; i++) {
                // convert to int
                intCoords[i] = Integer.parseInt(coords[i]);
            }
            // check each ship against the guess
            String result = "miss";
            for (Ship ship : ships) {
                result = ship.check(intCoords);
                // if hit or killed break out of loop
                if (result == "hit") break;
                if (result == "kill") {
                    killCount++;
                    break;
                }
            }
            numGuesses++;
            // print the last assignment of result
            System.out.println(result);
        }
        System.out.println("You took " + numGuesses + " guesses.");

    }
}