// Given a non-empty array of integers, every element appears twice except for one. Find that single one.
// Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra

import java.util.*;
public class SingleNumber {
	public static int singleNumber(int[] nums) {
		int result = 0; 
		for (int num : nums) { 
			result ^= num; 
		}
		return result;
	}


	
		public static int singleNumberx(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i += 2) {
		    if (nums[i] != nums[i + 1]) {
			   return nums[i];
		    }
		}
		return nums[nums.length - 1]; // if single is last elemen
		}

		public static void main(String[] args) {
			int[] list = {9,4,3,5,4,3,5};
			int x= singleNumber(list);
			int y =singleNumberx(list);
			System.out.println(x);
			System.out.println(y);
		}
}
			
	
// 1 if the bits are different 
// 0 if the bits are same 
// a ^ a = 0 
// 0 ^ b = b
// result = 0 ^ 4 ^ 1 ^ 2 ^ 1 ^ 2 
//        = (((0 ^ 4) ^ 1) ^ 2) ^ 1 ^ 2 
//        = 4 ^ 1 = 5 
//    = 5 ^ 2 = 7 
//    = 7 ^ 1 = 6 
//    = 6 ^ 2 = 4