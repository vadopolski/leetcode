package golmansacs.minimumpathsum;

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return backtrack(grid, 0, 0, memo);
    }

    private int backtrack(int[][] grid, int x, int y, int[][] memo) {
        System.out.println("x:" + x + " y:" + y);
        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        }

        int min = Integer.MAX_VALUE;
        if (x < grid.length - 1) {
            min = Math.min(backtrack(grid, x + 1, y, memo), min);
        }
        if (y < grid[0].length - 1) {
            min = Math.min(backtrack(grid, x, y + 1, memo), min);
        }
        min += grid[x][y];
        memo[x][y] = min;
        return min;
    }


    public static void main(String[] args) {
        int [][] arr = {{1,3,1}, {1,5,1}, {4,2,1}};

        Solution sol = new Solution();

        System.out.println(sol.minPathSum(arr));
    }
}