import java.sql.Struct;
import java.util.LinkedList;
import java.util.Queue;

public class day63 {
    /*
        게임 맵 최단거리
        https://school.programmers.co.kr/learn/courses/30/lessons/1844
     */
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.printf(""+solution(maps));
    }

    static int blocks = Integer.MAX_VALUE;
    static int width;
    static int height;
    static boolean[][] visited;

    public static int solution(int[][] maps) {

        width = maps.length;
        height = maps[0].length;
        visited = new boolean[width][height];

        Queue<Node> queue = new LinkedList<>();

        visited[0][0] = true;
        queue.offer(new Node(0,0,1));

        while (!queue.isEmpty()){
            Node node = queue.poll();

            if (node.getX() == width-1 && node.getY() == height-1) {
                return node.getCount();
            }

            for (Direction dr : Direction.values()) {
                int nextX = node.getX() + dr.getX();
                int nextY = node.getY() + dr.getY();

                if (nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) {
                    continue;
                }

                if (maps[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY, node.getCount()+1));
                }
            }
        }

        return -1;
    }

    public static class Node {
        public int x;
        public int y;
        public int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static int solutionByDfs(int[][] maps) {
        int answer = 0;

        // dfs 풀이
        // 효율성 통과 못함.
        width = maps.length;
        height = maps[0].length;
        visited = new boolean[width][height];


        dfs(0, 0, 0, maps);

        return answer+blocks;
    }

    public static void dfs(int x, int y, int count, int[][] maps) {

        count++;

        if (x == width-1 && y == height-1) {
            blocks = Math.min(count, blocks);
            return;
        }

        for (Direction d : Direction.values()) {
            int nextX = x+d.getX();
            int nextY = y+d.getY();

            if (nextX < 0 || nextX > width - 1) {
                continue;
            }

            if (nextY < 0 || nextY > height - 1) {
                continue;
            }

            if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, count, maps);
                visited[nextX][nextY] = false;
            }
        }
    }

    public enum Direction {
        NORTH   (0, 1),
        EAST    (1, 0),
        WEST    (-1, 0),
        SOUTH   (0, -1);

        int x;
        int y;

        Direction (int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
