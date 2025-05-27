package prep;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

import org.json.JSONObject;

public class MergeSort
{
	public static void main(String args[]) throws NoSuchAlgorithmException
	{
		//		int arr[] = {12, 11, 13, 5, 6, 7};
		//
		//		System.out.println("Given array is");
		//		for (int i = 0; i < arr.length; i++)
		//		{
		//			System.out.print(arr[i] + " ");
		//		}
		//		mergeSort(arr, 0, arr.length - 1);
		//
		//		System.out.println("\nSorted array is");
		//		for (int i = 0; i < arr.length; i++)
		//		{
		//			System.out.print(arr[i] + " ");
		//		}

		//		String[] word1 = {"ab", "c"};
		//		String[] word2 = {"a", "bc"};
		//		System.out.println(arrayStringsAreEqual(word1, word2));

		//		int[] arr = {1, 2, 3, 4, 3, 2, 1};
		//		System.out.println(isArrayAnPalindrome(arr));

		//		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

		//		System.out.println(findDuplicate(new int[] {1, 3, 4, 2, 2}));
		int[][] matrix = {
			{1, 2},
			{3, 4}

		};
		//		System.out.println("Original Matrix:");
		//		printMatrix(matrix);
		//
		//		// Call the rotate function (to be implemented)
		//		rotate(matrix);
		//
		//		System.out.println("Matrix After 90-degree Rotation:");
		//		printMatrix(matrix);
		//		rotate(matrix);

		//		System.out.println(findSortedArray(new int[] {4, 5, 6, 7, 1, 2, 3}, 1));
		//		arrayStringsAreEqual(new String[]{"hi"}, new String[]{"hi", "hello"});

		//		System.out.println(findFirstDuplicate("My drEss is super DRESS like DreSS"));
		//		System.out.println(gasStation(new int[] {}, new int[] {}));
		//		System.out.println(halfAdder(77, 457));
		//		List result = getDeciBinaryParts("33");
		//		System.out.println(result);
		System.out.println(Arrays.toString(productExceptSelf(new int[] {1, 2, 3, 4})));
	}

	public static void merge(int[] arr, int l, int m, int r)
	{
		int n1 = m - l + 1;
		int n2 = r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++)
		{
			L[i] = arr[l + i];
		}

