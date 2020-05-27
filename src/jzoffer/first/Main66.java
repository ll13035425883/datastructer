package jzoffer.first;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author ll
 */
public class Main66 {
    private static int count = 0;
    public static void main(String[] args) {
        System.out.println(numsCount(35, 37));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        movingCountHelper(threshold, rows, cols, 0, 0, flag);
        return count;
    }

    public static void movingCountHelper(int threshold, int rows, int cols, int i, int j, boolean[][] flag) {
        if(i == rows || j == cols || i < 0 || j < 0 || numsCount(i, j) > threshold || flag[i][j]) {
            return;
        }
        flag[i][j] = true;
        count++;
        movingCountHelper(threshold, rows, cols, i + 1, j, flag);
        movingCountHelper(threshold, rows, cols, i - 1, j, flag);
        movingCountHelper(threshold, rows, cols, i, j + 1, flag);
        movingCountHelper(threshold, rows, cols, i, j - 1, flag);
    }

    /**
     * 计算数位之和
     * @param i
     * @param j
     * @return
     */
    public static int numsCount(int i, int j) {
        int numsI = 0, numsJ = 0;
        while(i != 0) {
            numsI += i % 10;
            i /= 10;
        }
        while(j != 0) {
            numsI += j % 10;
            j /= 10;
        }
        return numsI + numsJ;
    }
}
