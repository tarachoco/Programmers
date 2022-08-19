import java.util.*;

public class day5_1 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo","muzii"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi","muzi frodo","frodo muzii","neo muzii", "muzii muzi"};
        Solution solution = new Solution();
        System.out.printf("내가 제출한 답 ="+Arrays.toString(solution.solution(id_list,report,2))+"\n");
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        List<User> user_info = new ArrayList<>();

        for(String user_id : id_list){
            user_info.add(new User(user_id));
        }

        for(String item : report){
            String[] report_info = item.split(" ",2);
            if(report_info == null) continue;
            User target = user_info.stream().filter(user -> user.getId().equals(report_info[1])).findAny().orElse(null);
            if(target != null){
                target.getReport().add(report_info[0]);
                if(target.getReport().size() > k){
                    target.suspend();
                }
            }
        }

        for(int i=0;i<user_info.size();i++){
            if(user_info.get(i).isSuspension()){
                for(String r: user_info.get(i).getReport()){
                    int idx = Arrays.asList(id_list).indexOf(r);
                    answer[idx]++;
                }
            }
        }

        return answer;
    }

    public class User{
        private String id;
        private HashSet<String> report;
        private boolean isSuspension;

        public User(String id){
            this.id = id;
            this.report = new HashSet<>();
            this.isSuspension = false;
        }

        public String getId(){
            return id;
        }
        public HashSet<String> getReport(){
            return report;
        }
        public void suspend(){
            this.isSuspension = true;
        }
        public boolean isSuspension() {
            return isSuspension;
        }
    }
}