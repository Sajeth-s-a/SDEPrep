package prep;

import org.apache.commons.lang3.StringUtils;

public class FindMinInRotated
{
	public static void main(String[] args)
	{
		FindMinInRotated f = new FindMinInRotated();
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(f.findMin(nums)); // Output: 0
		System.out.println(StringUtils.isNotEmpty(""));
	}
	public int findMin(int[] nums)
	{
		int left = 0;
		int right = nums.length - 1;

		while (left <= right)
		{
			int mid = left + (right - left) / 2;

			if(nums[right] > nums[mid])
			{
				right = mid;
			}
			else
			{
				left = mid + 1;
			}

		}
		return nums[left];
	}
}
