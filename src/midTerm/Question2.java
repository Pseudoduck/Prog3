package midTerm;

public class Question2
{

	public static int numGCs (String s)
	{
		int numGCs = 0;
		for (int i=0;i<s.length();i++)
		{
			if (s.charAt(i) == 'G' || s.charAt(i)== 'C')
			{
				numGCs++;
			}
			
		}
		return numGCs;
	}
	
	public static void main(String[] args)
	{
		String s = "GATCCCTAGGA";
		System.out.println(numGCs(s));
	}
}
