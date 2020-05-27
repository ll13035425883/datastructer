package zijie.sort;

import java.util.HashSet;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1019/
 * @author ll
 */
public class Main6 {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int maxStreak = 0;
        for (Integer num : hashSet) {
            if(!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while(hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                maxStreak = Math.max(currentStreak, maxStreak);
            }
        }
        return maxStreak;
    }
}
