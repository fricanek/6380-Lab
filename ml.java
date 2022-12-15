package finalProject;

import java.awt.Color;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

//This is project is incomplete and still needs to be worked on
//The goal for this project was to do some machine learning with data (similar to the data below)

//I tried installing the weka package to do svm but was unsuccessful 

public class ml{
	static HashMap<String, List<String>> training;
	 static SortedMap<String, List<String>> testing;

	public static void getData() {
		
		phage p1 = new phage("mEp450","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p2 = new phage("mEp174","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p3 = new phage("S104","Salmonella enterica serovar Typhimurium","Siphoviridae","O-antigen","rfbB");
		phage p4 = new phage("mEp410","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p5 = new phage("mEp500","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p6 = new phage("AR1","Escherichia coli","Myoviridae","OmpC","OmpC");
		phage p7 = new phage("mEp539","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p8 = new phage("mEp173","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p9 = new phage("mEp167","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p10 = new phage("mEp043","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p11 = new phage("IF1","Escherichia coli","Inoviridae","TolA","TolA");
		phage p12 = new phage("mEp174","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p13 = new phage("mEp147","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p14 = new phage("mEp003","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p15 = new phage("mEp144","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p16 = new phage("PBP1","Bacillus pumulis","Siphoviridae","flagella","flgK");
		phage p17 = new phage("mEp543","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p18 = new phage("mEp506","Escherichia coli","Siphoviridae","fhuA","fhuA");
		phage p19 = new phage("SPN9C","Salmonella enterica serovar Typhimurium","Siphoviridae","Btub","Btub");
		phage p20 = new phage("mEp234","Escherichia coli","Siphoviridae","fhuA","fhuA");
		//divide the data into train and test 
		List<phage> l = new ArrayList<phage>(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20));
		HashMap<String, List <String>> first = new HashMap<String, List<String>>();
		HashMap<String, List <String>> second = new HashMap<String, List<String>>();
	
		 
		
		
		for(phage p : l) {
			if(first.containsKey(p.phage_name)) {
				first.get(p.phage_name).add(p.host_name+"-"+p.family+"-"+p.receptor+"-"+p.RBP);
			}else {
				first.put(p.phage_name, new ArrayList<String>());
				first.get(p.phage_name).add(p.host_name+"-"+p.family+"-"+p.receptor+"-"+p.RBP);
			}
		}
		
		
		
		//checking to see if all the RBP are the same 
		//if the RBPs are the same group them together and look at the host, family, and receptor 
		//use the results from this to use 
		
		
	}
	
	//checking to see if the data enterd will likely have fhua as the RBP

		public static phage testUserData() {
			int accuracy =0;
			Scanner sc= new Scanner(System.in);    
			System.out.print("Enter the phage name: ");  
			String phageName = sc.nextLine(); 
			System.out.print("Enter the host name: ");  
			String hostName = sc.nextLine(); 
			System.out.print("Enter the family name: ");  
			String fam_name= sc.nextLine(); 
			System.out.print("Enter the receptor name: ");  
			String rec_name= sc.nextLine(); 
			
			String RBP = "";
			phage phage = new phage(phageName, hostName, fam_name, rec_name, RBP);

			
			
			if (hostName.equalsIgnoreCase("Escherichia coli")) {
				accuracy++;
			}
			if (fam_name.equalsIgnoreCase("Siphoviridae")) {
				accuracy++;
			}
			if (rec_name.equalsIgnoreCase("fhua")) {
				accuracy++;
			}
			System.out.print("The phage you entered: " + phageName + hostName + fam_name + rec_name + "\n" );
		
			if( accuracy/3 == 1) {
				System.out.print("The RBP for the phage information eneter is most likely fhua");
			}
			else {
				System.out.print("The RBP for the phage information eneter is not fhua");
			}
			return phage;
			
		}
	


	
	public static void main(String[] args) {
			testUserData();
		
		
			
			
	
	}
}
