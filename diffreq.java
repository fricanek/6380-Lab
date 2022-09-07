package lab1;
import java.util.Random;

public class diffreq {



	



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

			for(int x=0;x<3;x++)

			{
				float f = random.nextFloat();
				
				
				//writhe if statements for each letter 
				
				if(f < 0.12) {
					DNAmers = DNAmers +"A";
					
				}
				else if (f< 0.23) {
					DNAmers = DNAmers + "T";
				}
				
				else if (f< 0.62) {
					DNAmers = DNAmers + "G";
				}
				
				else {
					DNAmers = DNAmers + "C";
				}
				
			}
			
			//printing out 1000 DNA seq
			System.out.println(DNAmers);

			//seeing if any DNA seq match AAA and increment if so
			if(DNAmers.equals("AAA")) {
				AAA++;
			}
			}
			
			//printing out the freq 
			System.out.println("Freq of AAA:" + AAA);
			

			
		

		}
	}





