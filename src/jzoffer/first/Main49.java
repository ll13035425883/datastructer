package jzoffer.first;

import com.sun.org.apache.xerces.internal.impl.dv.XSSimpleType;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author ll
 */
public class Main49 {
    public static void main(String[] args) { ;
        System.out.println(strToInt("-2147483649"));
    }

    /**
     * 输入： +2147483647
     *       1a33
     * 输出： 2147483647
     *       0
     * @param str
     * @return
     */
    public static int strToInt(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        // flag: true 正, false 负
        boolean flag = true;
        int sum = 0, m = 10, i = 0;
        if(str.charAt(0) == '-') {
            flag = false;
            i++;
        } else if(str.charAt(0) == '+') {
            i++;
        }
        for(;i < str.length();i++) {
            switch (str.charAt(i)) {
                case '0': sum = sum * m + 0; break;
                case '1': sum = sum * m + 1; break;
                case '2': sum = sum * m + 2; break;
                case '3': sum = sum * m + 3; break;
                case '4': sum = sum * m + 4; break;
                case '5': sum = sum * m + 5; break;
                case '6': sum = sum * m + 6; break;
                case '7': sum = sum * m + 7; break;
                case '8': sum = sum * m + 8; break;
                case '9': sum = sum * m + 9; break;
                default: return 0;
            }
            if(sum < 0) {
                if(sum == -2147483648 && flag == false) {
                    return -2147483648;
                } else {
                    return 0;
                }
            }
        }
        if(flag == false) {
            return -sum;
        }
        return sum;
    }
}
