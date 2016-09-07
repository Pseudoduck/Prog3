package lab02;

import java.util.Random;

public class Page03

{

	public static void main (String[] args)
	
	{	
	
		String threemers = "ATGC";
		int count = 0;
		int x = 1000;
		String target = "AAA";
		Random random = new Random();
		
		for (int i = 0; i < x; i++)
		
		{
			for (int t = 0; t < 4; t++)
				{
				char m = threemers.charAt(random.nextInt(4));
				String n = Character.toString(m);
				System.out.println(n);
						
			if (n.equals(target))
			
			{
				count = count + 1;
			}
				}	
		}
		
		System.out.println(count);
		
		double d = 0.25*0.25*0.25;
		
		System.out.println("Expected to see 'AAA'"+ d*x +"times");	
		
		System.out.println ("Java's number is:" + count);
	
	}
}
	