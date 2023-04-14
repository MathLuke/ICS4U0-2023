public class Recursion_Assignment_Set2 {

    public int count(String line, char c) {
        if (line.length() == 0) {
            return 0;
        }

        if (line.charAt(0) == c) {
            return 1 + count(line.substring(1), c);
        } else {
            return count(line.substring(1), c);
        }
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

    public int findCheapestPath (int[][] map, int x, int y) {
        if (x < 0 || y > map.length - 1) {
            return Integer.MAX_VALUE;
        }
        if (x == 0 && y == map.length - 1) {
            return map[0][map.length-1];
        } else {
            return map[x][y] + Math.min(findCheapestPath(map, x-1, y), findCheapestPath(map, x, y+1));
        }
    }
}
