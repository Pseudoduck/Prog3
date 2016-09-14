package lab03;

import java.util.Random;
import java.util.Scanner;

public class AminoAcidsQuiz 
{
	public static String[] SHORT_NAMES = 
		{ "A","R", "N", "D", "C", "Q", "E", 
		"G",  "H", "I", "L", "K", "M", "F", 
		"P", "S", "T", "W", "Y", "V" };
	
	public static String[] FULL_NAMES = 
		{"alanine","arginine", "asparagine", 
		"aspartic acid", "cysteine",
		"glutamine",  "glutamic acid",
		"glycine" ,"histidine","isoleucine",
		"leucine",  "lysine", "methionine", 
		"phenylalanine", "proline", 
		"serine","threonine","tryptophan", 
		"tyrosine", "valine"};

	public static void main(String[] args)
	{
		boolean b = true;
		int score = 0;		
		float secondsLimit = 30f;
		float millisToSeconds = 1000f;
		String quit = "quit";
		Scanner scan = new Scanner(System.in);
		long startTime = System.currentTimeMillis();
		
		do
		{
			Random r = new Random();
			int randomIndex = r.nextInt(FULL_NAMES.length);
			System.out.println(FULL_NAMES[randomIndex]);
			System.out.println("Enter the one letter code for this amino acid (or type 'quit' to quit the quiz):");					
			String s = scan.next();
			
			if(s.equals(quit)) //detect if user decides to quit
			{
				break;
			}
			
			else 
			{
				String aChar = "" + s.charAt(0);
				System.out.println(aChar.toUpperCase());
			
				if(aChar.toUpperCase().equals(SHORT_NAMES[randomIndex])) // check if the input is correct
				{
					long endTime = System.currentTimeMillis();
					long diffTime = endTime - startTime;
					
					if (diffTime/millisToSeconds < secondsLimit) // check if the test running time is less than 30 seconds
						{
							endTime = System.currentTimeMillis();
							diffTime = endTime - startTime;
							score++;
							System.out.println("Right! " + "Score= " + score + "; " + 
							"seconds= " + diffTime/millisToSeconds + " out of " + secondsLimit + "\n"); 	
						}
				
					else // nullify input when test running time is more than 30 seconds
						{
						endTime = System.currentTimeMillis();
						diffTime = endTime - startTime;
						System.out.println("time is up!");
						System.out.println("Total test time you used was: " + secondsLimit);
						break;
						}
				}
			
				else // when the user input is wrong
				{
					long endTime = System.currentTimeMillis();
					long diffTime = endTime - startTime;
					System.out.println("Wrong!" + " " + "Should be:" + SHORT_NAMES[randomIndex] + "\nYou cannot continue!");
				
					if (diffTime/millisToSeconds < secondsLimit)
						{
				
							System.out.println("Total test time you used was: " + diffTime/millisToSeconds + " seconds");
						}
					
					else
						{
							System.out.println("Total test time you used was: " + secondsLimit + " seconds");
						}
					
					break;
				}
			}
		} while (b);
			
		System.out.println("Test ends with score of " + score);
		scan.close();	
	}		
}
