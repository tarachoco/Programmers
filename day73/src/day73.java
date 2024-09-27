import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class day73 {
    /*
        등굣길
        https://school.programmers.co.kr/learn/courses/30/lessons/42898
     */
    public static void main(String[] args) {
        int[][] puddles = {{2, 2}};
        System.out.printf(""+solution(4, 3, puddles));
    }

    static int[][] map;
    static Map<Integer, Integer> path;
    static int min;

    public static int solution(int m, int n, int[][] puddles) {
        min = Integer.MAX_VALUE;
        path = new HashMap<>();
        map = new int[m+2][n+2];

        for (int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = -1;
        }

        // dp 풀이
        map[1][1] = 1;
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                if (map[i][j-1] > 0) {
                    map[i][j] += map[i][j-1] % 1000000007;
                }
                if (map[i-1][j] > 0) {
                    map[i][j] += map[i-1][j] % 1000000007;
                }
            }
        }

        return map[m][n] % 1000000007;

        // dfs 효율성 테스트 실패
//        dfs(1, 1, 0);
//        return path.get(min);
    }
//
//    public static void dfs(int x, int y, int count) {
//
//        count %= 1000000007;
//
//        if ( x+1 < map.length && map[x+1][y] > -1) {
//            dfs (x+1, y,count+1 );
//        }
//        if( y+1 < map[0].length && map[x][y+1] > -1 ) {
//            dfs (x, y+1,count+1 );
//        }
//
//        if ( x+1 == map.length && y+1 == map[0].length) {
//            min = Math.min(min, count);
//            path.put(count, path.getOrDefault(count, 0)+1);
//        }
//    }
}
