import java.util.ArrayList;
import java.util.List;

public class day12 {
    public static void main(String[] args) {
        // 6.2 n개의 원소 중 m개를 고르는 모든 조합으르 찾는 알고리즘
        // n: 전체 원소의 수
        // picked: 지금까지 고른 원소들의 번호
        // toPick: 더 고를 원소의 수
        // 일 때, 앞으로 toPick개의 원소를 고르는 모든 방법을 출력한다.
//        pick(10,new ArrayList<>(), 5);
//        hasWord(1,1,"PRETTY");

    }
//
//    public static void pick(int n, List<Integer> picked, int toPick){
//        if(toPick == 0) {
//            System.out.println("");
//            picked.forEach(System.out::print);
//            return;
//        }
//
//        int smallest = picked.size() == 0 ? 0 : picked.get(picked.size()-1);
//
//        for(int next = smallest; next < n; ++next){
//            picked.add(next);
//            pick(n, picked, toPick - 1);
//            picked.remove(picked.size()-1);
//        }
//    }
//
//    static int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
//    static int[] dy = {-1, 0,1, -1, 0, 1, -1, 1};
//    static char[][] board = {{'U','R','L','P','M'},
//                            {'X','P','R','E','T'},
//                            {'G','I','A','E','T'},
//                            {'X','T','N','Z','Y'},
//                            {'X','O','Q','R','S'}};
//
//    public static boolean hasWord(int y, int x, String word){
//        // 기저 사례 1: 시작 위차가 범위 밖이면 무조건 실패
//        if(!inRange(y,x)) return false;
//        // 기저 사례 2: 첫 글자가 일치하지 않으면 실패
//        if(board[y][x] != word.charAt(0)) return false;
//        // 기저 사례 3: 단어 길이가 1이면 성공
//        if(word.length() == 1) return true;
//        // 인접한 여덟 칸을 검사한다.
//        for(int direction = 0; direction < 8; ++direction){
//            int nextY = y + dy[direction];
//            int nextX = x + dx[direction];
//            if(hasWord(nextY, nextX, word.substring(1))){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static boolean inRange(int y, int x){
//        if(5 <= y) {
//            return false;
//        }
//        if(5 <= x){
//            return false;
//        }
//        return true;
//    }
//
//    static int n;
//    static boolean areFriends[][] = new boolean[10][10];
//    // taken[i] = i번째 학생이 짝을 이미 찾았으면 true, 아니면 flase
//    public static int countPairings(boolean taken[]){
//        //남은 학생들 중 가장 번호가 빠른 학생을 찾는다.
//        int firstFree = -1;
//
//        for(int i=0; i<n; ++i){
//            if(!taken[i]){
//                firstFree = i;
//                break;
//            }
//        }
//        // 기저 사례: 모든 학생이 짝을 찾았으면 한 가지 방법을 찾았으니 종료한다.
//        if(firstFree == -1) return 1;
//        int ret = 0;
//        // 이 학생과 짝지을 학생을 결정한다.
//        for(int pairWith = firstFree+1; pairWith < n; ++pairWith){
//            if(!taken[pairWith] && areFriends[firstFree][pairWith]){
//                taken[firstFree] = taken[pairWith] = true;
//                ret += countPairings(taken);
//                taken[firstFree] = taken[pairWith] = false;
//            }
//        }
//        return ret;
//    }

