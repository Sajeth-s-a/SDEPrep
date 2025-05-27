package prep;

public class TypesOfTriangle
{
	public static void main(String[] args)
	{
		TypesOfTriangle tt = new TypesOfTriangle();
		int[] nums = {9,4,9};
		System.out.println(tt.triangleType(nums)); // Output: "Scalene"
	}

	public String triangleType(int[] nums)
	{
		int a = nums[0];
		int b = nums[1];
		int c = nums[2];
		if (a + b <= c || a + c <= b || b + c <= a)
		{
			return "none";
		}

		int sameCount = 1;
		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] == nums[i-1])
			{
				sameCount++;
			}

		}
		if (sameCount == 3)
		{
			return "equilateral";
		}
		else if (sameCount == 2)
		{
			return "isosceles";
		}
		else
		{
			return "scalene";
		}
	}
}
