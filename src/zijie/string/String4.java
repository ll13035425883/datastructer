package zijie.string;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

/**
 * 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1015/
 * @author ll
 */
public class String4 {
    public static void main(String[] args) {
        System.out.println(multiply("1", "1"));
    }

    public static String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        return multiplyHelper(num2, num1);
    }

    public static String multiplyHelper(String num1, String num2) {
        String rs = "0";
        int t;
        for (int j = num2.length() - 1; j >= 0; j--) {
            StringBuffer buffer = new StringBuffer();
            t = 0;
            for(int k = 0;k < num2.length() - j - 1;k++) {
                buffer.append(0);
            }
            for (int i = num1.length() - 1; i >= 0; i--) {
                int rs1 = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + t;
                int m = rs1 % 10;
                t = rs1 / 10;
                buffer.append(m);
                if(i == 0 && t > 0) {
                    buffer.append(t);
                }
            }
            // 累加
            rs = addHelper(rs, buffer.reverse().toString());
        }
        return rs;
    }

    /**
     * 字符串相加
     * @param rs1
     * @param rs2
     * @return
     */
    public static String addHelper(String rs1, String rs2) {
        int t = 0, p, m;
        StringBuffer rs = new StringBuffer();
        int n1 = rs1.length() - 1;
        int n2 = rs2.length() - 1;
        while(n1 >= 0 && n2 >= 0) {
            m = (rs1.charAt(n1) - '0') + (rs2.charAt(n2) - '0') + t;
            p = m % 10;
            rs.append(p);
            t = m / 10;
            n1--;
            n2--;
        }
        while(n2 >= 0) {
            m = (rs2.charAt(n2) - '0') + t;
            p = m % 10;
            rs.append(p);
            t = m / 10;
            n2--;
        }
        while(n1 >= 0) {
            m = (rs1.charAt(n1) - '0') + t;
            p = m % 10;
            rs.append(p);
            t = m / 10;
            n1--;
        }
        if(t > 0) {
            rs.append(t);
        }
        return rs.reverse().toString();
    }
}
