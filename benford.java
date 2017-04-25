/*Patrick Vanegas, ID: 2605
 * Assignment 1:
 * Benfords Law
 */

import java.util.*;
import java.io.*; //used for "File"; allows us to read files from package

public class Benford {
	
	public static String numScan; //stores current number from "data.txt"
	public int total_num; //Amount of numbers in "data.txt"
	
	/* Following are used as counter variables to keep track of how many 
	 * instances of each number there is. 
	 */
	public int one;
	public int two;
	public int three;
	public int four;
	public int five;
	public int six;
	public int seven;
	public int eight;
	public int nine;
	public Scanner x; //used to open, read, and close file
	
	//Method to open "data.txt"		
	public void openFile(){
		
			//find file in our package
			try{
				x = new Scanner(new File("data.txt"));
			}
			//Throw error if the file is not found
			catch(Exception Error){
				System.out.println("Could not find file");
			}
		}
	
	//Method to read strings from "data.txt"
	public void readFile(){
			//read while there are strings
			while(x.hasNext()){
				//collect first string from "data.txt"
				numScan = x.next();
				total_num++;
				/*loop iterates through string to find sig digit
				 * and updates counters accordingly
				 */
				for (int i = 0; i < numScan.length(); i++)
				{
					
					switch(numScan.charAt(i)){
					
						case '1':
							one++;
							break;
						case '2':
							two++;
							break;
						case '3':
							three++;
							break;
						case '4':
							four++;
							break;
						case '5': 
							five++;
							break;
						case '6':
							six++;
							break;
						case '7':
							seven++;
							break;
						case '8':
							eight++;
							break;
						case '9':
							nine++;
							break;
						default:
							continue;
			}
			break; //continue to next string if sig digit is found
				
		}
	
	}
}
	
	//Method to close the file
	public void closeFile(){
		x.close();	
	}
	
	//Method to calculate the percentage of a number from the total
	public double percentOf(int counter, int total){
		double new_count = (double) counter;
		double new_total = (double) total;
		double percentage = (double) (new_count/new_total)*100;	
		return percentage;
	}
	
	/*Method to convert percentage into a visual representation.
	 *The percentage is passed through "double a"
	 */
	public String starRep(double a){
		
		String stars = "";
		//round the percentage
		int rounded = (int) Math.round(a);
		//loop used to create visual display
		for(int i = 0; i < rounded; i++)
		{
			stars += '*';
		}
		return stars;		
	}
	
	public static void main(String[] args){
		//create instance of a Benford object
		Benford data = new Benford();
		data.openFile();
		data.readFile();
		
		//calculate percentages of each number to the total
		double many_ones = data.percentOf(data.one, data.total_num);
		double many_twos = data.percentOf(data.two, data.total_num);
		double many_threes = data.percentOf(data.three, data.total_num);
		double many_fours = data.percentOf(data.four, data.total_num);
		double many_fives = data.percentOf(data.five, data.total_num);
		double many_sixes = data.percentOf(data.six, data.total_num);
		double many_sevens = data.percentOf(data.seven, data.total_num);
		double many_eights = data.percentOf(data.eight, data.total_num);
		double many_nines = data.percentOf(data.nine, data.total_num);
		
		//calculate visual display of each number
		String disp_ones = data.starRep(many_ones);
		String disp_twos = data.starRep(many_twos);
		String disp_threes = data.starRep(many_threes);
		String disp_fours = data.starRep(many_fours);
		String disp_fives = data.starRep(many_fives);
		String disp_sixes = data.starRep(many_sixes);
		String disp_sevens = data.starRep(many_sevens);
		String disp_eights = data.starRep(many_eights);
		String disp_nines = data.starRep(many_nines);

		//print out our data
		System.out.printf("1 (%.3f%%)\t: %s\n", many_ones, disp_ones);
		System.out.printf("2 (%.3f%%)\t: %s\n", many_twos, disp_twos);
		System.out.printf("3 (%.3f%%)\t: %s\n", many_threes, disp_threes);
		System.out.printf("4 (%.3f%%)\t: %s\n", many_fours, disp_fours);
		System.out.printf("5 (%.3f%%)\t: %s\n", many_fives, disp_fives);
		System.out.printf("6 (%.3f%%)\t: %s\n", many_sixes, disp_sixes);
		System.out.printf("7 (%.3f%%)\t: %s\n", many_sevens, disp_sevens);
		System.out.printf("8 (%.3f%%)\t: %s\n", many_eights, disp_eights);
		System.out.printf("9 (%.3f%%)\t: %s\n", many_nines, disp_nines);
		
	}
	
}
