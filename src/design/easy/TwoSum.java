package design.easy;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    Map<Integer, Integer> stream;
    /** Initialize your data structure here. */
    public TwoSum() {
        stream = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        stream.put(number, stream.getOrDefault(number, 0)+1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int num : stream.keySet()){
            int diff = value - num;
            if(stream.containsKey(diff)){
                if(diff != num || (diff == num && stream.get(diff) > 1)){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */