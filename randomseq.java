package randomseq;

import java.util.Random;

public class randomseq {
	
	public static String generateRandomSeq(char[]alphabet, float[] weight, int length)
	throws Exception{

	//setting variables 
		float sum = 0;
		String seq = "";
		Random rand = new Random();
		//checking to see if the length of alphabet equals the length of weight 
		if(alphabet.length != weight.length) {
			throw new Exception("The alphabet and weight do not have the same length");
		}
		
		//checking to see if the length is greater than 0
		if(length < 0) {
			throw new Exception("The length is than 0");
			
		}
		
		//looping through the weight length to get the sum 
		for(int i =0; i < weight.length; i++) {
			sum += weight[i];
		}
		
		//checking to see if the sum is close to 1 
		if(sum >= .99 && sum <= 1.01) {
			//System.out.println("The sum of weights is: " + sum);
		}
		else {
			throw new Exception("The weight sum is out of bounds");
		}
		//return a string of characters from alphabet 
		//use length to help define how many characters 
		//and use weight to determine the frequencies of each letter 
		
		float f = rand.nextFloat();
		 
		
		
			//length is the number of char
			
		//loop through the weights
		//for(int k =0; k < weight.length; k++) {
			
			
		//loop through the length 	
		for(int i = 0; i < length; i++) {
			seq = seq + alphabet[(int)Math.random()];
		}
		//making sure the length is correct
		if(seq.length() != length) {
			System.out.println("Wrong length");
		}
			
		

	
		
		return seq;
		
		
	}
	public static void main(String[] args) throws Exception
	{
		float[] dnaWeights = { .3f, .3f, .2f, .2f };
		char[] dnaChars = { 'A', 'C', 'G', 'T'  };
		
		// a random DNA 30 mer
		System.out.println(generateRandomSeq(dnaChars, dnaWeights,30));
		
		// background rate of residues from https://www.science.org/doi/abs/10.1126/science.286.5438.295
		float proteinBackground[] =
			{0.072658f, 0.024692f, 0.050007f, 0.061087f,
		        0.041774f, 0.071589f, 0.023392f, 0.052691f, 0.063923f,
		        0.089093f, 0.023150f, 0.042931f, 0.052228f, 0.039871f,
		        0.052012f, 0.073087f, 0.055606f, 0.063321f, 0.012720f,
		        0.032955f}; 
			

		char[] proteinResidues = 
				new char[] { 'A', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
							 'V', 'W', 'Y' };
		
		// a random protein with 30 residues
		System.out.println(generateRandomSeq(proteinResidues, proteinBackground, 30));
		
	}
	

}
