import java.util.*;

public class day2 {
    public static void main(String[] args) {

        /*
            코딩테스트 연습
            동적계획법(Dynamic Programming)
            정수 삼각형

            TODO
            bottom-up 방식으로 변경 필요
         */

        int[][] triangle ={{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.printf(String.valueOf(Solution.solution(triangle)));
    }
}

class Solution {
    public static int solution(int[][] triangle) {
        int answer = 0;

        for(int i=1; i<triangle.length; i++){
            int[] inArr = triangle[i];
            for(int j=0; j<inArr.length; j++){
                if(j==0) {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i][j];
                }else if(j<inArr.length-1){
                    triangle[i][j] = triangle[i - 1][j - 1] > triangle[i - 1][j] ? triangle[i - 1][j - 1] + triangle[i][j]: triangle[i - 1][j] + triangle[i][j];
                }else{
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
                }
            }
        }
        int[] result = triangle[triangle.length-1];
        Arrays.sort(result);
        answer = result[result.length - 1];
        return answer;
    }
}