import java.util.Arrays;
import java.util.Random;

public class ShipLocationTest {
    public static void main(String[] args) {
        int duplicateCount = 0;
        int[][] loc1 = null;
        int[][] loc2 = null;
        int[][] loc3 = null;
        ShipLocations g = new ShipLocations();

        // run test 100 times if there is ever an instance of a duplicate, the test is failed.
        for (int x = 0; x < 100; x++) {
            
            loc1 = g.createLocations();
            loc2 = g.createLocations();
            loc3 = g.createLocations();

            //for (int[] loc : g.getUsedLocations()) {
            //    System.out.println(Arrays.toString(loc));
            //}
            
            int arrayLength = g.getUsedLocations().length;
            for (int i = 0; i < arrayLength - 1; i++) {
                int[] currentPair = g.getUsedLocations()[i];
                for (int j= i + 1; j < arrayLength; j++) {
                    // if there is another array with the same contents then a duplicate is present
                    if (Arrays.equals(g.getUsedLocations()[j], currentPair)) {
                        duplicateCount++;
                        System.out.println(Arrays.toString(currentPair));
                        System.out.println(Arrays.toString(g.getUsedLocations()[j]));
                    }
                }
            }
        }
        if (duplicateCount > 0) {
            System.out.println("fail");
        }
        else {
            System.out.println("pass");
            System.out.println(Arrays.deepToString(loc1));
            System.out.println(Arrays.deepToString(loc2));
            System.out.println(Arrays.deepToString(loc3));
            System.out.println(Arrays.deepToString(g.getUsedLocations()));
        }


    }
}