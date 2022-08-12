import java.util.*;
import java.util.stream.IntStream;

public class day3 {
    public static void main(String[] args) {
        // 5*5-5/5
        System.out.printf(String.valueOf(Solution.solution(5,12)));
    }
}

class Solution {
    public static int solution(int N, int number) {
        int answer = -1;
        List<Set<Integer>> list = new ArrayList<>();
        list.add(null);
        list.add(new HashSet(){{
            add(N);
        }});

        if(N==number) return 1;

        for(int i=2;i<=8;i++){
            int K = getK(i,N);
            list.add(new HashSet(){{
                add(K);
            }});
            for(int j=1; j<i; j++){
                for(int x : list.get(i-j)){
                    if(x == 0){
                        continue;
                    }
                    Set<Integer> set = new HashSet<>();
                    for(int y : list.get(j)){
                        if(y == 0){
                            continue;
                        }
                        set.add(x+y);
                        set.add(x-y);
                        set.add(x*y);
                        set.add(x/y);
                        set.add(y/x);
                    }
                    list.get(i).addAll(set);
                }
            }
            if(list.get(i).contains(number)){
                return i;
            }
        }
        return answer;
    }


    public static int getK(int i, int N){
        StringBuilder sb = new StringBuilder();
        IntStream.range(0,i).forEach((s)->{ sb.append(N); });
        return Integer.parseInt(sb.toString());
    }
}
