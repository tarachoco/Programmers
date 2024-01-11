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

    /*

     public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[] {0,0,1}); //{현재 위치, 현재위치, 총 수}

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        int answer = 0;

        while(queue.isEmpty() == false){
            int[] currPoint = queue.remove();
            if(currPoint[0] == n-1 && currPoint[1] == m-1){
                return currPoint[2];
            }
            for (int i = 0; i < 4; i++) {
                int xx = dx[i] + currPoint[0];
                int yy = dy[i] + currPoint[1];
                if(xx >= 0 && xx < n && yy >= 0 && yy < m){
                    if(maps[xx][yy] == 1 && !visited[xx][yy]){
                        visited[xx][yy] = true;
                        queue.add(new int[] {xx, yy, currPoint[2]+1});
                    }
                }

            }
        }
        return -1;
    }

     */
}
