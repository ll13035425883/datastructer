package jzoffer.second;

/**
 * @Author ll
 * @Date 2020/4/28 23:07
 */
public class Main9 {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * f(1)=1表示跳1级台阶的跳法数量;
     * f(2)=2表示跳2级台阶的跳法数量;
     * f(3)=f(2)+f(1)+1  我们可以递推出  f(n)=f(n-1)+f(n-2)+ *** +f(1)+1 ,
     * 而f(n-1)=f(n-2)+ *** +f(1)+1。
     * 将两式想减可以求出递推公式，也即是 f(n)-f(n-1)=f(n-1)，即f(n)=2*f(n-1);
     * 所以自底向上的动态规划方法浮出眼前。
     * @param target
     * @return
     */
    public static int jumpFloorII(int target) {
        if(target == 0 || target == 1) {
            return 1;
        }
        return 2 * jumpFloorII(target - 1);
    }

    public static int jumpFloorII2(int target) {
        if(target == 0 || target == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= target; i++) {
            sum += jumpFloorII(i);
        }
        return sum;
    }
}
