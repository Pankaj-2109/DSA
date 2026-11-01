class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(end>start){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1;
            }
            
        }
        return start;
        
    }
    
}
// class Solution {
//     public int peakIndexInMountainArray(int[] arr) {
//         int start = 0;
//         int end = arr.length - 1;

//         while (start < end) {
//             int mid = start + (end - start) / 2;  // ✅ Correct midpoint
//             if (arr[mid] > arr[mid + 1]) {
//                 // You are in the decreasing part of the mountain
//                 end = mid;
//             } else {
//                 // You are in the increasing part of the mountain
//                 start = mid + 1;
//             }
//         }

//         return start; // or end, both are same when loop ends
//     }
// }
