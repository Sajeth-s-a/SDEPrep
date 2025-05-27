package prep;

import java.util.HashMap;
import java.util.Map;

public class SubArrayEqualZeroAndOne
{
	public static void main(String[] args)
	{
		int[] nums = {0, 1, 0, 1, 0};
		int result = countSubarrays(nums);
		System.out.println("Count of subarrays with equal number of 0s and 1s: " + result);
	}

	public static int countSubarrays(int[] nums)
	{
		int count = 0;
		int sum = 0;
		Map<Integer, Integer> sumMap = new HashMap<>();
		sumMap.put(0, 1); // Initialize with sum 0 to handle cases where subarray starts from index 0

		for (int num : nums)
		{
			sum += (num == 0) ? -1 : 1; // Treat 0 as -1 and 1 as +1
			count += sumMap.getOrDefault(sum, 0);
			sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	static int maxLen(int[] arr)
	{
		HashMap<Integer, Integer> mp = new HashMap<>();

		int preSum = 0;
		int res = 0;

		for (int i = 0; i < arr.length; i++)
		{

			preSum += (arr[i] == 0) ? -1 : 1;
			if (preSum == 0)
				res = i + 1;

			if (mp.containsKey(preSum))
				res = Math.max(res, i - mp.get(preSum));

			else
				mp.put(preSum, i);
		}

		return res;
	}
}
