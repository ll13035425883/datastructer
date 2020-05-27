package zijie.sort;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;

/**
 * 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1021/
 * @author ll
 */
public class Main7 {
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }

    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // 保存 1 ~ n 的字符
        List<Character> nums = new ArrayList<>();
        for(int i = 1; i <= n;i++){
            nums.add((char)(i+48));
        }
        int f = 0;
        int index = 0;
        // 将题目的人类习惯计数改为list内部下标计数
        k--;
        for (int j = 1; j < n; j++) {
            // 固定一位数有多少种排列组合
            f = fac(n - j);
            // 找到第一位数字的下标
            index = k / f;
            k = k % f;
            // 将这一位“数字”加进来后从list内部删除该“数字”
            sb.append(nums.get(index));
            nums.remove(index);
            // 如果此时不再有相对偏移量，退出循环
            if(k == 0) {
                break;
            }
        }
        while(nums.size() > 0) {
            sb.append(nums.get(0));
            nums.remove(0);
        }
        return sb.toString();
    }

    public static int fac(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return fac(n - 1) * n;
    }

}
