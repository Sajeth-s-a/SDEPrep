package prep;

public class PatternSearch
{
	public static void main(String[] args)
	{
		String text = "ababcabcabababd";
		String pattern = "ababd";
		int result = search(text, pattern);
		System.out.println("Pattern found at index: " + result);
	}

	public static int search(String text, String pattern)
	{
		int[] lps = buildLPSArray(pattern);
		int i = 0; // index for text
		int j = 0; // index for pattern

		while(i<text.length())
		{
			if(pattern.charAt(i) == text.charAt(j))
			{
				i++;
				j++;
			}
			if (j == pattern.length())
			{
				return i - j; //Return first match
			}
			else if(i< text.length() && pattern.charAt(j) != text.charAt(i))
			{
				if (j != 0)
				{
					j = lps[j - 1];
				}
				else
				{
					i++;
				}
			}
		}
		return -1;
	}

	public static int[] buildLPSArray(String pattern)
	{
		int n = pattern.length();
		int[] lps = new int[n];
		int len = 0; // length of the previous longest prefix suffix
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		while (i<n)
		{
			if(pattern.charAt(i) == pattern.charAt(len))
			{
				len++;
				lps[i] = len;
				i++;
			}
			else
			{
				if(len != 0)
				{
					len = lps[len - 1];
				}
				else
				{
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
}
