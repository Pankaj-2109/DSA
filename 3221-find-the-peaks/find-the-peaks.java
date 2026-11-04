import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> al = new ArrayList<>();
        
       
        for (int i = 1; i < mountain.length - 1; i++) {
            // Check if the current element is strictly greater than its neighbors
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                al.add(i);
            }
        }
        
        return al;
    }
}