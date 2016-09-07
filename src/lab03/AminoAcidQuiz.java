package lab03;

import java.util.Random;
import java.util.Scanner;

public class AminoAcidQuiz 

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
		
		Random r = new Random();
		int randomIndex = r.nextInt(FULL_NAMES.length);
		System.out.println(FULL_NAMES[randomIndex]);
		System.out.println("Plase enter one letter character for this amino acid:");
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		String aChar = "" + s.charAt(0);
		System.out.println(aChar);
		
		if (aChar.equals(SHORT_NAMES[randomIndex]))
			System.out.println("Right!");
		
		else 
			System.out.println("Wrong!" + " " + "Should be:" + SHORT_NAMES[randomIndex]);
		
	}
	
}
