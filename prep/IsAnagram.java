package prep;

public class IsAnagram
{
	public static void main(String[] args)
	{
		String s = "anagram";
		String t = "nagaram";
		boolean result = isAnagram(s, t);
		System.out.println("Are the strings anagrams? " + result);
	}

	public static boolean isAnagram(String s, String t)
	{
		if (s.length() != t.length())
		{
			return false;
		}

		int[] charCount = new int[26]; // Assuming only lowercase letters a-z

		for (int i = 0; i < s.length(); i++)
		{
			charCount[s.charAt(i) - 'a']++;
			charCount[t.charAt(i) - 'a']--;
		}

		for (int count : charCount)
		{
			if (count != 0)
			{
				return false;
			}
		}

		return true;
	}
}
