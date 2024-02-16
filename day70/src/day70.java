import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.*;

public class day70 {
    /*
        여행 경로
        https://school.programmers.co.kr/learn/courses/30/lessons/43164
     */
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        solution(tickets);
    }

    static Map<String, List<String>> graph;

    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        graph = new HashMap<>();

        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new ArrayList<>());
            graph.get(ticket[0]).add(ticket[1]);
        }

        Departure departure = bfs(tickets.length+1);

        System.out.printf(departure.toString());

        return answer;
    }

    public static Departure bfs(int n) {
        PriorityQueue<Departure> queue = new PriorityQueue<>();
        queue.offer(new Departure("ICN", 1, new ArrayList<>()));
        Map<String, Boolean> visited = new HashMap<>();

        while (!queue.isEmpty()) {
            Departure departure = queue.poll();
            departure.path.add(departure.name);

            if (n == departure.count) {
                return departure;
            }

            for (String destination : graph.get(departure.name)) {
                if (!visited.getOrDefault(destination, false)) {
                    queue.offer(new Departure(destination, departure.count+1, departure.path));
                }
            }
        }

        return null;
    }

    public static class Departure implements Comparable<Departure>{
        public String name  ;
        public int count;
        public List<String> path;

        public Departure(String name, int count, List<String> path) {
            this.name = name;
            this.count = count;
            this.path = path;
        }

        @Override
        public String toString() {
            return "Departure{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    ", path=" + path +
                    '}';
        }

        @Override
        public int compareTo(Departure o) {
            return this.name.compareTo(o.name);
        }
    }
}