		for (int i = 0; i < n2; i++)
		{
			R[i] = arr[m + 1 + i];
		}
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2)
		{
			if (L[i] <= R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1)
		{
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2)
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static void mergeSort(int[] arr, int l, int r)
	{
		if (l < r)
		{
			int m = l + (r - l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	public int[] twoSum(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			int otherValue = nums[i] - target;
			if (map.containsKey(otherValue))
			{
				return new int[] {map.get(otherValue), i};
			}
			else
			{
				map.put(nums[i], i);
			}

		}
		return new int[] {};
	}

	public static int maxSubArraySum(int[] nums)
	{
		int res = nums[0];
		int maxEnding = nums[0];
		for (int i = 0; i < nums.length; i++)
		{
			maxEnding = Math.max(maxEnding + nums[i], nums[i]);
			res = Math.max(res, maxEnding);
		}
		return res;
	}

	public static boolean arrayStringsAreEqual(String[] word1, String[] word2)
	{
		String word1Str = Arrays.stream(word1).reduce("", (a, b) -> a + b);
		System.out.println(word1Str);
		String word2Str = Arrays.stream(word2).reduce("", (a, b) -> a + b);
		System.out.println(word2Str);
		return word1Str.equals(word2Str);
	}

	public static boolean isArrayAnPalindrome(int[] arr)
	{
		int n = arr.length;
		if (n == 0)
		{
			return false;
		}
		else
		{
			int left = 0;
			int right = n - 1;
			while (left < right)
			{
				if (arr[left] != arr[right])
				{
					return false;
				}
				left++;
				right--;
			}
			return true;
		}
	}

	public static boolean isPalindrome(String s)
	{
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		String rev = new StringBuilder(s).reverse().toString();
		return s.equals(rev);
	}

	//Solving using Floyd's Tortoise and Hare (Cycle Detection)
	public static int findDuplicate(int[] nums)
	{
		int slow = nums[0];
		int fast = nums[0];

		do
		{
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		slow = nums[0];
		while (slow != fast)
		{
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}

	public static int minTotalPrice(int[] prices, int n)
	{
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		for (int price : prices)
		{
			priorityQueue.add(price);
		}

		for (int i = 0; i < n; i++)
		{
			if (!priorityQueue.isEmpty())
			{
				int max = priorityQueue.poll();
				if (max != 0)
				{
					max /= 2;
					priorityQueue.add(max);
				}
			}
		}

		return Arrays.stream(priorityQueue.toArray(new Integer[0])).mapToInt(Integer::intValue).sum();
	}

	public int mergeStones(int[] stones, int k)
	{
		int n = stones.length;
		if ((n - 1) % (k - 1) != 0)
		{
			return -1;
		}
		else
		{

		}
		return 0;
	}

	public static void rotate(int[][] matrix)
	{
		int n = matrix.length;
		int m = matrix[1].length;

		for (int i = 0; i < n; i++)
		{
			for (int j = i + 1; j < m; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// Reverse each row
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n / 2; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}
	}

	public static void printMatrix(int[][] matrix)
	{
		for (int[] row : matrix)
		{
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}

	public static int binarySearch(int[] nums, int target)
	{
		int l = 0;
		int r = nums.length - 1;
		while (l <= r)
		{
			int m = l + (r - l) / 2;
			if (nums[m] == target)
			{
				return m;
			}
			else if (nums[m] < target)
			{
				l = m + 1;
			}
			else
			{
				r = m - 1;
			}
		}
		return -1;
	}

	public static int[] mergeSortedArrays(int[] nums1, int[] nums2)
	{
		int n = nums1.length;
		int m = nums2.length;

		int[] arr = new int[n + m];
		int i = 0, j = 0, k = 0;
		while (i < n && j < m)
		{
			if (nums1[i] < nums2[j])
			{
				arr[k] = nums1[i];
				i++;
			}
			else
			{
				arr[k] = nums2[j];
				j++;
			}
			k++;
		}
		while (i < n)
		{
			arr[k] = nums1[i];
			i++;
			k++;
		}
		while (j < m)
		{
			arr[k] = nums2[j];
			j++;
			k++;
		}
		return arr;
	}

	//[7,8,9,0,1,2]
	public static int findSortedArray(int[] nums, int target)
	{
		int start = 0;
		int end = nums.length - 1;

		while (start <= end)
		{
			int m = start + (end - start) / 2;

			// If target is found
			if (nums[m] == target)
			{
				return m;
			}

			if (nums[start] <= nums[m])
			{
				if (nums[start] <= target && target < nums[m])
				{
					end = m - 1;  // Target is in the left half
				}
				else
				{
					start = m + 1;  // Target is in the right half
				}
			}
			// Right half is sorted
			else
			{
				if (nums[m] < target && target <= nums[end])
				{
					start = m + 1;  // Target is in the right half
				}
				else
				{
					end = m - 1;  // Target is in the left half
				}
			}
		}

		// Target not found
		return -1;
	}

	//[4,5,6,7,0,1,2], target = 0
	public static int findSortedArrayTest(int[] nums, int target)
	{

		return -1;
	}

	public static void revereArray(int[] nums)
	{
		int n = nums.length;
		for (int i = 0; i < n / 2; i++)
		{
			int temp = nums[i];
			nums[i] = nums[n - 1 - i];
			nums[n - 1 - i] = temp;
		}
	}

	public static HashSet<Long> testMem()
	{
		int numElements = 400000;
		HashSet<Long> longSet = new HashSet<>();

		Set<Long> hashSet = new HashSet<>(500_000, 0.75f);

		longSet.add(1L);
		// Generate random long values
		Random random = new Random();
		for (int i = 0; i < numElements; i++)
		{
			longSet.add(random.nextLong());
		}

		// Measure memory usage
		long usedMemoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("Memory used before: " + usedMemoryBefore / 1024 / 1024 + " MB");

		return longSet;
	}

	public static String findFirstDuplicate(String sentence)
	{
		String[] words = sentence.split(" ");
		Set<String> seen = new HashSet<>();
		String result = "";

		for (int i = words.length - 1; i >= 0; i--)
		{
			if (seen.contains(words[i].toLowerCase()))
			{
				result = words[i];
			}
			seen.add(words[i].toLowerCase());
		}

		return result;
	}

	public static boolean hasElement(long e, HashSet<Long> longHashSet)
	{
		return longHashSet.contains(e);
	}

	public static int gasStation(int[] gas, int[] cost)
	{
		int n = gas.length;
		int totalTank = 0, startPoint = 0, currentTank = 0;
		for (int i = 0; i < n; i++)
		{
			int diff = cost[i] - gas[i];
			totalTank += diff;
			currentTank += diff;

			if (currentTank < 0)
			{
				startPoint = i + 1;

				currentTank = 0;
			}
		}
		return totalTank <= 0 ? -1 : startPoint;
	}

	public class TreeNode
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

	public boolean hasPathSum(TreeNode root, int targetSum)
	{
		if (root == null)
		{
			return false;
		}
		if (root.left == null && root.right == null)
		{
			return targetSum == root.val;
		}
		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}

	//Minimum Time to repair cars
	public long repairCars(int[] ranks, int cars)
	{
		long min = 1;
		long max = (long) ranks[0] * cars * cars;
		while (min < max)
		{
			long mid = (min + max) / 2;
			long carSum = 0;
			for (int rank : ranks)
			{
				carSum += (long) Math.sqrt(mid / rank);
			}
			if (carSum < cars)
			{
				min = mid + 1;
			}
			else
			{
				max = mid;
			}
		}
		return min;
	}

	public static int halfAdder(int a, int b)
	{
		int place = 1, result = 0, count = 0;
		int length = Math.max(String.valueOf(a).length(), String.valueOf(b).length());

		while (a > 0 || b > 0)
		{
			int digitx = a % 10;
			int digity = b % 10;

			int sum = digitx + digity;
			if (count != length - 1)
			{
				sum = sum % 10;
			}

			result += sum * place;
			place *= 10;
			a /= 10;
			b /= 10;
			count++;
		}

		return result;
	}

	public int countGoodTriplets(int[] arr, int a, int b, int c)
	{
		int good = 0;
		int n = arr.length;
		for (int i = 0; i < n - 2; i++)
		{
			for (int k = i + 2; k < n; k++)
			{
				if (Math.abs(arr[k] - arr[i]) > c)
					continue;
				for (int j = i + 1; j < k; j++)
				{
					if (Math.abs(arr[i] - arr[j]) <= a &&
						Math.abs(arr[j] - arr[k]) <= b)
					{
						good++;
					}
				}
			}
		}
		return good;
	}

	static class Trolley
	{
		int start, end, products;

		Trolley(int start, int end, int products)
		{
			this.start = start;
			this.end = end;
			this.products = products;
		}
	}

	public static int maxProducts(List<Trolley> trolleys)
	{
		trolleys.sort(Comparator.comparingInt(t -> t.end));

		int n = trolleys.size();
		int[] dp = new int[n];
		int[] ends = new int[n];

		for (int i = 0; i < n; i++)
		{
			ends[i] = trolleys.get(i).end;
		}

		for (int i = 0; i < n; i++)
		{
			int include = trolleys.get(i).products;
			int prevIndex = findLastNonOverlapping(trolleys, i, ends);
			if (prevIndex != -1)
			{
				include += dp[prevIndex];
			}

			dp[i] = Math.max(i > 0 ? dp[i - 1] : 0, include);
		}

		return dp[n - 1];
	}

	// Binary search to find the last trolley that doesn't conflict
	private static int findLastNonOverlapping(List<Trolley> trolleys, int currentIndex, int[] ends)
	{
		int low = 0, high = currentIndex - 1;
		int targetStart = trolleys.get(currentIndex).start;
		int result = -1;

		while (low <= high)
		{
			int mid = (low + high) / 2;
			if (ends[mid] <= targetStart)
			{
				result = mid;
				low = mid + 1;
			}
			else
			{
				high = mid - 1;
			}
		}

		return result;
	}

	public static List<Integer> getDeciBinaryParts(String S)
	{
		int length = S.length();
		int maxDigit = 0;
		for (char c : S.toCharArray())
		{
			maxDigit = Math.max(maxDigit, c - '0');
		}

		List<Integer> result = new ArrayList<>();
		int[] digits = new int[length];

		for (int i = 0; i < length; i++)
		{
			digits[i] = S.charAt(i) - '0';
		}

		for (int i = 0; i < maxDigit; i++)
		{
			StringBuilder part = new StringBuilder();
			for (int j = 0; j < length; j++)
			{
				if (digits[j] > 0)
				{
					part.append('1');
					digits[j]--;
				}
				else
				{
					part.append('0');
				}
			}
			result.add(Integer.parseInt(part.toString()));
		}

		return result;
	}

	public static int[] productExceptSelf(int[] nums)
	{
		int n = nums.length;
		//compute prefix product
		int product = 1;
		for (int j = 0; j < n; j++)
		{
			product *= nums[j];
		}
		System.out.println(product);
		for (int j = 0; j < n; j++)
		{
			int temp = nums[j];
			nums[j] = product / temp;
		}
		return nums;
	}

	public int[] topKFrequent(int[] nums, int k)
	{
		// Count the frequency of each number
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : nums)
		{
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet())
		{
			minHeap.offer(entry);
			if (minHeap.size() > k)
			{
				minHeap.poll();
			}
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++)
		{
			result[i] = minHeap.poll().getKey();
		}
		return result;
	}

	public int longestConsecutive(int[] nums)
	{
		if (nums.length == 0)
			return 0;

		Arrays.sort(nums);

		int maxStreak = 1;
		int currentStreak = 1;

		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] == nums[i - 1])
			{
				continue;
			}
			else if (nums[i] == nums[i - 1] + 1)
			{
				currentStreak++;
				maxStreak = Math.max(maxStreak, currentStreak);
			}
			else
			{
				currentStreak = 1;
			}
		}

		return maxStreak;
	}

	static int bitonic(int arr[], int n)
	{
		int[] inc = new int[n];
		int[] dec = new int[n];
		int max;

		inc[0] = 1;

		dec[n - 1] = 1;

		for (int i = 1; i < n; i++)
			inc[i] = (arr[i] >= arr[i - 1]) ? inc[i - 1] + 1 : 1;

		for (int i = n - 2; i >= 0; i--)
			dec[i] = (arr[i] >= arr[i + 1]) ? dec[i + 1] + 1 : 1;

		max = inc[0] + dec[0] - 1;
		for (int i = 1; i < n; i++)
		{
			int i1 = inc[i] + dec[i] - 1;
			if (i1 > max)
				max = i1;
		}

		return max;
	}

	//Sliding Window
	public static boolean containsNearbyDuplicate(int[] nums, int k)
	{
		int left = 0;
		int right = nums.length - 1;
		while (left < right)
		{
			int width = right - left;
			if (nums[left] == nums[right] && width <= k)
			{
				return true;
			}
			if (nums[left] < nums[right])
			{
				left++;
			}
			else
			{
				right--;
			}
		}
		return false;
	}

	public boolean checkInclusion(String s1, String s2)
	{
		if (s1.length() > s2.length())
			return false;

		int[] count1 = new int[26];
		int[] count2 = new int[26];

		for (int i = 0; i < s1.length(); i++)
		{
			count1[s1.charAt(i) - 'a']++;
			count2[s2.charAt(i) - 'a']++;
		}

		for (int i = s1.length(); i < s2.length(); i++)
		{
			if (matches(count1, count2))
				return true;
			count2[s2.charAt(i) - 'a']++;
			count2[s2.charAt(i - s1.length()) - 'a']--;

		}
		return matches(count1, count2);

	}

	private boolean matches(int[] arr1, int[] arr2)
	{
		for (int i = 0; i < 26; i++)
		{
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

	public int lengthOfLongestSubstring(String s)
	{
		Set<Character> set = new HashSet<>();
		int left = 0;
		int maxLen = 0;
		for (int right = 0; right < s.length(); right++)
		{
			char c = s.charAt(right);
			while (set.contains(c))
			{
				set.remove(s.charAt(left));
				left++;
			}
			set.add(s.charAt(right));
			maxLen = Math.max(maxLen, right - left + 1);
		}
		return maxLen;
	}

}
