package lab1;


import java.util.Random;

public class randomDNA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//DNA mers 
		String mers="ATGC";

		//to help store the frequency of AAA
		int AAA=0; 


		//creating random number generator
		Random random = new Random();
		
		
		 
		// creating 1000 DNA 3mers
		
		for(int i=0;i<1000;i++)

		{
			
			
		String DNAmers = "";
		

		
		//randomly producing a 3mer

		for(int j=0;j<3;j++)

		{
			float f = random.nextFloat();
			
			
			//writhe if statements for each letter 
			
			if(f < 0.25) {
				DNAmers = DNAmers +"A";
				
			}
			else if (f< 0.50) {
				DNAmers = DNAmers + "T";
			}
			
			else if (f< 0.75) {
				DNAmers = DNAmers + "G";
			}
			
			else {
				DNAmers = DNAmers + "C";
			}
		
		}
		
		//printing out DNA 
		System.out.println(DNAmers);

		//seeing if DNA matches AAA
		if(DNAmers.equals("AAA")) {
			AAA++;
		}
		
		}
		//printing out the frequency 
		
		System.out.println("Freq of AAA: " + AAA);
		
	
		
		
		
	}
}


