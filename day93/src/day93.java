public class day93 {
    /*
        풍선 터뜨리기
        https://school.programmers.co.kr/learn/courses/30/lessons/68646
     */
    public static void main(String[] args) {
//        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        int[] a = {9,-1,-5};
        System.out.printf(""+solution(a));
    }

    /*
        규칙이 없어 dp로는 구현 불가능하고 완전 탐색 필요하다.
        왼쪽과 오른쪽의 최솟값이 현재 풍선 값보다 작으면 터뜨릴 수 없는 풍선이다.
     */
    public static int solution(int[] a) {
        int answer = 0;

        int[] leftMinArr = new int[a.length];
        int leftMin = Integer.MAX_VALUE;

        for (int i=0; i<a.length; i++) {
            leftMin = Math.min(leftMin, a[i]);
            leftMinArr[i] = leftMin;
        }

        int rightMin = Integer.MAX_VALUE;
        int count = 0;
        for (int i=a.length-1; i>=0; i--) {
            rightMin = Math.min(rightMin, a[i]);
            if (leftMinArr[i] < a[i] && rightMin < a[i]) {
                count++;
            }
        }

        answer = a.length - count;

        return answer;
    }
}
