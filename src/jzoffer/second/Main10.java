package jzoffer.second;

/**
 * @Author ll
 * @Date 2020/4/29 10:21
 */
public class Main10 {
    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖
     * 一个2*n的大矩形，总共有多少种方法？
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 第一步如果选择竖方向填充，那么该问题的规模就缩减为对于剩余的2×（number-1）的大矩形的填充。
     * 如果，第一步如果选择横方向的填充，则第二排的前面两个小矩形也只能如此填充，那么该问题的规模就
     * 缩减为对于剩余的2×（number-2）的大矩形的填充.
     * 结合上述分析，很容易得到递推的关系： 
     * rectCover(number)=rectCover(number-1)+rectCover(number-2)。
     * 当然此处也要注意递归跳出条件的判定。
     * @param target
     * @return
     */
    public static int rectCover(int target) {
        if(target <= 0) {
            return 0;
        }
        if(target == 1 || target == 2) {
            return target;
        }
        return rectCover(target - 1) + rectCover(target - 2);
    }

}
