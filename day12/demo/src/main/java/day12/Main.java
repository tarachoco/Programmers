package demo.src.main.java.day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    /*
        이중우선순위큐
        https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=java

        아 문제 제목대로 풀어야겠다 다음부턴...
    */
    public static void main(String[] args) {
        String[] operations = {"I 1", "I 3", "I 5", "I 7", "I 9", "D -1", "D -1", "D 1", "I 2", "D 1", "D 1"};
        int[] result = solution(operations);
        System.out.println(result[0]+","+result[1]);
    }

    public static int[] solution(String[] operations) {
        List<Integer> queue = new ArrayList<>();

        for (String operation : operations) {
            String[] operationSet = operation.split(" ");

            switch (operationSet[0]) {
                case "I":
                    queue.add(Integer.parseInt(operationSet[1]));
                    break;
                case "D":
                    if (queue.size() == 0) continue;
                    if (operationSet[1].equals("1")) {
                        queue.remove(Collections.max(queue));
                    } else {
                        queue.remove(Collections.min(queue));
                    }
                    break;
                default:
                    break;
            }
        }

        int[] answer = new int[2];

        if (queue.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = Collections.max(queue);
            answer[1] = Collections.min(queue);
        }

        return answer;
    }
    
}