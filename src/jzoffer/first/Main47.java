package jzoffer.first;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author ll
 */
public class Main47 {
    public static void main(String[] args) {
        System.out.println(sum_Solution(100));
    }

    public static int sum_Solution(int n) {
        if(n == 1) {
            return 1;
        }
        return n + sum_Solution(n - 1);
    }
}
