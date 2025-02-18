package codility;

import java.util.*;

/*

Time - O(nlogn)
Space - O(n)

 */

public class MaxChunksToSortArray {

    public static int maxNumberOfChunks(int[] nums) {
        int count = 0, copySum = 0, sum = 0;
        int[] copyArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyArr);
        for (int i = 0; i < nums.length; i++) {
            copySum += copyArr[i];
            sum += nums[i];
            if (copySum == sum) ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfChunks(new int[]{2, 4, 1, 6, 5, 9, 7}));
    }
} 
  
 
