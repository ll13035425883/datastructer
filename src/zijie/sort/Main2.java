package zijie.sort;

/**
 * 岛屿的最大面积
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1034/
 * @author ll
 */
public class Main2 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                                     {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                     {0,1,1,0,1,0,0,0,0,0,0,0,0},
                                     {0,1,0,0,1,1,0,0,1,0,1,0,0},
                                     {0,1,0,0,1,1,0,0,1,1,1,0,0},
                                     {0,0,0,0,0,0,0,0,0,0,1,0,0},
                                     {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                     {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIslandHelper(int i, int j, int[][] grid, boolean[][] flag) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || flag[i][j]) {
            return 0;
        }
        flag[i][j] = true;
        return  maxAreaOfIslandHelper(i + 1, j, grid, flag)
                + maxAreaOfIslandHelper(i - 1, j, grid, flag)
                + maxAreaOfIslandHelper(i, j + 1, grid, flag)
                + maxAreaOfIslandHelper(i, j - 1, grid, flag) + 1;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !flag[i][j]) {
                    maxArea = Math.max(maxArea, maxAreaOfIslandHelper(i, j, grid, flag));
                }
            }
        }
        return maxArea;
    }

}
