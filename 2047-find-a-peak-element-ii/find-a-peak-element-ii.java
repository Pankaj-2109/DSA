public class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat.length > 0 ? mat[0].length : 0;
        
        int low = 0;
        int high = m - 1;
        
        while (low <= high) {
            int midCol = low + (high - low) / 2;
            
            // Find the row index with the maximum element in the midCol column
            int maxRow = getMaxRowIndex(mat, n, midCol);
            
            // Get left and right values, treating out-of-bounds as -1
            int leftValue = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
            int rightValue = (midCol + 1 < m) ? mat[maxRow][midCol + 1] : -1;
            
            int current = mat[maxRow][midCol];
            
            // Check if it is a peak element
            if (current > leftValue && current > rightValue) {
                return new int[] { maxRow, midCol };
            } 
            // If the left element is greater, search in the left half
            else if (current < leftValue) {
                high = midCol - 1;
            } 
            // Otherwise, search in the right half
            else {
                low = midCol + 1;
            }
        }
        
        return new int[] { -1, -1 };
    }
    
    // Helper function to find the row index of the maximum element in a given column
    private int getMaxRowIndex(int[][] mat, int rows, int col) {
        int maxVal = Integer.MIN_VALUE;
        int maxRowIndex = -1;
        
        for (int i = 0; i < rows; i++) {
            if (mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                maxRowIndex = i;
            }
        }
        
        return maxRowIndex;
    }
}