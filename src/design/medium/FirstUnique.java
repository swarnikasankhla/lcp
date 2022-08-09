package design.medium;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class FirstUnique {
    Set<Integer> queue = new LinkedHashSet<>();
    Map<Integer, Boolean> unique = new HashMap<>();

    public FirstUnique(int[] nums) {
        for(int n : nums){
            add(n);
        }
    }

    public int showFirstUnique() {
        if(!queue.isEmpty()){
            return queue.iterator().next();
        }
        return -1;
    }

    public void add(int value) {
        if(!unique.containsKey(value)){
            unique.put(value, true);
            queue.add(value);
        }else if(unique.get(value)){
            unique.put(value, false);
            queue.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
