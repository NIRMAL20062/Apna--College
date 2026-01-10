package Hashing;

import java.util.HashMap;

class LongestSubarraySumZero {

    public static void main(String[] args) {

        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        HashMap<Integer, Integer> map = new HashMap<>();
        // (prefixSum, firstIndex)

        int sum = 0;
        int len = 0;

        for (int j = 0; j < arr.length; j++) {

            sum += arr[j];

            // Case 1: sum itself becomes 0
            if (sum == 0) {
                len = j + 1;
            }

            // Case 2: sum already seen before
            if (map.containsKey(sum)) {
                len = Math.max(len, j - map.get(sum));
            }
            // Case 3: first time seeing this sum
            else {
                map.put(sum, j);
            }
        }

        System.out.println("Longest subarray with sum 0 = " + len);
    }
}
