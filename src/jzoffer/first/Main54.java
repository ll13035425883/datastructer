package jzoffer.first;

import java.util.*;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @author ll
 */
public class Main54 {

    private static List<Character> list;
    /**
     * 只记录没有重复的值
     */
    private static List<Character> list2;
    
    public static void main(String[] args) {
        insert('g');
        insert('o');
        insert('o');
        insert('g');
        insert('l');
        insert('e');
        insert('l');
        insert('l');
        insert('e');
        System.out.println(firstAppearingOnce());
    }

    public static void insert(char ch) {
        if(list == null) {
            list = new ArrayList<>();
            list2 = new ArrayList<>();
        }
        if(list.contains(ch)) {
            Iterator<Character> iterator = list2.iterator();
            while(iterator.hasNext()) {
                if(iterator.next() == ch) {
                    iterator.remove();
                    break;
                }
            }
        } else {
            list.add(ch);
            list2.add(ch);
        }
    }

    public static char firstAppearingOnce() {
        if(list2 == null || list2.size() == 0) {
            return '#';
        }
        return list2.get(0);
    }
}
