class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Start from the top-right corner
        int rowIndex = 0;
        int colIndex = cols - 1;
        
        while (rowIndex < rows && colIndex >= 0) {
            int element = matrix[rowIndex][colIndex];
            
            if (element == target) {
                return true;
            } else if (element > target) {
                // If the element is greater than the target, move left to smaller values
                colIndex--;
            } else {
                // If the element is smaller than the target, move down to larger values
                rowIndex++;
            }
        }
        
        return false;
    }
}