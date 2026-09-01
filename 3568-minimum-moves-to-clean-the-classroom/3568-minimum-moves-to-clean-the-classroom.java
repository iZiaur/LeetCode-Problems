import java.util.*;

class Solution {
    static class State {
        int r, c, mask, energy, steps;

        State(int r, int c, int mask, int energy, int steps) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.energy = energy;
            this.steps = steps;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litters.add(new int[]{i, j});
                }
            }
        }

        int totalLitter = litters.size();
        if (totalLitter == 0) return 0;

        int targetMask = (1 << totalLitter) - 1;

        int[][] litterIdx = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(litterIdx[i], -1);
        for (int i = 0; i < totalLitter; i++) {
            litterIdx[litters.get(i)[0]][litters.get(i)[1]] = i;
        }

        int[][][] maxEnergy = new int[m][n][1 << totalLitter];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }

        Queue<State> queue = new ArrayDeque<>();
        
        int initialMask = 0;
        queue.offer(new State(startR, startC, initialMask, energy, 0));
        maxEnergy[startR][startC][initialMask] = energy;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            if (curr.mask == targetMask) {
                return curr.steps;
            }

            if (curr.energy == 0 && classroom[curr.r].charAt(curr.c) != 'R') {
                continue;
            }

            for (int[] d : dirs) {
                int nr = curr.r + d[0];
                int nc = curr.c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n || classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int nextEnergy = curr.energy - 1;
                char nextCell = classroom[nr].charAt(nc);

                if (nextCell == 'R') {
                    nextEnergy = energy;
                }

                int nextMask = curr.mask;
                if (nextCell == 'L') {
                    int bit = litterIdx[nr][nc];
                    nextMask |= (1 << bit);
                }

                if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                    maxEnergy[nr][nc][nextMask] = nextEnergy;
                    queue.offer(new State(nr, nc, nextMask, nextEnergy, curr.steps + 1));
                }
            }
        }

        return -1;
    }
}