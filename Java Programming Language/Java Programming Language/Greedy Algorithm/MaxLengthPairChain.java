import java.util.Arrays;

public class MaxLengthPairChain {

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1])); // Sort by second element

        int chainLength = 1;
        int lastEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastEnd) {
                chainLength++;
                lastEnd = pairs[i][1];
            }
        }

        return chainLength;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        int result = findLongestChain(pairs);
        System.out.println("Maximum length of chain: " + result);
    }
}