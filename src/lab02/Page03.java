//write a for loop to replace direct repetition between line 21-28; avoid the use of "magical numbers" 

package lab02;

import java.util.Random;

public class Page03

{

	public static void main (String[] args)
	
	{	
	
		String threemers = "ATGC";
		int count = 0;
		int times = 1000;
		String target = "AAA";
		Random random = new Random();
		String s = "";
		
		for (int i = 0; i < times; i++)
		
		{
				for (int t=0; t<3; t++)
				
				{
					char m = threemers.charAt(random.nextInt(threemers.length()));
					String n = Character.toString(m);
					s += n; // concatenate strings				
				}
					
					System.out.println(s);	
				
						if (s.equals(target))
			
							{
								count = count + 1;
							}
					
						s = ""; // empty string and to have new threemers; otherwise, will be xxx, xxxxxx, xxxxxxxxx!
				
		}
		
		System.out.println(count);
		double b = 0.25*0.25*0.25;
		System.out.println("Expected to see AAA " +  b*times + " times");	
		System.out.println ("Java's number is:" + count);
	
	}

}