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
		long startTime = System.currentTimeMillis();
		long secondsLimit = 30;
		long millisToSeconds = 1000;
		do
		{
			Random r = new Random();
			int randomIndex = r.nextInt(FULL_NAMES.length);
			System.out.println(FULL_NAMES[randomIndex]);
			System.out.println("Plase enter one letter character for this amino acid:");					
			Scanner scan = new Scanner(System.in);
			String s = scan.next();
			String aChar = "" + s.charAt(0);
			System.out.println(aChar.toUpperCase());
			
			if(aChar.toUpperCase().equals(SHORT_NAMES[randomIndex]))
			{
				long endTime = System.currentTimeMillis();
				long diffTime = endTime - startTime;
				if (diffTime/1000 < 30)
					{
							endTime = System.currentTimeMillis();
							diffTime = endTime - startTime;
							score++;
							System.out.println("Right!"); 
							System.out.println("Score=" + score);
							System.out.println("elapsed time: " + diffTime/millisToSeconds + " seconds of " + secondsLimit);
					}
				else
					{
					System	.out.println("time is up!");
					break;
					}
			}
			else 
			{
				System.out.println("Wrong!" + " " + "Should be:" + SHORT_NAMES[randomIndex] + "\nYou cannot continue!");
				scan.close();
				long endTime = System.currentTimeMillis();
				long diffTime = endTime - startTime;
				System.out.println("tota test time is: " + diffTime/millisToSeconds);
				break;
			}
		} while (b);
		
		System.out.println("Test ends with score of " + score);
		
	}		
}
