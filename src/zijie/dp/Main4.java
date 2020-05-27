package zijie.dp;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1029/
 * @author ll
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for(int i = 1;i < nums.length;i++) {
                if(dp[i - 1] < 0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = nums[i] + dp[i - 1];
                }
            }
            int max = Integer.MIN_VALUE;
            for (int d : dp) {
                if(d > max) {
                    max = d;
                }
            }
            return max;
    }
}
