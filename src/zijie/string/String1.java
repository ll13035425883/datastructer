package zijie.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 * @author ll
 */
public class String1 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        // i： 左边界   j:  右边界
        int maxL = 0, i = 0, j = 0;
        HashSet<Character> characters = new HashSet<>();
        while(i < n && j < n) {
            if(!characters.contains(s.charAt(j))) {
                characters.add(s.charAt(j++));
                maxL = Math.max(maxL, characters.size());
            } else {
                characters.remove(s.charAt(i++));
            }
        }
        return maxL;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int maxL = 1;
        int j;
        List<Character> cList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            cList.add(s.charAt(i));
            for (j = i + 1; j < s.length(); j++) {
                if(cList.contains(s.charAt(j))) {
                    if(j - i > maxL) {
                        maxL = j - i;
                    }
                    break;
                }
                cList.add(s.charAt(j));
            }
            cList.clear();
            if(j == s.length()) {
                if(j - i > maxL) {
                    maxL = j - i;
                    break;
                }
            }
        }
        return maxL;
    }
}
