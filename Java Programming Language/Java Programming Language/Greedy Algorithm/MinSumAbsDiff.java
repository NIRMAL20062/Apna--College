import java.util.Arrays;

public class MinSumAbsDiff {

    public static int minAbsSum(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += Math.abs(A[i] - B[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {2, 1, 3};

        int result = minAbsSum(A, B);
        System.out.println("Minimum sum of absolute differences = " + result);
    }
}
