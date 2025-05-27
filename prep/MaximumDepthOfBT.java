package prep;

public class MaximumDepthOfBT
{
	public static void main(String[] args)
	{
		MaximumDepthOfBT mdbt = new MaximumDepthOfBT();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(mdbt.maxDepth(root)); // Output: 3
	}

	public int maxDepth(TreeNode root)
	{
		if (root == null)
		{
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	public static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode()
		{
		}

		TreeNode(int val)
		{
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right)
		{
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}




