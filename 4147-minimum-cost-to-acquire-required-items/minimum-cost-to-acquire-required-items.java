
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        // Option 1: Buy separate items
        long a = (long) cost1 * need1 + (long) cost2 * need2;

        // Option 2: Buy only type 3 items
        long b = (long) costBoth * Math.max(need1, need2);

        // Option 3: Buy type 3 for common requirements
        // and individual items for remaining requirements
        long c = (long) costBoth * Math.min(need1, need2);

        if (need1 > need2) {
            c += (long) cost1 * (need1 - need2);
        } else {
            c += (long) cost2 * (need2 - need1);
        }

        return Math.min(a, Math.min(b, c));
    }
}
