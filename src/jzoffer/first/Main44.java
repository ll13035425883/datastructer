package jzoffer.first;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，
 * 你能帮助他么？
 * @author ll
 */
public class Main44 {

    public static void main(String[] args) {
        System.out.println(reverseSentence1(" "));
        System.out.println(reverseSentence2("student. a am I"));
    }

    public static String reverseSentence1(String str) {
        if(str == null){
            return null;
        }
        if(str.trim().equals("")){
            return str;
        }
        String target = "";
        List<String> strings = Arrays.asList(str.split(" "));
        Collections.reverse(strings);
        for (int i = 0; i < strings.size(); i++) {
            if(i != strings.size() - 1) {
                target += strings.get(i) + " ";
            } else {
                target += strings.get(i);
            }
        }
        return target;
    }

    public static String reverseSentence2(String str) {
        if(str == null){
            return null;
        }
        if(str.trim().equals("")){
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = str.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            if(i == 0) {
                stringBuilder.append(strings[i]);
            } else {
                stringBuilder.append(strings[i] + " ");
            }
        }
        return stringBuilder.toString();
    }
}
