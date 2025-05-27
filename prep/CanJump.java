package prep;

public class CanJump
{
	public static void main(String[] args)
	{
		int[] nums = {2, 3, 1, 1, 4};
		boolean result = canJump(nums);
		System.out.println("Can jump to the end: " + result);
	}

	public static boolean canJump(int[] nums)
	{
		if(nums ==null || nums.length == 0)
		{
			return true;
		}
		int lastPos = nums.length - 1;
		for(int i = lastPos ; i>=0; i--)
		{
			if( i+nums[i] >= lastPos)
			{
				lastPos = i;
			}
		}
		return lastPos == 0;
	}
}

