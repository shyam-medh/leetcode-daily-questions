// Sum of Left Leaves

/*
Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.


Example 2:
Input: root = [1]
Output: 0
 

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000
*/

//                                                        Solution: 👇

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        
        if (root == null) {
            return sum;
        }
        
        // Java uses the Queue interface, usually implemented by LinkedList
        Queue<TreeNode> q = new LinkedList<>();  
        q.offer(root); // Use offer() or add() to push to the queue
        
        while (!q.isEmpty()) {
            int n = q.size();  
            
            for (int i = 0; i < n; i++) {
                TreeNode current = q.poll(); // Use poll() to pop from the queue
                
                // Check if the left child exists
                if (current.left != null) {
                    // Check if that left child is a leaf node
                    if (current.left.left == null && current.left.right == null) {
                        sum += current.left.val;  
                    }
                    // Always add left child to queue to explore its descendants
                    q.offer(current.left);  
                }
                
                // Add right child to queue to explore its descendants
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
        }
        
        return sum;
    }
}
