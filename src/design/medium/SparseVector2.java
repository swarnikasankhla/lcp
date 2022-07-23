package design.medium;

import java.util.HashMap;
import java.util.Map;
/*
Runtime: 18 ms, faster than 26.16% of Java online submissions for Dot Product of Two Sparse Vectors.
Pros : less space, run only for least non-zero length
Cons : slow due to hashing and hash collisions
* */
class SparseVector2 {
    private Map<Integer, Integer> vector;

    SparseVector2(int[] nums) {
        vector = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                vector.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector2 vec) {
        Map<Integer, Integer> vecMap = vec.getVector();
        if(vecMap.size() > vector.size()){
            return this.product(vecMap);
        }else{
            return vec.product(vector);
        }
    }

    public Map<Integer, Integer> getVector(){
        return vector;
    }

    public int product(Map<Integer, Integer> vec){
        int result = 0;
        for(int index : vector.keySet()){
            if(vec.containsKey(index)){
                result = result + (vector.get(index) * vec.get(index));
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);