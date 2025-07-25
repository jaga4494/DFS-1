class Solution {
    // BFS
    public int[][] updateMatrix1(int[][] mat) {
        
        // Using size variable is more intuitive.  So that we can assign the level as the distance
        // But can also be solved without using size variable. Add one to the elements's value from where it is discovered and that will be the new element's value. like kind of finding distance. For the first level nodes, it will be 0 + 1. then for second level, it will be 1 + 1 then 2 + 1 and so no..

        if (mat == null || mat.length == 0) {
            return mat;
        }

        int[][] dirs = {{-1, 0}, {1,0}, {0, -1}, {0, 1}}; //UDLR
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }

        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; ++i) {
                int[] cur = q.poll();

                for (int[] dir : dirs) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == 1) {
                        mat[nr][nc] = -(level + 1);
                        q.add(new int[] {nr, nc});
                    }
                }

            }
            level++;
        }

        // Another way is to change the input matrix all 1st to -1 at the start and add it to the queue inside while
        // only if the value is -1 (original). 
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] < 0) {
                    mat[i][j] = -mat[i][j];
                }
            }
        }

        return mat;
    }

    
}