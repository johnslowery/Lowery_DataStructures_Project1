/**
 * COP 3530: Project 1 - Array Searches and Sorts
 * <p>
 * The Project1 class is responsible for parsing through a given file, organzing it into different fields (Country Name, Code, Capitol,
 * Population, GDP, and Happiness Rank) and then sorting those fields depending on the options that the user selects. The first thing
 * the user has to input is the name of a valid file, "Countries1.csv". Once they input a valid file, the user will have a choice between 6
 * options: Print a report of all the countries and their data, sort the countries by their name alphabetically, sort the countries by
 * their happiness rank, sort the countries by their GDP per Capita, find and print a specific country that they also input, or quitting.
 * <p>
 * @author John Lowery
 * @version 1/31/2020
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Project1 {
	//Temporary Arrays used to store values to be sorted later on (based on user input)
	static String tempName[] = new String[155];
	static String tempCode[] = new String[155];
	static String tempCap[] = new String[155];
	static int tempPop[] = new int[155];
	static double tempGDP[] = new double[155];
	static int tempHapp[] = new int[155];
	//num represents the length of 155 countries
	static int num = 155;
	//nameSortCheck checks if it has been sorted by Name (0 means it has not been sorted by name, 1 means it has been sorted by name)
	static int nameSortCheck = 0;
	
	/**
	 * The main method is mainly responsible for running the parseFile method (used to parse the given file and put the data into arrays),
	 * and checking the user inputs to make sure they are valid. Using the switch case, if they put in 1, they will get a printed report 
	 * of the countries based on how they were sorted. If they input 2, they will sort the Countries by their name alphabetically using 
	 * Bubble Sort. If they input 3, they will sort the Countries by their Happiness Rank using Selection Sort. If they input 4, they will 
	 * sort the Countries by their GDP per Capita using Insertion Sort. If they input 5, they will be able to input a specific Country to 
	 * get a report of that country's Name, Code, Capitol, Population, GDP, and Happiness Rank. If they input 6, they will exit the code.
	 * If they input any number that is not 1, 2, 3, 4, 5, or 6, the switch case will default and ask them to try inputting a valid number.
	 * The main method also keeps track of two variables: testInput and nameSortCheck. testInput is responsible by making the switch case
	 * continue to run until the user inputs 6. nameSortCheck will check if the user has the Countries sorted by Name. If it is sorted by name,
	 * it will be a 1, if it is sorted in any other way, it will be a 0. This is used in the findCountry method later on.
	 */
	
	public static void main(String[] args) throws FileNotFoundException{
		//Parses the File
		parseFile();
		//Checks the user input to make sure it is valid, and runs it again if it is not
		int testInput = 1;
		System.out.println("Enter your choice between 1-6:");
		System.out.println();
		System.out.println("1. Print a countries report\r\n" + 
				"2. Sort by Name\r\n" + 
				"3. Sort by Happiness\r\n" + 
				"4. Sort by GDP per capita\r\n" + 
				"5. Find and print a given country\r\n" + 
				"6. Quit");
		
		//User Input
		Scanner input = new Scanner(System.in);
		String whichMethod = input.nextLine();
		
		//Switch Case so user can input a number and sort the countries in whatever way they want as many times as they want
		while(testInput == 1) {
			switch(whichMethod) {
			case "1":
				//Runs a report of the countries
				countriesReport();
				whichMethod = input.nextLine();
				if(whichMethod == "6") {
					testInput = 0;
				}
				break;
			case "2":
				//Uses Bubble Sort to sort by Country Name
				nameSort();
				System.out.println("Sorted by Name");
				nameSortCheck = 1;
				whichMethod = input.nextLine();
				if(whichMethod == "6") {
					testInput = 0;
				}
				break;
			case "3":
				//Uses Selection Sort to sort by Happiness Rank
				happySort();
				System.out.println("Sorted by Happiness Rank");
				nameSortCheck = 0;
				whichMethod = input.nextLine();
				if(whichMethod == "6") {
					testInput = 0;
				}
				break;
			case "4":
				//Uses Insertion Sort to sort by GDP per Capita
				gdpSort();
				System.out.println("Sorted by GDP per Capita");
				nameSortCheck = 0;
				whichMethod = input.nextLine();
				if(whichMethod == "6") {
					testInput = 0;
				}
				break;
			case "5":
				int tester = 1;
				//Finds and prints a country based on user input
				int j = 0;
				System.out.println("Which Country?");
				while(tester == 1) {
					input = new Scanner(System.in);
					String whichCountry = input.nextLine();
					for(int x = 0; x < num; x++) {
						int compare = whichCountry.compareTo(tempName[x]);
						if(compare == 0) {
							j = x;
							tester = 0;
							break;
						}else {
							continue;
						}
					}
					if(tester == 1) {
						System.out.println("Invalid Country, Please Try Again!");
					}
				}
				findCountry(j);
				whichMethod = input.nextLine();
				if(whichMethod == "6") {
					testInput = 0;
				}
				break;
			case "6":
				//Quits the program
				testInput = 0;
				System.out.println("Have a wonderful day!");
				break;
			//If they do not input 1-6, it will default and ask them to input a valid number
			default:
				System.out.println("Invalid Option, Please Try a Number Between 1 - 6!");
				input = new Scanner(System.in);
				whichMethod = input.nextLine();
				break;
			}
		}
	}
	
	/**
	 * parseFile is responsible for reading through the file. It will first check if the user inputs a valid file. Once the user has inputted
	 * a valid file, it will scan through the file. It will skip the first line, as it is just the headers for the table and not needed when
	 * sorting and searching. After that, it splits the table, using a delimiter, into the Country type fileInfo array, and arrays for each
	 * different field (Name, Code, Capitol, Population, GDP, and Happiness Rank). It also throws a FileNotFoundException in order to properly
	 * handle files.
	 */
	
	public static void parseFile() throws FileNotFoundException {
		System.out.println("Please Enter the Name of a Valid CSV File to be Manipulated: ");
		Scanner input = new Scanner(System.in);
		String fileTest = input.nextLine();
		//Checks if the file is correct
		int check = 1;
		String tester = "Countries1.csv";
		while(check == 1) {
			if(fileTest.contentEquals(tester)) {
				check = 0;
			}else {
				System.out.println("Please try another file: ");
				fileTest = input.nextLine();
			}
		}
		//Finds file and puts it into a Country type array
			File countryInfo = new File("Countries1.csv");
			Scanner sc = new Scanner(countryInfo);
			sc.nextLine();
			sc.useDelimiter(",|\n");
			Country[] fileInfo = new Country[155];
			for(int x = 0; x < num; x++) {
				fileInfo[x].setName(sc.next());
				String a = Country.getName();
				tempName[x] = a;
				fileInfo[x].setCode(sc.next());
				a = Country.getCode();
				tempCode[x] = a;
				fileInfo[x].setCapitol(sc.next());
				a = Country.getCapitol();
				tempCap[x] = a;
				fileInfo[x].setPop(sc.next());
				a = Country.getPop();
				tempPop[x] = Integer.parseInt(a);
				fileInfo[x].setGDP(sc.next());
				a = Country.getGDP();
				tempGDP[x] = Double.parseDouble(a);
				fileInfo[x].setHapp(sc.next());
				a = Country.getHapp();
				tempHapp[x] = Integer.parseInt(a);
			}
			System.out.println("155 Countries are Loaded");
			System.out.println();
		}

	/**
	 * countriesReport will print the countries based on how they were sorted from the various different switch cases. If the countries have not
	 * been sorted yet, they will be printed as they are in the CVS file.
	 */
	
	public static void countriesReport() {
		//Prints countries based on how they were sorted from other options in the program, default will display as it does in the CVS file
		System.out.printf("%-34s %-14s %-14s %-14s %-19s %s %n", "Name", "Code", "Capitol", "Population", "GDP", "Happiness Rank");
		System.out.println("--------------------------------------------------------------------------------------------------------------------");
		for(int x = 0; x < 155; x++) {
			System.out.printf("%-35s", tempName[x]);
			System.out.printf("%-15s", tempCode[x]);
			System.out.printf("%-15s", tempCap[x]);
			System.out.printf("%-15s", tempPop[x]);
			System.out.printf("%-20s", tempGDP[x]);
			System.out.printf("%-15s", tempHapp[x]);
			System.out.println();
		}
	}
		
	/**
	 * nameSort uses Bubble Sort to sort the countries by Country Name.
	 */
	
	public static void nameSort() {
		//Bubble Sort
		for (int outer = 0; outer < num - 1; outer++) {
			for (int inner = num - 1; inner > outer; inner--) {
				int comp = tempName[inner].compareTo(tempName[inner - 1]);
				if (comp < 0) {
					String temp = tempName[inner];
					tempName[inner] = tempName[inner - 1];
					tempName[inner - 1] = temp;
					String temp2 = tempCode[inner];
					tempCode[inner] = tempCode[inner - 1];
					tempCode[inner - 1] = temp2;
					String temp3 = tempCap[inner];
					tempCap[inner] = tempCap[inner - 1];
					tempCap[inner - 1] = temp3;
					int temp4 = tempPop[inner];
					tempPop[inner] = tempPop[inner - 1];
					tempPop[inner - 1] = temp4;
					double temp5 = tempGDP[inner];
					tempGDP[inner] = tempGDP[inner - 1];
					tempGDP[inner - 1] = temp5;
					int temp6 = tempHapp[inner];
					tempHapp[inner] = tempHapp[inner - 1];
					tempHapp[inner - 1] = temp6;
				}
			}
		}
	}
	
	/**
	 * happySort uses Selection Sort to sort the countries by Happiness Rank
	 */
	
	public static void happySort() {
		//Selection Sort
		for(int outer = 0; outer < num - 1; outer++) {
			int lowest = outer;
			for(int inner = outer + 1; inner < num; inner++) {
				if(tempHapp[inner] < tempHapp[lowest]) {
					lowest = inner;
				}
			}
			if(lowest != outer) {
				String temp = tempName[lowest];
				tempName[lowest] = tempName[outer];
				tempName[outer] = temp;
				String temp2 = tempCode[lowest];
				tempCode[lowest] = tempCode[outer];
				tempCode[outer] = temp2;
				String temp3 = tempCap[lowest];
				tempCap[lowest] = tempCap[outer];
				tempCap[outer] = temp3;
				int temp4 = tempPop[lowest];
				tempPop[lowest] = tempPop[outer];
				tempPop[outer] = temp4;
				double temp5 = tempGDP[lowest];
				tempGDP[lowest] = tempGDP[outer];
				tempGDP[outer] = temp5;
				int temp6 = tempHapp[lowest];
				tempHapp[lowest] = tempHapp[outer];
				tempHapp[outer] = temp6;
			}
		}
	}
	
	/**
	 * gdpSort sorts the countries by GDP per Capita. First it creates a temporary array in order to calculate and store GDP per Capita,
	 * which is found by dividing a country's GDP by its population. After that, tempGDPCapita is sorted using Insertion Sort, which is
	 * then used to sort the countries in the same way.
	 */
	
	public static void gdpSort() {
		int z = 0;
		//Creates temporary array to calculate and store GDP per capita
		double tempGDPCapita[] = new double[num];
		for(int x = 0; x < num; x++) {
			tempGDPCapita[x] = tempGDP[x] / tempPop[x];
		}
		//Insertion Sort by GDP per Capita
		int inner;
		int outer;
		for(outer = 1; outer < num; outer++) {
			double temp = tempGDPCapita[outer];
			String temp2 = tempName[outer];
			String temp3 = tempCode[outer];
			String temp4 = tempCap[outer];
			int temp5 = tempPop[outer];
			double temp6 = tempGDP[outer];
			int temp7 = tempHapp[outer];
			inner = outer - 1;
			while(inner >= 0 && tempGDPCapita[inner] > temp) {
				tempGDPCapita[inner + 1] = tempGDPCapita[inner];
				tempName[inner + 1] = tempName[inner];
				tempCode[inner + 1] = tempCode[inner];
				tempCap[inner + 1] = tempCap[inner];
				tempPop[inner + 1] = tempPop[inner];
				tempGDP[inner + 1] = tempGDP[inner];
				tempHapp[inner + 1] = tempHapp[inner];
				inner--;
			}
			tempGDPCapita[inner + 1] = temp;
			tempName[inner + 1] = temp2;
			tempCode[inner + 1] = temp3;
			tempCap[inner + 1] = temp4;
			tempPop[inner + 1] = temp5;
			tempGDP[inner + 1] = temp6;
			tempHapp[inner + 1] = temp7;
		}
	}
	/**
	 * This method will use the user inputted Country Name to print out a report of a specified Country
	 * including its Name, Code, Capitol, Population, GDP, and Happiness Rank. nameSortCheck is utilized here in order to know what type of
	 * sort it needs to run. If nameSortCheck is equal to 1, the last sort that was made was sorting the Names, meaning a binary
	 * search should be used, as that is more efficient in that scenario. If nameSortCheck is equal to 0, the last sort that was made was not
	 * sorting by Name, meaning a sequential search is used, as that is necessary in any other scenario.
	 * 
	 * @param y: the location of the specified Country in the tempName array
	 */
	public static void findCountry(int y) {
		if(nameSortCheck == 1) {
			//Binary Search if the file is sorted by Country Name
			int lowerBound = 0; 
			int upperBound = num-1;
			int mid;
			
			while(lowerBound <= upperBound) {
				mid = (lowerBound + upperBound ) / 2;
				int compare = tempName[mid].compareTo(tempName[y]);
				if(compare == 0) {
					System.out.printf("%-20s %s%n", "Name:", tempName[mid]);
					System.out.printf("%-20s %s%n", "Code:", tempCode[mid]);
					System.out.printf("%-20s %s%n", "Capitol:", tempCap[mid]);
					System.out.printf("%-20s %s%n", "Population:", tempPop[mid]);
					System.out.printf("%-20s %s%n", "GDP:", tempGDP[mid]);
					System.out.printf("%-20s %s%n", "Happiness Rank:", tempHapp[mid]);
					break;
				} else if (compare > 0) {
					upperBound = mid - 1;
				} else {
					lowerBound = mid + 1;
				}
			}
			System.out.println();
			System.out.println("Binary Search");
		}else {
			//Sequential Search if the file is not sorted by Country Name
			System.out.println();
			for(int x = 0; x < tempName.length; x++) {
				int compare = tempName[x].compareTo(tempName[y]);
				if(compare == 0) {
					System.out.printf("%-20s %s%n", "Name:", tempName[x]);
					System.out.printf("%-20s %s%n", "Code:", tempCode[x]);
					System.out.printf("%-20s %s%n", "Capitol:", tempCap[x]);
					System.out.printf("%-20s %s%n", "Population:", tempPop[x]);
					System.out.printf("%-20s %s%n", "GDP:", tempGDP[x]);
					System.out.printf("%-20s %s%n", "Happiness Rank:", tempHapp[x]);
					break;
				}
			}
			System.out.println();
			System.out.println("Sequential Search");
		}
	}
}