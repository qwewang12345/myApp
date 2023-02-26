package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/8/11 9:23
 **/
public class Struct693 {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int res = maxAreaOfIsland(grid);
        System.out.println(res);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int maxCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    maxCount = Math.max(dfs(grid, i, j), maxCount);
                }
            }
        }
        return maxCount;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return 0;
        }
        if (j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 1) {
            int ans = 1;
            grid[i][j] = 0;
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : dirs) {
                ans += dfs(grid, i + dir[0], j + dir[1]);
            }
            return ans;
        }
        return 0;
    }

}
