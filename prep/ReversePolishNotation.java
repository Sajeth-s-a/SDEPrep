package prep;

import java.util.Arrays;
import java.util.Stack;

public class ReversePolishNotation
{
	public static void main(String[] args)
	{
		ReversePolishNotation rpn = new ReversePolishNotation();
		String[] tokens = {"2", "1", "+", "3", "*"};
		System.out.println(rpn.evalRPN(tokens)); // Output: 9
	}

	public int evalRPN(String[] tokens)
	{
		Stack<Integer> stack = new Stack<>();

		for (String token : tokens)
		{
			if (isOperand(token))
			{
				int y = stack.pop();
				int x = stack.pop();
				int result = 0;

				switch (token)
				{
					case "+":
						result = x + y;
						break;
					case "-":
						result = x - y;
						break;
					case "*":
						result = x * y;
						break;
					case "/":
						result = x / y;
						break;
				}
				stack.push(result);
			}
			else
			{
				stack.push(Integer.parseInt(token));
			}
		}

		return stack.pop();
	}

	public boolean isOperand(String c)
	{
		return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
	}
}
