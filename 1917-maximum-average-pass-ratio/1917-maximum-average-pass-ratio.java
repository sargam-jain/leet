

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to maximize the incremental gain
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(b[0], a[0])
        );

        // Populate the priority queue with initial gain for each class
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            pq.offer(new double[] { gain(pass, total), pass, total });
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1], total = (int) top[2];
            pass++;
            total++;
            pq.offer(new double[] { gain(pass, total), pass, total });
        }

        // Calculate the final average ratio
        double sum = 0.0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            int pass = (int) top[1], total = (int) top[2];
            sum += (double) pass / total;
        }

        return sum / classes.length;
    }

    // Helper function to calculate the incremental gain
    private double gain(int pass, int total) {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }
}