    // case1. 잘못된 코드
//    public static int countPairings(boolean[] taken){
//        // 기저 사례: 모든 학생이 짝을 찾았으면 한 가지 방법을 찾았으니 종료한다.
//        boolean finished = true;
//        for(int i=0; i<n; ++i){
//            if(!taken[i]) finished = false;
//        }
//        if(finished) return 1;
//        int ret = 0;
//        // 서로 친구인 두 학생을 찾아 짝을 지어 준다.
//        for(int i=0; i<n; ++i){
//            for(int j=0; j<n; ++j){
//                if(!taken[i] && !taken[j] && areFriends[i][j]){
//                    taken[i] = taken[j] = true;
//                    ret += countPairings(taken);
//                    taken[i] = taken[j] = false;
//                }
//                return ret;
//            }
//        }
//    }
//
//    /*
//        주어진 칸을 덮을 수 있는 네 가지 방법
//        블록을 구성하는 세 칸의 상대적 위치 (dy,dx)의 목록
//     */
//    final static int[][][] coverType = {
//            {{0,0},{1,0},{0,1}},
//            {{0,0},{0,1},{1,1}},
//            {{0,0},{1,0},{1,1}},
//            {{0,0},{1,0},{1,-1}}
//    };
//    /*
//        board의 (y,x)를 type번 방법으로 덮거나, 덮었던 블록을 없앤다.
//        delta=1이면 덮고, -1이면 덮었던 블록을 없앤다.
//        만약 블록이 제대로 덮이지 않은 경우 (게임판 밖으로 나가거나, 겹치거나, 검은 칸을 덮을 때)
//        false를 반환한다.
//     */
//    public static boolean set(int[][] board, int y, int x, int type, int delta){
//        boolean ok = true;
//        for(int i=0; i<3; ++i){
//            int ny = y + coverType[type][i][0];
//            int nx = x + coverType[type][i][1];
//
//            if(ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length){
//                ok = false;
//            }else if((board[ny][nx] += delta) > 1){
//                ok = false;
//            }
//        }
//        return ok;
//    }
//
//    /*
//        board의 모든 빈 칸을 덮을 수 있는 방법의 수를 반환한다.
//        board[i][j] = 1 이미 덮인 칸 혹은 검은 칸
//        board[i][j] = 0 아직 덮이지 않은 칸
//     */
//    public static int cover(int[][] board){
//        // 아직 채우지 못한 칸 중 가장 윗줄 왼쪽에 있는 칸을 찾는다.
//        int y = -1;
//        int x = -1;
//
//        for(int i=0; i<board.length; ++i){
//            for(int j=0; j<board.length; ++j){
//                if (board[i][j] == 0) {
//                    y = i;
//                    x = j;
//                    break;
//                }
//            }
//            if(y!= -1) break;
//        }
//
//        //기저 사례: 모든 칸을 채웠으면 1을 반환한다.
//        if(y==-1) return 1;
//        int ret = 0;
//        for(int type=0; type<4; ++type){
//            // 만약 board[y][x]를 type 형태로 덮을 수 있으면 재귀 호출한다.
//            if(set(board, y, x, type, 1)){
//                ret += cover(board);
//            }
//            // 덮었던 블록을 치운다.
//            set(board, y, x, type, -1);
//        }
//        return ret;
//    }

//    static int n; //도시의 수
//    static double dist[][]; // 두 도시 간의 거리를 저장하는 배열
//
//    //path: 지금까지 만든 경로
//    //visited: 각 도시의 방문 여부
//    //currentLength: 지금까지 만든 경로의 길이
//    //나머지 도시들을 모두 방문하는 경로들 중 가장 짧은 것의 길이를 반환한다.
//    public static double shortestPath(List<Integer> path, boolean[] visited, double currentLength){
//        //기저 사례: 모든 도시를 다 방문했을 때에는 시작 도시로 돌아가고 종료한다.
//        if(path.size()-1 == n){
//            return currentLength + dist[path.get(0)][path.size()-1];
//        }
//        double ret = 987654321;
//        // 다음 방문할 도시를 전부 시도해 본다
//        for(int next = 0; next < n; ++next){
//            if(visited[next]) continue;
//            int here = path.get(path.size()-1);
//            path.add(next);
//            visited[next] = true;
//            //나머지 경로를 재귀 호출을 통해 완성하고 가장 짧은 경로의 길이를 얻는다.
//            double cand = shortestPath(path, visited, currentLength + dist[here][next]);
//            ret = ret < cand ? ret : cand;
//            visited[next] = false;
//            path.get(path.size()-1);
//        }
//        return ret;
//   }

    static int INF = 9999;
    static int SWITCHES = 10;
    static int CLOCKS = 16;
    // linked[i][j] = 'x': i번 스위치와 j번 시계가 연결되어 있다.
    // linked[i][j] = '.': i번 스위치와 j번 시계가 연결되어 있지 않다.

    static String[] linked = {
      // 0123456789012345
      "xxx.............",
      "...x...x.x.x....",
      "....x.....x...xx",
      "x...xxxx........",
      "......xxx.x.x...",
      "x.x...........xx",
      "...x..........xx",
      "....xx.x......xx",
      ".xxxxx..........",
      "...xxx...x...x..",
    };

    // 모든 시계가 12시를 가리키고 있는지 확인한다.
    static boolean areAligned(List<Integer> clocks){
        return true;
    }

    public static void push(List<Integer> clocks, int swtch){
        for(int clock = 0; clock < CLOCKS; ++clock){
            if(linked[swtch].charAt(clock) == 'x'){
                clocks.set(clock, clocks.get(clock) + 3);
                if(clocks.get(clock) == 15) clocks.set(clock, 3);
            }
        }
    }

    //clocks: 현재 시계들의 상태
    //swtch: 이번에 누를 스위치의 번호
    // 가 주어질 때, 남은 스위치들을 눌러서 clocks를 12시로 맞출 수 있는 최소 횟수를 반환한다.
    // 만약 불가능하다면 INF 이상의 큰 수를 반환한다.
    public static int solve(List<Integer> clocks, int swtch){
        if(swtch == SWITCHES) return areAligned(clocks) ? 0 : INF;

        // 이 스위치를 0번 누르는 경우부터 세 번 누르는 경우까지 모두 시도한다.
        int ret = INF;
        for(int cnt = 0; cnt < 4; ++cnt){
            int target = cnt + solve(clocks, swtch + 1));
            ret = ret > target ? target : ret;
            push(clocks, swtch);
        }
        //push (clocks,swtch) 가 네 번 호출되었으니 clocks는 원래와 같은 상태가 된다.
        return ret;
    }
}
