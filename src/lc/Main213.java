package lc;

/**
 * 打家劫舍2
 * https://leetcode-cn.com/problems/house-robber-ii/
 * @author ll
 */
public class Main213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 7, 9, 2}));
    }

    /**
     * 第一次对0 -> n-1的元素动态规划
     * 二次对1 -> n的元素动态规划
     * 比较两次动态规划中的最大值
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[0];
        }
        if(n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int max = dp[n - 2];
        dp[1] = nums[1];
        dp[2] = Math.max(dp[1], nums[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        max = Math.max(max, dp[n - 1]);
        return max;
    }
}
