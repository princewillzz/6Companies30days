class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }
    private Node helper(int[][] grid, int x, int y, int n) {
        if (n == 1) {
            return new Node(grid[x][y] == 1, true, null, null, null, null);
        }
        Node result = new Node();

        Node topLeft = helper(grid, x, y, n / 2);
        Node topRight = helper(grid, x, y + n / 2, n / 2);
        Node bottomLeft = helper(grid, x + n / 2, y, n / 2);
        Node bottomRight = helper(grid, x + n / 2, y + n / 2, n / 2);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            result.isLeaf = true;
            result.val = topLeft.val;

        } else {
            result.topLeft = topLeft;
            result.topRight = topRight;
            result.bottomLeft = bottomLeft;
            result.bottomRight = bottomRight;
        }
        return result;
    }
}