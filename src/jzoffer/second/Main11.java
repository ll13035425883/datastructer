package jzoffer.second;

/**
 * @Author ll
 * @Date 2020/4/29 10:30
 */
public class Main11 {
    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static int numberOf1(int n) {
        int count = 0;
        for(int i = 0;i < 32;i++) {
            if(((n >>> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
