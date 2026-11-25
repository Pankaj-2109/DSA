
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> al = new ArrayList<>();

        int total = 1 << n;

        for (int i = 0; i < total; i++) {
            al.add(i ^ (i >> 1));
        }

        return al;
    }
}
