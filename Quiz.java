package lab2;

import java.lang.reflect.Array;


import java.util.Random;
import java.util.Scanner;


//first get the time 




		// randomize the full names 
		
		
		
		//show the user a full name and they should enter a short name
		
		//while loop through and make sure the answer is correct
		
		
		
		//if the answer is correct keep going
		//if the answer is wrong then stop and tell them the correct answer
		//stop after 30 seconds no matter what 
		//give score once the quiz has stopped 
		
public class Quiz {
	
	public static String[] SHORT_NAMES = 
		{ "A","R", "N", "D", "C", "Q", "E", 
		"G",  "H", "I", "L", "K", "M", "F", 
		"P", "S", "T", "W", "Y", "V" };
	public static String[] FULL_NAMES = 
		{
		"alanine","arginine", "asparagine", 
		"aspartic acid", "cysteine",
		"glutamine",  "glutamic acid",
		"glycine" ,"histidine","isoleucine",
		"leucine",  "lysine", "methionine", 
		"phenylalanine", "proline", 
		"serine","threoninef","tryptophan", 
		"tyrosine", "valine"};
	


	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner input = new Scanner(System.in);
	
		
		//setting variables 
		
		String answer;
		
		int score = 0;
		int incorrect = 0;
		
		
		
		//getting current time
		long startTime = System.currentTimeMillis();
		
		
		
	
			
		

		while(true) {	
			
			
			
			//randomizing and printing out full names
			int rand = random.nextInt(FULL_NAMES.length);
			System.out.println(FULL_NAMES[rand]);
	

			//getting the users answer
			answer = input.nextLine();
			
		
			
			
				
				//checking the short_names to answer
				if(SHORT_NAMES[rand].equalsIgnoreCase(answer)) {
						
				
						score++;
						System.out.println("Correct");
						System.out.println("Score: " + score);
					}
					
				
					else {
						incorrect++;
						
						
						
					}
				//getting endtime	
				long endTime = System.currentTimeMillis();
				float x = (endTime - startTime)/1000f;
				
				//seeing if the time is less than 30 seconds
				if(x < 30) {
					System.out.println(x + "  Seconds of of 30");
				}
				else {
					System.out.println(x + "seconds. The quiz is over ");
				
					break;
				}
				if(incorrect > 0) {
					System.out.println("Wrong answer");
					System.out.println("The correct answer is: " + SHORT_NAMES[rand]);
					System.out.println("Score: " + score);
				
					
					break;
				}
				
					

			
		}
		
	}
	}
	







		
		
		
		
	
	
		

		

	

