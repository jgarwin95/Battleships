import java.util.Arrays;

public class ShipLocationsTest3 {
    public static void main(String[] args) {
        ShipLocations shipLocations = new ShipLocations();
        int[][] loc = shipLocations.createLocations();

        for (int[] i : shipLocations.getUsedLocations()) {
            System.out.println(Arrays.toString(i));
        }
        for (int[] i : loc) {
            System.out.println(Arrays.toString(i));
        }
    }
}