import java.util.HashSet;
import java.util.Set;

public class day36 {
    /*
        둘만의 암호
        https://school.programmers.co.kr/learn/courses/30/lessons/155652/solution_groups?language=java
     */
    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd", 5));
    }

    public static String solution(String s, String skip, int index) {
        String answer = "";

        char[] charArray = s.toCharArray();
        Set<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        for (int i=0; i<s.length(); i++){
            int w = 0;
            while (w<index) {

                charArray[i]++;

                if ( charArray[i] > 'z') {
                    charArray[i]=97;
                }

                if (skipSet.contains(charArray[i])) {
                    continue;
                }

                w++;
            }
        }

        answer = new String(charArray);

        return answer;
    }
}
