//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics Array Sorting 👍 23233 👎 844

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
	public int[][] merge(int[][] intervals)
	{
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int index = 0;

		for (int i = 1; i < intervals.length; i++)
		{
			if (intervals[index][1] >= intervals[i][0])
			{
				intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
			}
			else
			{
				index++;
				intervals[index] = intervals[i];
			}
		}
		return Arrays.copyOfRange(intervals, 0, index + 1);
	}
}
