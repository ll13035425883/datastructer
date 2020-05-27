package zijie.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1035/
 * @author ll
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int maxL = 0;
        dp[0] = 1;
        for(int i = 1;i < nums.length;i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
        }
        for (int m : dp) {
            if(m > maxL) {
                maxL = m;
            }
        }
        return maxL;
    }
}
