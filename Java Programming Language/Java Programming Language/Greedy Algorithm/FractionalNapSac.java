 import java.util.Arrays;
import java.util.Comparator;

public class FractionalNapSac {

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;  // Total capacity of the knapsack

        // Creating ratio array: [index][value/weight]
        double[][] ratio = new double[val.length][2];

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // Sort by value/weight ratio in ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        double finalVal = 0;

        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];

            if (capacity >= weight[idx]) {  // Include full item
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                // Include fractional item
                finalVal += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println("Final value = " + finalVal);
    }
}
