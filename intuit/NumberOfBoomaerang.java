class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {

                int distance = (points[j][0] - points[i][0])*(points[j][0] - points[i][0]) + (points[j][1] - points[i][1])*(points[j][1] - points[i][1]);

                int size = map.getOrDefault(distance, 0);

                cnt += size++ * 2;

                map.put(distance, size);
            }
        }
        return cnt;
    }
}