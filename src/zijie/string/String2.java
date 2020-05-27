package zijie.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 最长公共前缀
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1014/
 * @author ll
 */
public class String2 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    /**
     * 暴力破解
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String common = "";
        int i = 0;
        while(i < strs[0].length()) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i < strs[j].length() && strs[j].charAt(i) == c) {
                    continue;
                } else {
                    return common;
                }
            }
            common += c;
            i++;
        }
        return common;
    }

    /**
     * 运用startWith方法
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String common = strs[0];
        for (String str : strs) {
            // 不以 common 为前缀
            while(!str.startsWith(common)) {
                if(common.length() == 1) {
                    return "";
                }
                // 从后向前删除字符
                common = common.substring(0, common.length() - 1);
            }
        }
        return common;
    }
}
