import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        HashMap<String, Integer> reportCntMap = new HashMap<>();
        HashMap<String, List<String>> reportMap = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            List<String> list = new LinkedList<>();
            reportCntMap.put(id_list[i], 0);
            reportMap.put(id_list[i], list);
        }
        
        for(int i = 0; i < report.length; i++) {
            String[] arr = report[i].split(" ");
            String reporter = arr[0]; // 신고자
            String target = arr[1]; // 신고 당한 사람
            
            List<String> list = reportMap.get(target) ;
            if(list.contains(reporter)) continue;
            list.add(reporter);
            reportMap.put(target, list);
        }

        for(int i = 0; i < id_list.length; i++) {
            List<String> list = reportMap.get(id_list[i]);
            if(list.size() >= k) {
                for(int j = 0; j < list.size(); j++) {
                    reportCntMap.put(list.get(j), reportCntMap.get(list.get(j)) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = reportCntMap.get(id_list[i]);
        }
        
        return answer;
    }
}