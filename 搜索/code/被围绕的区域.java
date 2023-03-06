class Solution {
    int m;
    int n;
    char[][] board;
    int [][] visit; // 为0表示没有被访问，为1表示被访问，为2表示被着色，只对'O'有效
    int [][]direction = new int [][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        visit = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 0 && board[i][j] == 'O') {
                    if (dfs(i, j)) draw(i, j);
                }
            }
        }
    }

    public boolean dfs(int x, int y) {
        // 碰到墙，我们返回false。所以只要在一次dfs中返回false，证明没有被包围
        if(ifOut(x, y)) return false;
        // 碰到其他已经访问的O的或者X我们返回true
        if (visit[x][y] != 0 || board[x][y] == 'X') return true;
        visit[x][y] = 1;
        boolean ans = true;
        for (int[] dir : direction) {
            x += dir[0];
            y += dir[1];
            ans &= dfs(x, y);
            y -= dir[1];
            x -= dir[0];
        }

        return ans;
    }

    public void draw(int x, int y) {
        if (visit[x][y] == 2 || board[x][y] == 'X') return;
        visit[x][y] = 2;
        board[x][y] = 'X';
        for (int[] dir : direction) {
            x += dir[0];
            y += dir[1];
            draw(x, y);
            y -= dir[1];
            x -= dir[0];
        }
    }



    public boolean ifOut(int x, int y) {
        return x < 0 || y < 0 || x >= m || y >= n;
    }

}