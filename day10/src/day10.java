public class day10 {
    public static void main(String[] args) {
//         1, 2, 1, 2 / 6 / 1
        int[] s = {1, 2, 1, 2};
//        int[] s = {1,1,1,1,1};
        Solution so = new Solution();
        so.solution(s, 6);
    }
}

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer+= dfs(numbers[0],0, 1,numbers,target);
        answer+= dfs(-numbers[0],0, 1,numbers,target);
        System.out.printf("result="+answer);
        return answer;
    }

    public int dfs (int k, int r, int idx, int[] numbers, int target){
        if(idx >= numbers.length) {
            System.out.printf("k="+k+", r="+r+"\n");
            if(r==target) {
                return 1;
            }
            return 0;
        }
        int n = numbers[idx];
        return dfs(n,r+k, ++idx, numbers, target ) + dfs(n,r-k, ++idx, numbers, target);
    }
}