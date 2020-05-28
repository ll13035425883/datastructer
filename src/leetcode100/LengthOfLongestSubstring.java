package leetcode100;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 *
 * @Author ll
 * @Date 2020/5/27 23:31
 */
public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param args
     */
    public static void main(String[] args) {
        int len = lengthOfLongestSubstring("pwwkew");
        System.out.println(len);
    }

    /**
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null) {
            return 0;
        }
        int max = 0;
        int left = 0, right = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < s.length();) {
            if(!hashSet.contains(s.charAt(i))) {
                hashSet.add(s.charAt(i++));
                right++;
                max = Math.max(max, right - left);
            } else {
                hashSet.remove(s.charAt(left++));
            }
        }
        return max;
    }
}
