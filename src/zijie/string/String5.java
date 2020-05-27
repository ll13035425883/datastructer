package zijie.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1011/
 * @author ll
 */
public class String5 {

    public static void main(String[] args) {
        System.out.println(reverseWords2("a sky is blue") );
    }

    public static String reverseWords(String s) {
        String target = "";
        // 是否遍历到不为空的字符
        boolean flag = false;
        // 截取字符串时的右边界
        int right = s.length();
        for (int left = s.length() - 1; left >= 0;) {
            if(!flag) {
                if(s.charAt(left) != ' ') {
                    left--;
                    flag = true;
                    if(left < 0) {
                        target += s.substring(left + 1, right);
                        return target;
                    }
                } else {
                    left--;
                    right--;
                }
            } else {
                if(flag) {
                    if(s.charAt(left) != ' ') {
                        left--;
                        if(left < 0) {
                            target += s.substring(left + 1, right);
                            return target;
                        }
                    } else {
                        target += s.substring(left + 1, right) + " ";
                        right = left + 1;
                        flag = false;
                    }
                }
            }
        }
        return target.length() > 0 ? target.substring(0, target.length() - 1) : target;
    }

    public static String reverseWords2(String s) {
        s = s.trim() + " ";
        ArrayList<String> strings = new ArrayList<>();
        int p = 0;
        String rs = "";
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                // 遍历到新的单词
                if(!flag) {
                    flag = true;
                    p = i;
                }
            } else {
                // 单词结尾
                if(flag) {
                    flag = false;
                    strings.add(s.substring(p, i));
                }
            }
        }
        for (int i = strings.size() - 1; i >= 0; i--) {
            if(i != 0) {
                rs += strings.get(i) + " ";
            } else {
                rs += strings.get(i);
            }
        }
        return rs;
    }
}
