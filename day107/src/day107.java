import java.util.ArrayList;
import java.util.List;

public class day107 {
    /*
        모음 사전
        https://school.programmers.co.kr/learn/courses/30/lessons/84512
     */
    public static void main(String[] args) {
        System.out.printf(""+solution("AAAAA"));
    }

    static List<String> list;
    static String [] words = {"A", "E", "I", "O", "U"};

    public static int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("", 0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    static void dfs(String str, int len) {
        list.add(str);
        if (len == 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], len + 1);
        }
    }
}
