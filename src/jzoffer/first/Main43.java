package jzoffer.first;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串
 * 模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输
 * 出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 * @author ll
 */
public class Main43 {

    public static void main(String[] args) {
        System.out.println(leftRotateString("", 6));
    }

    public static String leftRotateString(String str, int n) {
        if(str.length() == 0) {
            return "";
        }
        if(n == 0 || n % str.length() == 0) {
            return str;
        }
        int len = str.length();
        n = n % len;
        return str.substring(n, len) + str.substring(0, n);
    }
}
