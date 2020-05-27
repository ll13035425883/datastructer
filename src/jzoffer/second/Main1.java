package jzoffer.second;

/**
 * @Author ll
 * @Date 2020/4/28 21:52
 */
public class Main1 {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
     * 个整数，判断数组中是否含有该整数。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static boolean find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j] == target) {
                    return true;
                } else if(array[i][j] > target) {
                    break;
                }
            }
        }
        return false;
    }

}
