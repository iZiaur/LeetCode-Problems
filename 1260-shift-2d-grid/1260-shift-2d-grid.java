import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k = k % total;
        
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            sol.add(row);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int oldIdx = i * n + j;
                int newIdx = (oldIdx + k) % total;
                int newRow = newIdx / n;
                int newCol = newIdx % n;
                sol.get(newRow).set(newCol, grid[i][j]);
            }
        }
        
        return sol;
    }
}