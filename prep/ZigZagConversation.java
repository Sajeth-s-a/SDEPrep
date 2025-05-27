package prep;

public class ZigZagConversation
{
	public static void main(String[] args)
	{
		String s = "PAYPALISHIRING";
		int numRows = 3;
		String result = convert(s, numRows);
		System.out.println("Converted string: " + result); // Output: "PAHNAPLSIIGYIR"

	}

	public static String convert(String s, int numRows)
	{
		if (numRows <= 1 || numRows >= s.length())
		{
			return s;
		}

		StringBuilder[] rows = new StringBuilder[numRows];
		for (int i = 0; i < rows.length; i++)
		{
			rows[i] = new StringBuilder();
		}

		int currentRow = 0;
		boolean goingDown = false;

		for (char c : s.toCharArray())
		{
			rows[currentRow].append(c);
			if (currentRow == 0)
			{
				goingDown = true;
			}
			else if (currentRow == numRows - 1)
			{
				goingDown = false;
			}
			currentRow += goingDown ? 1 : -1;
		}

		StringBuilder result = new StringBuilder();
		for (StringBuilder row : rows)
		{
			result.append(row);
		}

		return result.toString();
	}
}
