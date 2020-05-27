package jzoffer.first;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 如输入 8   就输出 18
 * @author ll
 */
public class Main67 {

    public static void main(String[] args) {
        System.out.println(cutRope2(8));
    }

    /**
     * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
     * @param target
     * @return
     */
    public static int cutRope(int target) {
        if(target <= 3) {
            return target - 1;
        }
        int a = target / 3;
        int b = target % 3;
        if(b == 0) {
            return (int) Math.pow(3, a);
        } else if(b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        } else {
            return (int) Math.pow(3, a) * 2;
        }
    }

    /**
     * 动态规划
     * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/xu-lie-xing-dong-tai-gui-hua-by-muyids-2/
     * @param target
     * @return
     */
    public static int cutRope2(int target) {
        int[] dp = new int[target + 1];
        // dp[i] 表示 绳子长为 i 的最大乘积
        dp[0] = 1;
        for (int i = 1; i < target; i++) {
            for(int j = i; j <= target; j++) {
                dp[j] = Math.max(dp[j], dp[j - i] * i);
            }
        }
        return dp[target];
    }

}
