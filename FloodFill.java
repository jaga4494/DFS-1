class Solution {
    int[][] dirs;

    // DFS
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }

        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //UDLR

        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int oldColor, int color) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor) {
            return;
        }
        image[row][col] = color;

        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(image, nr, nc, oldColor, color);
                
        }

    }


    public int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }

        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //UDLR

        int oldColor = image[sr][sc];
        image[sr][sc] = color;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {sr, sc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] dir : dirs) {
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];

                if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == oldColor) {
                    image[nr][nc] = color;
                    q.add(new int[] {nr, nc});
                }
            }

        }

        return image;
    }
}