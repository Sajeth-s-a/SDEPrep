package prep;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis
{
	public static void main(String[] args)
	{
		GenerateParenthesis gp = new GenerateParenthesis();
		int n = 2;
		List<String> result = gp.generateParenthesis(n);
		System.out.println(result); // Output: ["((()))","(()())","(())()","()(())","()()()"]
	}

	public List<String> generateParenthesis(int n)
	{
		List<String> result = new ArrayList<>();
		backTrackAndAdd(result, "", 0, 0, n);
		return result;
	}

	public void backTrackAndAdd(List<String> resultList, String eachNodeResult, int left, int right, int max)
	{
		if (eachNodeResult.length() == max * 2)
		{
			resultList.add(eachNodeResult);
			return;
		}

		if (left < max)
		{
			backTrackAndAdd(resultList, eachNodeResult + "(", left + 1, right, max);
		}
		if (right < left)
		{
			backTrackAndAdd(resultList, eachNodeResult + ")", left, right + 1, max);
		}
	}
}
