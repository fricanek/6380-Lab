
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FastaSequence {

	// variables
	private final String header;
	private final String sequence;
	private static ArrayList<String> headerList = new ArrayList<String>();
	private static ArrayList<String> sequenceList = new ArrayList<String>();

	public FastaSequence(String header, String sequence) {
		this.header = header;
		this.sequence = sequence;

	}

	public static List<FastaSequence> readFastaFile(String filepath) throws Exception {

		List<FastaSequence> list = new ArrayList<FastaSequence>();

		BufferedReader reader = new BufferedReader(new FileReader(filepath));

		String line;
		String sequence = "";
		String header = "";

		while ((line = reader.readLine()) != null) {

			if (line.startsWith(">")) {
				
				
				if(!sequence.isEmpty()) {
					
				

				list.add((new FastaSequence(header, sequence)));
				
				sequence = "";
				}
				header = line.replace(">", "");

			} else {

				 sequence += line;
				
	

			}
		}
			list.add((new FastaSequence(header, sequence)));
		
		reader.close();

		return list;
	}

	// returns the header of this sequence without the “>”
	public String getHeader()

	{

		return header;
	}

	// returns the Dna sequence of this FastaSequence
	public String getSequence()

	{

		// sequence = sequence.trim();

		return sequence;
	} //

	public String setHeader()

	{

		return header;
	}

	// returns the Dna sequence of this FastaSequence
	public String setSequence()

	{

		// sequence = sequence.trim();

		return sequence;
	} //
// number of G’s and C’s divided by the length of this sequence 

	public float getGCRatio() {
		float GCcount = 0;
		float GCratio;
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.equals("G") || sequence.equals("C")) {
				GCcount++;
			}

		}
		GCratio = GCcount / sequence.length();

		return GCratio;
	}

	public int numA() {
		int numA = 0;
		for (int i = 0; i < sequenceList.size(); i++) {
			if (sequence.charAt(i) == 'A') {
				numA++;
			}

		}
		// System.out.print(numA);
		return numA;
	}

	public int numT() {
		int numT = 0;
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) == 'T') {
				numT++;
			}

		}
		return numT;
	}

	public int numG() {
		int numG = 0;
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) == 'G') {
				numG++;
			}

		}
		return numG;
	}

	public int numC() {
		int numC = 0;
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) == 'C') {
				numC++;
			}

		}
		return numC;
	}

	public static void writeTableSummary(List<FastaSequence> list, File outputFile) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

		writer.write("sequenceID\tnumA\tnumC\tnumG\tnumT\tsequence");
		for (FastaSequence fs : list) {

			writer.newLine();

			writer.write(fs.getHeader() + "\t" + fs.numA() + "\t" + fs.numC() + "\t" + fs.numG() + "\t" + fs.numT()
					+ "\t" + fs.getSequence());

		}

		writer.flush();
		writer.close();

	}

	public static void main(String[] args) throws Exception {
		List<FastaSequence> fastaList = FastaSequence.readFastaFile("/Users/lisaricanek/Downloads/fastap.txt");

		for (FastaSequence fs : fastaList) {
			System.out.println(fs.getHeader());
			System.out.println(fs.getSequence());

		}

		File myFile = new File("/Users/lisaricanek/Downloads/myFile.txt");
		writeTableSummary(fastaList, myFile);

	}

}
