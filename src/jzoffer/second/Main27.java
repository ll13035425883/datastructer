package jzoffer.second;

import java.util.ArrayList;

/**
 * @Author ll
 * @Date 2020/5/21 22:02
 */
public class Main27 {
    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
     * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static ArrayList<String> permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str == null) {
            return arrayList;
        }
        char[] chars = str.toCharArray();
        permutationHelper(chars, 0, arrayList);
        return arrayList;
    }

    public static void permutationHelper(char[] chars, int begin, ArrayList<String> rs) {
        String c;
        if(begin == chars.length - 1) {
            if(!rs.contains(c = new String(chars))) {
                rs.add(c);
                return;
            }
        }
        for (int i = begin; i < chars.length; i++) {
            swap(chars, begin, i);
            permutationHelper(chars, begin + 1, rs);
            swap(chars, i, begin);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        if(i == j) {
            return;
        }
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
