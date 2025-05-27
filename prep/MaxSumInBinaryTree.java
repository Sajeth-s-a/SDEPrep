package prep;

public class MaxSumInBinaryTree
{
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		int result = maxPathSum(root);
		System.out.println("Maximum path sum in binary tree: " + result);
	}

	public static void maxPathSumHelper(TreeNode node, int currVal, int[] maxSum)
	{
		if (node == null)
		{
			return;
		}

		currVal += node.val;

		if (node.left == null && node.right == null)
		{
			maxSum[0] = Math.max(maxSum[0], currVal); // Update maxSum if it's a leaf node
		}
		else
		{
			maxPathSumHelper(node.left, currVal, maxSum); // Recur for left subtree
			maxPathSumHelper(node.right, currVal, maxSum); // Recur for right subtree
		}

	}

	public static int maxPathSum(TreeNode root)
	{
		int[] maxSum = new int[1]; // Use an array to keep track of the maximum sum
		maxSum[0] = Integer.MIN_VALUE; // Initialize to the smallest possible value
		maxPathSumHelper(root, 0, maxSum);
		return maxSum[0];
	}
}
