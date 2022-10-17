

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.util.ArrayList;
	import java.util.List;
public class FastaSequence {

		//variables
		private  String header;
		private  String sequence;
		private static ArrayList<String> headerList = new ArrayList<String>();
		private static ArrayList<String> sequenceList = new ArrayList<String>();
	
		
		
		public FastaSequence(String header, String sequence) {
			this.header = header;
			this.sequence = sequence; 

		}
		
		public static List<FastaSequence> readFastaFile(String filepath) throws Exception{
			
				List<FastaSequence> list = new ArrayList<FastaSequence>();
				
			
				BufferedReader reader = new BufferedReader (new FileReader(filepath));

				String line;
				
				
				while((line = reader.readLine())!= null)
				{
					FastaSequence fs = new FastaSequence(line, line ); 
			
				  
					  if(line.startsWith(">")){
						  
						  fs.sequence = "";
						 
							 fs.sequence.concat(line);
							 //fs.sequence.trim();
							 
						
						headerList.add(line.replace(">",""));
					 
					  }
					  else {
						  
						   fs.header = "";
						// fs.header = line.replace(">","");
					
					fs.header.concat(line);
					//fs.sequence = fs.sequence.trim();
					
						 
							 
					  
					
					
				 sequenceList.add(line.trim());
				 
				  
				  }
				  list.add(new FastaSequence(fs.header,fs.sequence));
				
					
				}
				
		
							reader.close(); 
					
					  return list;
					}

		  
		   
		  // returns the header of this sequence without the “>” 
		public String getHeader() 
		
		  { 
			
			header = header.replace(">", "");
			
			
			
			  return header; 
			  }
		  
		  // returns the Dna sequence of this FastaSequence
		  public String getSequence()
		  
		  { 
			  
			  sequence = sequence.trim();
		
		  return sequence;
		  } //
		  //returns the number of G’s and C’s divided by the length of this sequence 
			
			  public float getGCRatio() { float GCcount = 0; float GCratio; for(int i = 0;
			  i < sequence.length(); i++)
			  { 
				  if(sequence.equals("G")) { GCcount++; }
			  
			  } GCratio = GCcount / sequence.length();
			  
			  return GCratio; }
			  
			  public int numA() { int numA = 0; for(int i = 0; i < sequenceList.size();
			  i++) { if(sequenceList.contains("A")) { numA++; }
			  
			  }
			 // System.out.print(numA);
			  return numA; }
			 
		  
		  public int numT () {  int numT = 0;for(int i = 0; i < sequence.length(); i++)
		  { if(sequence.charAt(i)=='T') { numT++; }
		  
		  } return numT; }
		  
		  public int numG() { int numG = 0;  for(int i = 0; i < sequence.length(); i++)
		  { if(sequence.charAt(i)=='G') { numG++; }
		  
		  } return numG; }
		  
		  public int numC() { int numC = 0; for(int i = 0; i < sequence.length(); i++)
		  { if(sequence.charAt(i)=='C') { numC++; }
		  
		  } return numC; }
		  

		
		  public static void writeTableSummary( List<FastaSequence> list, File outputFile)
		  throws Exception { BufferedWriter writer = new BufferedWriter(new
		  FileWriter(outputFile));
		  
		
		  writer.write("sequenceID\tnumA\tnumC\tnumG\tnumT\tsequence"); 
		  for( FastaSequence fs : list) {
			  
			 writer.newLine();
				
				  writer.write( fs.getHeader() + "\t" + fs.numA() + "\t" +fs.numC() + "\t" +
				  fs.numG() + "\t" + fs.numT() + "\t" + fs.getSequence()  );
				 
		
		  
		  
		 }
		  
		  
		  writer.flush(); 
		  writer.close();
		 
		 
		  }
		
		public static void main(String[] args) throws Exception {
			List<FastaSequence> fastaList = 
					FastaSequence.readFastaFile("/Users/lisaricanek/Downloads/fastap.txt");
			
			  for( FastaSequence fs : fastaList) {  System.out.println(fs.getHeader()); 
			 System.out.println(fs.getSequence()); //System.out.println(fs.getGCRatio());
			  
			  
			  
			  }
			
			// System.out.print(headerList);
			 			 
	
			  
			  File myFile = new File("/Users/lisaricanek/Downloads/myFile.txt");
			  writeTableSummary(fastaList, myFile);
			 
		}

	}


