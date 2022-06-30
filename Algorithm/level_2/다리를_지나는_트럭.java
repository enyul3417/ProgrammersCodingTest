import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int total = 0;
        
        Queue<Integer> bridge = new LinkedList<>();       
        for(int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            
            while(true) {
                if(bridge.isEmpty()) { // 큐가 비었을 때
                    bridge.add(truck);
                    time++;
                    total += truck;
                    break;
                } else if(bridge.size() == bridge_length) { // 큐가 꽉 찼을때
                    total -= bridge.poll();
                } else { // 큐에 자리가 있는 경우
                    if(total + truck <= weight) {
                        bridge.add(truck);
                        time++;
                        total += truck;
                        break;
                    } else {
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }
        
        return time + bridge_length;
    }
}