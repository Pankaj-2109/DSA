class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> st = new Stack<>();

        for (String token : tokens) {

            if (token.equals("") || token.equals(".")) {
                continue;
            }

            if (!token.equals("..")) {
                st.push(token);
            } 
            else if (!st.isEmpty()) {
                st.pop();
            }
        }

        StringBuilder result = new StringBuilder();

        for (String token : st) {
            result.append("/").append(token);
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}