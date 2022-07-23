package design.medium;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

class SparseVector3 {
    private List<Pair<Integer, Integer>> vector;

    SparseVector3(int[] nums) {
        vector = new LinkedList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                vector.add(new Pair(i, nums[i]));
            }
        }
    }

    public int dotProduct(SparseVector3 vec) {
        List<Pair<Integer, Integer>> sparse = vec.getVector();
        int result = 0, p=0, q=0;
        while(p < vector.size() && q < sparse.size()){
            Pair<Integer, Integer> vectorPair = vector.get(p);
            Pair<Integer, Integer> vecPair = sparse.get(q);
            if(vectorPair.getKey().compareTo(vecPair.getKey()) == 0){
                result = result + (vectorPair.getValue() * vecPair.getValue());
                p++;
                q++;
            }
            else if(vectorPair.getKey().compareTo(vecPair.getKey()) < 0){
                p++;
            }else{
                q++;
            }
        }
        return result;
    }

    public List<Pair<Integer, Integer>> getVector(){
        return vector;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);*/