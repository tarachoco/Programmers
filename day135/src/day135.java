import java.util.LinkedList;
import java.util.Queue;

public class day135 {
    /*
        경주로 건설
        https://school.programmers.co.kr/learn/courses/30/lessons/67259
     */
    public static void main(String[] args) {
//        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
//        int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
//        int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
//        int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        int[][] board = {{0,1,0,0,0},{0,0,0,1,0},{1,1,1,0,0},{0,0,0,0,1},{0,0,0,0,0}}; // 4700
        System.out.printf(""+solution(board));
    }

    public static int solution(int[][] board) {
        int answer = 0;

        int destinationX = board.length;
        int destinationY = board[0].length;

        int[][][] dp = new int[destinationY][destinationX][2];
        boolean[][][] visited = new boolean[destinationY][destinationX][2];

        for (int i=0; i<destinationY; i++) {
            for (int j=0; j<destinationX; j++) {
                dp[i][j][0] = Integer.MAX_VALUE;
                dp[i][j][1] = Integer.MAX_VALUE;
            }
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0, 0, Type.MOVE_Y));
        queue.offer(new Node(0, 0, 0, Type.MOVE_X));

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if ( board[now.y][now.x] == 1) {
                continue;
            }

            if (now.sum < dp[now.y][now.x][now.type.num]) {
                dp[now.y][now.x][now.type.num] = now.sum;
            }

            if (now.x + 1 < destinationX) {
                int sum = now.type != Type.MOVE_Y ? 100 : 600;
                queue.offer(new Node(now.x + 1, now.y, now.sum + sum, Type.MOVE_X));
            }

            if (now.y + 1 < destinationY) {
                int sum = now.type != Type.MOVE_X ? 100 : 600;
                queue.offer(new Node(now.x , now.y + 1, now.sum + sum, Type.MOVE_Y));
            }

            if (now.x - 1 > 0) {
                int sum = now.type != Type.MOVE_Y ? 100 : 600;
                queue.offer(new Node(now.x - 1, now.y, now.sum + sum, Type.MOVE_X));
            }

            if (now.y - 1 > 0) {
                int sum = now.type != Type.MOVE_X ? 100 : 600;
                queue.offer(new Node(now.x , now.y - 1, now.sum + sum, Type.MOVE_Y));
            }

        }

        answer = Math.min(dp[destinationY-1][destinationX-1][0], dp[destinationY-1][destinationX-1][1]);

        return answer;
    }

    public static class Node {
        int x;
        int y;
        int sum;
        Type type;

        public Node(int x, int y, int sum, Type type) {
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.type = type;
        }
    }

    public enum Type {
        MOVE_X (0),
        MOVE_Y (1);

        Type (int num) {
            this.num = num;
        }

        int num;
    }

}
