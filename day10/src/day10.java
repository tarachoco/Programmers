public class day10 {
    public static void main(String[] args) {
//         1, 2, 1, 2 / 6 / 1
//        int[] s = {1, 2, 1, 2};
        int[] s = {1,1,1,1,1};
        Solution so = new Solution();
        so.solution(s, 3);
    }
}

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, 0, 0, target);
        return answer;
    }

    public int dfs (int[] numbers, int sum, int idx, int target){
        if(idx == numbers.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        return dfs(numbers, sum+numbers[idx], idx+1, target) + dfs(numbers, sum-numbers[idx], idx+1, target);
    }
}