import java.util.*;

// 명함. level1

public class day6 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.printf("결과값 : " + solution.solution(sizes));
    }
}

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int maxWidth = 0;
        int maxHeight = 0;
        for(int i=0;i<sizes.length;i++){
            int[] arr = sizes[i];
            maxWidth = Math.max(maxWidth,Math.max(arr[0],arr[1]));
            maxHeight = Math.max(maxHeight,Math.min(arr[0],arr[1]));
        }

        answer = maxWidth * maxHeight;
        return answer;
    }
}