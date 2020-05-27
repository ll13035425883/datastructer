package jzoffer.second;

/**
 * @Author ll
 * @Date 2020/4/28 23:01
 */
public class Main7 {
    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项
     * （从0开始，第0项为0，第1项是1）。
     * n<=39
     * @param args
     */
    public static void main(String[] args) {

    }

    public static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
