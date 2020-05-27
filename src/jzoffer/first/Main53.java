package jzoffer.first;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author ll
 */
public class Main53 {

    public static void main(String[] args) {
        System.out.println(isNumeric("12e+5.4".toCharArray()));
    }

    public static boolean isNumeric(char[] str) {
        if(str == null || str.length == 0) {
            return false;
        }
        int i = 0;
        // 小数点
        boolean pointShow = false;
        // e or E
        boolean eShow = false;
        // +、-
        boolean sShow = false;
        // 数字
        boolean numShow = false;
        // 判断首位字符是不是+或者-
        if(str[i] == '+' || str[i] == '-') {
            i++;
            if(i == str.length) {
                return false;
            }
        }
        while(i < str.length) {
            if(str[i] <= '9' && str[i] >= '0') {
                numShow = true;
                i++;
            } else if(str[i] == 'e' || str[i] == 'E') {
                // e如果之前出现过一次或者数字没出现
                if(eShow || !numShow) {
                    return false;
                } else {
                    eShow = true;
                    // e前面字符必须为数字且e不能为最后一个字符
                    if(i + 1 < str.length && str[i - 1] <= '9' && str[i - 1] >= '0') {
                        i++;
                    } else {
                        return false;
                    }
                }
            } else if(str[i] == '+' || str[i] == '-') {
                if(sShow || !eShow) {
                    return false;
                } else {
                    // +、-只能出现在e的后面
                    if(str[i - 1] != 'e' && str[i - 1] != 'E') {
                        return false;
                    }
                    sShow = true;
                    i++;
                }
            } else if(str[i] == '.') {
                // 小数点只能在e之前出现，且只能出现一次
                if(pointShow || eShow) {
                    return false;
                } else {
                    // 小数点不能为最后一位
                    if(i + 1 < str.length) {
                        i++;
                    } else {
                        return false;
                    }
                    pointShow = true;
                    i++;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
