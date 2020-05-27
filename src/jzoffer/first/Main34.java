package jzoffer.first;

import java.util.*;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 * @author ll
 */
public class Main34 {

    public int firstNotRepeatingChar(String str) {
        if(str == null || "".equals(str)) {
            return -1;
        }
        Map<Character, Integer> hashMap = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(hashMap.get(chars[i]) == null) {
                hashMap.put(chars[i], i);
            } else {
                hashMap.put(chars[i], -1);
            }
        }
        for (char aChar : chars) {
            if(hashMap.get(aChar) != -1) {
                return hashMap.get(aChar);
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        Main34 main34 = new Main34();
        System.out.println(main34.firstNotRepeatingChar("google"));;
    }

}
