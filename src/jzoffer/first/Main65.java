package jzoffer.first;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向
 * 下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *
 * https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11218&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author ll
 */
public class Main65 {
    private static boolean[][] flag;
    public static void main(String[] args) {
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "BCCED".toCharArray();
        System.out.println(hasPath(matrix, 3, 4, str));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for (int i = 0; i < rows; i++) {
            for(int j = 0;j < cols;j++) {
                flag = new boolean[rows][cols];
                if(dfs(matrix, rows, cols, i, j, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param i
     * @param j
     * @param str
     * @param index str下标
     * @return
     */
    public static boolean dfs(char[] matrix, int rows, int cols, int i, int j, char[] str, int index) {
        if(index == str.length) {
            return true;
        }
        if( i == rows || j == cols || i < 0 || j < 0 || flag[i][j] ||
                str[index] != matrix[i * cols + j]) {
            return false;
        }
        flag[i][j] = true;
        index++;
        return dfs(matrix, rows, cols, i + 1, j, str, index) ||
                dfs(matrix, rows, cols, i, j + 1, str, index) ||
                dfs(matrix, rows, cols, i - 1, j, str, index) ||
                dfs(matrix, rows, cols, i, j - 1, str, index);
    }
}
