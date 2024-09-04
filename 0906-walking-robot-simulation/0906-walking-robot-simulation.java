
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions: North, East, South, West
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Create a set of obstacles for quick lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "_" + obstacle[1]);
        }
        
        int x = 0, y = 0; // starting position
        int direction = 0; // starting direction: North
        int maxDistanceSq = 0;
        
        for (int command : commands) {
            if (command == -2) { // turn left 90 degrees
                direction = (direction + 3) % 4;
            } else if (command == -1) { // turn right 90 degrees
                direction = (direction + 1) % 4;
            } else { // move forward 'command' units
                for (int i = 0; i < command; i++) {
                    int nextX = x + directions[direction][0];
                    int nextY = y + directions[direction][1];
                    
                    // Check if the next position is an obstacle
                    if (!obstacleSet.contains(nextX + "_" + nextY)) {
                        x = nextX;
                        y = nextY;
                        maxDistanceSq = Math.max(maxDistanceSq, x * x + y * y);
                    } else {
                        break; // stop moving if an obstacle is encountered
                    }
                }
            }
        }
        
        return maxDistanceSq;
    }
}
