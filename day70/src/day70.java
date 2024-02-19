import java.util.*;

public class day70 {
    /*
        여행 경로
        https://school.programmers.co.kr/learn/courses/30/lessons/43164
     */
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        Arrays.stream(solution(tickets)).forEach(System.out::println);
    }

    /*
        DFS로 변경
        => 알파벳 순서가 앞서는 경로를 구하기 위해 BFS를 하려했으나 시간 문제로 DFS로 모든 경로 구하고 sort한다.
     */
    static List<String> pathList = new ArrayList<>();
    static boolean[] visited;

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", 0, "ICN");
        Collections.sort(pathList);

        return pathList.get(0).split(" ");
    }

    private static void dfs(String[][] tickets, String currentCity, int cnt, String path) {
        if(cnt == tickets.length) {
            pathList.add(path);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && currentCity.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], cnt + 1, path + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }

//    static Map<String, List<String>> graph;

//    public static String[] solution(String[][] tickets) {
//        String[] answer = {};
//
//        graph = new HashMap<>();
//
//        for (String[] ticket : tickets) {
//            graph.putIfAbsent(ticket[0], new ArrayList<>());
//            graph.get(ticket[0]).add(ticket[1]);
//        }
//
//        Departure departure = bfs(tickets.length+1);
//
//        System.out.printf(departure.toString());
//
//        return answer;
//    }
//
//    public static Departure bfs(int n) {
//        Queue<Departure> queue = new LinkedList<>();
//        Departure icn = new Departure("ICN", 1, new ArrayList<>());
//        icn.path.add(icn.name);
//        queue.offer(icn);
//
//        while (!queue.isEmpty()) {
//            Departure departure = queue.poll();
//
//            if (n == departure.count) {
//                departure.result = String.join(",", departure.path);
//                return departure;
//            }
//
//            for (String destination : graph.get(departure.name)) {
//                departure.path.add(destination);
//                queue.offer(new Departure(destination, departure.count+1, departure.path));
//            }
//        }
//
//        return null;
//    }
//
//    public static class Departure {
//        public String name  ;
//        public int count;
//        public List<String> path;
//        public String result;
//
//        public Departure(String name, int count, List<String> path) {
//            this.name = name;
//            this.count = count;
//            this.path = path;
//        }
//
//        @Override
//        public String toString() {
//            return "Departure{" +
//                    "name='" + name + '\'' +
//                    ", count=" + count +
//                    ", path=" + path +
//                    '}';
//        }
//    }
}
