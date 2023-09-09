package com.day13;

/*
 * 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * 근데 A,C랑 연결되는 건...
 */

 public class Main {
    public static void main(String[] args) {
        int[][] computers = {{1, 0, 1}, {0, 0, 0}, {0, 0, 0}} ;  
        int result = solution(3, computers);
        System.out.println(result);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];

        for (int i=0; i<n; i++) {
            if (!chk[i]) {
                dfs(i, computers, chk);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int start, int[][] computers, boolean[] chk) {
        chk[start] = true;

        for (int j=0; j<computers.length; j++) {
            if (!chk[j] && computers[start][j] == 1) {  // 연결된 종착지까지 계속 찾기
                dfs(j, computers, chk);
            }
        }
    }
}