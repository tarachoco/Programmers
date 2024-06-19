import java.util.*;

public class day103 {
    /*
        과제 진행하기
        https://school.programmers.co.kr/learn/courses/30/lessons/176962
     */
    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
//        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
//        String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
//        String[][] plans = {{"a","09:00","30"},{"b","09:10","20"},{"c","09:15","20"},{"d","09:55","10"},{"e","10:50","5"}}; // 반례. 기대값 : {"c","b","d","a","e"}
        String[] results = solution(plans);
        Arrays.stream(results).forEach(System.out::println);
    }

    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        Stack<Integer[]> stack = new Stack<>();
        Queue<Integer[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        /*
            Integer [0] = 과제 명
            Integer [1] = 과제 시작 시간
            Integer [2] = 걸리는 시간
         */
        int subjectNumber = 0;
        HashMap<Integer, String> subjects = new HashMap<>();

        for (int i=0; i<plans.length; i++) {
            String[] splits = plans[i][1].split(":");
            int pt = Integer.parseInt(splits[0]) * 60 + Integer.parseInt(splits[1]);

            subjects.put(++subjectNumber, plans[i][0]);
            Integer[] p = new Integer[3];
            p[0] = subjectNumber;
            p[1] = pt;
            p[2] = Integer.parseInt(plans[i][2]);

            queue.offer(p);
        }

        int idx = 0;
        Integer[] now = queue.poll();
        int time = now[1];

        while (!queue.isEmpty()) {
            time += now[2];
            Integer[] next = queue.peek();

            if (time > next[1]) {
                now[2] = time - next[1];
                stack.push(now);
            } else {
                answer[idx++] = subjects.get(now[0]);

                if (!stack.empty()) {
                    now = stack.pop();
                    continue;
                }
            }
            now = queue.poll();
            time = now[1];
        }

        answer[idx++] = subjects.get(now[0]);

        while (!stack.empty()) {
            answer[idx++] = subjects.get(stack.pop()[0]);
        }

        return answer;
    }
}
