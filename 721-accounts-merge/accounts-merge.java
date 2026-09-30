import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                graph.computeIfAbsent(email, key -> new ArrayList<>());
                emailToName.put(email, name);

                // Connect every email to the first email.
                if (i > 1) {
                    graph.get(firstEmail).add(email);
                    graph.get(email).add(firstEmail);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : graph.keySet()) {
            if (visited.contains(email)) continue;

            List<String> emails = new ArrayList<>();
            dfs(email, graph, visited, emails);
            Collections.sort(emails);

            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(email));
            merged.addAll(emails);
            result.add(merged);
        }

        return result;
    }

    private void dfs(String email,
                     Map<String, List<String>> graph,
                     Set<String> visited,
                     List<String> emails) {
        visited.add(email);
        emails.add(email);

        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, emails);
            }
        }
    }
}