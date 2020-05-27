package jzoffer.second;

/**
 * @Author ll
 * @Date 2020/4/29 10:39
 */
public class Main12 {
    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     * @param args
     */
    public static void main(String[] args) {

    }

    public static double power(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        if(base == 0) {
            return base;
        }
        double target = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            target *= base;
        }
        if(exponent > 0) {
            return target;
        } else {
            return 1.0 / target;
        }
    }

}
