class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {

            boolean alive = true;

            // Collision can happen only when:
            // stack top is moving right (+)
            // current asteroid is moving left (-)
            while (alive && !st.isEmpty() && st.peek() > 0 && asteroid < 0) {

                if (st.peek() < -asteroid) {
                    // Stack asteroid is smaller -> it explodes
                    st.pop();

                } else if (st.peek() == -asteroid) {
                    // Both explode
                    st.pop();
                    alive = false;

                } else {
                    // Current asteroid is smaller -> it explodes
                    alive = false;
                }
            }

            if (alive) {
                st.push(asteroid);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}