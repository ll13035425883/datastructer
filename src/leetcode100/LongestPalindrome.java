package leetcode100;

/**
 * 最长回文子串
 *
 * @Author ll
 * @Date 2020/5/28 22:46
 */
public class LongestPalindrome {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        }
        String rs = "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if(dp[i][j] && j - i + 1 > rs.length()) {
                    rs = s.substring(i, j + 1);
                }
            }
        }
        return rs;
    }

}
