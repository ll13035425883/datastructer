package zijie.string;

import jdk.nashorn.internal.ir.CallNode;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 字符串的排列
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1016/
 * @author ll
 */
public class String3 {
    private static boolean a;
    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }

    /**
     * 滑动窗口思想
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 > n2) {
            return false;
        }
        int[] num1 = new int[26];
        int[] num2 = new int[26];
        for (int i = 0; i < n1; i++) {
            num1[s1.charAt(i) - 'a']++;
            num2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0, j = n1; j < n2;) {
            if(isSame(num1, num2)) {
                return true;
            } else {
                // 窗口滑动: i 左边界  j 右边界
                num2[s2.charAt(i++) - 'a']--;
                num2[s2.charAt(j++) - 'a']++;
            }
        }
        return isSame(num1, num2);
    }

    public static boolean isSame(int[] num1, int[] num2) {
        for (int i = 0; i < num1.length; i++) {
            if(num1[i] != num2[i]) {
                return false;
            }
        }
        return true;
    }
}
