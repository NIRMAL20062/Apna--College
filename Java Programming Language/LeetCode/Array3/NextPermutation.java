import java.util.Arrays;

class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int infpt = -1;

        // get inflection point (first dip from the end) so traversing from end
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                infpt = i;
                break;
            }
        }

        // If no inflection point found, array is in descending order → sort it
        if (infpt == -1) {
            Arrays.sort(nums);
            return;
        }

        // get the just greater number from the end to swap with infpt
        for (int i = n - 1; i > infpt; i--) {
            if (nums[i] > nums[infpt]) {
                // Swap
                int temp = nums[i];
                nums[i] = nums[infpt];
                nums[infpt] = temp;
                break;
            }
        }

        // Reversing the subarray from infpt+1 to end
        int left = infpt + 1;
        int right = n - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 6, 5, 4};
        System.out.println("Before: " + Arrays.toString(list));
        nextPermutation(list);
        System.out.println("After: " + Arrays.toString(list));
    }
}
