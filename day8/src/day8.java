import java.util.*;

public class day8 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //[1, 2, 1, 2]	[1, 10, 1, 2]
        int[] queue1 ={1, 2, 1, 2};
        int[] queue2 ={1, 10, 1, 2};
//        int[] queue1 ={3, 2, 7, 2};
//        int[] queue2 ={4, 6, 5, 1};
        System.out.printf(solution.solution(queue1,queue2)+"");
    }
}

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int length = queue1.length * 3;

        Queue<Long> q1 = new LinkedList();
        Queue<Long> q2 = new LinkedList();
        long totalQ1 = 0;
        long totalQ2 = 0;

        for (int i=0; i<queue1.length;i++){
            q1.add((long) queue1[i]);
            totalQ1 += (long) queue1[i];
            q2.add((long) queue2[i]);
            totalQ2 += (long) queue2[i];
        }

        for(int i=0; i<length; i++){
            if(totalQ1 == totalQ2){
                answer = i;
                break;
            }else if(totalQ1 > totalQ2){
                totalQ1-=q1.peek();
                totalQ2+=q1.peek();
                q2.add(q1.poll());
            }else{
                totalQ2-=q2.peek();
                totalQ1+=q2.peek();
                q1.add(q2.poll());
            }
        }

        return answer;
    }
}
