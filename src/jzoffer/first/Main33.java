package jzoffer.first;

/**
 * 丑数
 * @author ll
 */
public class Main33 {

    public static int getUglyNumberSolution(int index) {
        if(index < 7) {
            return index;
        }
        int[] res = new int[index];
        res[0] = 1;
        int res2 = 0, res3 = 0, res5 = 0;
        for(int i = 1;i < index;i++) {
            res[i] = Math.min(Math.min(res[res2] * 2, res[res3] * 3), res[res5] * 5);
            if(res[i] == res[res2] * 2) {
                res2++;
            }
            if(res[i] == res[res3] * 3) {
                res3++;
            }
            if(res[i] == res[res5] * 5) {
                res5++;
            }
        }
        return res[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumberSolution(7));
    }

}
