package prep;

public class KokoBananas
{
	public static void main(String[] args)
	{
		KokoBananas kb = new KokoBananas();
		int[] piles = {3, 6, 7, 11};
		int h = 8;
		System.out.println(kb.minEatingSpeed(piles, h)); // Output: 4
	}
	public int minEatingSpeed(int[] piles, int h)
	{
		int left = 1;
		int right = 100;

		while (left < right)
		{
			int mid = left + (right - left) / 2;
			if (canEatAll(piles, mid, h))
			{
				right = mid;
			}
			else
			{
				left = mid + 1;
			}
		}
		return left;

	}

	private boolean canEatAll(int[] piles, int mid, int h)
	{
		int hours = 0;
		for (int pile : piles)
		{
			hours += (int) Math.ceil((double) pile / mid);// Equivalent to Math.ceil(pile / mid)
		}
		return hours <= h;
	}
}
