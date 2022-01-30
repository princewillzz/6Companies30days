class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0], prere = prerequisites[i][1];
            indegree[course]++;
            adj.get(prere).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        int time=0;
        while (!q.isEmpty()) {
            int pre = q.poll();
            ans[time++] = pre;
            for (int courses: adj.get(pre)) {
                indegree[courses]--;
                if (indegree[courses]== 0)
                    q.offer(courses);
            }
        }
        if(time == numCourses) {
            return ans;
        }
        else {
            return new int[0];
        }
    }
}