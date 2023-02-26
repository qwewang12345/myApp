package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/8/18 21:07
 **/
public class Struct79 {

    private static boolean flag = false;

    public static void main(String[] args) {
        char[][] board = {{'A','B','C', 'E'},{'S','F','C','S'},{'A','D','E','E'}};
        exist(board, "SEE");
        System.out.println(1);
    }

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, visited, i, j, "", word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, boolean[][] visited, int i, int j, String path, String word) {
        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i > row - 1) {
            return false;
        }
        if (j < 0 || j > col - 1) {
            return false;
        }
        // 已经访问过 或者 当前访问的不等于word对应位置的元素
        if (visited[i][j] || board[i][j] != word.charAt(path.length())) {
            return false;
        }
        visited[i][j] = true;
        path = path + board[i][j];
        if (path.length() == word.length()) {
            return true;
        }
        int[][] forwards = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] forward : forwards) {
            if (dfs(board, visited, i + forward[0], j + forward[1], path, word)) {
                return true;
            }
        }
        return false;
    }
}
