import java.util.*;
import java.util.stream.Collectors;

public class day5_2 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        Solution1 solution = new Solution1();
        System.out.printf("내가 제출한 답 ="+Arrays.toString(solution.solution(id_list,report,2))+"\n");
    }
}

class Solution1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> report_info = new HashMap<>();

        for(String rep: report){
            String[] r = rep.split(" ",2);
            if(!report_info.containsKey(r[1])){
                HashSet s = new HashSet();
                s.add(r[0]);
                report_info.put(r[1], s);
            }else{
                report_info.get(r[1]).add(r[0]);
            }
        }

        for(Map.Entry<String,HashSet<String>> entry : report_info.entrySet()){
            if( entry.getValue().size() >= k){
                for(int i=0;i<id_list.length;i++){
                    if(entry.getValue().contains(id_list[i])){
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
}