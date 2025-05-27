package prep;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraySumK
{
	public static void main(String[] args)
	{
		int[] nums = {1, 2, 3, -3};
		int k = 2;
		int result = countSubarrays(nums, k);
		System.out.println("Count of subarrays with sum " + k + ": " + result);
	}

	public static int countSubarrays(int[] nums, int k)
	{
		int sum = 0;
		int count = 0;
		Map<Integer, Integer> sumMap = new HashMap<>();
		sumMap.put(0, 1); // Initialize with sum 0 to handle cases where subarray starts from index 0
		for (int num : nums)
		{
			sum +=num;
			if(sumMap.containsKey(sum - k))
			{
				count += sumMap.get(sum - k);
			}
			sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

}
