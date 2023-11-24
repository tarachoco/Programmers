public class day50 {
    /*
        신규 아이디 추천
        https://school.programmers.co.kr/learn/courses/30/lessons/72410?language=java
     */
    public static void main(String[] args) {
        System.out.printf(solution("abcdefghijklmn.p"));
    }

     public static String solution(String new_id) {

        // #1. 소문자로 변환
         new_id = new_id.toLowerCase();

         // #2. 문자 제거
         new_id = new_id.replaceAll("[^a-z0-9-_.]","");

         // #3. 마침표 중복 제거
         while (new_id.contains("..")) {
             new_id = new_id.replace("..", ".");
         }

         // #4. 마침표 시작 끝 제거
         if (!new_id.isEmpty() && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
         }

         if (!new_id.isEmpty() && new_id.charAt(new_id.length()-1) == '.') {
             new_id = new_id.substring(0,new_id.length()-1);
         }

         // #5 빈 문자열 체크
         if (new_id.isEmpty()) {
             new_id = "a";
         }

         // #6. 길이 체크
         int max = 15;
         if (new_id.length() > max ) {
             new_id = new_id.substring(0, max);
             while ( new_id.charAt(new_id.length()-1) == '.' ) {
                max--;
                new_id = new_id.substring(0, max);
             }
         }

         while (new_id.length() <=2) {
             new_id = new_id + new_id.charAt(new_id.length()-1);
         }

        return new_id;
    }
}
