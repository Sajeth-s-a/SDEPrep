package prep;

public class PushZerosToEnd
{
	public static void main(String[] args)
	{
		PushZerosToEnd p = new PushZerosToEnd();
		int[] nums = {0, 1, 0, 3, 12};
		p.moveZeroes(nums);
		for (int num : nums)
		{
			System.out.print(num + " ");
		}
	}

	public void moveZeroes(int[] nums)
	{
		int count = 0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i] !=0)
			{
				int temp = nums[i];
				nums[i] = nums[count];
				nums[count] = temp;
				count++;
			}
		}
	}
}
