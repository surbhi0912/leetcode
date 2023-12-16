class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] edges = new int[n * (n - 1) / 2][3]; // Edges array: [point1, point2, distance]

        // Step 1: Calculate Manhattan distance for all pairs of points
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges[idx++] = new int[]{i, j, distance};
            }
        }

        // Step 2: Sort the edges based on their weights (Manhattan distances)
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        // Step 3: Use Kruskal's algorithm to find the minimum spanning tree
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int cost = 0;
        int edgeCount = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if (rootU != rootV) {
                // Union operation
                parent[rootU] = rootV;
                cost += edge[2];
                edgeCount++;

                if (edgeCount == n - 1) {
                    break; // Found the minimum spanning tree
                }
            }
        }

        return cost;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }
}