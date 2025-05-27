package prep;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals
{
	public static void main(String[] args)
	{
		MergeIntervals mi = new MergeIntervals();
		int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		int[][] merged = mi.merge(intervals);
		for (int[] interval : merged)
		{
			System.out.println(Arrays.toString(interval));
		}
	}
	public int[][] merge(int[][] intervals)
	{
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
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
