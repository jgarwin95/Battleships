import java.util.Arrays;

public class SimpleDotComTest {
    public static void main(String[] args) {

        Ship[] ships = new Ship[2];

        for (int i = 0; i < ships.length; i++) {
            ships[i] = new Ship();
            int[][] locations = ShipLocations.createLocations();
            System.out.println(Arrays.deepToString(locations));
            ships[i].setLocationCells(locations);
            System.out.println(Arrays.deepToString(ships[i].getLocationCells()));
        }

        for (int i = 0; i < ships.length; i++) {
            System.out.println(Arrays.deepToString(ships[i].getLocationCells()));
        }
        System.out.println(Arrays.deepToString(ShipLocations.getUsedLocations()));

        System.out.println(ships[0] == ships[1]);
        
    }
}