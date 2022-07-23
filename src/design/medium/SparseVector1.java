package design.medium;
 /*Runtime : 2 ms, faster than 100.00% of Java online submissions for Dot Product of Two Sparse Vectors.
 Pros : Fast compute, no extra emory used to store vectors.
 Cons : Uses input reference which might not be allowed. Space is not optimized and compute across the entire vector.
 * */
class SparseVector1 {
    private int[] vector;
    SparseVector1(int[] nums) {
        this.vector = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector1 vec) {
        int result = 0;
        for(int i=0; i<vector.length; i++){
            if(vector[i] !=0 && vec.getValue(i) !=0){
                result =  result + (vector[i] * vec.getValue(i));
            }
        }
        return result;
    }

    public int getValue(int index){
        return vector[index];
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);