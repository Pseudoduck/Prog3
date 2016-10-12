package midTerm;

public class Question3
{

	public static int bothPositive(int m, int n)
	{
		int a;
		if (m >= 0 && n >= 0)
		{
			a = 1;
		}
		else
		{
			a = 0;
		}
		return a;
	}
	
	public static void main(String[] args)
	{
		int x = -3;
		int y = 5;
		System.out.println(bothPositive(x,y));
	}
}
