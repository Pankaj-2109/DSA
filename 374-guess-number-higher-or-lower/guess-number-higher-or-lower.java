
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while(start <= end) {
            int mid = start + (end-start)/2;
            int g = guess(mid);
            if(g == 0) {
               return mid;
            }
            else if(g == 1) {
               start = mid+1;
            }
            else{
              //-1
              end = mid-1;
            }
        }
        return -1;
    }
}