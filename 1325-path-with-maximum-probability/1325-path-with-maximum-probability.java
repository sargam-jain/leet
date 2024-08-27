

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Step 1: Build the graph as an adjacency list
        Map<Integer, List<Pair>> graph = new HashMap<>();
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, prob));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, prob));
        }
        
        // Step 2: Use a max-heap to store probabilities
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        
        pq.offer(new Pair(start_node, 1.0));
        
        // Step 3: Dijkstra-like algorithm
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            double prob = current.probability;
            
            if (node == end_node) {
                return prob;
            }
            
            // Explore neighbors
            if (prob < maxProb[node]) {
                continue;  // Skip if we have already found a better way
            }
            
            for (Pair neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                double newProb = prob * neighbor.probability;
                if (newProb > maxProb[neighbor.node]) {
                    maxProb[neighbor.node] = newProb;
                    pq.offer(new Pair(neighbor.node, newProb));
                }
            }
        }
        
        return 0.0; // If we can't reach the end_node
    }
    
    // Helper class to store pairs of (node, probability)
    class Pair {
        int node;
        double probability;
        
        Pair(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }
}
