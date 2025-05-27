package prep;

public class MinimumDepthOfBT
{
	public static void main(String[] args)
	{
		MinimumDepthOfBT mdbt = new MinimumDepthOfBT();
		TreeNode root = new TreeNode(1);                  //1
		root.left = new TreeNode(2);				     // / \
		root.right = new TreeNode(3);					// 	2   3
		root.left.left = new TreeNode(4);				//  / \
		root.left.right = new TreeNode(5);				// 4   5
		System.out.println(mdbt.minDepth(root)); // Output: 2
	}
	public int minDepth(TreeNode root)
	{
		if (root == null)
		{
			return 0;
		}
		if(root.left == null)
		{
			return minDepth(root.right) + 1;
		}
		if(root.right == null)
		{
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}
