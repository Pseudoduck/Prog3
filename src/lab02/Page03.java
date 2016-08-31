package lab02;

import java.util.Random;

public class Page03
{

	public static void main (String[] args)
	
	{	
	
		String threemers = "ATGC";
		int count = 0;
		String target = "AAA";
		Random random = new Random();
		
		for (int i = 0; i < 1000; i++)
		
		{
			char m1 = threemers.charAt(random.nextInt(4));
			char m2 = threemers.charAt(random.nextInt(4));
			char m3 = threemers.charAt(random.nextInt(4));
			
			String n1 = Character.toString(m1);
			String n2 = Character.toString(m2);
			String n3 = Character.toString(m3);
			
			String n = n1 + n2 + n3;
		
			System.out.println(n);
		
			if (n == target)
			{
				count++;
			}
		
		}
		
		System.out.println(count);
		
		System.out.println("Expected to see 'AAA' 15.626 times");	
		System.out.println ("Java's number is:" + count);
	}
				
}
	