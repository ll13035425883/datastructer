package tree;

import java.util.*;

/**
 *
 腐烂的橘子
 在给定的网格中，每个单元格可以有以下三个值之一：

 值 0 代表空单元格；
 值 1 代表新鲜橘子；
 值 2 代表腐烂的橘子。
 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 https://leetcode-cn.com/problems/rotting-oranges/
 */
public class OrangesRotting {

    // 自己思路
    public static int orangesRotting(int[][] grid) {
        int m = 0;
        for(int k = 0;k < grid.length * grid[0].length; k++){
            int[][] bad = new int[grid.length][grid[0].length];
            int[][] good = new int[grid.length][grid[0].length];
            boolean goodFlag = false;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length;j++) {
                    if(grid[i][j] == 1) {
                        // 好橘子
                        good[i][j] = 1;
                        goodFlag = true;
                    } else if(grid[i][j] == 2) {
                        // 烂橘子
                        bad[i][j] = 1;
                    }
                }
            }
            // 没有好橘子就返回
            if(goodFlag == false)
                return m;
            boolean flag = false;
            for(int i = 0; i < bad.length; i++) {
                for(int j = 0; j < bad[0].length;j++) {
                    if(bad[i][j] == 1) {
                        if(j + 1 < good[0].length && good[i][j + 1] == 1) {
                            flag = true;
                            grid[i][j + 1] = 2;
                        }
                        if(j -1 >= 0 && good[i][j - 1] == 1) {
                            flag = true;
                            grid[i][j - 1] = 2;
                        }
                        if(i + 1 < good.length && good[i + 1][j] == 1) {
                            flag = true;
                            grid[i + 1][j] = 2;
                        }
                        if(i - 1 >= 0 && good[i - 1][j] == 1) {
                            flag = true;
                            grid[i - 1][j] = 2;
                        }
                    }
                }
            }
            if(!flag) {
                // 不能感染好橘子
                if(goodFlag)
                    return -1;
                return m;
            } else {
                m++;
            }
        }
        return m;
    }

    /**
     * 思路： 这种需要一圈一圈往外传播的一般用BFS解， 先找到起始所有腐烂的橘子，然后循环处理，把新腐烂的橘子加入下一次循环的队列中，
     * 当下一次循环的队列为空时，说明不能继续腐烂了， 判断一下还有没有新鲜的橘子，如果有，就返回-1，否则返回分钟数
     * @param grid
     * @return
     */
    public static int BFS(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int cnt1 = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * n + j); // 将腐烂的橘子入队
                } else if (grid[i][j] == 1) {
                    cnt1++; // 统计新鲜橘子的数量
                }
            }
        }

        int time = 0;
        while (!queue.isEmpty() && cnt1 > 0) { // 当队列空了 或者 没有新鲜橘子了，停止循环
            time++; // 一层一层的传染，每传染一层，时间+1
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int p = queue.poll();
                int x = p / n, y = p % n;
                if (x - 1 >= 0 && grid[x - 1][y] == 1) { // 上
                    cnt1--; // 每传染一个，更新新鲜橘子的数量
                    grid[x - 1][y] = 2;
                    queue.offer((x - 1) * n + y);
                }
                if (x + 1 < m && grid[x + 1][y] == 1) { // 下
                    cnt1--;
                    grid[x + 1][y] = 2;
                    queue.offer((x + 1) * n + y);
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) { // 左
                    cnt1--;
                    grid[x][y - 1] = 2;
                    queue.offer(x * n + y - 1);
                }
                if (y + 1 < n && grid[x][y + 1] == 1) { // 右
                    cnt1--;
                    grid[x][y + 1] = 2;
                    queue.offer(x * n + y + 1);
                }
            }
        }

        return cnt1 == 0? time: -1;
    }

    public static int[][] findContinuousSequence(int target) {
        int count = target/2 + 1;
        List<int[]> result = new ArrayList<>();
        for(int i = 1; i <= count;i++) {
            int sum = 0;
            for(int j = i; j <= count;j++) {
                sum += j;
                if(sum == target) {
                    int k = 0, n = i;
                    int[] array = new int[j - n + 1];
                    while(n <= j) {
                        array[k++] = n;
                        n++;
                    }
                    result.add(array);
                }
                if(sum > target)
                    break;
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
//        int[][] grid = new int[][]{{0,2}};
//        int[][] grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        int[][] continuousSequence = findContinuousSequence(9);
        System.out.println(BFS(grid));
    }
}
