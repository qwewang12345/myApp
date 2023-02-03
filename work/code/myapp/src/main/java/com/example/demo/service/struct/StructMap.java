package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/8/10 21:57
 **/
public class StructMap {

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'O', 'X', 'X', 'X'}};
        solve(board);
        System.out.println(board);
    }

    public static void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) {
            return;
        }
        // 竖向边界列
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        // 横向边界行
        for (int j = 1; j < board[0].length -1; j++) {
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return;
        }
        if (j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 'O') {
            grid[i][j] = '*';
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : dirs) {
                dfs(grid, i + dir[0], j + dir[1]);
            }
        }
    }
}

