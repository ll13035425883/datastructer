package jzoffer.second;

/**
 * @Author ll
 * @Date 2020/4/28 23:05
 */
public class Main8 {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     * （先后次序不同算不同的结果）。
     */
    public static void main(String[] args) {

    }

    public static int jumpFloor(int target) {
        if(target == 0 || target == 1) {
            return 1;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}
