package leetcode100;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author ll
 * @Date 2020/5/27 22:58
 */
public class SumTwoNums {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
     * 并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(ints[0] + ", " + ints[1]);
    }

    /**
     * 利用hash表，空间换时间
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if(hashMap.containsKey(c) && hashMap.get(c) != i) {
                return new int[]{hashMap.get(c), i};
            }
        }
        return null;
    }
}
